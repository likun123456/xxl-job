package com.xxl.job.executor.user.vo;

import java.io.Serializable;

/**
 * @Date 2022/3/30 15:21
 * @Created by likun
 */
@SuppressWarnings("unused")
public class UserVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String uuid;
    private String name;
    private Integer age;
    private Integer gender;
    private String genderDesc;

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

    public String getGenderDesc() {
        return this.gender == 0 ? "女" : "男";
    }
}
