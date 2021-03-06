package com.helloandroid.db.greendao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "USER".
 */
public class User {

    private Long id;
    /** Not-null value. */
    private String name;
    private Integer age;
    private java.util.Date update_time;

    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    public User(Long id, String name, Integer age, java.util.Date update_time) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.update_time = update_time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** Not-null value. */
    public String getName() {
        return name;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public java.util.Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(java.util.Date update_time) {
        this.update_time = update_time;
    }

}
