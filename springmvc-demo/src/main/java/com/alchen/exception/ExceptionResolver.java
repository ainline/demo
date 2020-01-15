package com.alchen.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExceptionResolver implements HandlerExceptionResolver {

    /**
     * 处理异常信息
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        ExceptionMessage em = null;
        if (e instanceof ExceptionMessage) {
            em = (ExceptionMessage) e;
        } else {
            e = new Exception("系统异常");
        }

        ModelAndView mv = new ModelAndView();
        mv.setViewName("error");
        mv.addObject("errorMessage", em.getMessage());
        return mv;
    }
}
