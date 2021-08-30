package net.lab1024.smartadmin.module.business.model.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import net.lab1024.smartadmin.common.domain.BaseEntity;
import lombok.Data;

/**
 * [ 考核模板 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-14 22:11:15
 * @since JDK1.8
 */
@Data
@TableName("t_auth_model")
public class AuthModelEntity extends BaseEntity{


    /**
     * 模板名称
     */
    private String name;

    /**
     * 对应审批表名
     */
    private String model;

    /**
     * 审核人
     */
    private String auth;

    /**
     * 被审核对象
     */
    private String dest;


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


}
