package com.model;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 成绩
 * Created by huihui on 16-6-5.
 */
@Entity
@Table(name = "score")
public class Score {

    /**
     * 主键
     */
    @Id @Column(name = "score_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 分数
     */
    private String score;

    /**
     * 成绩对应的学生（多对多）
     */
    @ManyToOne(targetEntity = Student.class,
        fetch = FetchType.EAGER)
    @JoinTable(name = "student_score",
            joinColumns = @JoinColumn(name = "score_id",
                    referencedColumnName = "score_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id",
                    referencedColumnName = "student_id"))
    private Student student = new Student();

    /**
     * 成绩对应的课程表（多对一）
     */
    @ManyToOne(targetEntity = Syllabus.class,
        fetch = FetchType.EAGER)
    @JoinTable(name = "syllabus_score",
            joinColumns = @JoinColumn(name = "score_id",
                    referencedColumnName = "score_id"),
            inverseJoinColumns = @JoinColumn(name = "syllabus_id",
                    referencedColumnName = "syllabus_id"))
    private Syllabus syllabus;


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
    public Score () {}

    public Score(String score,
                 Student student,
                 Syllabus syllabus,
                 Date updateTime,
                 Date createTime) {
        this.score = score;
        this.student = student;
        this.syllabus = syllabus;
        this.updateTime = updateTime;
        this.createTime = createTime;
    }

    // get/set方法

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Syllabus getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(Syllabus syllabus) {
        this.syllabus = syllabus;
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
