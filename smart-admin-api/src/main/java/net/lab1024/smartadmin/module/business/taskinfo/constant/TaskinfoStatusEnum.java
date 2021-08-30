package net.lab1024.smartadmin.module.business.taskinfo.constant;

import net.lab1024.smartadmin.common.domain.BaseEnum;

public enum TaskinfoStatusEnum implements BaseEnum {
    /**
     * 用户正常状态 1
     */
    NORMAL(0, "正常"),

    /**
     * 用户已被禁用 0
     */
    DISABLED(1, "禁用");

    TaskinfoStatusEnum(int i, String 正常) {
    }

    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public String getDesc() {
        return null;
    }
    //11计划暂存12计划已提交13计划审核通过14计划审核不通过21计划暂存22计划已提交23计划审核通过24计划审核不通过25审结归档
}
