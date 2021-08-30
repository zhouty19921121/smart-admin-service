package net.lab1024.smartadmin.module.business.article.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import net.lab1024.smartadmin.common.domain.BaseEntity;
import lombok.Data;

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
@TableName("t_inner_article")
public class InnerArticleEntity extends BaseEntity{


    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章描述
     */
    private String description;

    /**
     * 文章作者
     */
    private String author;

    /**
     * 文章内容
     */
    private String content;

    /**
     * html的content
     */
    private String contentFormat;

    /**
     * 阅读量
     */
    private Integer readNum;

    /**
     * 评论量
     */
    private Integer commentNum;

    /**
     * 点赞量
     */
    private Integer likeNum;

    /**
     * 文章展示类别,1:普通，2：大图片，3：无图片
     */
    private Integer coverType;

    /**
     * 封面
     */
    private String cover;



    /**
     * 是否推荐文章
     */
    private Integer recommend;

    /**
     * 分类类别存在多级分类，用逗号隔开
     */
    private String categoryId;

    /**
     * 发布状态
     */
    private Integer publish;

    /**
     * 是否置顶
     */
    private Integer top;

}
