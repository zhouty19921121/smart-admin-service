package net.lab1024.smartadmin.module.business.sumscore.domain.dto;

import lombok.Data;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

/**
 * 新建 [ 年度综合考评成绩汇总 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c) 2018 三格数维Inc. All rights reserved.
 * @date  2021-08-15 14:57:40
 * @since JDK1.8
 */
@Data
public class YearLeaderAddDTO {
    @ApiModelProperty("考核人ID")
    private Long uId;

    @ApiModelProperty("第一季度")
    private Float item1;

    @ApiModelProperty("第二季度")
    private Float item2;

    @ApiModelProperty("第三季度")
    private Float item3;

    @ApiModelProperty("第四季度")
    private Float item4;

    @ApiModelProperty("平均成绩×80%")
    private Float item5;

    @ApiModelProperty("评议成绩x20%")
    private Float item6;

    @ApiModelProperty("综合成绩")
    private Float item7;

    @ApiModelProperty("安全管理")
    private Float item8;

    @ApiModelProperty("员工评价")
    private Float item9;

    @ApiModelProperty("领导评议")
    private Float item10;

    @ApiModelProperty("表彰加分")
    private Float item11;

    @ApiModelProperty("节点量加分")
    private Float item12;

    @ApiModelProperty("是否复议1是")
    private Integer approval;

    @ApiModelProperty("审批人")
    private Integer approvalperson;

    @ApiModelProperty("审批时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date approvaltime;

    @ApiModelProperty("总分")
    private Integer total;

    @ApiModelProperty("季度")
    private Integer quarter;

    @ApiModelProperty("年份")
    private String year;

    @ApiModelProperty("是否删除0否 1是")
    private Integer isDelete;

    @ApiModelProperty("模板")
    private String modelId;

    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


}
