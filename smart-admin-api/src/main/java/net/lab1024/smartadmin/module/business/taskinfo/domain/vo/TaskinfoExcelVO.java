package net.lab1024.smartadmin.module.business.taskinfo.domain.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import java.util.Date;

/**
 *  [ 工作绩效 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c) 三格数维Inc. All rights reserved.
 * @date  2021-08-14 16:20:27
 * @since JDK1.8
 */
@Data
public class TaskinfoExcelVO {
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

    @Excel(name = "工作任务")
    private String name;

    @Excel(name = "计划完成时间", format = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    @Excel(name = "完成与否0未完成1已完成")
    private Integer approval;

    @Excel(name = "备注")
    private Integer sucinfo;

    @Excel(name = "分管领导")
    private Integer approvalperson;

    @Excel(name = "审批时间", format = "yyyy-MM-dd HH:mm:ss")
    private Date approvaltime;

    @Excel(name = "填报人")
    private Integer fillperson;

    @Excel(name = "填报时间", format = "yyyy-MM-dd HH:mm:ss")
    private Date filltime;

    @Excel(name = "主管领导")
    private Integer ownerperson;

    @Excel(name = "审批时间", format = "yyyy-MM-dd HH:mm:ss")
    private Date signtime;

    @Excel(name = "考核类型1月度2季度3年度")
    private Integer type;

    @Excel(name = "是否删除0否 1是")
    private Integer isDelete;

    @Excel(name = "状态11计划暂存12计划已提交13计划审核通过14计划审核不通过21计划暂存22计划已提交23计划审核通过24计划审核不通过25审结归档")
    private Integer status;



}
