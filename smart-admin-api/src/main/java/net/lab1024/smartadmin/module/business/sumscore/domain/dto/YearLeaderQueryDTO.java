package net.lab1024.smartadmin.module.business.sumscore.domain.dto;

import net.lab1024.smartadmin.common.domain.PageParamDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**
 * [ 年度综合考评成绩汇总 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-15 14:57:40
 * @since JDK1.8
 */
@Data
public class YearLeaderQueryDTO extends PageParamDTO {

    @ApiModelProperty("ID")
    private Long id;

    @ApiModelProperty("考核人ID")
    private Long uId;

    @ApiModelProperty("年份")
    private String year;

    @ApiModelProperty("季度")
    private Integer quarter;

    @ApiModelProperty("是否复议1是")
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
