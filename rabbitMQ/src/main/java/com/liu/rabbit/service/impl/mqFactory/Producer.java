package com.liu.rabbit.service.impl.mqFactory;

import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

//生产者
public class Producer {
    //队列名称
    public static final String QUEUE_NAME="queue2.0";

    //生产消息
    public static void main(String[] args) throws TimeoutException, IOException {
        Channel channel=MQutils.getChannel();

        //生成一个队列，参数挨个为：队列名，是否持久化，是否允许多消费者消费，其他参数
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        //发消息，参数挨个为：交换机，路由的key值，其他参数，发送的消息
        //发送大量消息
        for(int i=0;i<20;++i){
            String message="message"+i;
            channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
        }
        System.out.println("生产者发送完成！");
    }
}
