package net.lab1024.smartadmin.module.business.group.controller;

import net.lab1024.smartadmin.common.domain.PageResultDTO;
import net.lab1024.smartadmin.common.controller.BaseController;
import net.lab1024.smartadmin.common.domain.ResponseDTO;
import net.lab1024.smartadmin.common.domain.ValidateList;
import net.lab1024.smartadmin.module.business.group.domain.dto.AuthGroupEmployeeAddDTO;
import net.lab1024.smartadmin.module.business.group.domain.dto.AuthGroupEmployeeUpdateDTO;
import net.lab1024.smartadmin.module.business.group.domain.dto.AuthGroupEmployeeQueryDTO;
import net.lab1024.smartadmin.module.business.group.domain.vo.AuthGroupEmployeeVO;
import net.lab1024.smartadmin.module.business.group.domain.vo.AuthGroupEmployeeExcelVO;
import net.lab1024.smartadmin.module.business.group.service.AuthGroupEmployeeService;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import org.apache.poi.ss.usermodel.Workbook;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * [ 考核组表 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-14 22:01:40
 * @since JDK1.8
 */
@RestController
@Api(tags = {"考核组表"})
public class AuthGroupEmployeeController extends BaseController {

    @Autowired
    private AuthGroupEmployeeService authGroupEmployeeService;

    @ApiOperation(value = "分页查询考核组表",notes = "@author 周天颖")
    @PostMapping("/authGroupEmployee/page/query")
    public ResponseDTO<PageResultDTO<AuthGroupEmployeeVO>> queryByPage(@RequestBody AuthGroupEmployeeQueryDTO queryDTO) {
        return authGroupEmployeeService.queryByPage(queryDTO);
    }

    @ApiOperation(value = "添加考核组表",notes = "@author 周天颖")
    @PostMapping("/authGroupEmployee/add")
    public ResponseDTO<String> add(@RequestBody @Validated AuthGroupEmployeeAddDTO addTO){
        return authGroupEmployeeService.add(addTO);
    }

    @ApiOperation(value="修改考核组表",notes = "@author 周天颖")
    @PostMapping("/authGroupEmployee/update")
    public ResponseDTO<String> update(@RequestBody @Validated AuthGroupEmployeeUpdateDTO updateDTO){
        return authGroupEmployeeService.update(updateDTO);
    }

    @ApiOperation(value="批量删除考核组表",notes = "@author 周天颖")
    @PostMapping("/authGroupEmployee/deleteByIds")
    public ResponseDTO<String> delete(@RequestBody @Validated ValidateList<Long> idList) {
        return authGroupEmployeeService.deleteByIds(idList);
    }

    @ApiOperation(value = "批量导出", notes = "@author 周天颖")
    @PostMapping("/authGroupEmployee/export/batch")
    public void batchExport(@RequestBody @Validated ValidateList<Long> idList, HttpServletResponse response) {
        //查询数据
        List<AuthGroupEmployeeExcelVO> authGroupEmployeeList = authGroupEmployeeService.queryBatchExportData(idList);
        //导出操作
        ExportParams ex = new ExportParams("考核组表", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, AuthGroupEmployeeExcelVO.class, authGroupEmployeeList);
        downloadExcel("考核组表", workbook, response);
    }

    @ApiOperation(value = "导出全部", notes = "@author 周天颖")
    @PostMapping("/authGroupEmployee/export/all")
    public void exportAll(@RequestBody @Validated AuthGroupEmployeeQueryDTO queryDTO, HttpServletResponse response) {
        //查询数据
        List<AuthGroupEmployeeExcelVO> authGroupEmployeeList = authGroupEmployeeService.queryAllExportData(queryDTO);
        //导出操作
        ExportParams ex = new ExportParams("考核组表", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, AuthGroupEmployeeExcelVO.class, authGroupEmployeeList);
        downloadExcel("考核组表", workbook, response);
    }

}
