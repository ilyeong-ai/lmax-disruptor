package com.yjz.lmax.disruptor.demo;


import com.lmax.disruptor.EventHandler;

/**
 * Created by yangjianzhang on 17/2/4.
 *
 * PeopleEventHandler是一个事件处理器,也就是一个事件处理器。这里面负责具体业务逻辑
 */
public class PeopleEventHandler implements EventHandler<PeopleEvent> {

    public void onEvent(PeopleEvent event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("name:" + event.getName()+",sex:" + event.getSex() + ",age:" + event.getAge());
    }
}
