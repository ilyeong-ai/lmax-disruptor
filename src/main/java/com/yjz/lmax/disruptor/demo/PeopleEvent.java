package com.yjz.lmax.disruptor.demo;

/**
 * Created by yangjianzhang on 17/2/4.
 *
 * PeopleEvent包含传递数据，通过PeopleEvent将人员信息在消费者和生产者直接传递
 */
public class PeopleEvent {
    private String name;
    private Integer age;
    private Integer sex;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getSex() {
        return sex;
    }
}
