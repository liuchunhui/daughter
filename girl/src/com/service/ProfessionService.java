package com.service;

import com.dao.CollegeDao;
import com.dao.ProfessionDao;
import com.model.College;
import com.model.Grade;
import com.model.Profession;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 专业 service
 * Created by huihui on 16-6-6.
 */
public class ProfessionService {
    Profession profession;
    ProfessionDao professionDao;
    College college;
    CollegeDao collegeDao;

    /**
     * 创建专业信息
     * @param collegeNum 学院编号
     * @param number 专业编号
     * @param name 专业名称
     * @param description 专业描述
     * @return 专业在数据库生成id
     */
    public Integer addProfession (String collegeNum,
                                  String number,
                                  String name,
                                  String description) {

        college = collegeDao.findByNumber(collegeNum);

        profession.setCollege(college);
        profession.setNumber(number);
        profession.setName(name);
        profession.setDescription(description);
        profession.setCreateTime(new Date());
        profession.setUpdateTime(new Date());

        return professionDao.save(profession);
    }

    /**
     * 获取所有专业信息
     * @return 专业信息列表
     */
    public List<Profession> getAllProfession () {
        try {
            return professionDao.findAll();
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据专业信息在数据库中的主键id查找该专业信息
     * @param id
     * @return
     */
    public Profession getProfessionById (String id) {
        return professionDao.findById(id);
    }

    /**
     * 修改专业信息
     * @param id 数据表中主键id
     * @param collegeNum 学院编号
     * @param number 专业编号
     * @param name 专业名称
     * @param description 专业描述
     * @return 修改结果信息
     */
    public HashMap<String, Object> eidtProfession (String id,
                                                   String collegeNum,
                                                   String number,
                                                   String name,
                                                   String description) {

        profession = professionDao.findById(id);

        // 判断专业所属学院是否修改
        if (null != profession && (null == profession.getCollege() ||
                !profession.getCollege().getNumber().equals(collegeNum))) {
            college = collegeDao.findByNumber(collegeNum);
            profession.setCollege(college);
        }

        HashMap<String, Object> result = new HashMap<>();
        if (null != profession) {
            profession.setNumber(number);
            profession.setName(name);
            profession.setDescription(description);
            profession.setUpdateTime(new Date());
            professionDao.saveOrUpdate(profession);
            result.put("status", "0");
            result.put("msg", "修改专业信息成功");
        }else {
            result.put("status", "1");
            result.put("msg", "修改专业信息失败，获取该专业信息失败");
        }
        return result;
    }

    /**
     * 删除专业信息
     * @param id 专业id
     */
    public void deleteProfession (String id) {
        profession = professionDao.findById(id);
        professionDao.delete(profession);
    }

    // get/set方法

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public ProfessionDao getProfessionDao() {
        return professionDao;
    }

    public void setProfessionDao(ProfessionDao professionDao) {
        this.professionDao = professionDao;
    }

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
