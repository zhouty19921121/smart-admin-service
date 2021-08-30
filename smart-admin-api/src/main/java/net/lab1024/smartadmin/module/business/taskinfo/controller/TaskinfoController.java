package net.lab1024.smartadmin.module.business.taskinfo.controller;

import net.lab1024.smartadmin.common.domain.PageResultDTO;
import net.lab1024.smartadmin.common.controller.BaseController;
import net.lab1024.smartadmin.common.domain.ResponseDTO;
import net.lab1024.smartadmin.common.domain.ValidateList;
import net.lab1024.smartadmin.module.business.taskinfo.domain.dto.TaskinfoAddDTO;
import net.lab1024.smartadmin.module.business.taskinfo.domain.dto.TaskinfoUpdateDTO;
import net.lab1024.smartadmin.module.business.taskinfo.domain.dto.TaskinfoQueryDTO;
import net.lab1024.smartadmin.module.business.taskinfo.domain.vo.TaskinfoVO;
import net.lab1024.smartadmin.module.business.taskinfo.domain.vo.TaskinfoExcelVO;
import net.lab1024.smartadmin.module.business.taskinfo.service.TaskinfoService;
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
 * [ 工作绩效 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-14 16:20:27
 * @since JDK1.8
 */
@RestController
@Api(tags = {"工作绩效"})
public class TaskinfoController extends BaseController {

    @Autowired
    private TaskinfoService taskinfoService;

    @ApiOperation(value = "分页查询工作绩效",notes = "@author 周天颖")
    @PostMapping("/taskinfo/page/query")
    public ResponseDTO<PageResultDTO<TaskinfoVO>> queryByPage(@RequestBody TaskinfoQueryDTO queryDTO) {
        return taskinfoService.queryByPage(queryDTO);
    }

    @ApiOperation(value = "添加工作绩效",notes = "@author 周天颖")
    @PostMapping("/taskinfo/add")
    public ResponseDTO<String> add(@RequestBody @Validated TaskinfoAddDTO addTO){
        return taskinfoService.add(addTO);
    }

    @ApiOperation(value="修改工作绩效",notes = "@author 周天颖")
    @PostMapping("/taskinfo/update")
    public ResponseDTO<String> update(@RequestBody @Validated TaskinfoUpdateDTO updateDTO){
        return taskinfoService.update(updateDTO);
    }

    @ApiOperation(value="批量删除工作绩效",notes = "@author 周天颖")
    @PostMapping("/taskinfo/deleteByIds")
    public ResponseDTO<String> delete(@RequestBody @Validated ValidateList<Long> idList) {
        return taskinfoService.deleteByIds(idList);
    }

    @ApiOperation(value = "批量导出", notes = "@author 周天颖")
    @PostMapping("/taskinfo/export/batch")
    public void batchExport(@RequestBody @Validated ValidateList<Long> idList, HttpServletResponse response) {
        //查询数据
        List<TaskinfoExcelVO> taskinfoList = taskinfoService.queryBatchExportData(idList);
        //导出操作
        ExportParams ex = new ExportParams("工作绩效", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, TaskinfoExcelVO.class, taskinfoList);
        downloadExcel("工作绩效", workbook, response);
    }

    @ApiOperation(value = "导出全部", notes = "@author 周天颖")
    @PostMapping("/taskinfo/export/all")
    public void exportAll(@RequestBody @Validated TaskinfoQueryDTO queryDTO, HttpServletResponse response) {
        //查询数据
        List<TaskinfoExcelVO> taskinfoList = taskinfoService.queryAllExportData(queryDTO);
        //导出操作
        ExportParams ex = new ExportParams("工作绩效", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, TaskinfoExcelVO.class, taskinfoList);
        downloadExcel("工作绩效", workbook, response);
    }

}
