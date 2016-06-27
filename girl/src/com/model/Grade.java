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
 * 班级
 * Created by huihui on 16-6-5.
 */
@Entity
@Table(name = "grade")
public class Grade {

    /**
     * 主键
     */
    @Id @Column(name = "grade_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 班级编号
     */
    @Column(unique = true, nullable = false)
    private String number;

    /**
     * 班级名称
     */
    @Column(unique = true, nullable = false)
    private String name;

    /**
     * 专业(多对一)
     */
    @ManyToOne(targetEntity = Profession.class,
        fetch = FetchType.EAGER)
    @JoinTable(name = "profession_grade",
        joinColumns = @JoinColumn(name = "grade_id",
            referencedColumnName = "grade_id", unique = true),
        inverseJoinColumns = @JoinColumn(name = "profession_id",
            referencedColumnName = "profession_id"))
    private Profession profession;

    /**
     * 班级下的学生（一对多）
     */
    @OneToMany(targetEntity = Student.class,
        fetch = FetchType.EAGER)
    @JoinTable(name = "grade_student",
        joinColumns = @JoinColumn(name = "grade_id",
            referencedColumnName = "grade_id"),
        inverseJoinColumns = @JoinColumn(name = "student_id",
            referencedColumnName = "student_id",
            unique =  true))
    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,
            property = "@id")
    private Set<Student> students = new HashSet<>();

    /**
     * 课程表（一对多）
     */
    @OneToMany(targetEntity = Syllabus.class,
        fetch = FetchType.EAGER)
    @JoinTable(name = "grade_syllabus",
        joinColumns = @JoinColumn(name = "grade_id",
            referencedColumnName = "grade_id"),
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
    public Grade() {}

    public Grade(String number,
                 String name,
                 Profession profession,
                 Set<Student> students,
                 Set<Syllabus> syllabuses,
                 Date createTime,
                 Date updateTime) {
        this.number = number;
        this.name = name;
        this.profession = profession;
        this.students = students;
        this.syllabuses = syllabuses;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    @Override
    public String toString () {
        return "\nnumber: " + number + " name: " + name + " profession: " + profession.toString();
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

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
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
