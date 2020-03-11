package com.demofeng.demo.util;

import com.demofeng.demo.enums.ResultStateEnum;
import com.demofeng.demo.vo.BaseResVo;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

@Slf4j
@Data
public class RespJson implements Serializable {


    /**
     * 响应代码
     */
    protected String code;

    /**
     * 错误消息
     */
    protected String message;

    /**
     * 响应的数据域
     */
    protected Object data;

    /***
     * 时间戳
     */
    private long timestamp = System.currentTimeMillis();

    /**
     * 构建成功响应
     */
    public static RespJson buildSuccessResponse() {
        return buildSuccessResponse(null);
    }

    /**
     * 构建成功响应
     *
     * @param data 返回的数据对象 (JSon数组 或 Json对象)
     */
    public static RespJson buildSuccessResponse(Object data) {
        RespJson respJson = new RespJson();
        respJson.setCode(String.valueOf(ResultStateEnum.SUCCESS.getCode()));
        respJson.setMessage(ResultStateEnum.SUCCESS.getDesc());
        respJson.setData(data);
        return respJson;
    }

    /**
     * 构建成功响应
     *
     * @param resultMsg 返回给前端的信息
     * @param data 返回的数据对象 (JSon数组 或 Json对象)
     */
    public static RespJson buildSuccessResponse(String resultMsg, Object data) {
        RespJson respJson = new RespJson();
        respJson.setCode(String.valueOf(ResultStateEnum.SUCCESS.getCode()));
        respJson.setMessage(resultMsg);
        respJson.setData(data);
        return respJson;
    }

    /**
     * 构建失败响应
     *
     * @param resultCode 响应代码
     * @param errorMsg 返回给前端的错误信息
     */
    public static RespJson buildFailureResponse(String resultCode, String errorMsg) {
        RespJson respJson = new RespJson();
        respJson.setCode(
                StringUtils.isEmpty(resultCode) ? String.valueOf(ResultStateEnum.FAIL.getCode())
                        : resultCode);
        respJson.setMessage(errorMsg);
        respJson.setData(null);
        return respJson;
    }

    /**
     * 构建失败响应
     *
     * @param errorMsg 返回给前端的错误信息
     */
    public static RespJson buildFailureResponse(String errorMsg) {
        return buildFailureResponse(null, errorMsg);
    }

    /**
     * 从 BaseResVo 的子类构建返回的 Json
     *
     * @param resVo 业务逻辑返回的响应VO
     * @return 根据响应Vo构建的返回 Json
     */
    public static RespJson buildResponseFromResVo(BaseResVo resVo) {
        RespJson respJson = new RespJson();
        if (resVo != null) {
            boolean isSuccess = (
                    ResultStateEnum.SUCCESS.getCode().equalsIgnoreCase(resVo.getResultCode()));
            boolean hasErrorMsg = StringUtils.isNotEmpty(resVo.getResultMsg());
            respJson
                    .setCode(isSuccess ? resVo.getResultCode() : ResultStateEnum.FAIL.getCode());
            respJson
                    .setMessage(hasErrorMsg ? resVo.getResultMsg() : ResultStateEnum.FAIL.getDesc());
            respJson.setData(isSuccess ? resVo : null);
        }
        return respJson;
    }

}
