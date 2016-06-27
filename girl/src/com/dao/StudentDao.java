package com.dao;

import com.model.Grade;
import com.model.Student;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.StreamHandler;

/**
 * 学生 dao
 * Created by huihui on 16-6-6.
 */
public class StudentDao extends HibernateDaoSupport {

    /**
     * 创建学生信息
     * @param student
     * @return
     */
    @Transactional(readOnly = false)
    public Integer save (Student student) {
        return (Integer)getHibernateTemplate().save(student);
    }

    /**
     * 修改学生信息，学生信息不存在则创建学生信息
     * @param student
     */
    @Transactional(readOnly = false)
    public void saveOrUpdate (Student student) {
        getHibernateTemplate().saveOrUpdate(student);
    }

    /**
     * 删除学生信息
     * @param student
     */
    @Transactional(readOnly = false)
    public void delete (Student student) {
        getHibernateTemplate().delete(student);
    }

    /**
     * 查看所有学生信息
     * @return
     */
    public List<Student> findAll () {
        return (List<Student>)getHibernateTemplate().find("from Student");
    }

    /**
     * 根据学号查找学生信息
     * @param number
     * @return
     */
    public Student findByNumber (String number) {
        List<Student> students = (List<Student>)getHibernateTemplate().
                find("from Student as s where s.number=?", number);

        if (students.size() == 0) {
            return null;
        }else {
            return students.get(0);
        }
    }

    /**
     *
     * @param grade
     * @return
     */
    public List<Student> findByGradeNum(Grade grade) {
        return (List<Student>) getHibernateTemplate().
                find("from Student as s where s.grade=?", grade);


    }

    /**
     * 根据学生id查找学生信息
     * @param id
     * @return
     */
    public Student findById (String id) {
        Integer ID = new Integer(id);
        List<Student> students = (List<Student>)getHibernateTemplate().
                find("from Student as s where s.id=?", ID);

        if (students.size() == 0) {
            return null;
        }else {
            return students.get(0);
        }
    }
}
