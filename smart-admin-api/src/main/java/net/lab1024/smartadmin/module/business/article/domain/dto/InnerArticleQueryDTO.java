package net.lab1024.smartadmin.module.business.article.domain.dto;

import net.lab1024.smartadmin.common.domain.PageParamDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**
 * [ 内部采风 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-14 20:49:41
 * @since JDK1.8
 */
@Data
public class InnerArticleQueryDTO extends PageParamDTO {

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("文章标题")
    private String title;

    @ApiModelProperty("文章展示类别,1:普通，2：大图片，3：无图片")
    private Integer coverType;

    @ApiModelProperty("发布状态")
    private Integer publish;

    @ApiModelProperty("是否置顶")
    private Integer top;

    @ApiModelProperty("创建时间-开始")
    private Date createTimeBegin;

    @ApiModelProperty("创建时间-截止")
    private Date createTimeEnd;

    @ApiModelProperty("上次更新时间-开始")
    private Date updateTimeBegin;

    @ApiModelProperty("上次更新创建时间-开始")
    private Date updateTimeEnd;
}
