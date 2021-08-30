package net.lab1024.smartadmin.module.business.score.controller;

import net.lab1024.smartadmin.common.domain.PageResultDTO;
import net.lab1024.smartadmin.common.controller.BaseController;
import net.lab1024.smartadmin.common.domain.ResponseDTO;
import net.lab1024.smartadmin.common.domain.ValidateList;
import net.lab1024.smartadmin.module.business.score.domain.dto.DepartmenDepartmentAddDTO;
import net.lab1024.smartadmin.module.business.score.domain.dto.DepartmenDepartmentUpdateDTO;
import net.lab1024.smartadmin.module.business.score.domain.dto.DepartmenDepartmentQueryDTO;
import net.lab1024.smartadmin.module.business.score.domain.vo.DepartmenDepartmentVO;
import net.lab1024.smartadmin.module.business.score.domain.vo.DepartmenDepartmentExcelVO;
import net.lab1024.smartadmin.module.business.score.service.DepartmenDepartmentService;
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
 * [ 本部部门互评打分表 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-15 12:56:11
 * @since JDK1.8
 */
@RestController
@Api(tags = {"本部部门互评打分表"})
public class DepartmenDepartmentController extends BaseController {

    @Autowired
    private DepartmenDepartmentService departmenDepartmentService;

    @ApiOperation(value = "分页查询本部部门互评打分表",notes = "@author 周天颖")
    @PostMapping("/departmenDepartment/page/query")
    public ResponseDTO<PageResultDTO<DepartmenDepartmentVO>> queryByPage(@RequestBody DepartmenDepartmentQueryDTO queryDTO) {
        return departmenDepartmentService.queryByPage(queryDTO);
    }

    @ApiOperation(value = "添加本部部门互评打分表",notes = "@author 周天颖")
    @PostMapping("/departmenDepartment/add")
    public ResponseDTO<String> add(@RequestBody @Validated DepartmenDepartmentAddDTO addTO){
        return departmenDepartmentService.add(addTO);
    }

    @ApiOperation(value="修改本部部门互评打分表",notes = "@author 周天颖")
    @PostMapping("/departmenDepartment/update")
    public ResponseDTO<String> update(@RequestBody @Validated DepartmenDepartmentUpdateDTO updateDTO){
        return departmenDepartmentService.update(updateDTO);
    }

    @ApiOperation(value="批量删除本部部门互评打分表",notes = "@author 周天颖")
    @PostMapping("/departmenDepartment/deleteByIds")
    public ResponseDTO<String> delete(@RequestBody @Validated ValidateList<Long> idList) {
        return departmenDepartmentService.deleteByIds(idList);
    }

    @ApiOperation(value = "批量导出", notes = "@author 周天颖")
    @PostMapping("/departmenDepartment/export/batch")
    public void batchExport(@RequestBody @Validated ValidateList<Long> idList, HttpServletResponse response) {
        //查询数据
        List<DepartmenDepartmentExcelVO> departmenDepartmentList = departmenDepartmentService.queryBatchExportData(idList);
        //导出操作
        ExportParams ex = new ExportParams("本部部门互评打分表", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, DepartmenDepartmentExcelVO.class, departmenDepartmentList);
        downloadExcel("本部部门互评打分表", workbook, response);
    }

    @ApiOperation(value = "导出全部", notes = "@author 周天颖")
    @PostMapping("/departmenDepartment/export/all")
    public void exportAll(@RequestBody @Validated DepartmenDepartmentQueryDTO queryDTO, HttpServletResponse response) {
        //查询数据
        List<DepartmenDepartmentExcelVO> departmenDepartmentList = departmenDepartmentService.queryAllExportData(queryDTO);
        //导出操作
        ExportParams ex = new ExportParams("本部部门互评打分表", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, DepartmenDepartmentExcelVO.class, departmenDepartmentList);
        downloadExcel("本部部门互评打分表", workbook, response);
    }

}
