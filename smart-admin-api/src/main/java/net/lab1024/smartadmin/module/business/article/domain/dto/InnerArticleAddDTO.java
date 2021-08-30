package net.lab1024.smartadmin.module.business.article.domain.dto;

import lombok.Data;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

/**
 * 新建 [ 内部采风 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c) 2018 三格数维Inc. All rights reserved.
 * @date  2021-08-14 20:49:41
 * @since JDK1.8
 */
@Data
public class InnerArticleAddDTO {
    @ApiModelProperty("文章标题")
    private String title;

    @ApiModelProperty("文章描述")
    private String description;

    @ApiModelProperty("文章作者")
    private String author;

    @ApiModelProperty("文章内容")
    private String content;

    @ApiModelProperty("html的content")
    private String contentFormat;

    @ApiModelProperty("阅读量")
    private Integer readNum;

    @ApiModelProperty("评论量")
    private Integer commentNum;

    @ApiModelProperty("点赞量")
    private Integer likeNum;

    @ApiModelProperty("文章展示类别,1:普通，2：大图片，3：无图片")
    private Integer coverType;

    @ApiModelProperty("封面")
    private String cover;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    @ApiModelProperty("是否推荐文章")
    private Integer recommend;

    @ApiModelProperty("分类类别存在多级分类，用逗号隔开")
    private String categoryId;

    @ApiModelProperty("发布状态")
    private Integer publish;

    @ApiModelProperty("是否置顶")
    private Integer top;


}
