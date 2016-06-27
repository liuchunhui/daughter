package com.dao;

import com.model.Admin;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * admin dao
 * Created by huihui on 16-6-5.
 */
public class AdminDao extends HibernateDaoSupport {

    /**
     * 添加用户信息
     *
     * @param admin
     * @return
     */
    @Transactional(readOnly = false)
    public Integer save(Admin admin) {
        return (Integer) getHibernateTemplate().save(admin);
    }

    /**
     * 根据username获取用户信息
     *
     * @param username
     * @return
     */
    public Admin find(String username) {
        Admin result = null;
        try {
            List<Admin> admins = (List<Admin>) getHibernateTemplate()
                    .find("from Admin as a where a.username=?", username);
            if (null != admins && admins.size() > 0) {
                result = admins.get(0);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 更新用户信息
     *
     * @param admin
     * @return
     */
    @Transactional(readOnly = false)
    public void saveOrUpdate(Admin admin) {
        getHibernateTemplate().saveOrUpdate(admin);
    }

    /**
     * 根据用户id删除用户信息
     *
     * @param username
     */
    @Transactional(readOnly = false)
    public void delete(String username) {
        getHibernateTemplate().delete(find(username));
    }
}