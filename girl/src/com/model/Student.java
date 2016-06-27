package com.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 学生
 * Created by huihui on 16-6-5.
 */
@Entity
@Table(name = "student")
public class Student {

    /**
     * 主键
     */
    @Id @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 学号
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
     * 出生年月日
     */
    private String birth;

    /**
     * 家庭住址
     */
    private String address;

    /**
     * 联系电话
     */
    private String tel;

    /**
     * 联系邮箱
     */
    private String email;

    /**
     * 登录系统密码
     */
    @Column(nullable = false)
    private String password;

    /**
     * 对应班级
     */
    @ManyToOne(targetEntity = Grade.class,
        fetch = FetchType.EAGER)
    @JoinTable(name = "grade_student",
            joinColumns = @JoinColumn(name = "student_id",
                    referencedColumnName = "student_id",
                    unique = true),
            inverseJoinColumns = @JoinColumn(name = "grade_id",
                    referencedColumnName = "grade_id"))
    private Grade grade;

    @OneToMany(targetEntity = Score.class,
        fetch = FetchType.EAGER)
    @JoinTable(name = "student_score",
            joinColumns = @JoinColumn(name = "student_id",
                    referencedColumnName = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "score_id",
                    referencedColumnName = "score_id"))
    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,
            property = "@id")
    private Set<Score> scores = new HashSet<>();

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
    public Student () {}

    public Student(String number,
                   String name,
                   String sex,
                   String birth,
                   String address,
                   String tel,
                   String email,
                   String password,
                   Grade grade,
                   Set<Score> scores,
                   Date createTime,
                   Date updateTime) {
        this.number = number;
        this.name = name;
        this.sex = sex;
        this.birth = birth;
        this.address = address;
        this.tel = tel;
        this.email = email;
        this.password = password;
        this.grade = grade;
        this.scores = scores;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Set<Score> getScores() {
        return scores;
    }

    public void setScores(Set<Score> scores) {
        this.scores = scores;
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
