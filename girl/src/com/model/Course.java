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
 * 课程
 * Created by huihui on 16-6-5.
 */
@Entity
@Table(name = "course")
public class Course {

    /**
     * 主键
     */
    @Id @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 课程编号
     */
    @Column(unique = true, nullable = false)
    private String number;

    /**
     * 课程名称
     */
    @Column(unique = true, nullable = false)
    private String name;

    /**
     * 课程学时
     */
    @Column(nullable = false)
    private String period;

    /**
     * 课程表
     */
    @OneToMany(targetEntity = Syllabus.class,
        fetch = FetchType.EAGER)
    @JoinTable(name = "course_syllabus",
        joinColumns = @JoinColumn(name = "course_id",
            referencedColumnName = "course_id"),
        inverseJoinColumns = @JoinColumn(name = "syllabus_id",
            referencedColumnName = "syllabus_id"))
    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,property = "@id")
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
    public Course() {}

    public Course(String number,
                  String name,
                  String period,
                  Set<Syllabus> syllabuses,
                  Date createTime,
                  Date updateTime) {
        this.number = number;
        this.name = name;
        this.period = period;
        this.syllabuses = syllabuses;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    @Override
    public String toString () {
        return "id: " + id + " number: " + number + " name: " + name +
            " period: " + period + " syllabuses: " + syllabuses;
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

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
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
