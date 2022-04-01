package com.xxl.job.executor.user.entity;

import com.fasterxml.jackson.databind.util.JSONPObject;

import java.util.UUID;

/**
 * @Date 2022/3/30 14:39
 * @Created by likun
 */
public class User {
    private String uuid;
    private String name;
    private Integer age;
    private Integer gender;

    public User() {
    }

    public User(String name, Integer age, Integer gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public static String genUuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

}
