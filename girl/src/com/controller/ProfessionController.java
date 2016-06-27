package com.controller;

import com.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * 专业 controller
 * Created by huihui on 16-6-11.
 */
@Controller
@RequestMapping(value = "/profession")
public class ProfessionController {
    @Autowired
    ProfessionService professionService;

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object add (HttpServletRequest request) {
        String number = request.getParameter("number");
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String collegeNum = request.getParameter("collegeNum");

        HashMap<String, String> result = new HashMap<>();
        try {
            Integer id = professionService.addProfession(collegeNum, number, name, description);
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
            result.put("profession", professionService.getAllProfession());
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
            result.put("profession", professionService.getProfessionById(id));
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
        String number = request.getParameter("number");
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String collegeNum = request.getParameter("collegeNum");

        HashMap<String, Object> result = new HashMap<>();
        try {
            result = professionService.eidtProfession(id, collegeNum, number, name, description);

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
            professionService.deleteProfession(id);
            result.put("status", "0");
            result.put("msg", "删除成功");
        }catch (Exception e) {
            result.put("status", "1");
            result.put("msg", "删除失败");
        }

        return result;
    }

    // get/set

    public ProfessionService getProfessionService() {
        return professionService;
    }

    public void setProfessionService(ProfessionService professionService) {
        this.professionService = professionService;
    }
}
