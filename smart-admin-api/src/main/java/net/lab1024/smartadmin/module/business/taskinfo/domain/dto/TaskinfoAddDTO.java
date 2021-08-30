package net.lab1024.smartadmin.module.business.taskinfo.domain.dto;

import lombok.Data;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

/**
 * 新建 [ 工作绩效 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c) 2018 三格数维Inc. All rights reserved.
 * @date  2021-08-14 16:20:27
 * @since JDK1.8
 */
@Data
public class TaskinfoAddDTO {
    @ApiModelProperty("年份")
    private String year;

    @ApiModelProperty("季度")
    private Integer quarter;

    @ApiModelProperty("月份")
    private Integer month;

    @ApiModelProperty("部门Id")
    private Long pId;

    @ApiModelProperty("工作任务")
    private String name;

    @ApiModelProperty("计划完成时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date time;

    @ApiModelProperty("完成与否0未完成1已完成")
    private Integer approval;

    @ApiModelProperty("备注")
    private Integer sucinfo;

    @ApiModelProperty("分管领导")
    private Integer approvalperson;

    @ApiModelProperty("审批时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date approvaltime;

    @ApiModelProperty("填报人")
    private Integer fillperson;

    @ApiModelProperty("填报时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date filltime;

    @ApiModelProperty("主管领导")
    private Integer ownerperson;

    @ApiModelProperty("审批时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date signtime;

    @ApiModelProperty("考核类型1月度2季度3年度")
    private Integer type;

    @ApiModelProperty("是否删除0否 1是")
    private Integer isDelete;

    @ApiModelProperty("状态11计划暂存12计划已提交13计划审核通过14计划审核不通过21计划暂存22计划已提交23计划审核通过24计划审核不通过25审结归档")
    private Integer status;


}
