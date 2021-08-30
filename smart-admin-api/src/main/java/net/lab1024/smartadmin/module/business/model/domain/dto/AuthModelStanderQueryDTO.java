package net.lab1024.smartadmin.module.business.model.domain.dto;

import net.lab1024.smartadmin.common.domain.PageParamDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**
 * [ 部门考核标准 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-14 22:10:14
 * @since JDK1.8
 */
@Data
public class AuthModelStanderQueryDTO extends PageParamDTO {

    @ApiModelProperty("ID")
    private Long id;

    @ApiModelProperty("评分项")
    private String item;

    @ApiModelProperty("模板id")
    private Long modelId;

    @ApiModelProperty("创建时间-开始")
    private Date createTimeBegin;

    @ApiModelProperty("创建时间-截止")
    private Date createTimeEnd;

    @ApiModelProperty("上次更新时间-开始")
    private Date updateTimeBegin;

    @ApiModelProperty("上次更新创建时间-开始")
    private Date updateTimeEnd;
}
