package com.service;

import com.dao.ScoreDao;
import com.dao.StudentDao;
import com.dao.SyllabusDao;
import com.dao.TeacherDao;
import com.model.Score;
import com.model.Student;
import com.model.Syllabus;
import com.model.Teacher;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 成绩 service
 * Created by huihui on 16-6-6.
 */
public class ScoreService {
    Score score;
    ScoreDao scoreDao;
    Student student;
    StudentDao studentDao;
    Teacher teacher;
    TeacherDao teacherDao;
    Syllabus syllabus;
    SyllabusDao syllabusDao;

    public Integer addScore (String scorenum,
                             String studentNum,
                             String syllabusId) {

        student = studentDao.findByNumber(studentNum);
        syllabus = syllabusDao.findById(syllabusId);
        score.setScore(scorenum);
        score.setStudent(student);
        score.setSyllabus(syllabus);
        score.setCreateTime(new Date());
        score.setUpdateTime(new Date());

        return scoreDao.save(score);
    }


    public List<Score> getAllScore () {
        try {
            return scoreDao.findAll();
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Score> getScoreByTeacherNum (String number) {
        teacher = teacherDao.findByNumber(number);
        return scoreDao.findByTeacherNum(teacher);
    }

    public List<Score> getScoreByStudentNum (String number) {
        student = studentDao.findByNumber(number);
        return scoreDao.findByStudentNum(student);
    }


    public HashMap<String, Object> editScore (String id,
                                                String scorenum,
                                                String studentNum,
                                                String syllabusId) {

        score = scoreDao.findById(id);

        // 判断所属学生是否修改
        if (score != null && !score.getStudent().getNumber().equals(studentNum)) {
            student = studentDao.findByNumber(studentNum);
            score.setStudent(student);
        }

        // 判断所属课程是否修改
        if (score != null && !score.getSyllabus().getId().equals(syllabusId)) {
            syllabus = syllabusDao.findById(syllabusId);
            score.setSyllabus(syllabus);
        }

        HashMap<String, Object> result = new HashMap<>();

        if (null != score) {
            score.setScore(scorenum);
            score.setUpdateTime(new Date());

            scoreDao.saveOrUpdate(score);
            result.put("status", "0");
            result.put("msg", "修改学生成绩信息成功");
        }else {
            result.put("status", "1");
            result.put("msg", "修改学生成绩信息失败，获取改学生成绩信息失败");
        }
        return result;
    }

    /**
     * 删除学生成绩信息
     * @param id 成绩id
     */
    public void deleteScore (String id) {
        score = scoreDao.findById(id);
        scoreDao.delete(score);
    }

    // get/set

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public ScoreDao getScoreDao() {
        return scoreDao;
    }

    public void setScoreDao(ScoreDao scoreDao) {
        this.scoreDao = scoreDao;
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
}
