package com.gh003.user.entity;

import java.util.Date;

public class User {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String password;

    /**
     * 
     */
    private Date time;

    /**
     * 
     */
    private String usergrade;


    /**
     * 
     */
    private Integer age;

    /**
     * 
     */
    private String sex;

    /**
     * 
     */
    private String status;
    /**
     * 
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return name 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name 
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 
     * @return password 
     */
    public String getPassword() {
        return password;
    }

    /**
     * 
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 
     * @return time 
     */
    public Date getTime() {
        return time;
    }

    /**
     * 
     * @param time 
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * 
     * @return usergrade 
     */
    public String getGrade() {
        return usergrade;
    }

    /**
     * 
     * @param usergrade 
     */
    public void setGrade(String usergrade) {
        this.usergrade = usergrade == null ? null : usergrade.trim();
    }
   
    /**
     * 
     * @return age 
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 
     * @param age 
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 
     * @return sex 
     */
    public String getSex() {
        return sex;
    }

    /**
     * 
     * @param sex 
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }
    
    /**
     * 
     * @return status 
     */
    public String getStatus() {
        return status;
    }

    /**
     * 
     * @param status 
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
    
    
}