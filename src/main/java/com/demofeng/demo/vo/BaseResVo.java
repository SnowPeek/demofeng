package com.demofeng.demo.vo;

import com.demofeng.demo.enums.ResultStateEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class BaseResVo implements Serializable {

    /**
     * 返回状态 0失败 1成功
     */
    protected String resultCode = String.valueOf(ResultStateEnum.SUCCESS.getCode());

    /**
     * 返回给调用者的消息
     */
    protected String resultMsg = "";

    /**
     * 无参构造函数
     */
    public BaseResVo() {
    }

    /**
     * 全参构造函数
     *
     * @param resultCode 返回状态码
     * @param resultMsg 错误消息
     */
    public BaseResVo(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    /**
     * 获得 resultCode
     */
    @JsonIgnore
    public String getResultCode() {
        return resultCode;
    }

    /**
     * 设置 resultCode
     */
    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    /**
     * 获得 resultMsg
     */
    @JsonIgnore
    public String getResultMsg() {
        return resultMsg;
    }

    /**
     * 设置 resultMsg
     */
    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }
}
