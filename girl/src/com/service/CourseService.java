package com.service;

import com.dao.CourseDao;
import com.model.Course;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 课程 service
 * Created by huihui on 16-6-6.
 */
public class CourseService {
    Course course;
    CourseDao courseDao;

    /**
     * 添加课程
     * @param number 课程编号
     * @param name 课程姓名
     * @param period 课程学时
     * @return 课程创建的id
     */
    public Integer addCourse (String number,
                              String name,
                              String period) {
        course.setNumber(number);
        course.setName(name);
        course.setPeriod(period);
        course.setCreateTime(new Date());
        course.setUpdateTime(new Date());

        System.out.println(course);
        return courseDao.save(course);
    }

    /**
     * 获取所有课程信息
     * @return 课程信息列表
     */
    public List<Course> getAllCourse () {
        return courseDao.findAll();
    }

    /**
     * 根据课程id获取课程信息
     * @param id
     * @return
     */
    public Course getCourseById (String id) {
        return courseDao.findById(id);
    }

    /**
     * 根据课程的number获取课程信息
     * @param number
     * @return
     */
    public Course getCourseByNumber (String number) {
        return courseDao.findByNumber(number);
    }


    public HashMap<String, Object> editCourse (String id,
                                               String number,
                                               String name,
                                               String period) {

        course = courseDao.findById(id);

        HashMap<String, Object> result = new HashMap<>();
        if (null != course) {
            course.setNumber(number);
            course.setName(name);
            course.setPeriod(period);
            course.setUpdateTime(new Date());
            courseDao.saveOrUpdate(course);

            result.put("status", "0");
            result.put("msg", "修改课程信息成功");
        }else {
            result.put("status", "1");
            result.put("msg", "修改课程信息失败，获取该课程信息失败");
        }
        return result;
    }

    /**
     * 根据课程id删除课程信息
     * @param id
     */
    public void deleteCourse (String id) {
        course = courseDao.findById(id);
        courseDao.delete(course);
    }


    // get/set

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
}
