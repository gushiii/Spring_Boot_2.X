package com.springboot.chapter3.pojo;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : chapter1
 * @package : com.springboot.chapter3.pojo
 * @className : User
 * @description : TODO
 * @date : 2022/11/15 17:14
 */
public class User1 {
    private Long id;
    private String userName;
    private String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
