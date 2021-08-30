package net.lab1024.smartadmin.module.business.score.controller;

import net.lab1024.smartadmin.common.domain.PageResultDTO;
import net.lab1024.smartadmin.common.controller.BaseController;
import net.lab1024.smartadmin.common.domain.ResponseDTO;
import net.lab1024.smartadmin.common.domain.ValidateList;
import net.lab1024.smartadmin.module.business.score.domain.dto.LeaderDepartmentAddDTO;
import net.lab1024.smartadmin.module.business.score.domain.dto.LeaderDepartmentUpdateDTO;
import net.lab1024.smartadmin.module.business.score.domain.dto.LeaderDepartmentQueryDTO;
import net.lab1024.smartadmin.module.business.score.domain.vo.LeaderDepartmentVO;
import net.lab1024.smartadmin.module.business.score.domain.vo.LeaderDepartmentExcelVO;
import net.lab1024.smartadmin.module.business.score.service.LeaderDepartmentService;
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
 * [ 公司领导对机关部门民主评议 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-15 12:59:58
 * @since JDK1.8
 */
@RestController
@Api(tags = {"公司领导对机关部门民主评议"})
public class LeaderDepartmentController extends BaseController {

    @Autowired
    private LeaderDepartmentService leaderDepartmentService;

    @ApiOperation(value = "分页查询公司领导对机关部门民主评议",notes = "@author 周天颖")
    @PostMapping("/leaderDepartment/page/query")
    public ResponseDTO<PageResultDTO<LeaderDepartmentVO>> queryByPage(@RequestBody LeaderDepartmentQueryDTO queryDTO) {
        return leaderDepartmentService.queryByPage(queryDTO);
    }

    @ApiOperation(value = "添加公司领导对机关部门民主评议",notes = "@author 周天颖")
    @PostMapping("/leaderDepartment/add")
    public ResponseDTO<String> add(@RequestBody @Validated LeaderDepartmentAddDTO addTO){
        return leaderDepartmentService.add(addTO);
    }

    @ApiOperation(value="修改公司领导对机关部门民主评议",notes = "@author 周天颖")
    @PostMapping("/leaderDepartment/update")
    public ResponseDTO<String> update(@RequestBody @Validated LeaderDepartmentUpdateDTO updateDTO){
        return leaderDepartmentService.update(updateDTO);
    }

    @ApiOperation(value="批量删除公司领导对机关部门民主评议",notes = "@author 周天颖")
    @PostMapping("/leaderDepartment/deleteByIds")
    public ResponseDTO<String> delete(@RequestBody @Validated ValidateList<Long> idList) {
        return leaderDepartmentService.deleteByIds(idList);
    }

    @ApiOperation(value = "批量导出", notes = "@author 周天颖")
    @PostMapping("/leaderDepartment/export/batch")
    public void batchExport(@RequestBody @Validated ValidateList<Long> idList, HttpServletResponse response) {
        //查询数据
        List<LeaderDepartmentExcelVO> leaderDepartmentList = leaderDepartmentService.queryBatchExportData(idList);
        //导出操作
        ExportParams ex = new ExportParams("公司领导对机关部门民主评议", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, LeaderDepartmentExcelVO.class, leaderDepartmentList);
        downloadExcel("公司领导对机关部门民主评议", workbook, response);
    }

    @ApiOperation(value = "导出全部", notes = "@author 周天颖")
    @PostMapping("/leaderDepartment/export/all")
    public void exportAll(@RequestBody @Validated LeaderDepartmentQueryDTO queryDTO, HttpServletResponse response) {
        //查询数据
        List<LeaderDepartmentExcelVO> leaderDepartmentList = leaderDepartmentService.queryAllExportData(queryDTO);
        //导出操作
        ExportParams ex = new ExportParams("公司领导对机关部门民主评议", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, LeaderDepartmentExcelVO.class, leaderDepartmentList);
        downloadExcel("公司领导对机关部门民主评议", workbook, response);
    }

}
