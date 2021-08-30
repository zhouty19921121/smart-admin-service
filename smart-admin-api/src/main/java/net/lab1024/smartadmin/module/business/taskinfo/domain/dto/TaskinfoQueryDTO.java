package net.lab1024.smartadmin.module.business.taskinfo.domain.dto;

import net.lab1024.smartadmin.common.domain.PageParamDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**
 * [ 工作绩效 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-14 16:20:27
 * @since JDK1.8
 */
@Data
public class TaskinfoQueryDTO extends PageParamDTO {

    @ApiModelProperty("任务ID")
    private Long id;

    @ApiModelProperty("工作任务")
    private String name;

    @ApiModelProperty("考核类型1月度2季度3年度")
    private Integer type;

    @ApiModelProperty("年份")
    private String year;

    @ApiModelProperty("季度")
    private Integer quarter;

    @ApiModelProperty("月份")
    private Integer month;

    @ApiModelProperty("状态11计划暂存12计划已提交13计划审核通过14计划审核不通过21计划暂存22计划已提交23计划审核通过24计划审核不通过25审结归档")
    private Integer status;

    @ApiModelProperty("完成与否0未完成1已完成")
    private Integer approval;

    @ApiModelProperty("创建时间-开始")
    private Date createTimeBegin;

    @ApiModelProperty("创建时间-截止")
    private Date createTimeEnd;

    @ApiModelProperty("上次更新时间-开始")
    private Date updateTimeBegin;

    @ApiModelProperty("上次更新创建时间-开始")
    private Date updateTimeEnd;
}
