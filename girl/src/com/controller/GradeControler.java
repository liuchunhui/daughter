package com.controller;

import com.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * 班级 controller
 * Created by huihui on 16-6-11.
 */
@Controller
@RequestMapping(value = "/grade")
public class GradeControler {

    @Autowired
    GradeService gradeService;

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object add (HttpServletRequest request) {
        String number = request.getParameter("number");
        String name = request.getParameter("name");
        String professionNum = request.getParameter("professionNum");

        HashMap<String, String> result = new HashMap<>();
        try {
            Integer id = gradeService.addGrade(number, name, professionNum);
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
            result.put("grade", gradeService.getAllGrade());
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
    public Object getById (@PathVariable String number) {
        HashMap<String, Object> result = new HashMap<>();
        try {
            result.put("grade", gradeService.getGradeByNumber(number));
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
        String professionNum = request.getParameter("professionNum");

        HashMap<String, Object> result = new HashMap<>();
        try {
            result = gradeService.editGrade(id, number, name, professionNum);
            result.put("status", 0);
            result.put("msg", "修改班级信息成功");
        }catch (Exception e) {
            e.printStackTrace();
            result.put("status", "1");
            result.put("msg", "修改班级信息失败,出现异常");
        }finally {
            return result;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public Object delete (@PathVariable String id) {
        HashMap<String, Object> result = new HashMap<>();
        try {
            gradeService.deleteGrade(id);
            result.put("status", "0");
            result.put("msg", "删除成功");
        }catch (Exception e) {
            result.put("status", "1");
            result.put("msg", "删除失败");
        }

        return result;
    }

    // get/set

    public GradeService getGradeService() {
        return gradeService;
    }

    public void setGradeService(GradeService gradeService) {
        this.gradeService = gradeService;
    }
}
