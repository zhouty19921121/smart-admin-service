package net.lab1024.smartadmin.module.business.model.domain.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import java.util.Date;

/**
 *  [ 考核模板 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c) 三格数维Inc. All rights reserved.
 * @date  2021-08-14 22:11:15
 * @since JDK1.8
 */
@Data
public class AuthModelExcelVO {
    @Excel(name = "ID")
    private Long id;

    @Excel(name = "模板名称")
    private String name;

    @Excel(name = "对应审批表名")
    private String model;

    @Excel(name = "审核人")
    private String auth;

    @Excel(name = "被审核对象")
    private String dest;

    @Excel(name = "创建时间", format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @Excel(name = "创建人")
    private Integer creator;

    @Excel(name = "是否删除0否 1是")
    private Integer isDelete;

    @Excel(name = "是否启用0是1否")
    private Integer isUse;

    @Excel(name = "更新时间", format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;



}
