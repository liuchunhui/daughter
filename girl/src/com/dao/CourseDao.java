package com.dao;

import com.model.Course;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 课程 dao
 * Created by huihui on 16-6-6.
 */
public class CourseDao extends HibernateDaoSupport {

    /**
     * 创建课程信息
     * @param course
     * @return
     */
    @Transactional(readOnly = false)
    public Integer save (Course course) {
        return (Integer)getHibernateTemplate().save(course);
    }

    /**
     * 修改课程信息，如果课程信息不存在则创建课程信息
     * @param course
     */
    @Transactional(readOnly = false)
    public void saveOrUpdate (Course course) {
        getHibernateTemplate().saveOrUpdate(course);
    }

    /**
     * 删除课程信息
     * @param course
     */
    @Transactional(readOnly = false)
    public void delete (Course course) {
        getHibernateTemplate().delete(course);
    }

    /**
     * 获取所有的课程信息
     * @return
     */
    public List<Course> findAll () {
        return (List<Course>)getHibernateTemplate().find("from Course");
    }

    /**
     * 根据课程编号获取课程信息
     * @param number
     * @return
     */
    public Course findByNumber (String number) {

        List<Course> courses = (List<Course>) getHibernateTemplate()
            .find("from Course as c where c.number=?", number);

        if (courses.size() == 0) {
            return null;
        }else {
            return courses.get(0);
        }
    }

    /**
     * 根据课程id获取课程信息
     * @param id
     * @return
     */
    public Course findById (String id) {
        Integer ID = new Integer(id);
        List<Course> courses = (List<Course>) getHibernateTemplate()
            .find("from Course as c where c.id=?", ID);

        if (courses.size() == 0) {
            return null;
        }else {
            return courses.get(0);
        }
    }

}
