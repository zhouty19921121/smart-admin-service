package net.lab1024.smartadmin.module.business.sumscore.domain.vo;

import lombok.Data;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

/**
 *  [ 季度所属各单位考核结果排名 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c) 三格数维Inc. All rights reserved.
 * @date  2021-08-15 14:39:58
 * @since JDK1.8
 */
@Data
public class QuarterCompanyVO {
    @ApiModelProperty("ID")
    private Long id;

    @ApiModelProperty("基层单位ID")
    private Long pId;

    @ApiModelProperty("考核周期")
    private String taskId;

    @ApiModelProperty("工作完成情况")
    private Float item1;

    @ApiModelProperty("公司领导")
    private Float item2;

    @ApiModelProperty("部室互评")
    private Float item3;

    @ApiModelProperty("基层单位评议")
    private Float item4;

    @ApiModelProperty("日常稽查")
    private Float item5;

    @ApiModelProperty("表彰加分")
    private Float add;

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
