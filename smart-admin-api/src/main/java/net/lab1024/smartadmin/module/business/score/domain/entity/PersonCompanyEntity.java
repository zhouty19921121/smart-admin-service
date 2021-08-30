package net.lab1024.smartadmin.module.business.score.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import net.lab1024.smartadmin.common.domain.BaseEntity;
import java.util.Date;
import lombok.Data;

/**
 * [ 基层员工评价表 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-15 13:03:21
 * @since JDK1.8
 */
@Data
@TableName("t_model_person_company")
public class PersonCompanyEntity extends BaseEntity{


    /**
     * 单位整体运行情况1好2比较好3一般4差
     */
    private Integer item1;

    /**
     * 班子配合及团结协作
     */
    private Integer item2;

    /**
     * 作风和党风廉政建设
     */
    private Integer item3;

    /**
     * 组织管理
     */
    private Integer item4;

    /**
     * 生活安排
     */
    private Integer item5;

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



    /**
     * 基层单位ID
     */
    private Long pId;

}
