package net.lab1024.smartadmin.module.business.model.domain.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import java.util.Date;

/**
 *  [ 部门考核标准 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c) 三格数维Inc. All rights reserved.
 * @date  2021-08-14 22:10:14
 * @since JDK1.8
 */
@Data
public class AuthModelStanderExcelVO {
    @Excel(name = "ID")
    private Long id;

    @Excel(name = "评分项")
    private String item;

    @Excel(name = "评分标准")
    private String content;

    @Excel(name = "分数占比")
    private Float score;

    @Excel(name = "模板id")
    private Long modelId;

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

    @Excel(name = "部门id")
    private Long dId;



}
