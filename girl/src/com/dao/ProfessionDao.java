package com.dao;

import com.model.Profession;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 专业信息 dao
 * Created by huihui on 16-6-6.
 */
public class ProfessionDao extends HibernateDaoSupport {

    /**
     * 保存专业信息
     * @param profession
     * @return
     */
    @Transactional(readOnly = false)
    public Integer save (Profession profession) {
        return (Integer)getHibernateTemplate().save(profession);
    }

    /**
     * 修改专业信息
     * @param profession
     */
    @Transactional(readOnly = false)
    public void saveOrUpdate (Profession profession) {
        getHibernateTemplate().saveOrUpdate(profession);
    }

    /**
     * 删除专业信息
     * @param profession
     */
    @Transactional(readOnly = false)
    public void delete (Profession profession) {
        getHibernateTemplate().delete(profession);
    }

    /**
     * 获取所有专业信息
     * @return
     */
    public List<Profession> findAll () {
        try {
            return  (List<Profession>)getHibernateTemplate().find("from Profession");
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 根据专业id获取专业信息
     * @param id
     * @return
     */
    public Profession findById (String id) {
        Integer ID = new Integer(id);
        List<Profession> professions = (List<Profession>)getHibernateTemplate().find("from Profession as p where p.id=?", ID);

        if (professions.size() == 0) {
            return null;
        }else {
            return professions.get(0);
        }
    }

    /**
     * 根据专业id获取专业信息
     * @param number
     * @return
     */
    public Profession findByNum (String number) {
        List<Profession> professions = (List<Profession>)getHibernateTemplate().find("from Profession as p where p.number=?", number);

        if (professions.size() == 0) {
            return null;
        }else {
            return professions.get(0);
        }
    }
}
