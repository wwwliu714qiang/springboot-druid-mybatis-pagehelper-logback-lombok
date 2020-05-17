package com.chiy.dualpolarization.common.config;
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

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author liuqiang
 * @ClassName RabbitConfig
 * @Description 消息队列配置类
 * @Date 2020/05/13 9:37
 * @Version 1.0
 */
@Configuration
public class RabbitConfig {

    @Bean(name = "rafs_lq_test")
    public Queue wrfdaInfoLqQueue() {
        return new Queue("rafs_lq_test", true, false, false, null);
    }
}
