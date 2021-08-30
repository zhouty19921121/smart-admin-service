package net.lab1024.smartadmin.module.business.sumscore.controller;

import net.lab1024.smartadmin.common.domain.PageResultDTO;
import net.lab1024.smartadmin.common.controller.BaseController;
import net.lab1024.smartadmin.common.domain.ResponseDTO;
import net.lab1024.smartadmin.common.domain.ValidateList;
import net.lab1024.smartadmin.module.business.sumscore.domain.dto.QuarterCompanyAddDTO;
import net.lab1024.smartadmin.module.business.sumscore.domain.dto.QuarterCompanyUpdateDTO;
import net.lab1024.smartadmin.module.business.sumscore.domain.dto.QuarterCompanyQueryDTO;
import net.lab1024.smartadmin.module.business.sumscore.domain.vo.QuarterCompanyVO;
import net.lab1024.smartadmin.module.business.sumscore.domain.vo.QuarterCompanyExcelVO;
import net.lab1024.smartadmin.module.business.sumscore.service.QuarterCompanyService;
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
 * [ 季度所属各单位考核结果排名 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-15 14:39:58
 * @since JDK1.8
 */
@RestController
@Api(tags = {"季度所属各单位考核结果排名"})
public class QuarterCompanyController extends BaseController {

    @Autowired
    private QuarterCompanyService quarterCompanyService;

    @ApiOperation(value = "分页查询季度所属各单位考核结果排名",notes = "@author 周天颖")
    @PostMapping("/quarterCompany/page/query")
    public ResponseDTO<PageResultDTO<QuarterCompanyVO>> queryByPage(@RequestBody QuarterCompanyQueryDTO queryDTO) {
        return quarterCompanyService.queryByPage(queryDTO);
    }

    @ApiOperation(value = "添加季度所属各单位考核结果排名",notes = "@author 周天颖")
    @PostMapping("/quarterCompany/add")
    public ResponseDTO<String> add(@RequestBody @Validated QuarterCompanyAddDTO addTO){
        return quarterCompanyService.add(addTO);
    }

    @ApiOperation(value="修改季度所属各单位考核结果排名",notes = "@author 周天颖")
    @PostMapping("/quarterCompany/update")
    public ResponseDTO<String> update(@RequestBody @Validated QuarterCompanyUpdateDTO updateDTO){
        return quarterCompanyService.update(updateDTO);
    }

    @ApiOperation(value="批量删除季度所属各单位考核结果排名",notes = "@author 周天颖")
    @PostMapping("/quarterCompany/deleteByIds")
    public ResponseDTO<String> delete(@RequestBody @Validated ValidateList<Long> idList) {
        return quarterCompanyService.deleteByIds(idList);
    }

    @ApiOperation(value = "批量导出", notes = "@author 周天颖")
    @PostMapping("/quarterCompany/export/batch")
    public void batchExport(@RequestBody @Validated ValidateList<Long> idList, HttpServletResponse response) {
        //查询数据
        List<QuarterCompanyExcelVO> quarterCompanyList = quarterCompanyService.queryBatchExportData(idList);
        //导出操作
        ExportParams ex = new ExportParams("季度所属各单位考核结果排名", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, QuarterCompanyExcelVO.class, quarterCompanyList);
        downloadExcel("季度所属各单位考核结果排名", workbook, response);
    }

    @ApiOperation(value = "导出全部", notes = "@author 周天颖")
    @PostMapping("/quarterCompany/export/all")
    public void exportAll(@RequestBody @Validated QuarterCompanyQueryDTO queryDTO, HttpServletResponse response) {
        //查询数据
        List<QuarterCompanyExcelVO> quarterCompanyList = quarterCompanyService.queryAllExportData(queryDTO);
        //导出操作
        ExportParams ex = new ExportParams("季度所属各单位考核结果排名", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, QuarterCompanyExcelVO.class, quarterCompanyList);
        downloadExcel("季度所属各单位考核结果排名", workbook, response);
    }

}
