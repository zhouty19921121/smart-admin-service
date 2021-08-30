package net.lab1024.smartadmin.module.business.score.controller;

import net.lab1024.smartadmin.common.domain.PageResultDTO;
import net.lab1024.smartadmin.common.controller.BaseController;
import net.lab1024.smartadmin.common.domain.ResponseDTO;
import net.lab1024.smartadmin.common.domain.ValidateList;
import net.lab1024.smartadmin.module.business.score.domain.dto.CleaderDepartmentLcAddDTO;
import net.lab1024.smartadmin.module.business.score.domain.dto.CleaderDepartmentLcUpdateDTO;
import net.lab1024.smartadmin.module.business.score.domain.dto.CleaderDepartmentLcQueryDTO;
import net.lab1024.smartadmin.module.business.score.domain.vo.CleaderDepartmentLcVO;
import net.lab1024.smartadmin.module.business.score.domain.vo.CleaderDepartmentLcExcelVO;
import net.lab1024.smartadmin.module.business.score.service.CleaderDepartmentLcService;
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
 * [ 基层单位对机关部门评议打分表（路产） ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-15 12:50:51
 * @since JDK1.8
 */
@RestController
@Api(tags = {"基层单位对机关部门评议打分表（路产）"})
public class CleaderDepartmentLcController extends BaseController {

    @Autowired
    private CleaderDepartmentLcService cleaderDepartmentLcService;

    @ApiOperation(value = "分页查询基层单位对机关部门评议打分表（路产）",notes = "@author 周天颖")
    @PostMapping("/cleaderDepartmentLc/page/query")
    public ResponseDTO<PageResultDTO<CleaderDepartmentLcVO>> queryByPage(@RequestBody CleaderDepartmentLcQueryDTO queryDTO) {
        return cleaderDepartmentLcService.queryByPage(queryDTO);
    }

    @ApiOperation(value = "添加基层单位对机关部门评议打分表（路产）",notes = "@author 周天颖")
    @PostMapping("/cleaderDepartmentLc/add")
    public ResponseDTO<String> add(@RequestBody @Validated CleaderDepartmentLcAddDTO addTO){
        return cleaderDepartmentLcService.add(addTO);
    }

    @ApiOperation(value="修改基层单位对机关部门评议打分表（路产）",notes = "@author 周天颖")
    @PostMapping("/cleaderDepartmentLc/update")
    public ResponseDTO<String> update(@RequestBody @Validated CleaderDepartmentLcUpdateDTO updateDTO){
        return cleaderDepartmentLcService.update(updateDTO);
    }

    @ApiOperation(value="批量删除基层单位对机关部门评议打分表（路产）",notes = "@author 周天颖")
    @PostMapping("/cleaderDepartmentLc/deleteByIds")
    public ResponseDTO<String> delete(@RequestBody @Validated ValidateList<Long> idList) {
        return cleaderDepartmentLcService.deleteByIds(idList);
    }

    @ApiOperation(value = "批量导出", notes = "@author 周天颖")
    @PostMapping("/cleaderDepartmentLc/export/batch")
    public void batchExport(@RequestBody @Validated ValidateList<Long> idList, HttpServletResponse response) {
        //查询数据
        List<CleaderDepartmentLcExcelVO> cleaderDepartmentLcList = cleaderDepartmentLcService.queryBatchExportData(idList);
        //导出操作
        ExportParams ex = new ExportParams("基层单位对机关部门评议打分表（路产）", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, CleaderDepartmentLcExcelVO.class, cleaderDepartmentLcList);
        downloadExcel("基层单位对机关部门评议打分表（路产）", workbook, response);
    }

    @ApiOperation(value = "导出全部", notes = "@author 周天颖")
    @PostMapping("/cleaderDepartmentLc/export/all")
    public void exportAll(@RequestBody @Validated CleaderDepartmentLcQueryDTO queryDTO, HttpServletResponse response) {
        //查询数据
        List<CleaderDepartmentLcExcelVO> cleaderDepartmentLcList = cleaderDepartmentLcService.queryAllExportData(queryDTO);
        //导出操作
        ExportParams ex = new ExportParams("基层单位对机关部门评议打分表（路产）", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, CleaderDepartmentLcExcelVO.class, cleaderDepartmentLcList);
        downloadExcel("基层单位对机关部门评议打分表（路产）", workbook, response);
    }

}
