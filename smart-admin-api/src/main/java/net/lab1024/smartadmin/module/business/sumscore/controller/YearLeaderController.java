package net.lab1024.smartadmin.module.business.sumscore.controller;

import net.lab1024.smartadmin.common.domain.PageResultDTO;
import net.lab1024.smartadmin.common.controller.BaseController;
import net.lab1024.smartadmin.common.domain.ResponseDTO;
import net.lab1024.smartadmin.common.domain.ValidateList;
import net.lab1024.smartadmin.module.business.sumscore.domain.dto.YearLeaderAddDTO;
import net.lab1024.smartadmin.module.business.sumscore.domain.dto.YearLeaderUpdateDTO;
import net.lab1024.smartadmin.module.business.sumscore.domain.dto.YearLeaderQueryDTO;
import net.lab1024.smartadmin.module.business.sumscore.domain.vo.YearLeaderVO;
import net.lab1024.smartadmin.module.business.sumscore.domain.vo.YearLeaderExcelVO;
import net.lab1024.smartadmin.module.business.sumscore.service.YearLeaderService;
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
 * [ 年度综合考评成绩汇总 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-15 14:57:40
 * @since JDK1.8
 */
@RestController
@Api(tags = {"年度综合考评成绩汇总"})
public class YearLeaderController extends BaseController {

    @Autowired
    private YearLeaderService yearLeaderService;

    @ApiOperation(value = "分页查询年度综合考评成绩汇总",notes = "@author 周天颖")
    @PostMapping("/yearLeader/page/query")
    public ResponseDTO<PageResultDTO<YearLeaderVO>> queryByPage(@RequestBody YearLeaderQueryDTO queryDTO) {
        return yearLeaderService.queryByPage(queryDTO);
    }

    @ApiOperation(value = "添加年度综合考评成绩汇总",notes = "@author 周天颖")
    @PostMapping("/yearLeader/add")
    public ResponseDTO<String> add(@RequestBody @Validated YearLeaderAddDTO addTO){
        return yearLeaderService.add(addTO);
    }

    @ApiOperation(value="修改年度综合考评成绩汇总",notes = "@author 周天颖")
    @PostMapping("/yearLeader/update")
    public ResponseDTO<String> update(@RequestBody @Validated YearLeaderUpdateDTO updateDTO){
        return yearLeaderService.update(updateDTO);
    }

    @ApiOperation(value="批量删除年度综合考评成绩汇总",notes = "@author 周天颖")
    @PostMapping("/yearLeader/deleteByIds")
    public ResponseDTO<String> delete(@RequestBody @Validated ValidateList<Long> idList) {
        return yearLeaderService.deleteByIds(idList);
    }

    @ApiOperation(value = "批量导出", notes = "@author 周天颖")
    @PostMapping("/yearLeader/export/batch")
    public void batchExport(@RequestBody @Validated ValidateList<Long> idList, HttpServletResponse response) {
        //查询数据
        List<YearLeaderExcelVO> yearLeaderList = yearLeaderService.queryBatchExportData(idList);
        //导出操作
        ExportParams ex = new ExportParams("年度综合考评成绩汇总", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, YearLeaderExcelVO.class, yearLeaderList);
        downloadExcel("年度综合考评成绩汇总", workbook, response);
    }

    @ApiOperation(value = "导出全部", notes = "@author 周天颖")
    @PostMapping("/yearLeader/export/all")
    public void exportAll(@RequestBody @Validated YearLeaderQueryDTO queryDTO, HttpServletResponse response) {
        //查询数据
        List<YearLeaderExcelVO> yearLeaderList = yearLeaderService.queryAllExportData(queryDTO);
        //导出操作
        ExportParams ex = new ExportParams("年度综合考评成绩汇总", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, YearLeaderExcelVO.class, yearLeaderList);
        downloadExcel("年度综合考评成绩汇总", workbook, response);
    }

}
