package net.lab1024.smartadmin.module.business.model.domain.vo;

import lombok.Data;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

/**
 *  [ 考核模板 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c) 三格数维Inc. All rights reserved.
 * @date  2021-08-14 22:11:15
 * @since JDK1.8
 */
@Data
public class AuthModelVO {
    @ApiModelProperty("ID")
    private Long id;

    @ApiModelProperty("模板名称")
    private String name;

    @ApiModelProperty("对应审批表名")
    private String model;

    @ApiModelProperty("审核人")
    private String auth;

    @ApiModelProperty("被审核对象")
    private String dest;

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



}
