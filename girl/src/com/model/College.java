package com.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 学院
 * Created by huihui on 16-6-5.
 */

@Entity
@Table(name = "college")
public class College implements Serializable{

    /**
     * 主键
     */
    @Id @Column(name = "college_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 学院编号
     */
    @Column(unique = true, nullable = false)
    private String number;

    /**
     * 学院名称
     */
    @Column(unique = true, nullable = false)
    private String name;

    /**
     * 学院描述
     */
    private String description;

    /**
     * 专业（一对多）
     */
    @OneToMany(targetEntity = Profession.class,
        fetch = FetchType.EAGER)
    @JoinTable(name = "college_profession",
        joinColumns = @JoinColumn(name = "college_id",
            referencedColumnName = "college_id"),
        inverseJoinColumns = @JoinColumn(name = "profession_id",
            referencedColumnName = "profession_id",
            unique = true))
    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,property = "@id")
    private Set<Profession> professions = new HashSet<Profession>();

    /**
     * 教师（一对多）
     */
    @OneToMany(targetEntity = Teacher.class,
        fetch = FetchType.EAGER)
    @JoinTable(name = "college_teacher",
        joinColumns = @JoinColumn(name = "college_id",
            referencedColumnName = "college_id"),
        inverseJoinColumns = @JoinColumn(name = "teacher_id",
            referencedColumnName = "teacher_id",
            unique = true))
    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,property = "@id")
    private Set<Teacher> teachers = new HashSet<Teacher>();

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

    // construcor
    public College() {}

    public College(Integer id,
                   String number,
                   String name,
                   String description,
                   Set<Profession> professions,
                   Set<Teacher> teachers,
                   Date createTime,
                   Date updateTime) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.description = description;
        this.professions = professions;
        this.teachers = teachers;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    // get/set 方法
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

    public Set<Profession> getProfessions() {
        return professions;
    }

    public void setProfessions(Set<Profession> professions) {
        this.professions = professions;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
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

    @Override
    public String toString () {
        return "number: " + number + " name: " + name + " description: " + description;
    }
}
