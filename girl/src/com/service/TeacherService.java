package com.service;

import com.dao.CollegeDao;
import com.dao.TeacherDao;
import com.model.College;
import com.model.Teacher;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * 教师 service
 * Created by huihui on 16-6-6.
 */
public class TeacherService {

    Teacher teacher;
    TeacherDao teacherDao;
    College college;
    CollegeDao collegeDao;


    public HashMap<String, String> loginTeacher(String username, String password) {
        HashMap<String, String> result = new HashMap<String, String>();
        teacher = teacherDao.findByNumber(username);  // 教师的编号

        if (null == teacher) {
            result.put("msg", "用户名不存在");
        }else {
            if (teacher.getPassword().equals(password)) {
                String url = "/teacher/frame/page?number=" + teacher.getNumber();
                result.put("url", url);
            }else {
                result.put("msg", "密码错误");
            }
        }
        return result;
    }

    public Integer addTeacher (String number,
                               String name,
                               String sex,
                               String birth,
                               String address,
                               String tel,
                               String email,
                               String collegeNum) {

        college = collegeDao.findByNumber(collegeNum);

        teacher.setNumber(number);
        teacher.setName(name);
        teacher.setSex(sex);
        teacher.setBirth(birth);
        teacher.setAddress(address);
        teacher.setTel(tel);
        teacher.setEmail(email);
        teacher.setPassword("0000");  // 密码初始都是0000
        teacher.setCollege(college);
        teacher.setCreateTime(new Date());
        teacher.setUpdateTime(new Date());

        return teacherDao.save(teacher);
    }


    public List<Teacher> getAllTeacher () {
        try {
            return teacherDao.fineAll();
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public Teacher getTeacherById (String id) {
        return teacherDao.findById(id);
    }

    public Teacher getTeacherByNumber (String number) {
        return teacherDao.findByNumber(number);
    }

    public HashMap<String, Object> changePassword (String id,
                                                   String oldPassword,
                                                   String newPassword) {
        teacher = teacherDao.findById(id);
        HashMap<String, Object> result = new HashMap<>();
        if (null != teacher) {

            try {
                if (teacher.getPassword().equals(oldPassword)) {
                    teacher.setPassword(newPassword);
                    teacherDao.saveOrUpdate(teacher);
                    result.put("status", "0");
                    result.put("msg", "修改教师信息成功");
                }else {
                    result.put("status", "1");
                    result.put("msg", "输入原始密码不正确");
                }
            }catch (Exception e) {
                e.printStackTrace();
                result.put("status", "1");
                result.put("msg", "修改教师信息失败，获取改教师信息失败");
            }
        }else {
            result.put("status", "1");
            result.put("msg", "修改教师信息失败，获取改教师信息失败");
        }
        return result;

    }

    public HashMap<String, Object> editTeacher (String id,
                                                String number,
                                                String name,
                                                String sex,
                                                String birth,
                                                String address,
                                                String tel,
                                                String email,
                                                String collegeNum) {

        teacher = teacherDao.findById(id);

        // 判断所属学院是否修改
        if (teacher != null && (teacher.getCollege() == null || !teacher.getCollege().getNumber().equals(collegeNum))) {
            college = collegeDao.findByNumber(number);
            teacher.setCollege(college);
        }

        HashMap<String, Object> result = new HashMap<>();

        if (null != teacher) {
            teacher.setNumber(number);
            teacher.setName(name);
            teacher.setSex(sex);
            teacher.setBirth(birth);
            teacher.setAddress(address);
            teacher.setTel(tel);
            teacher.setEmail(email);
            teacher.setUpdateTime(new Date());

            teacherDao.saveOrUpdate(teacher);
            result.put("status", "0");
            result.put("msg", "修改教师信息成功");
        }else {
            result.put("status", "1");
            result.put("msg", "修改教师信息失败，获取改教师信息失败");
        }
        return result;
    }

    /**
     * 删除教师信息
     * @param id
     */
    public void deleteTeacher (String id) {
        teacher = teacherDao.findById(id);
        teacherDao.delete(teacher);
    }

    // get/set

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

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public CollegeDao getCollegeDao() {
        return collegeDao;
    }

    public void setCollegeDao(CollegeDao collegeDao) {
        this.collegeDao = collegeDao;
    }
}
