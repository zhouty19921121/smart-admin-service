package net.lab1024.smartadmin.module.business.score.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import net.lab1024.smartadmin.common.domain.BaseEntity;
import java.util.Date;
import lombok.Data;

/**
 * [ 基层单位对机关部门评议打分表（收费） ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-15 12:53:32
 * @since JDK1.8
 */
@Data
@TableName("t_model_cleader_department_sf")
public class CleaderDepartmentSfEntity extends BaseEntity{


    /**
     * 基层单位ID
     */
    private Long pId;

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

    /**
     * 模板
     */
    private String modelId;



}
