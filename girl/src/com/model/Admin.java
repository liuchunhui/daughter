package com.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 系统管理员
 * Created by huihui on 16-6-5.
 */

@Entity
@Table(name = "admin")
public class Admin implements Serializable {

    /**
     * 主键
     */
    @Id @Column(name = "admin_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 管理员用户名
     */
    @Column(unique = true, nullable = false)
    private String username;

    /**
     * 密码
     */
    @Column(nullable = false)
    private String password;


    public Admin() {}
    public Admin(String name, String password) {
        this.username = name;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "username: " + username + " password: " + password;
    }
}