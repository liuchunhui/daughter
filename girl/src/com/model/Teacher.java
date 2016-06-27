package com.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 教师
 * Created by huihui on 16-6-5.
 */
@Entity
@Table(name = "teacher")
public class Teacher {

    /**
     * 主键
     */
    @Id @Column(name = "teacher_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 教师编号
     */
    @Column(unique = true, nullable = false)
    private String number;

    /**
     * 姓名
     */
    @Column(nullable = false)
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 出生年月
     */
    private String birth;

    /**
     * 联系电话
     */
    private String tel;

    /**
     * 联系邮件
     */
    private String email;

    /**
     * 家庭住址
     */
    private String address;

    /**
     * 登陆系统密码
     */
    private String password;

    /**
     * 教师所在的学院(多对一)
     */
    @ManyToOne(targetEntity = College.class,
        fetch = FetchType.EAGER)
    @JoinTable(name = "college_teacher",
        joinColumns = @JoinColumn(name = "teacher_id",
            referencedColumnName = "teacher_id",
            unique = true),
        inverseJoinColumns = @JoinColumn(name = "college_id",
            referencedColumnName = "college_id"))
    private College college;

    @OneToMany(targetEntity = Syllabus.class,
        fetch = FetchType.EAGER)
    @JoinTable(name = "teacher_syllabus",
        joinColumns = @JoinColumn(name = "teacher_id",
            referencedColumnName = "teacher_id"),
        inverseJoinColumns = @JoinColumn(name = "syllabus_id",
            referencedColumnName = "syllabus_id"))
    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,
        property = "@id")
    private Set<Syllabus> syllabuses = new HashSet<>();

    /**
     * 创建时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    /**
     * 更新时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    // constructor
    public Teacher () {}

    public Teacher(String number,
                   String name,
                   String sex,
                   String birth,
                   String tel,
                   String email,
                   String address,
                   String password,
                   College college,
                   Set<Syllabus> syllabuses,
                   Date createTime,
                   Date updateTime) {
        this.number = number;
        this.name = name;
        this.sex = sex;
        this.birth = birth;
        this.tel = tel;
        this.email = email;
        this.address = address;
        this.password = password;
        this.college = college;
        this.syllabuses = syllabuses;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    // get/set方法

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public Set<Syllabus> getSyllabuses() {
        return syllabuses;
    }

    public void setSyllabuses(Set<Syllabus> syllabuses) {
        this.syllabuses = syllabuses;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
