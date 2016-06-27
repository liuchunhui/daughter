package com.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 专业
 * Created by huihui on 16-6-5.
 */
@Entity
@Table(name = "profession")
public class Profession {

    /**
     * 主键
     */
    @Id @Column(name = "profession_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 专业编号
     */
    @Column(unique = true, nullable = false)
    private String number;
    /**
     * 专业名称
     */
    @Column(nullable = false)
    private String name;

    /**
     * 专业描述
     */
    private String description;

    /**
     * 学院（多对一）
     */
    @ManyToOne(targetEntity = College.class,
        fetch = FetchType.EAGER)
    @JoinTable(name = "college_profession",
        joinColumns = @JoinColumn(name = "profession_id",
            referencedColumnName = "profession_id",
            unique = true),
        inverseJoinColumns = @JoinColumn(name = "college_id",
            referencedColumnName = "college_id"))
    private College college;

    /**
     * 班级（一对多）
     */
    @OneToMany(targetEntity = Grade.class,
        fetch = FetchType.EAGER)
    @JoinTable(name = "profession_grade",
        joinColumns = @JoinColumn(name = "profession_id",
            referencedColumnName = "profession_id"),
        inverseJoinColumns = @JoinColumn(name = "grade_id",
            referencedColumnName = "grade_id",
            unique = true))
    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,property = "@id")
    private Set<Grade> grades = new HashSet<Grade>();

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
    public Profession() {}

    public Profession(String number,
                      String name,
                      String description,
                      College college,
                      Set<Grade> grades,
                      Date createTime,
                      Date updateTime) {
        this.number = number;
        this.name = name;
        this.description = description;
        this.college = college;
        this.grades = grades;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    @Override
    public String toString () {
        return "number: " + number + " name: " + name + " description: " + description +
                " college: " + college.toString();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public Set<Grade> getGrades() {
        return grades;
    }

    public void setGrades(Set<Grade> grades) {
        this.grades = grades;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
