package net.lab1024.smartadmin.module.business.score.domain.dto;

import net.lab1024.smartadmin.common.domain.PageParamDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**
 * [ 公司领导对机关部门民主评议 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-15 12:59:58
 * @since JDK1.8
 */
@Data
public class LeaderDepartmentQueryDTO extends PageParamDTO {

    @ApiModelProperty("ID")
    private Long id;

    @ApiModelProperty("基层单位ID")
    private Long pId;

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
