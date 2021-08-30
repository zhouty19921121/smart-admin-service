package net.lab1024.smartadmin.module.business.score.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import net.lab1024.smartadmin.common.domain.BaseEntity;
import java.util.Date;
import lombok.Data;

/**
 * [ 基层员工评价对所属各单位测评表 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-15 12:57:48
 * @since JDK1.8
 */
@Data
@TableName("t_model_leader_company")
public class LeaderCompanyEntity extends BaseEntity{


    /**
     * 基层单位ID
     */
    private Long pId;

    /**
     * 考核周期
     */
    private String taskId;

    /**
     * 工作计划
     */
    private Integer item1;

    /**
     * 工作执行情况
     */
    private Integer item2;

    /**
     * 工作作风
     */
    private Integer item3;

    /**
     * 队伍建设
     */
    private Integer item4;

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

}
