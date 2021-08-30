package net.lab1024.smartadmin.module.business.article.controller;

import net.lab1024.smartadmin.common.domain.PageResultDTO;
import net.lab1024.smartadmin.common.controller.BaseController;
import net.lab1024.smartadmin.common.domain.ResponseDTO;
import net.lab1024.smartadmin.common.domain.ValidateList;
import net.lab1024.smartadmin.module.business.article.domain.dto.InnerArticleAddDTO;
import net.lab1024.smartadmin.module.business.article.domain.dto.InnerArticleUpdateDTO;
import net.lab1024.smartadmin.module.business.article.domain.dto.InnerArticleQueryDTO;
import net.lab1024.smartadmin.module.business.article.domain.vo.InnerArticleVO;
import net.lab1024.smartadmin.module.business.article.domain.vo.InnerArticleExcelVO;
import net.lab1024.smartadmin.module.business.article.service.InnerArticleService;
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
 * [ 内部采风 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-14 20:49:41
 * @since JDK1.8
 */
@RestController
@Api(tags = {"内部采风"})
public class InnerArticleController extends BaseController {

    @Autowired
    private InnerArticleService innerArticleService;

    @ApiOperation(value = "分页查询内部采风",notes = "@author 周天颖")
    @PostMapping("/innerArticle/page/query")
    public ResponseDTO<PageResultDTO<InnerArticleVO>> queryByPage(@RequestBody InnerArticleQueryDTO queryDTO) {
        return innerArticleService.queryByPage(queryDTO);
    }

    @ApiOperation(value = "添加内部采风",notes = "@author 周天颖")
    @PostMapping("/innerArticle/add")
    public ResponseDTO<String> add(@RequestBody @Validated InnerArticleAddDTO addTO){
        return innerArticleService.add(addTO);
    }

    @ApiOperation(value="修改内部采风",notes = "@author 周天颖")
    @PostMapping("/innerArticle/update")
    public ResponseDTO<String> update(@RequestBody @Validated InnerArticleUpdateDTO updateDTO){
        return innerArticleService.update(updateDTO);
    }

    @ApiOperation(value="批量删除内部采风",notes = "@author 周天颖")
    @PostMapping("/innerArticle/deleteByIds")
    public ResponseDTO<String> delete(@RequestBody @Validated ValidateList<Long> idList) {
        return innerArticleService.deleteByIds(idList);
    }

    @ApiOperation(value = "批量导出", notes = "@author 周天颖")
    @PostMapping("/innerArticle/export/batch")
    public void batchExport(@RequestBody @Validated ValidateList<Long> idList, HttpServletResponse response) {
        //查询数据
        List<InnerArticleExcelVO> innerArticleList = innerArticleService.queryBatchExportData(idList);
        //导出操作
        ExportParams ex = new ExportParams("内部采风", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, InnerArticleExcelVO.class, innerArticleList);
        downloadExcel("内部采风", workbook, response);
    }

    @ApiOperation(value = "导出全部", notes = "@author 周天颖")
    @PostMapping("/innerArticle/export/all")
    public void exportAll(@RequestBody @Validated InnerArticleQueryDTO queryDTO, HttpServletResponse response) {
        //查询数据
        List<InnerArticleExcelVO> innerArticleList = innerArticleService.queryAllExportData(queryDTO);
        //导出操作
        ExportParams ex = new ExportParams("内部采风", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, InnerArticleExcelVO.class, innerArticleList);
        downloadExcel("内部采风", workbook, response);
    }

}
