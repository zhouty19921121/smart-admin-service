package net.lab1024.smartadmin.module.business.score.domain.dto;

import lombok.Data;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

/**
 * 新建 [ 基层员工评价表 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c) 2018 三格数维Inc. All rights reserved.
 * @date  2021-08-15 13:03:21
 * @since JDK1.8
 */
@Data
public class PersonCompanyAddDTO {
    @ApiModelProperty("单位整体运行情况1好2比较好3一般4差")
    private Integer item1;

    @ApiModelProperty("班子配合及团结协作")
    private Integer item2;

    @ApiModelProperty("作风和党风廉政建设")
    private Integer item3;

    @ApiModelProperty("组织管理")
    private Integer item4;

    @ApiModelProperty("生活安排")
    private Integer item5;

    @ApiModelProperty("是否复议1是")
    private Integer approval;

    @ApiModelProperty("审批人")
    private Integer approvalperson;

    @ApiModelProperty("审批时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date approvaltime;

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

    @ApiModelProperty("基层单位ID")
    private Long pId;


}
