package net.lab1024.smartadmin.module.business.score.domain.dto;

import lombok.Data;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

/**
 * 新建 [ 公司领导对机关部门民主评议 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c) 2018 三格数维Inc. All rights reserved.
 * @date  2021-08-15 12:59:58
 * @since JDK1.8
 */
@Data
public class LeaderDepartmentAddDTO {
    @ApiModelProperty("基层单位ID")
    private Long pId;

    @ApiModelProperty("工作计划")
    private Integer item1;

    @ApiModelProperty("工作执行情况")
    private Integer item2;

    @ApiModelProperty("工作作风")
    private Integer item3;

    @ApiModelProperty("队伍建设")
    private Integer item4;

    @ApiModelProperty("廉洁自律")
    private Integer item5;

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
