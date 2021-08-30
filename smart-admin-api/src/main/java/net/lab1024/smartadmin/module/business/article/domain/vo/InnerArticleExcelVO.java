package net.lab1024.smartadmin.module.business.article.domain.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import java.util.Date;

/**
 *  [ 内部采风 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c) 三格数维Inc. All rights reserved.
 * @date  2021-08-14 20:49:41
 * @since JDK1.8
 */
@Data
public class InnerArticleExcelVO {
    @Excel(name = "主键")
    private Long id;

    @Excel(name = "文章标题")
    private String title;

    @Excel(name = "文章描述")
    private String description;

    @Excel(name = "文章作者")
    private String author;

    @Excel(name = "文章内容")
    private String content;

    @Excel(name = "html的content")
    private String contentFormat;

    @Excel(name = "阅读量")
    private Integer readNum;

    @Excel(name = "评论量")
    private Integer commentNum;

    @Excel(name = "点赞量")
    private Integer likeNum;

    @Excel(name = "文章展示类别,1:普通，2：大图片，3：无图片")
    private Integer coverType;

    @Excel(name = "封面")
    private String cover;

    @Excel(name = "创建时间", format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @Excel(name = "更新时间", format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    @Excel(name = "是否推荐文章")
    private Integer recommend;

    @Excel(name = "分类类别存在多级分类，用逗号隔开")
    private String categoryId;

    @Excel(name = "发布状态")
    private Integer publish;

    @Excel(name = "是否置顶")
    private Integer top;



}
