package com.yjz.lmax.disruptor.demo;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;

import java.util.Map;

/**
 * Created by yangjianzhang on 17/2/4.
 *
 * PeopleEventProducer是一个生成事件的源，在这里面通过读取磁盘IO、数据库、network等。当事件源会在IO读取一部分数据时候触发事件(触发事件
 * 不是自动触发的，需要在读取到数据的时候自己触发事件并发布)
 */
public class PeopleEventProducer {

    private final RingBuffer<PeopleEvent> ringBuffer;

    private static final EventTranslatorOneArg<PeopleEvent,Map<String,Object>> tranlator = new EventTranslatorOneArg<PeopleEvent, Map<String, Object>>() {
        public void translateTo(PeopleEvent event, long sequence, Map<String, Object> data) {
            event.setName(data.get("name").toString());
            event.setAge((Integer) data.get("age"));
            event.setSex((Integer) data.get("sex"));
        }
    };

    public PeopleEventProducer(RingBuffer ringBuffer){
        this.ringBuffer = ringBuffer;
    }


    /**
     * onData用来发布事件，每调用一次就发布一次事件，它的参数会通过事件传递给消费者
     */
    public void onData(Map<String,Object> data){
        ringBuffer.publishEvent(tranlator,data);
    }
}
