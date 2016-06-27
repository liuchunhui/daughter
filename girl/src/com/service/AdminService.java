package com.service;

import com.model.Admin;
import com.dao.AdminDao;

import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 管理员角色Service
 * Created by huihui on 16-6-5.
 */
public class AdminService {

    Admin admin;
    AdminDao adminDao;

    /**
     * 根据用户名查找用户信息
     * 并判断密码是否正确
     *
     * @param username
     * @param password
     * @return
     */
    public HashMap<String, String> loginAdmin(String username, String password) {
        HashMap<String, String> result = new HashMap<String, String>();
        admin = adminDao.find(username);

        if (null == admin) {
            result.put("msg", "用户名不存在");
        }else {
            if (admin.getPassword().equals(password)) {
                result.put("url", "/admin/frame/page");
            }else {
                result.put("msg", "密码错误");
            }
        }
        return result;
    }

    /**
     * 添加用户信息
     * @param admin
     * @return
     */
    public Integer saveAdmin(Admin admin) {
        return adminDao.save(admin);
    }

    /**
     * 修改管理员密码
     * @param oldPassword
     * @param newPassword
     */
    public Object editAdmin(String oldPassword, String newPassword) {
        admin = adminDao.find("admin");

        HashMap<String, String> result = new HashMap<>();
        if (admin.getPassword().equals(oldPassword)) {
            admin.setPassword(newPassword);

            try{
                adminDao.saveOrUpdate(admin);
                result.put("status", "0");
                result.put("msg", "修改成功");
            }catch (Exception e) {
                e.printStackTrace();
                result.put("status", "1");
                result.put("msg", "修改失败");
            }

        }else {
            result.put("status", "1");
            result.put("msg", "原始密码不正确");
        }
        return result;
    }

    /**
     * 删除用户信息
     * @param username
     */
    public void deleteAdmin(String username) {
        adminDao.delete(username);
    }

    // get/set 方法

    public AdminDao getAdminDao() {
        return adminDao;
    }

    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
