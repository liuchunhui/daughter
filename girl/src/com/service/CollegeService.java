package com.service;

import com.dao.CollegeDao;
import com.model.College;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * 学院 service
 * Created by huihui on 16-6-6.
 */
public class CollegeService {

    College college;
    CollegeDao collegeDao;

    /**
     * 创建学院信息
     * @param number
     * @param name
     * @param description
     * @return
     */
    public Integer addCollege (String number, String name, String description) {
        college.setNumber(number);
        college.setName(name);
        college.setDescription(description);
        college.setCreateTime(new Date());
        college.setUpdateTime(new Date());

        return collegeDao.save(college);
    }

    /**
     * 获取所有学院信息
     * @return
     */
    public List<College> getAllCollege () {
        return collegeDao.findAll();
    }

    /**
     * 根绝学院编号获取学院信息
     * @param number
     * @return
     */
    public College getCollegeByNum (String number) {
        return collegeDao.findByNumber(number);
    }

    /**
     * 修改学院信息
     * @param number
     * @param name
     * @param description
     */
    public HashMap<String, Object> eidtCollege (String id, String number, String name, String description) {
        college = collegeDao.findById(id);
        HashMap<String, Object> result = new HashMap<>();
        if (null != college) {
            college.setNumber(number);
            college.setName(name);
            college.setDescription(description);
            college.setUpdateTime(new Date());

            collegeDao.saveOrUpdate(college);
            result.put("status", "0");
            result.put("msg", "修改学院信息成功");
        }else {
            result.put("status", "1");
            result.put("msg", "修改学院信息失败，获取该学院信息失败");
        }
        return result;
    }

    /**
     * 删除学院信息
     * @param number
     */
    public void deleteCollege (String number) {
        college = collegeDao.findByNumber(number);
        collegeDao.delete(college);
    }

    // get/set方法

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public CollegeDao getCollegeDao() {
        return collegeDao;
    }

    public void setCollegeDao(CollegeDao collegeDao) {
        this.collegeDao = collegeDao;
    }
}
