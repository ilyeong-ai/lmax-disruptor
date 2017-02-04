package com.yjz.lmax.disruptor.demo;

import com.lmax.disruptor.EventFactory;

/**
 * Created by yangjianzhang on 17/2/4.
 *
 * Disruptor要为我们创建事件(数据载体),通过工厂方法实例化事件
 */
public class PeopleEventFactory implements EventFactory<PeopleEvent> {

    public PeopleEvent newInstance(){
        return new PeopleEvent();
    }
}
