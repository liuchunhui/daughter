package com.dao;

import com.model.College;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 学院 dao
 * Created by huihui on 16-6-6.
 */
public class CollegeDao extends HibernateDaoSupport {

    /**
     * 创建学院信息
     * @param college
     * @return
     */
    @Transactional(readOnly = false)
    public Integer save (College college) {
        return (Integer) getHibernateTemplate().save(college);
    }

    /**
     * 修改学院信息，如果学院信息不存在则创建学院信息
     * @param college
     */
    @Transactional(readOnly = false)
    public void saveOrUpdate (College college) {
        getHibernateTemplate().update(college);
    }

    /**
     * 删除学院信息
     * @param college
     */
    @Transactional(readOnly = false)
    public void delete(College college) {
        getHibernateTemplate().delete(college);
    }

    /**
     * 获取所有学院信息
     * @return 所有学院信息
     */
    public List<College> findAll () {
        try {
            return (List<College>) getHibernateTemplate().find("from College");
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据学院编号获取学院信息
     * @param number 学院编号
     * @return 单条学院信息
     */
    public College findByNumber (String number) {
        List<College> colleges = (List<College>) getHibernateTemplate().find("from College as c where c.number=?", number);
        if (colleges.size() == 0) {
            return null;
        }else {
            return colleges.get(0);
        }
    }

    /**
     * 根据学院id获取学院信息
     * @param id 数据表中主键id
     * @return 具体一份学院信息
     */
    public College findById (String id) {
        Integer ID = new Integer(id);

        List<College> colleges = (List<College>) getHibernateTemplate().find("from College as c where c.id=?", ID);
        if (colleges.size() == 0) {
            return null;
        }else {
            return colleges.get(0);
        }
    }

}
