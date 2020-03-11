package com.demofeng.demo.enums;

import lombok.Getter;

@Getter
public enum ResultStateEnum {
    FAIL("500", "失败"),
    SUCCESS("200", "成功");

    private final String code;
    private final String desc;

    /**
     *
     */
    ResultStateEnum(String code, String description) {
        this.code = code;
        this.desc = description;
    }

    /**
     * 通过code获取枚举
     */
    public static ResultStateEnum getByCode(String code) {
        for (ResultStateEnum yesNo : values()) {
            if (yesNo.getCode().equals(code)) {
                return yesNo;
            }
        }
        return null;
    }

}
