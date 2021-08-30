package net.lab1024.smartadmin.module.business.model.controller;

import net.lab1024.smartadmin.common.domain.PageResultDTO;
import net.lab1024.smartadmin.common.controller.BaseController;
import net.lab1024.smartadmin.common.domain.ResponseDTO;
import net.lab1024.smartadmin.common.domain.ValidateList;
import net.lab1024.smartadmin.module.business.model.domain.dto.AuthModelAddDTO;
import net.lab1024.smartadmin.module.business.model.domain.dto.AuthModelUpdateDTO;
import net.lab1024.smartadmin.module.business.model.domain.dto.AuthModelQueryDTO;
import net.lab1024.smartadmin.module.business.model.domain.vo.AuthModelVO;
import net.lab1024.smartadmin.module.business.model.domain.vo.AuthModelExcelVO;
import net.lab1024.smartadmin.module.business.model.service.AuthModelService;
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
 * [ 考核模板 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-14 22:11:15
 * @since JDK1.8
 */
@RestController
@Api(tags = {"考核模板"})
public class AuthModelController extends BaseController {

    @Autowired
    private AuthModelService authModelService;

    @ApiOperation(value = "分页查询考核模板",notes = "@author 周天颖")
    @PostMapping("/authModel/page/query")
    public ResponseDTO<PageResultDTO<AuthModelVO>> queryByPage(@RequestBody AuthModelQueryDTO queryDTO) {
        return authModelService.queryByPage(queryDTO);
    }

    @ApiOperation(value = "添加考核模板",notes = "@author 周天颖")
    @PostMapping("/authModel/add")
    public ResponseDTO<String> add(@RequestBody @Validated AuthModelAddDTO addTO){
        return authModelService.add(addTO);
    }

    @ApiOperation(value="修改考核模板",notes = "@author 周天颖")
    @PostMapping("/authModel/update")
    public ResponseDTO<String> update(@RequestBody @Validated AuthModelUpdateDTO updateDTO){
        return authModelService.update(updateDTO);
    }

    @ApiOperation(value="批量删除考核模板",notes = "@author 周天颖")
    @PostMapping("/authModel/deleteByIds")
    public ResponseDTO<String> delete(@RequestBody @Validated ValidateList<Long> idList) {
        return authModelService.deleteByIds(idList);
    }

    @ApiOperation(value = "批量导出", notes = "@author 周天颖")
    @PostMapping("/authModel/export/batch")
    public void batchExport(@RequestBody @Validated ValidateList<Long> idList, HttpServletResponse response) {
        //查询数据
        List<AuthModelExcelVO> authModelList = authModelService.queryBatchExportData(idList);
        //导出操作
        ExportParams ex = new ExportParams("考核模板", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, AuthModelExcelVO.class, authModelList);
        downloadExcel("考核模板", workbook, response);
    }

    @ApiOperation(value = "导出全部", notes = "@author 周天颖")
    @PostMapping("/authModel/export/all")
    public void exportAll(@RequestBody @Validated AuthModelQueryDTO queryDTO, HttpServletResponse response) {
        //查询数据
        List<AuthModelExcelVO> authModelList = authModelService.queryAllExportData(queryDTO);
        //导出操作
        ExportParams ex = new ExportParams("考核模板", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, AuthModelExcelVO.class, authModelList);
        downloadExcel("考核模板", workbook, response);
    }

}
