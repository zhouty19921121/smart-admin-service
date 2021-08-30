package net.lab1024.smartadmin.module.business.rpscore.controller;

import net.lab1024.smartadmin.common.domain.PageResultDTO;
import net.lab1024.smartadmin.common.controller.BaseController;
import net.lab1024.smartadmin.common.domain.ResponseDTO;
import net.lab1024.smartadmin.common.domain.ValidateList;
import net.lab1024.smartadmin.module.business.rpscore.domain.dto.AuthRewardsPenaltyAddDTO;
import net.lab1024.smartadmin.module.business.rpscore.domain.dto.AuthRewardsPenaltyUpdateDTO;
import net.lab1024.smartadmin.module.business.rpscore.domain.dto.AuthRewardsPenaltyQueryDTO;
import net.lab1024.smartadmin.module.business.rpscore.domain.vo.AuthRewardsPenaltyVO;
import net.lab1024.smartadmin.module.business.rpscore.domain.vo.AuthRewardsPenaltyExcelVO;
import net.lab1024.smartadmin.module.business.rpscore.service.AuthRewardsPenaltyService;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import net.lab1024.smartadmin.module.system.login.domain.RequestTokenBO;
import net.lab1024.smartadmin.util.SmartRequestTokenUtil;
import org.apache.poi.ss.usermodel.Workbook;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * [ 考核加分扣分记录表 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-20 11:36:35
 * @since JDK1.8
 */
@RestController
@Api(tags = {"考核加分扣分记录表"})
public class AuthRewardsPenaltyController extends BaseController {

    @Autowired
    private AuthRewardsPenaltyService authRewardsPenaltyService;

    @ApiOperation(value = "分页查询考核加分扣分记录表",notes = "@author 周天颖")
    @PostMapping("/authRewardsPenalty/page/query")
    public ResponseDTO<PageResultDTO<AuthRewardsPenaltyVO>> queryByPage(@RequestBody AuthRewardsPenaltyQueryDTO queryDTO) {
        return authRewardsPenaltyService.queryByPage(queryDTO);
    }

    @ApiOperation(value = "添加考核加分扣分记录表",notes = "@author 周天颖")
    @PostMapping("/authRewardsPenalty/add")
    public ResponseDTO<String> add(@RequestBody @Validated AuthRewardsPenaltyAddDTO addTO){
        RequestTokenBO requestToken = SmartRequestTokenUtil.getRequestUser();
        return authRewardsPenaltyService.add(addTO,requestToken);
    }

    @ApiOperation(value="修改考核加分扣分记录表",notes = "@author 周天颖")
    @PostMapping("/authRewardsPenalty/update")
    public ResponseDTO<String> update(@RequestBody @Validated AuthRewardsPenaltyUpdateDTO updateDTO){
        return authRewardsPenaltyService.update(updateDTO);
    }

    @ApiOperation(value="批量删除考核加分扣分记录表",notes = "@author 周天颖")
    @PostMapping("/authRewardsPenalty/deleteByIds")
    public ResponseDTO<String> delete(@RequestBody @Validated ValidateList<Long> idList) {
        return authRewardsPenaltyService.deleteByIds(idList);
    }

    @ApiOperation(value = "批量导出", notes = "@author 周天颖")
    @PostMapping("/authRewardsPenalty/export/batch")
    public void batchExport(@RequestBody @Validated ValidateList<Long> idList, HttpServletResponse response) {
        //查询数据
        List<AuthRewardsPenaltyExcelVO> authRewardsPenaltyList = authRewardsPenaltyService.queryBatchExportData(idList);
        //导出操作
        ExportParams ex = new ExportParams("考核加分扣分记录表", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, AuthRewardsPenaltyExcelVO.class, authRewardsPenaltyList);
        downloadExcel("考核加分扣分记录表", workbook, response);
    }

    @ApiOperation(value = "导出全部", notes = "@author 周天颖")
    @PostMapping("/authRewardsPenalty/export/all")
    public void exportAll(@RequestBody @Validated AuthRewardsPenaltyQueryDTO queryDTO, HttpServletResponse response) {
        //查询数据
        List<AuthRewardsPenaltyExcelVO> authRewardsPenaltyList = authRewardsPenaltyService.queryAllExportData(queryDTO);
        //导出操作
        ExportParams ex = new ExportParams("考核加分扣分记录表", "Sheet1");
        Workbook workbook = ExcelExportUtil.exportExcel(ex, AuthRewardsPenaltyExcelVO.class, authRewardsPenaltyList);
        downloadExcel("考核加分扣分记录表", workbook, response);
    }

}
