package net.lab1024.smartadmin.module.business.model.controller;

import net.lab1024.smartadmin.common.domain.PageResultDTO;
import net.lab1024.smartadmin.common.controller.BaseController;
import net.lab1024.smartadmin.common.domain.ResponseDTO;
import net.lab1024.smartadmin.common.domain.ValidateList;
import net.lab1024.smartadmin.module.business.model.domain.dto.AuthModelStanderAddDTO;
import net.lab1024.smartadmin.module.business.model.domain.dto.AuthModelStanderUpdateDTO;
import net.lab1024.smartadmin.module.business.model.domain.dto.AuthModelStanderQueryDTO;
import net.lab1024.smartadmin.module.business.model.domain.vo.AuthModelStanderVO;
import net.lab1024.smartadmin.module.business.model.domain.vo.AuthModelStanderExcelVO;
import net.lab1024.smartadmin.module.business.model.service.AuthModelStanderService;
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
 * [ 部门考核标准 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-14 22:10:14
 * @since JDK1.8
 */
@RestController
@Api(tags = {"部门考核标准"})
public class AuthModelStanderController extends BaseController {

    @Autowired
    private AuthModelStanderService authModelStanderService;

    @ApiOperation(value = "分页查询部门考核标准",notes = "@author 周天颖")
    @PostMapping("/authModelStander/page/query")
    public ResponseDTO<PageResultDTO<AuthModelStanderVO>> queryByPage(@RequestBody AuthModelStanderQueryDTO queryDTO) {
        return authModelStanderService.queryByPage(queryDTO);
    }

    @ApiOperation(value = "添加部门考核标准",notes = "@author 周天颖")
    @PostMapping("/authModelStander/add")
    public ResponseDTO<String> add(@RequestBody @Validated AuthModelStanderAddDTO addTO){
        return authModelStanderService.add(addTO);
    }

    @ApiOperation(value="修改部门考核标准",notes = "@author 周天颖")
    @PostMapping("/authModelStander/update")
    public ResponseDTO<String> update(@RequestBody @Validated AuthModelStanderUpdateDTO updateDTO){
        return authModelStanderService.update(updateDTO);
    }

    @ApiOperation(value="批量删除部门考核标准",notes = "@author 周天颖")
    @PostMapping("/authModelStander/deleteByIds")
    public ResponseDTO<String> delete(@RequestBody @Validated ValidateList<Long> idList) {
        return authModelStanderService.deleteByIds(idList);
    }

    @ApiOperation(value = "批量导出", notes = "@author 周天颖")
    @PostMapping("/authModelStander/export/batch")
    public void batchExport(@RequestBody @Validated ValidateList<Long> idList, HttpServletResponse response) {
        //查询数据
        List<AuthModelStanderExcelVO> authModelStanderList = authModelStanderService.queryBatchExportData(idList);
        //导出操作
        ExportParams ex = new ExportParams("部门考核标准", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, AuthModelStanderExcelVO.class, authModelStanderList);
        downloadExcel("部门考核标准", workbook, response);
    }

    @ApiOperation(value = "导出全部", notes = "@author 周天颖")
    @PostMapping("/authModelStander/export/all")
    public void exportAll(@RequestBody @Validated AuthModelStanderQueryDTO queryDTO, HttpServletResponse response) {
        //查询数据
        List<AuthModelStanderExcelVO> authModelStanderList = authModelStanderService.queryAllExportData(queryDTO);
        //导出操作
        ExportParams ex = new ExportParams("部门考核标准", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, AuthModelStanderExcelVO.class, authModelStanderList);
        downloadExcel("部门考核标准", workbook, response);
    }

}
