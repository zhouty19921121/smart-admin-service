package net.lab1024.smartadmin.module.business.score.controller;

import net.lab1024.smartadmin.common.domain.PageResultDTO;
import net.lab1024.smartadmin.common.controller.BaseController;
import net.lab1024.smartadmin.common.domain.ResponseDTO;
import net.lab1024.smartadmin.common.domain.ValidateList;
import net.lab1024.smartadmin.module.business.score.domain.dto.PersonCompanyAddDTO;
import net.lab1024.smartadmin.module.business.score.domain.dto.PersonCompanyUpdateDTO;
import net.lab1024.smartadmin.module.business.score.domain.dto.PersonCompanyQueryDTO;
import net.lab1024.smartadmin.module.business.score.domain.vo.PersonCompanyVO;
import net.lab1024.smartadmin.module.business.score.domain.vo.PersonCompanyExcelVO;
import net.lab1024.smartadmin.module.business.score.service.PersonCompanyService;
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
 * [ 基层员工评价表 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-15 13:03:21
 * @since JDK1.8
 */
@RestController
@Api(tags = {"基层员工评价表"})
public class PersonCompanyController extends BaseController {

    @Autowired
    private PersonCompanyService personCompanyService;

    @ApiOperation(value = "分页查询基层员工评价表",notes = "@author 周天颖")
    @PostMapping("/personCompany/page/query")
    public ResponseDTO<PageResultDTO<PersonCompanyVO>> queryByPage(@RequestBody PersonCompanyQueryDTO queryDTO) {
        return personCompanyService.queryByPage(queryDTO);
    }

    @ApiOperation(value = "添加基层员工评价表",notes = "@author 周天颖")
    @PostMapping("/personCompany/add")
    public ResponseDTO<String> add(@RequestBody @Validated PersonCompanyAddDTO addTO){
        return personCompanyService.add(addTO);
    }

    @ApiOperation(value="修改基层员工评价表",notes = "@author 周天颖")
    @PostMapping("/personCompany/update")
    public ResponseDTO<String> update(@RequestBody @Validated PersonCompanyUpdateDTO updateDTO){
        return personCompanyService.update(updateDTO);
    }

    @ApiOperation(value="批量删除基层员工评价表",notes = "@author 周天颖")
    @PostMapping("/personCompany/deleteByIds")
    public ResponseDTO<String> delete(@RequestBody @Validated ValidateList<Long> idList) {
        return personCompanyService.deleteByIds(idList);
    }

    @ApiOperation(value = "批量导出", notes = "@author 周天颖")
    @PostMapping("/personCompany/export/batch")
    public void batchExport(@RequestBody @Validated ValidateList<Long> idList, HttpServletResponse response) {
        //查询数据
        List<PersonCompanyExcelVO> personCompanyList = personCompanyService.queryBatchExportData(idList);
        //导出操作
        ExportParams ex = new ExportParams("基层员工评价表", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, PersonCompanyExcelVO.class, personCompanyList);
        downloadExcel("基层员工评价表", workbook, response);
    }

    @ApiOperation(value = "导出全部", notes = "@author 周天颖")
    @PostMapping("/personCompany/export/all")
    public void exportAll(@RequestBody @Validated PersonCompanyQueryDTO queryDTO, HttpServletResponse response) {
        //查询数据
        List<PersonCompanyExcelVO> personCompanyList = personCompanyService.queryAllExportData(queryDTO);
        //导出操作
        ExportParams ex = new ExportParams("基层员工评价表", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, PersonCompanyExcelVO.class, personCompanyList);
        downloadExcel("基层员工评价表", workbook, response);
    }

}
