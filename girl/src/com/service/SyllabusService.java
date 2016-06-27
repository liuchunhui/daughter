package com.service;

import com.dao.*;
import com.model.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 课程表 service
 * Created by huihui on 16-6-6.
 */
public class SyllabusService {
    Syllabus syllabus;
    SyllabusDao syllabusDao;
    Course course;
    CourseDao courseDao;
    Teacher teacher;
    TeacherDao teacherDao;
    Grade grade;  // 班级model
    GradeDao gradeDao;  // 班级dao
    Student student;
    StudentDao studentDao;

    public Integer addSyllabus (String type,
                                String courseNum,
                                String teacherNum,
                                String gradeNum,
                                String starttime,
                                String endtime) {

        course = courseDao.findByNumber(courseNum);
        teacher = teacherDao.findByNumber(teacherNum);
        grade = gradeDao.findByNumber(gradeNum);

        syllabus.setType(type);
        syllabus.setCourse(course);
        syllabus.setTeacher(teacher);
        syllabus.setGrade(grade);
        syllabus.setStarttime(starttime);
        syllabus.setEndtime(endtime);
        syllabus.setCreateTime(new Date());
        syllabus.setUpdateTime(new Date());

        return syllabusDao.save(syllabus);
    }


    public List<Syllabus> getAllSyllabus () {
        try {
            return syllabusDao.findAll();
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Syllabus> getStudentAllSyllabus (String studentNum) {
        student = studentDao.findByNumber(studentNum);

        if (null != student) {
            grade = student.getGrade();
            return syllabusDao.findByGrade(grade);
        }else {
            return null;
        }

    }

    public List<Syllabus> getTeacherAllSyllabus (String teacherNum) {
        teacher = teacherDao.findByNumber(teacherNum);

        if (null != teacher) {
            return syllabusDao.findByTeacher(teacher);
        }else {
            return null;
        }

    }

    public Syllabus getSyllabusById (String id) {
        return syllabusDao.findById(id);
    }



    public HashMap<String, Object> editSyllabus (String id,
                                                 String type,
                                                 String courseNum,
                                                 String teacherNum,
                                                 String gradeNum,
                                                 String starttime,
                                                 String endtime) {

        syllabus = syllabusDao.findById(id);

        // 判断所属课程是否修改
        if (syllabus != null && (syllabus.getCourse() == null || !syllabus.getCourse().getNumber().equals(courseNum))) {
            course = courseDao.findByNumber(courseNum);
            syllabus.setCourse(course);
        }

        // 判断所属教师是否修改
        if (syllabus != null && (syllabus.getTeacher() == null || !syllabus.getTeacher().getNumber().equals(teacherNum))) {
            teacher = teacherDao.findByNumber(teacherNum);
            syllabus.setTeacher(teacher);
        }

        // 判断所属班级是否修改
        if (syllabus != null && (syllabus.getGrade() == null || !syllabus.getGrade().getNumber().equals(gradeNum))) {
            grade = gradeDao.findByNumber(gradeNum);
            syllabus.setGrade(grade);
        }



        HashMap<String, Object> result = new HashMap<>();

        if (null != syllabus) {
            syllabus.setType(type);
            syllabus.setStarttime(starttime);
            syllabus.setEndtime(endtime);
            syllabus.setUpdateTime(new Date());

            syllabusDao.saveOrUpdate(syllabus);
            result.put("status", "0");
            result.put("msg", "修改课程表信息成功");
        }else {
            result.put("status", "1");
            result.put("msg", "修改课程表信息失败，获取改课程表信息失败");
        }
        return result;
    }

    /**
     * 删除课程表信息
     * @param id 课程表id
     */
    public void deleteSyllabus (String id) {
        syllabus = syllabusDao.findById(id);
        syllabusDao.delete(syllabus);
    }

    // get/set方法

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public CourseDao getCourseDao() {
        return courseDao;
    }

    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public TeacherDao getTeacherDao() {
        return teacherDao;
    }

    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public GradeDao getGradeDao() {
        return gradeDao;
    }

    public void setGradeDao(GradeDao gradeDao) {
        this.gradeDao = gradeDao;
    }

    public Syllabus getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(Syllabus syllabus) {
        this.syllabus = syllabus;
    }

    public SyllabusDao getSyllabusDao() {
        return syllabusDao;
    }

    public void setSyllabusDao(SyllabusDao syllabusDao) {
        this.syllabusDao = syllabusDao;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
}
