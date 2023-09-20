package com.liu.rabbit.service.impl.mqFactory;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

//消费者 工作线程
public class Consumer implements Runnable{
    //队列名称
    public static final String QUEUE_NAME="queue2.0";

    @Override
    public void run() {
        try {
            Channel channel = MQutils.getChannel();

            //设置分发策略为不公平分发
//            channel.basicQos(1);

            //消费消息
            DeliverCallback deliverCallback=(consumerTag, message)->{
                System.out.println(Thread.currentThread().getName()+":"+new String(message.getBody()));
            };
            //参数挨个为：队列，消费成功后是否要自动应答，成功消费的回调，未成功消费的回调
            channel.basicConsume(QUEUE_NAME,true,deliverCallback,consumerTag-> {});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //接收消息
    public static void main(String[] args) throws TimeoutException, IOException {
        //启动两个消费者/工作线程
        Runnable runnable= new Consumer();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
