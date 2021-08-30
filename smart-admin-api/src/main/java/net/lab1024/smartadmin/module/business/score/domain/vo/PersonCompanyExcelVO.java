package net.lab1024.smartadmin.module.business.score.domain.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import java.util.Date;

/**
 *  [ 基层员工评价表 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c) 三格数维Inc. All rights reserved.
 * @date  2021-08-15 13:03:21
 * @since JDK1.8
 */
@Data
public class PersonCompanyExcelVO {
    @Excel(name = "ID")
    private Long id;

    @Excel(name = "单位整体运行情况1好2比较好3一般4差")
    private Integer item1;

    @Excel(name = "班子配合及团结协作")
    private Integer item2;

    @Excel(name = "作风和党风廉政建设")
    private Integer item3;

    @Excel(name = "组织管理")
    private Integer item4;

    @Excel(name = "生活安排")
    private Integer item5;

    @Excel(name = "是否复议1是")
    private Integer approval;

    @Excel(name = "审批人")
    private Integer approvalperson;

    @Excel(name = "审批时间", format = "yyyy-MM-dd HH:mm:ss")
    private Date approvaltime;

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

    @Excel(name = "基层单位ID")
    private Long pId;



}
