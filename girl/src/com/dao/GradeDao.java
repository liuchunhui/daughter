package com.dao;

import com.model.Grade;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 班级 dao
 * Created by huihui on 16-6-6.
 */
public class GradeDao extends HibernateDaoSupport {

    /**
     * 添加班级信息
     * @param grade
     * @return
     */
    @Transactional(readOnly = false)
    public Integer save (Grade grade) {
        return (Integer) getHibernateTemplate().save(grade);
    }

    /**
     * 更新班级信息，如果该班级信息不存在就创建班级信息
     * @param grade
     */
    @Transactional(readOnly = false)
    public void saveOrUpdate (Grade grade) {
        getHibernateTemplate().saveOrUpdate(grade);
    }

    /**
     * 删除班级信息
     * @param grade
     */
    @Transactional(readOnly = false)
    public void delete (Grade grade) {
        getHibernateTemplate().delete(grade);
    }

    /**
     * 获取所有班级信息
     * @return
     */
    public List<Grade> findAll () {
        return (List<Grade>)getHibernateTemplate().find("from Grade");
    }

    /**
     * 根据班级的编号获取班级信息
     * @param number
     * @return
     */
    public Grade findByNumber (String number) {
        List<Grade> grades = (List<Grade>)getHibernateTemplate()
                .find("from Grade as g where g.number=?", number);

        if (grades.size() == 0) {
            return null;
        }else {
            return grades.get(0);
        }
    }

    /**
     * 根据id获取班级信息
     * @param id
     * @return
     */
    public Grade findById (String id) {
        Integer ID = new Integer(id);
        List<Grade> grades = (List<Grade>) getHibernateTemplate()
                .find("from Grade as g where g.id=?", ID);

        if (grades.size() == 0) {
            return null;
        }else {
            return grades.get(0);
        }
    }
}
