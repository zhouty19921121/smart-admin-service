package net.lab1024.smartadmin.module.business.group.domain.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import java.util.Date;

/**
 *  [ 考核组表 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c) 三格数维Inc. All rights reserved.
 * @date  2021-08-14 22:01:40
 * @since JDK1.8
 */
@Data
public class AuthGroupEmployeeExcelVO {
    @Excel(name = "ID")
    private Long id;

    @Excel(name = "考核任务ID")
    private Long taskId;

    @Excel(name = "员工ID")
    private Long employeeId;

    @Excel(name = "创建时间", format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    @Excel(name = "创建时间", format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;



}
