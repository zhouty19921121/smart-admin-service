package net.lab1024.smartadmin.module.business.group.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import net.lab1024.smartadmin.common.domain.BaseEntity;
import lombok.Data;

/**
 * [ 考核组表 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-14 22:01:40
 * @since JDK1.8
 */
@Data
@TableName("t_auth_group_employee")
public class AuthGroupEmployeeEntity extends BaseEntity{


    /**
     * 考核任务ID
     */
    private Long taskId;

    /**
     * 员工ID
     */
    private Long employeeId;



}
