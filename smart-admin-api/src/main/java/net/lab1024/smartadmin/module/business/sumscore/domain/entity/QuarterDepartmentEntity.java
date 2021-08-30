package net.lab1024.smartadmin.module.business.sumscore.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import net.lab1024.smartadmin.common.domain.BaseEntity;
import java.util.Date;
import lombok.Data;

/**
 * [ 季度本部各部门考核结果排名 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-15 14:41:36
 * @since JDK1.8
 */
@Data
@TableName("t_score_quarter_department")
public class QuarterDepartmentEntity extends BaseEntity{


    /**
     * 基层单位ID
     */
    private Long pId;

    /**
     * 日常稽查
     */
    private Float item1;

    /**
     * 财务管理
     */
    private Float item2;

    /**
     * 人事管理
     */
    private Float item3;

    /**
     * 综合管理
     */
    private Float item4;

    /**
     * 业务考核
     */
    private Float item5;

    /**
     * 党建工作
     */
    private Float item6;

    /**
     * 廉政建设
     */
    private Float item7;

    /**
     * 安全管理
     */
    private Float item8;

    /**
     * 员工评价
     */
    private Float item9;

    /**
     * 领导评议
     */
    private Float item10;

    /**
     * 表彰加分
     */
    private Float item11;

    /**
     * 节点量加分
     */
    private Float item12;

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
     * 总分
     */
    private Integer total;

    /**
     * 季度
     */
    private Integer quarter;

    /**
     * 年份
     */
    private String year;

    /**
     * 是否删除0否 1是
     */
    private Integer isDelete;

    /**
     * 模板
     */
    private String modelId;



}
