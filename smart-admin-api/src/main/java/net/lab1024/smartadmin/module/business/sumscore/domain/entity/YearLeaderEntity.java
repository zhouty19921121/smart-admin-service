package net.lab1024.smartadmin.module.business.sumscore.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import net.lab1024.smartadmin.common.domain.BaseEntity;
import java.util.Date;
import lombok.Data;

/**
 * [ 年度综合考评成绩汇总 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-15 14:57:40
 * @since JDK1.8
 */
@Data
@TableName("t_score_year_leader")
public class YearLeaderEntity extends BaseEntity{


    /**
     * 考核人ID
     */
    private Long uId;

    /**
     * 第一季度
     */
    private Float item1;

    /**
     * 第二季度
     */
    private Float item2;

    /**
     * 第三季度
     */
    private Float item3;

    /**
     * 第四季度
     */
    private Float item4;

    /**
     * 平均成绩×80%
     */
    private Float item5;

    /**
     * 评议成绩x20%
     */
    private Float item6;

    /**
     * 综合成绩
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
