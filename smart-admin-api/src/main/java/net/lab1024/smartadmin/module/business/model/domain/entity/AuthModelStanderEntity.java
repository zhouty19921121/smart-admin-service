package net.lab1024.smartadmin.module.business.model.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import net.lab1024.smartadmin.common.domain.BaseEntity;
import lombok.Data;

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
@TableName("t_auth_model_stander")
public class AuthModelStanderEntity extends BaseEntity{


    /**
     * 评分项
     */
    private String item;

    /**
     * 评分标准
     */
    private String content;

    /**
     * 分数占比
     */
    private Float score;

    /**
     * 模板id
     */
    private Long modelId;


    /**
     * 创建人
     */
    private Integer creator;

    /**
     * 是否删除0否 1是
     */
    private Integer isDelete;

    /**
     * 是否启用0是1否
     */
    private Integer isUse;


    /**
     * 部门id
     */
    private Long dId;

}
