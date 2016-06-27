package com.dao;

import com.model.Teacher;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 教师 dao
 * Created by huihui on 16-6-6.
 */
public class TeacherDao extends HibernateDaoSupport {

    /**
     * 添加教师信息
     * @param teacher
     * @return
     */
    @Transactional(readOnly = false)
    public Integer save (Teacher teacher) {
        return (Integer)getHibernateTemplate().save(teacher);
    }

    /**
     * 修改教师信息，教师信息不存在则创建教师信息
     * @param teacher
     */
    @Transactional(readOnly = false)
    public void saveOrUpdate (Teacher teacher) {
        getHibernateTemplate().saveOrUpdate(teacher);
    }

    /**
     * 删除教师信息
     * @param teacher
     */
    @Transactional(readOnly = false)
    public void delete (Teacher teacher) {
        getHibernateTemplate().delete(teacher);
    }

    /**
     * 获取所有教师信息
     * @return
     */
    public List<Teacher> fineAll () {
        return (List<Teacher>) getHibernateTemplate().find("from Teacher");
    }

    /**
     * 根据教师编号查找教师信息
     * @param number
     * @return
     */
    public Teacher findByNumber (String number) {
        List<Teacher> teachers = (List<Teacher>) getHibernateTemplate().
                find("from Teacher as t where t.number=?", number);

        if (teachers.size() == 0) {
            return null;
        }else {
            return teachers.get(0);
        }
    }

    /**
     * 根据教师id查找教师信息
     * @param id
     * @return
     */
    public Teacher findById (String id) {
        Integer ID = new Integer(id);
        List<Teacher> teachers = (List<Teacher>) getHibernateTemplate().
                find("from Teacher as t where t.id=?", ID);

        if (teachers.size() == 0) {
            return null;
        }else {
            return teachers.get(0);
        }
    }
}
