package com.chiy.dualpolarization.rabbitmq;//package com.chiy.dualpolarization.rabbitmq;
///**
// * .::::.
// * .::::::::.
// * :::::::::::    佛主保佑、永无Bug
// * ..:::::::::::'
// * '::::::::::::'
// * .::::::::::
// * '::::::::::::::..
// * ..::::::::::::.
// * ``::::::::::::::::
// * ::::``:::::::::'        .:::.
// * ::::'   ':::::'       .::::::::.
// * .::::'      ::::     .:::::::'::::.
// * .:::'       :::::  .:::::::::' ':::::.
// * .::'        :::::.:::::::::'      ':::::.
// * .::'         ::::::::::::::'         ``::::.
// * ...:::           ::::::::::::'              ``::.
// * ```` ':.          ':::::::::'                  ::::..
// * '.:::::'                    ':'````..
// */
//
//import com.rabbitmq.client.Channel;
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.amqp.support.AmqpHeaders;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.handler.annotation.Headers;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.io.UnsupportedEncodingException;
//import java.util.Map;
//
///**
// * @author liuqiang
// * @ClassName MqDemo
// * @Description TODO 消息队列测试类  可删除
// * @Date 2020/5/13 12:39
// * @Version 1.0
// */
//@Component
//public class MqDemo {
//    @RabbitListener(queues = "rafs_lq_test")
//    @RabbitHandler
//    public void test(Message message, Channel channel, @Headers Map<String, Object> headers) {
//        long deliveryLag = (long) headers.get(AmqpHeaders.DELIVERY_TAG);
//        boolean flag = false;
//        String info = "";
//        try {
//            //获取信息
//            Object payload1 = message.getPayload();
//            if (payload1 == null) {
//                channel.basicAck(deliveryLag, false);
//                return;
//            }
//            //转换为字节
//            byte[] payload = (byte[]) payload1;
//        } catch (UnsupportedEncodingException e) {
//        } catch (Exception e) {
//        }
//        //消息确认机制
//        try {
//            if (flag) {
//                //消息入库成功，删除消息
//                channel.basicAck(deliveryLag, false);
//            } else {
//                //不知名的失败处理,数据返回队列
//                channel.basicReject(deliveryLag, false);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
