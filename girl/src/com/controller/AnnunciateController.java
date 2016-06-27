package com.controller;

import com.service.AnnunciateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * 公告 controller
 * Created by huihui on 16-6-10.
 */
@Controller
@RequestMapping(value = "/annunciate")
public class AnnunciateController {

    @Autowired
    AnnunciateService annunciateService;

    @ResponseBody
    @RequestMapping(value = "/add",
            method = RequestMethod.POST)
    public Object add (HttpServletRequest request) {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String creator = request.getParameter("creator");

        HashMap<String, String> result = new HashMap<>();
        try {
            Integer id = annunciateService.addAnnunciate(title, content, creator);
            result.put("msg", "创建成功");
            result.put("status", "0");
        }catch (Exception e) {
            e.printStackTrace();
            result.put("msg", "创建失败");
            result.put("status", "1");
        }

        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Object getAll () {
        HashMap<String, Object> result = new HashMap<>();

        try {
            result.put("annunciate", annunciateService.getAllAnnunciate());
            result.put("status", "0");
        }catch (Exception e) {
            e.printStackTrace();
            result.put("status", "1");
        }finally {
            return result;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/get/{number}", method = RequestMethod.GET)
    public Object getById (@PathVariable String id) {
        HashMap<String, Object> result = new HashMap<>();
        try {
            result.put("college", annunciateService.getAnnunciateById(id));
            result.put("status", "0");
        }catch (Exception e) {
            e.printStackTrace();
            result.put("status", "1");
        }finally {
            return result;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public Object edit (HttpServletRequest request) {
        String id = request.getParameter("id");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String creator = request.getParameter("creator");

        HashMap<String, Object> result = new HashMap<>();
        try {
            result = annunciateService.eidtAnnunciate(id, title, content, creator);

        }catch (Exception e) {
            e.printStackTrace();
            result.put("status", "1");
            result.put("msg", "修改公告信息失败,出现异常");
        }finally {
            return result;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public Object delete (@PathVariable String id) {
        HashMap<String, Object> result = new HashMap<>();
        try {
            annunciateService.deleteAnnunciate(id);
            result.put("status", "0");
            result.put("msg", "删除成功");
        }catch (Exception e) {
            result.put("status", "1");
            result.put("msg", "删除失败");
        }

        return result;
    }

    // get/set方法


    public AnnunciateService getAnnunciateService() {
        return annunciateService;
    }

    public void setAnnunciateService(AnnunciateService annunciateService) {
        this.annunciateService = annunciateService;
    }
}
