package com.controller;

import com.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * 学院 controller
 * Created by huihui on 16-6-7.
 */

@Controller
@RequestMapping(value = "/college")
public class CollegeController {

    @Autowired
    CollegeService collegeService;

    @ResponseBody
    @RequestMapping(value = "/add",
        method = RequestMethod.POST)
    public Object add (HttpServletRequest request) {
        String number = request.getParameter("number");
        String name = request.getParameter("name");
        String description = request.getParameter("description");

        HashMap<String, String> result = new HashMap<>();
        try {
            Integer id = collegeService.addCollege(number, name, description);
            result.put("msg", "创建成功");
            result.put("status", "0");
        }catch (Exception e) {
            e.printStackTrace();
            result.put("msg", e.getMessage());
            result.put("status", "1");
        }

        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Object getAll () {
        HashMap<String, Object> result = new HashMap<>();

        try {
            result.put("college", collegeService.getAllCollege());
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
    public Object getByNum (@PathVariable String number) {
        HashMap<String, Object> result = new HashMap<>();
        try {
            result.put("college", collegeService.getCollegeByNum(number));
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
        String name = request.getParameter("name");
        String number = request.getParameter("number");
        String description = request.getParameter("description");

        HashMap<String, Object> result = new HashMap<>();
        try {
            result = collegeService.eidtCollege(id, number, name, description);

        }catch (Exception e) {
            e.printStackTrace();
            result.put("status", "1");
            result.put("msg", "修改学院信息失败,出现异常");
        }finally {
            return result;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/delete/{number}", method = RequestMethod.GET)
    public Object delete (@PathVariable String number) {
        HashMap<String, Object> result = new HashMap<>();
        try {
            collegeService.deleteCollege(number);
            result.put("status", "0");
            result.put("msg", "删除成功");
        }catch (Exception e) {
            result.put("status", "1");
            result.put("msg", "删除失败");
        }

        return result;
    }

    // get/set 方法

    public CollegeService getCollegeService() {
        return collegeService;
    }

    public void setCollegeService(CollegeService collegeService) {
        this.collegeService = collegeService;
    }
}
