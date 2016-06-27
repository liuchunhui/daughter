package com.dao;

import com.model.Grade;
import com.model.Syllabus;
import com.model.Teacher;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 课程表信息 dao
 * Created by huihui on 16-6-6.
 */
public class SyllabusDao extends HibernateDaoSupport {


    /**
     * 保存课程表信息
     * @param syllabus
     * @return
     */
    @Transactional(readOnly = false)
    public Integer save (Syllabus syllabus) {
        return (Integer)getHibernateTemplate().save(syllabus);
    }

    /**
     * 修改课程表信息，课程表信息不存在则创建课程表信息
     * @param syllabus
     */
    @Transactional(readOnly = false)
    public void saveOrUpdate (Syllabus syllabus) {
        getHibernateTemplate().saveOrUpdate(syllabus);
    }

    /**
     * 删除课程表信息
     * @param syllabus
     */
    @Transactional(readOnly = false)
    public void delete (Syllabus syllabus) {
        getHibernateTemplate().delete(syllabus);
    }

    /**
     * 获取所有课程表信息
     * @return
     */
    public List<Syllabus> findAll () {
        return (List<Syllabus>)getHibernateTemplate().find("from Syllabus");
    }

    /**
     * 根据课程表id获取课程表信息
     * @param id
     * @return
     */
    public Syllabus findById (String id) {
        Integer ID = new Integer(id);
        List<Syllabus> syllabuses = (List<Syllabus>)getHibernateTemplate().
                find("from Syllabus as s where s.id=?", ID);

        if (syllabuses.size() == 0) {
            return null;
        }else {
            return syllabuses.get(0);
        }
    }

    /**
     * 根据班级查找课程表
     * @param grade
     * @return
     */
    public List<Syllabus> findByGrade (Grade grade) {
        List<Syllabus> syllabuses = (List<Syllabus>)getHibernateTemplate().
                find("from Syllabus as s where s.grade=?", grade);

        return syllabuses;
    }

    /**
     * 根据教师查找课程表
     * @param teacher
     * @return
     */
    public List<Syllabus> findByTeacher (Teacher teacher) {
        List<Syllabus> syllabuses = (List<Syllabus>)getHibernateTemplate().
                find("from Syllabus as s where s.teacher=?", teacher);

        return syllabuses;
    }
}
