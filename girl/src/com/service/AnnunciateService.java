package com.service;

import com.dao.AnnunciateDao;
import com.model.Annunciate;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 公告 dao
 * Created by huihui on 16-6-6.
 */
public class AnnunciateService {
    Annunciate annunciate;
    AnnunciateDao annunciateDao;

    /**
     * 添加公告信息
     * @param title 公告标题
     * @param content 公告内容
     * @param creator 公告创建者
     * @return 创建公告的id
     */
    public Integer addAnnunciate (String title, String content, String creator) {
        annunciate.setTitle(title);
        annunciate.setContent(content);
        annunciate.setCreator(creator);
        annunciate.setCreateTime(new Date());
        annunciate.setUpdateTime(new Date());

        return annunciateDao.save(annunciate);
    }

    /**
     * 获取所有公告信息
     * @return 公告列表
     */
    public List<Annunciate> getAllAnnunciate () {
        return annunciateDao.findAll();
    }

    /**
     * 根据id获取公告信息
     * @param id 公告id
     * @return 获取公告信息
     */
    public Annunciate getAnnunciateById (String id) {
        return annunciateDao.findById(id);
    }

    /**
     * 修改公告信息
     * @param id 公告id
     * @param title 公告标题
     * @param content 公告内容
     * @param creator 公告创建者
     * @return 创建公告的结果
     */
    public HashMap<String, Object> eidtAnnunciate (String id, String title, String content, String creator) {

        annunciate = annunciateDao.findById(id);

        HashMap<String, Object> result = new HashMap<>();
        if (null != annunciate) {
            annunciate.setTitle(title);
            annunciate.setContent(content);
            annunciate.setCreator(creator);
            annunciate.setUpdateTime(new Date());
            annunciateDao.saveOrUpdate(annunciate);
            result.put("status", "0");
            result.put("msg", "修改公告信息成功");
        }else {
            result.put("status", "1");
            result.put("msg", "修改公告信息失败，获取该公告信息失败");
        }
        return result;
    }

    /**
     * 删除公告信息
     * @param id 公告id
     */
    public void deleteAnnunciate (String id) {
        annunciate = annunciateDao.findById(id);
        annunciateDao.delete(annunciate);
    }

    // get/set
    public Annunciate getAnnunciate() {
        return annunciate;
    }

    public void setAnnunciate(Annunciate annunciate) {
        this.annunciate = annunciate;
    }

    public AnnunciateDao getAnnunciateDao() {
        return annunciateDao;
    }

    public void setAnnunciateDao(AnnunciateDao annunciateDao) {
        this.annunciateDao = annunciateDao;
    }
}
