package com.service;

import com.dao.GradeDao;
import com.dao.ProfessionDao;
import com.model.Grade;
import com.model.Profession;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 班级 service
 * Created by huihui on 16-6-6.
 */
public class GradeService {
    Grade grade;  // 班级model
    GradeDao gradeDao;  // 班级dao
    Profession profession;  // 专业model
    ProfessionDao professionDao;  // 专业dao

    public Integer addGrade (String number, String name, String professionNum) {

        profession = professionDao.findByNum(professionNum);

        grade.setName(name);
        grade.setNumber(number);
        grade.setProfession(profession);
        grade.setCreateTime(new Date());
        grade.setUpdateTime(new Date());

        return gradeDao.save(grade);
    }


    public List<Grade> getAllGrade () {
        try {
            return gradeDao.findAll();
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public Grade getGradeById (String id) {
        return gradeDao.findById(id);
    }

    public Grade getGradeByNumber (String number) {
        return gradeDao.findByNumber(number);
    }


    public HashMap<String, Object> editGrade (String id,
                                              String number,
                                              String name,
                                              String professionNum) {

        grade = gradeDao.findById(id);

        // 判断所属专业是否修改
        if (grade != null && (null == grade.getProfession() || !grade.getProfession().getNumber().equals(professionNum))) {
            profession = professionDao.findByNum(professionNum);
            grade.setProfession(profession);
        }

        HashMap<String, Object> result = new HashMap<>();

        if (null != grade) {
            grade.setNumber(number);
            grade.setName(name);
            grade.setUpdateTime(new Date());
            gradeDao.saveOrUpdate(grade);
            result.put("status", "0");
            result.put("msg", "修改班级信息成功");
        }else {
            result.put("status", "1");
            result.put("msg", "修改班级信息失败，获取该班级信息失败");
        }
        return result;
    }

    /**
     * 删除公告信息
     * @param id 公告id
     */
    public void deleteGrade (String id) {
        grade = gradeDao.findById(id);
        gradeDao.delete(grade);
    }

    // get/set

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public GradeDao getGradeDao() {
        return gradeDao;
    }

    public void setGradeDao(GradeDao gradeDao) {
        this.gradeDao = gradeDao;
    }

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
}
