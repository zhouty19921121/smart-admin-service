package net.lab1024.smartadmin.module.business.rpscore.domain.dto;

import lombok.Data;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

/**
 * 新建 [ 考核加分扣分记录表 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c) 2018 三格数维Inc. All rights reserved.
 * @date  2021-08-20 11:36:35
 * @since JDK1.8
 */
@Data
public class AuthRewardsPenaltyAddDTO {
    @ApiModelProperty("年份")
    private String year;

    @ApiModelProperty("季度")
    private Integer quarter;

    @ApiModelProperty("月份")
    private Integer month;

    @ApiModelProperty("部门Id")
    private Long pId;

    @ApiModelProperty("考核内容")
    private String content;

    @ApiModelProperty("事项")
    private String item;

    @ApiModelProperty("分值")
    private Float point;

    @ApiModelProperty("备注")
    private String sucinfo;

    @ApiModelProperty("填报人")
    private Integer fillperson;

    @ApiModelProperty("填报时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date filltime;

    @ApiModelProperty("是否复议1是")
    private Integer approval;

    @ApiModelProperty("审批人")
    private Integer approvalperson;

    @ApiModelProperty("审批时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date approvaltime;

    @ApiModelProperty("类型1表彰减分2违纪加分")
    private Integer type;

    @ApiModelProperty("是否删除0否 1是")
    private Integer isDelete;

    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


}
