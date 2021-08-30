package net.lab1024.smartadmin.module.business.rpscore.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import net.lab1024.smartadmin.common.domain.BaseEntity;
import java.util.Date;
import lombok.Data;

/**
 * [ 考核加分扣分记录表 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-20 11:36:35
 * @since JDK1.8
 */
@Data
@TableName("t_auth_rewards_penalty")
public class AuthRewardsPenaltyEntity extends BaseEntity{


    /**
     * 年份
     */
    private String year;

    /**
     * 季度
     */
    private Integer quarter;

    /**
     * 月份
     */
    private Integer month;

    /**
     * 部门Id
     */
    private Long pId;

    /**
     * 考核内容
     */
    private String content;

    /**
     * 事项
     */
    private String item;

    /**
     * 分值
     */
    private Float point;

    /**
     * 备注
     */
    private String sucinfo;

    /**
     * 填报人
     */
    private Integer fillperson;

    /**
     * 填报时间
     */
    private Date filltime;

    /**
     * 是否复议1是
     */
    private Integer approval;

    /**
     * 审批人
     */
    private Integer approvalperson;

    /**
     * 审批时间
     */
    private Date approvaltime;

    /**
     * 类型1表彰减分2违纪加分
     */
    private Integer type;

    /**
     * 是否删除0否 1是
     */
    private Integer isDelete;



}
