package net.lab1024.smartadmin.module.business.sumscore.controller;

import net.lab1024.smartadmin.common.domain.PageResultDTO;
import net.lab1024.smartadmin.common.controller.BaseController;
import net.lab1024.smartadmin.common.domain.ResponseDTO;
import net.lab1024.smartadmin.common.domain.ValidateList;
import net.lab1024.smartadmin.module.business.sumscore.domain.dto.QuarterDepartmentAddDTO;
import net.lab1024.smartadmin.module.business.sumscore.domain.dto.QuarterDepartmentUpdateDTO;
import net.lab1024.smartadmin.module.business.sumscore.domain.dto.QuarterDepartmentQueryDTO;
import net.lab1024.smartadmin.module.business.sumscore.domain.vo.QuarterDepartmentVO;
import net.lab1024.smartadmin.module.business.sumscore.domain.vo.QuarterDepartmentExcelVO;
import net.lab1024.smartadmin.module.business.sumscore.service.QuarterDepartmentService;
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
 * [ 季度本部各部门考核结果排名 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-15 14:41:36
 * @since JDK1.8
 */
@RestController
@Api(tags = {"季度本部各部门考核结果排名"})
public class QuarterDepartmentController extends BaseController {

    @Autowired
    private QuarterDepartmentService quarterDepartmentService;

    @ApiOperation(value = "分页查询季度本部各部门考核结果排名",notes = "@author 周天颖")
    @PostMapping("/quarterDepartment/page/query")
    public ResponseDTO<PageResultDTO<QuarterDepartmentVO>> queryByPage(@RequestBody QuarterDepartmentQueryDTO queryDTO) {
        return quarterDepartmentService.queryByPage(queryDTO);
    }

    @ApiOperation(value = "添加季度本部各部门考核结果排名",notes = "@author 周天颖")
    @PostMapping("/quarterDepartment/add")
    public ResponseDTO<String> add(@RequestBody @Validated QuarterDepartmentAddDTO addTO){
        return quarterDepartmentService.add(addTO);
    }

    @ApiOperation(value="修改季度本部各部门考核结果排名",notes = "@author 周天颖")
    @PostMapping("/quarterDepartment/update")
    public ResponseDTO<String> update(@RequestBody @Validated QuarterDepartmentUpdateDTO updateDTO){
        return quarterDepartmentService.update(updateDTO);
    }

    @ApiOperation(value="批量删除季度本部各部门考核结果排名",notes = "@author 周天颖")
    @PostMapping("/quarterDepartment/deleteByIds")
    public ResponseDTO<String> delete(@RequestBody @Validated ValidateList<Long> idList) {
        return quarterDepartmentService.deleteByIds(idList);
    }

    @ApiOperation(value = "批量导出", notes = "@author 周天颖")
    @PostMapping("/quarterDepartment/export/batch")
    public void batchExport(@RequestBody @Validated ValidateList<Long> idList, HttpServletResponse response) {
        //查询数据
        List<QuarterDepartmentExcelVO> quarterDepartmentList = quarterDepartmentService.queryBatchExportData(idList);
        //导出操作
        ExportParams ex = new ExportParams("季度本部各部门考核结果排名", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, QuarterDepartmentExcelVO.class, quarterDepartmentList);
        downloadExcel("季度本部各部门考核结果排名", workbook, response);
    }

    @ApiOperation(value = "导出全部", notes = "@author 周天颖")
    @PostMapping("/quarterDepartment/export/all")
    public void exportAll(@RequestBody @Validated QuarterDepartmentQueryDTO queryDTO, HttpServletResponse response) {
        //查询数据
        List<QuarterDepartmentExcelVO> quarterDepartmentList = quarterDepartmentService.queryAllExportData(queryDTO);
        //导出操作
        ExportParams ex = new ExportParams("季度本部各部门考核结果排名", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, QuarterDepartmentExcelVO.class, quarterDepartmentList);
        downloadExcel("季度本部各部门考核结果排名", workbook, response);
    }

}
