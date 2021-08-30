package net.lab1024.smartadmin.module.business.score.controller;

import net.lab1024.smartadmin.common.domain.PageResultDTO;
import net.lab1024.smartadmin.common.controller.BaseController;
import net.lab1024.smartadmin.common.domain.ResponseDTO;
import net.lab1024.smartadmin.common.domain.ValidateList;
import net.lab1024.smartadmin.module.business.score.domain.dto.CleaderDepartmentSfAddDTO;
import net.lab1024.smartadmin.module.business.score.domain.dto.CleaderDepartmentSfUpdateDTO;
import net.lab1024.smartadmin.module.business.score.domain.dto.CleaderDepartmentSfQueryDTO;
import net.lab1024.smartadmin.module.business.score.domain.vo.CleaderDepartmentSfVO;
import net.lab1024.smartadmin.module.business.score.domain.vo.CleaderDepartmentSfExcelVO;
import net.lab1024.smartadmin.module.business.score.service.CleaderDepartmentSfService;
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
 * [ 基层单位对机关部门评议打分表（收费） ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-15 12:53:32
 * @since JDK1.8
 */
@RestController
@Api(tags = {"基层单位对机关部门评议打分表（收费）"})
public class CleaderDepartmentSfController extends BaseController {

    @Autowired
    private CleaderDepartmentSfService cleaderDepartmentSfService;

    @ApiOperation(value = "分页查询基层单位对机关部门评议打分表（收费）",notes = "@author 周天颖")
    @PostMapping("/cleaderDepartmentSf/page/query")
    public ResponseDTO<PageResultDTO<CleaderDepartmentSfVO>> queryByPage(@RequestBody CleaderDepartmentSfQueryDTO queryDTO) {
        return cleaderDepartmentSfService.queryByPage(queryDTO);
    }

    @ApiOperation(value = "添加基层单位对机关部门评议打分表（收费）",notes = "@author 周天颖")
    @PostMapping("/cleaderDepartmentSf/add")
    public ResponseDTO<String> add(@RequestBody @Validated CleaderDepartmentSfAddDTO addTO){
        return cleaderDepartmentSfService.add(addTO);
    }

    @ApiOperation(value="修改基层单位对机关部门评议打分表（收费）",notes = "@author 周天颖")
    @PostMapping("/cleaderDepartmentSf/update")
    public ResponseDTO<String> update(@RequestBody @Validated CleaderDepartmentSfUpdateDTO updateDTO){
        return cleaderDepartmentSfService.update(updateDTO);
    }

    @ApiOperation(value="批量删除基层单位对机关部门评议打分表（收费）",notes = "@author 周天颖")
    @PostMapping("/cleaderDepartmentSf/deleteByIds")
    public ResponseDTO<String> delete(@RequestBody @Validated ValidateList<Long> idList) {
        return cleaderDepartmentSfService.deleteByIds(idList);
    }

    @ApiOperation(value = "批量导出", notes = "@author 周天颖")
    @PostMapping("/cleaderDepartmentSf/export/batch")
    public void batchExport(@RequestBody @Validated ValidateList<Long> idList, HttpServletResponse response) {
        //查询数据
        List<CleaderDepartmentSfExcelVO> cleaderDepartmentSfList = cleaderDepartmentSfService.queryBatchExportData(idList);
        //导出操作
        ExportParams ex = new ExportParams("基层单位对机关部门评议打分表（收费）", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, CleaderDepartmentSfExcelVO.class, cleaderDepartmentSfList);
        downloadExcel("基层单位对机关部门评议打分表（收费）", workbook, response);
    }

    @ApiOperation(value = "导出全部", notes = "@author 周天颖")
    @PostMapping("/cleaderDepartmentSf/export/all")
    public void exportAll(@RequestBody @Validated CleaderDepartmentSfQueryDTO queryDTO, HttpServletResponse response) {
        //查询数据
        List<CleaderDepartmentSfExcelVO> cleaderDepartmentSfList = cleaderDepartmentSfService.queryAllExportData(queryDTO);
        //导出操作
        ExportParams ex = new ExportParams("基层单位对机关部门评议打分表（收费）", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, CleaderDepartmentSfExcelVO.class, cleaderDepartmentSfList);
        downloadExcel("基层单位对机关部门评议打分表（收费）", workbook, response);
    }

}
