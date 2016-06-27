package com.dao;

import com.model.Annunciate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 公告 dao
 * Created by huihui on 16-6-6.
 */
public class AnnunciateDao extends HibernateDaoSupport {

    /**
     * 创建公告信息
     * @param annunciate
     * @return
     */
    @Transactional(readOnly = false)
    public Integer save (Annunciate annunciate) {
        return (Integer) getHibernateTemplate().save(annunciate);
    }

    /**
     * 修改公告信息，如果信息不存在就创建公告信息
     * @param annunciate
     */
    @Transactional(readOnly = false)
    public void saveOrUpdate (Annunciate annunciate) {
        getHibernateTemplate().saveOrUpdate(annunciate);
    }

    /**
     * 删除公告信息
     * @param annunciate
     */
    @Transactional(readOnly = false)
    public void delete (Annunciate annunciate) {
        getHibernateTemplate().delete(annunciate);
    }

    /**
     * 获取所有公告信息
     * @return
     */
    public List<Annunciate> findAll () {
        return (List<Annunciate>)getHibernateTemplate().find("from Annunciate");
    }

    /**
     * 根据公告id获取公告信息
     * @param id
     * @return
     */
    public Annunciate findById (String id) {
        Integer ID = new Integer(id);
        List<Annunciate> annunciates = (List<Annunciate>)getHibernateTemplate().find("from Annunciate as a where a.id=?", ID);

        if (annunciates.size() == 0) {
            return null;
        }else {
            return annunciates.get(0);
        }
    }
}
