package net.lab1024.smartadmin.module.business.sumscore.domain.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import java.util.Date;

/**
 *  [ 季度所属各单位考核结果排名 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c) 三格数维Inc. All rights reserved.
 * @date  2021-08-15 14:39:58
 * @since JDK1.8
 */
@Data
public class QuarterCompanyExcelVO {
    @Excel(name = "ID")
    private Long id;

    @Excel(name = "基层单位ID")
    private Long pId;

    @Excel(name = "考核周期")
    private String taskId;

    @Excel(name = "工作完成情况")
    private Float item1;

    @Excel(name = "公司领导")
    private Float item2;

    @Excel(name = "部室互评")
    private Float item3;

    @Excel(name = "基层单位评议")
    private Float item4;

    @Excel(name = "日常稽查")
    private Float item5;

    @Excel(name = "表彰加分")
    private Float add;

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

    @Excel(name = "模板")
    private String modelId;

    @Excel(name = "更新时间", format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    @Excel(name = "创建时间", format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;



}
