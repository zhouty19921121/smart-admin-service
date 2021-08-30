package net.lab1024.smartadmin.module.business.score.controller;

import net.lab1024.smartadmin.common.domain.PageResultDTO;
import net.lab1024.smartadmin.common.controller.BaseController;
import net.lab1024.smartadmin.common.domain.ResponseDTO;
import net.lab1024.smartadmin.common.domain.ValidateList;
import net.lab1024.smartadmin.module.business.score.domain.dto.LeaderCompanyAddDTO;
import net.lab1024.smartadmin.module.business.score.domain.dto.LeaderCompanyUpdateDTO;
import net.lab1024.smartadmin.module.business.score.domain.dto.LeaderCompanyQueryDTO;
import net.lab1024.smartadmin.module.business.score.domain.vo.LeaderCompanyVO;
import net.lab1024.smartadmin.module.business.score.domain.vo.LeaderCompanyExcelVO;
import net.lab1024.smartadmin.module.business.score.service.LeaderCompanyService;
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
 * [ 基层员工评价对所属各单位测评表 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-15 12:57:48
 * @since JDK1.8
 */
@RestController
@Api(tags = {"基层员工评价对所属各单位测评表"})
public class LeaderCompanyController extends BaseController {

    @Autowired
    private LeaderCompanyService leaderCompanyService;

    @ApiOperation(value = "分页查询基层员工评价对所属各单位测评表",notes = "@author 周天颖")
    @PostMapping("/leaderCompany/page/query")
    public ResponseDTO<PageResultDTO<LeaderCompanyVO>> queryByPage(@RequestBody LeaderCompanyQueryDTO queryDTO) {
        return leaderCompanyService.queryByPage(queryDTO);
    }

    @ApiOperation(value = "添加基层员工评价对所属各单位测评表",notes = "@author 周天颖")
    @PostMapping("/leaderCompany/add")
    public ResponseDTO<String> add(@RequestBody @Validated LeaderCompanyAddDTO addTO){
        return leaderCompanyService.add(addTO);
    }

    @ApiOperation(value="修改基层员工评价对所属各单位测评表",notes = "@author 周天颖")
    @PostMapping("/leaderCompany/update")
    public ResponseDTO<String> update(@RequestBody @Validated LeaderCompanyUpdateDTO updateDTO){
        return leaderCompanyService.update(updateDTO);
    }

    @ApiOperation(value="批量删除基层员工评价对所属各单位测评表",notes = "@author 周天颖")
    @PostMapping("/leaderCompany/deleteByIds")
    public ResponseDTO<String> delete(@RequestBody @Validated ValidateList<Long> idList) {
        return leaderCompanyService.deleteByIds(idList);
    }

    @ApiOperation(value = "批量导出", notes = "@author 周天颖")
    @PostMapping("/leaderCompany/export/batch")
    public void batchExport(@RequestBody @Validated ValidateList<Long> idList, HttpServletResponse response) {
        //查询数据
        List<LeaderCompanyExcelVO> leaderCompanyList = leaderCompanyService.queryBatchExportData(idList);
        //导出操作
        ExportParams ex = new ExportParams("基层员工评价对所属各单位测评表", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, LeaderCompanyExcelVO.class, leaderCompanyList);
        downloadExcel("基层员工评价对所属各单位测评表", workbook, response);
    }

    @ApiOperation(value = "导出全部", notes = "@author 周天颖")
    @PostMapping("/leaderCompany/export/all")
    public void exportAll(@RequestBody @Validated LeaderCompanyQueryDTO queryDTO, HttpServletResponse response) {
        //查询数据
        List<LeaderCompanyExcelVO> leaderCompanyList = leaderCompanyService.queryAllExportData(queryDTO);
        //导出操作
        ExportParams ex = new ExportParams("基层员工评价对所属各单位测评表", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, LeaderCompanyExcelVO.class, leaderCompanyList);
        downloadExcel("基层员工评价对所属各单位测评表", workbook, response);
    }

}
