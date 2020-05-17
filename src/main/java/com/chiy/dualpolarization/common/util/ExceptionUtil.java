package com.chiy.dualpolarization.common.util;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author liuqiang
 * @ClassName DruidConfig
 * @Description
 * 日志信息往往伴随着异常信息的输出，
 * 因此，我们需要修改统一异常的处理器，
 * 将异常信息以流的方式写到日志文件中
 * @Date 2020/5/12 19:07
 * @Version 1.0
 */
@Slf4j
public class ExceptionUtil {
    /**
     * 打印异常信息
     */
    public static String getMessage(Exception e) {
        String swStr = null;
        try (StringWriter sw = new StringWriter(); PrintWriter pw = new PrintWriter(sw)) {
            e.printStackTrace(pw);
            pw.flush();
            sw.flush();
            swStr = sw.toString();
        } catch (IOException ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
        }
        return swStr;
    }
}
