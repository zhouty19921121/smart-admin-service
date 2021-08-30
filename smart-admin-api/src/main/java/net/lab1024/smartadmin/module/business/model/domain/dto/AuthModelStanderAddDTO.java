package net.lab1024.smartadmin.module.business.model.domain.dto;

import lombok.Data;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

/**
 * 新建 [ 部门考核标准 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c) 2018 三格数维Inc. All rights reserved.
 * @date  2021-08-14 22:10:14
 * @since JDK1.8
 */
@Data
public class AuthModelStanderAddDTO {
    @ApiModelProperty("评分项")
    private String item;

    @ApiModelProperty("评分标准")
    private String content;

    @ApiModelProperty("分数占比")
    private Float score;

    @ApiModelProperty("模板id")
    private Long modelId;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("创建人")
    private Integer creator;

    @ApiModelProperty("是否删除0否 1是")
    private Integer isDelete;

    @ApiModelProperty("是否启用0是1否")
    private Integer isUse;

    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    @ApiModelProperty("部门id")
    private Long dId;


}
