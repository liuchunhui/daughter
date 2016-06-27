package com.service;

import com.dao.GradeDao;
import com.dao.StudentDao;
import com.model.Grade;
import com.model.Student;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 学生 service
 * Created by huihui on 16-6-6.
 */
public class StudentService {
    Student student;
    StudentDao studentDao;
    Grade grade;  // 班级model
    GradeDao gradeDao;  // 班级dao

    public HashMap<String, String> loginStudent(String username, String password) {
        HashMap<String, String> result = new HashMap<String, String>();
        student = studentDao.findByNumber(username);  // 学生的编号

        if (null == student) {
            result.put("msg", "用户名不存在");
        }else {
            if (student.getPassword().equals(password)) {
                String url = "/student/frame/page?number=" + student.getNumber();
                result.put("url", url);
            }else {
                result.put("msg", "密码错误");
            }
        }
        return result;
    }

    public Integer addStudent (String number,
                               String name,
                               String sex,
                               String birth,
                               String address,
                               String tel,
                               String email,
                               String gradeNum) {

        grade = gradeDao.findByNumber(gradeNum);

        student.setNumber(number);
        student.setName(name);
        student.setSex(sex);
        student.setBirth(birth);
        student.setAddress(address);
        student.setTel(tel);
        student.setEmail(email);
        student.setPassword("0000");  // 密码初始都是0000
        student.setGrade(grade);
        student.setCreateTime(new Date());
        student.setUpdateTime(new Date());

        return studentDao.save(student);
    }


    public List<Student> getAllStudent () {
        try {
            return studentDao.findAll();
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public Student getStudentById (String id) {
        return studentDao.findById(id);
    }

    public Student getStudentByNumber (String number) {
        return studentDao.findByNumber(number);
    }

    public List<Student> getStudentByGradeNum (String number) {
        grade = gradeDao.findByNumber(number);
        return studentDao.findByGradeNum(grade);
    }

    public HashMap<String, Object> editStudent (String id,
                                              String number,
                                              String name,
                                              String sex,
                                              String birth,
                                              String address,
                                              String tel,
                                              String email,
                                              String gradeNum) {

        student = studentDao.findById(id);

        // 判断所属专业是否修改
        if (student != null && (student.getGrade() == null || !student.getGrade().getNumber().equals(gradeNum))) {
            grade = gradeDao.findByNumber(number);
            student.setGrade(grade);
        }

        HashMap<String, Object> result = new HashMap<>();

        if (null != student) {
            student.setNumber(number);
            student.setName(name);
            student.setSex(sex);
            student.setBirth(birth);
            student.setAddress(address);
            student.setTel(tel);
            student.setEmail(email);
            student.setUpdateTime(new Date());

            studentDao.saveOrUpdate(student);
            result.put("status", "0");
            result.put("msg", "修改学生信息成功");
        }else {
            result.put("status", "1");
            result.put("msg", "修改学生信息失败，获取改学生信息失败");
        }
        return result;
    }

    public HashMap<String, Object> changePassword (String id,
                                                   String oldPassword,
                                                   String newPassword) {
        student = studentDao.findById(id);
        HashMap<String, Object> result = new HashMap<>();
        if (null != student) {

            try {
                if (student.getPassword().equals(oldPassword)) {
                    student.setPassword(newPassword);
                    studentDao.saveOrUpdate(student);
                    result.put("status", "0");
                    result.put("msg", "修改信息成功");
                }else {
                    result.put("status", "1");
                    result.put("msg", "输入原始密码不正确");
                }
            }catch (Exception e) {
                e.printStackTrace();
                result.put("status", "1");
                result.put("msg", "修改信息失败，获取改信息失败");
            }
        }else {
            result.put("status", "1");
            result.put("msg", "修改信息失败");
        }
        return result;
    }

    /**
     * 删除学生信息
     * @param id 学生id
     */
    public void deleteStudent (String id) {
        student = studentDao.findById(id);
        studentDao.delete(student);
    }

    // get/set方法

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public GradeDao getGradeDao() {
        return gradeDao;
    }

    public void setGradeDao(GradeDao gradeDao) {
        this.gradeDao = gradeDao;
    }
}
