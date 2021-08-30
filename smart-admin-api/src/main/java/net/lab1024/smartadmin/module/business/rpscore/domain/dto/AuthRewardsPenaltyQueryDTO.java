package net.lab1024.smartadmin.module.business.rpscore.domain.dto;

import net.lab1024.smartadmin.common.domain.PageParamDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

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
@Data
public class AuthRewardsPenaltyQueryDTO extends PageParamDTO {

    @ApiModelProperty("考核内容")
    private String content;

    @ApiModelProperty("事项")
    private String item;

    @ApiModelProperty("部门Id")
    private Long pId;

    @ApiModelProperty("是否复议1是")
    private Integer approval;

    @ApiModelProperty("类型1表彰减分2违纪加分")
    private Integer type;

    @ApiModelProperty("创建时间-开始")
    private Date createTimeBegin;

    @ApiModelProperty("创建时间-截止")
    private Date createTimeEnd;

    @ApiModelProperty("上次更新时间-开始")
    private Date updateTimeBegin;

    @ApiModelProperty("上次更新创建时间-开始")
    private Date updateTimeEnd;
}
