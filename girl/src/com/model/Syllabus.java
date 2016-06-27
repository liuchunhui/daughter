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
 * 课程表
 *
 * Created by huihui on 16-6-5.
 */
@Entity
@Table(name = "syllabus")
public class Syllabus {

    /**
     * 主键
     */
    @Id @Column(name = "syllabus_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 课程类型
     */
    @Column(nullable = false)
    private String type;

    /**
     * 授课教师
     */
    @ManyToOne(targetEntity = Teacher.class,
        fetch = FetchType.EAGER)
    @JoinTable(name = "teacher_syllabus",
        joinColumns = @JoinColumn(name = "syllabus_id",
            referencedColumnName = "syllabus_id"),
        inverseJoinColumns = @JoinColumn(name = "teacher_id",
            referencedColumnName = "teacher_id"))
    private Teacher teacher = new Teacher();

    /**
     * 课程名称
     */
    @ManyToOne(targetEntity = Course.class,
        fetch = FetchType.EAGER)
    @JoinTable(name = "course_syllabus",
        joinColumns = @JoinColumn(name = "syllabus_id",
            referencedColumnName = "syllabus_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id",
            referencedColumnName = "course_id"))
    private Course course = new Course();

    /**
     * 授课班级
     */
    @ManyToOne(targetEntity = Grade.class,
        fetch = FetchType.EAGER)
    @JoinTable(name = "grade_syllabus",
        joinColumns = @JoinColumn(name = "syllabus_id",
            referencedColumnName = "syllabus_id"),
        inverseJoinColumns = @JoinColumn(name = "grade_id",
            referencedColumnName = "grade_id"))
    private Grade grade = new Grade();

    /**
     * 课程表对应的成绩
     */
    @OneToMany(targetEntity = Score.class,
        fetch = FetchType.EAGER)
    @JoinTable(name = "syllabus_score",
        joinColumns = @JoinColumn(name = "syllabus_id",
                referencedColumnName = "syllabus_id"),
        inverseJoinColumns = @JoinColumn(name = "score_id",
                referencedColumnName = "score_id"))
    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,
        property = "@id")
    private Set<Score> scores = new HashSet<>();

    /**
     * 授课开始时间
     */
    private String starttime;

    /**
     * 授课结束时间
     */
    private String endtime;

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
    public Syllabus () {}

    public Syllabus(String type,
                    Teacher teacher,
                    Course course,
                    Grade grade,
                    Set<Score> scores,
                    String starttime,
                    String endtime,
                    Date createTime,
                    Date updateTime) {
        this.type = type;
        this.teacher = teacher;
        this.course = course;
        this.grade = grade;
        this.scores = scores;
        this.starttime = starttime;
        this.endtime = endtime;
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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
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

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
