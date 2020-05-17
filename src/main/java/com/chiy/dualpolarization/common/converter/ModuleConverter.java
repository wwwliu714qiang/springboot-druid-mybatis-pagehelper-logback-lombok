package com.chiy.dualpolarization.common.converter;
/**
 * .::::.
 * .::::::::.
 * :::::::::::    佛主保佑、永无Bug
 * ..:::::::::::'
 * '::::::::::::'
 * .::::::::::
 * '::::::::::::::..
 * ..::::::::::::.
 * ``::::::::::::::::
 * ::::``:::::::::'        .:::.
 * ::::'   ':::::'       .::::::::.
 * .::::'      ::::     .:::::::'::::.
 * .:::'       :::::  .:::::::::' ':::::.
 * .::'        :::::.:::::::::'      ':::::.
 * .::'         ::::::::::::::'         ``::::.
 * ...:::           ::::::::::::'              ``::.
 * ```` ':.          ':::::::::'                  ::::..
 * '.:::::'                    ':'````..
 */

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

/**
 * @author liuqiang
 * @ClassName ModuleConverter
 * @Description 自定义获取 moudle
 * @Date 2020/5/16 10:52
 * @Version 1.0
 */
public class ModuleConverter extends ClassicConverter {
    private static final int MAX_LENGTH = 20;

    @Override
    public String convert(ILoggingEvent iLoggingEvent) {
        if (iLoggingEvent.getLoggerName().length() > MAX_LENGTH) {
            return "";
        } else {
            return iLoggingEvent.getLoggerName();
        }
    }
}
