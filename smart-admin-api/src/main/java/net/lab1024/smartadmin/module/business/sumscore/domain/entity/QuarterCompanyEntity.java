package net.lab1024.smartadmin.module.business.sumscore.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import net.lab1024.smartadmin.common.domain.BaseEntity;
import java.util.Date;
import lombok.Data;

/**
 * [ 季度所属各单位考核结果排名 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-15 14:39:58
 * @since JDK1.8
 */
@Data
@TableName("t_score_quarter_company")
public class QuarterCompanyEntity extends BaseEntity{


    /**
     * 基层单位ID
     */
    private Long pId;

    /**
     * 考核周期
     */
    private String taskId;

    /**
     * 工作完成情况
     */
    private Float item1;

    /**
     * 公司领导
     */
    private Float item2;

    /**
     * 部室互评
     */
    private Float item3;

    /**
     * 基层单位评议
     */
    private Float item4;

    /**
     * 日常稽查
     */
    private Float item5;

    /**
     * 表彰加分
     */
    private Float add;

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
