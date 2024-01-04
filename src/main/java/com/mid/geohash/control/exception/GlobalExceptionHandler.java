package com.mid.geohash.control.exception;

import com.alibaba.fastjson2.JSONObject;
import com.mid.geohash.model.ResultResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理参数丢失异常
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    @ResponseBody
    public ResultResponse exceptionHandler(HttpServletRequest req, MissingServletRequestParameterException e) {
        logger.error("缺少参数！堆栈:", e);
        JSONObject result = new JSONObject();
        result.put("参数", e.getParameterName());
        result.put("类型", e.getParameterType());
        return ResultResponse.error(ExceptionEnum.BODY_NOT_MATCH, result);
    }

    /**
     * 处理其他异常
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultResponse exceptionHandler(HttpServletRequest req, Exception e) {
        logger.error("未知异常！原因是:", e);
        return ResultResponse.error(ExceptionEnum.INTERNAL_SERVER_ERROR, e.getMessage());
    }
}
