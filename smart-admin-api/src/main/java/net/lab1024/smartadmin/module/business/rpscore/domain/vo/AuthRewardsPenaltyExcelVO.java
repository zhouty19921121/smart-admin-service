package net.lab1024.smartadmin.module.business.rpscore.domain.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import java.util.Date;

/**
 *  [ 考核加分扣分记录表 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c) 三格数维Inc. All rights reserved.
 * @date  2021-08-20 11:36:35
 * @since JDK1.8
 */
@Data
public class AuthRewardsPenaltyExcelVO {
    @Excel(name = "任务ID")
    private Long id;

    @Excel(name = "年份")
    private String year;

    @Excel(name = "季度")
    private Integer quarter;

    @Excel(name = "月份")
    private Integer month;

    @Excel(name = "部门Id")
    private Long pId;

    @Excel(name = "考核内容")
    private String content;

    @Excel(name = "事项")
    private String item;

    @Excel(name = "分值")
    private Float point;

    @Excel(name = "备注")
    private String sucinfo;

    @Excel(name = "填报人")
    private Integer fillperson;

    @Excel(name = "填报时间", format = "yyyy-MM-dd HH:mm:ss")
    private Date filltime;

    @Excel(name = "是否复议1是")
    private Integer approval;

    @Excel(name = "审批人")
    private Integer approvalperson;

    @Excel(name = "审批时间", format = "yyyy-MM-dd HH:mm:ss")
    private Date approvaltime;

    @Excel(name = "类型1表彰减分2违纪加分")
    private Integer type;

    @Excel(name = "是否删除0否 1是")
    private Integer isDelete;

    @Excel(name = "更新时间", format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    @Excel(name = "创建时间", format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;



}
