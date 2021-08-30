package net.lab1024.smartadmin.module.business.taskinfo.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import net.lab1024.smartadmin.common.domain.BaseEntity;
import java.util.Date;
import lombok.Data;

/**
 * [ 工作绩效 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-14 16:20:27
 * @since JDK1.8
 */
@Data
@TableName("t_auth_taskinfo")
public class TaskinfoEntity extends BaseEntity{


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
     * 工作任务
     */
    private String name;

    /**
     * 计划完成时间
     */
    private Date time;

    /**
     * 完成与否0未完成1已完成
     */
    private Integer approval;

    /**
     * 备注
     */
    private Integer sucinfo;

    /**
     * 分管领导
     */
    private Integer approvalperson;

    /**
     * 审批时间
     */
    private Date approvaltime;

    /**
     * 填报人
     */
    private Integer fillperson;

    /**
     * 填报时间
     */
    private Date filltime;

    /**
     * 主管领导
     */
    private Integer ownerperson;

    /**
     * 审批时间
     */
    private Date signtime;

    /**
     * 考核类型1月度2季度3年度
     */
    private Integer type;

    /**
     * 是否删除0否 1是
     */
    private Integer isDelete;

    /**
     * 状态11计划暂存12计划已提交13计划审核通过14计划审核不通过21计划暂存22计划已提交23计划审核通过24计划审核不通过25审结归档
     */
    private Integer status;

}
