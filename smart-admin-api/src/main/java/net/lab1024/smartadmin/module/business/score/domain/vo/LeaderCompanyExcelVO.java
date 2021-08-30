package net.lab1024.smartadmin.module.business.score.domain.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import java.util.Date;

/**
 *  [ 基层员工评价对所属各单位测评表 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c) 三格数维Inc. All rights reserved.
 * @date  2021-08-15 12:57:48
 * @since JDK1.8
 */
@Data
public class LeaderCompanyExcelVO {
    @Excel(name = "ID")
    private Long id;

    @Excel(name = "基层单位ID")
    private Long pId;

    @Excel(name = "考核周期")
    private String taskId;

    @Excel(name = "工作计划")
    private Integer item1;

    @Excel(name = "工作执行情况")
    private Integer item2;

    @Excel(name = "工作作风")
    private Integer item3;

    @Excel(name = "队伍建设")
    private Integer item4;

    @Excel(name = "是否复议1是")
    private Integer approval;

    @Excel(name = "审批人")
    private Integer approvalperson;

    @Excel(name = "审批时间", format = "yyyy-MM-dd HH:mm:ss")
    private Date approvaltime;

    @Excel(name = "总分")
    private Integer total;

    @Excel(name = "季度")
    private Integer quarter;

    @Excel(name = "年份")
    private String year;

    @Excel(name = "是否删除0否 1是")
    private Integer isDelete;



}
