package com.controller;

import com.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * 教师 controller
 * Created by huihui on 16-6-12.
 */
@Controller
@RequestMapping(value = "/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @ResponseBody
    @RequestMapping(value = "/add",
            method = RequestMethod.POST)
    public Object add (HttpServletRequest request) {
        String number = request.getParameter("number");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String birth = request.getParameter("birth");
        String address = request.getParameter("address");
        String tel = request.getParameter("tel");
        String email = request.getParameter("email");
        String collegeNum = request.getParameter("collegeNum");

        HashMap<String, String> result = new HashMap<>();
        try {
            Integer id = teacherService.addTeacher(number, name, sex, birth, address,
                    tel, email, collegeNum);
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
            result.put("teacher", teacherService.getAllTeacher());
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
            result.put("teacher", teacherService.getTeacherByNumber(number));
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
        String sex = request.getParameter("sex");
        String birth = request.getParameter("birth");
        String address = request.getParameter("address");
        String tel = request.getParameter("tel");
        String email = request.getParameter("email");
        String collegeNum = request.getParameter("collegeNum");

        HashMap<String, Object> result = new HashMap<>();
        try {
            result = teacherService.editTeacher(id, number, name, sex, birth, address,
                    tel, email, collegeNum);

        }catch (Exception e) {
            e.printStackTrace();
            result.put("status", "1");
            result.put("msg", "修改教师信息失败,出现异常");
        }finally {
            return result;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/change/password", method = RequestMethod.POST)
    public Object changePassword (HttpServletRequest request) {

        String id = request.getParameter("id");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");

        HashMap<String, Object> result = new HashMap<>();
        try {
            result = teacherService.changePassword(id, oldPassword, newPassword);

        }catch (Exception e) {
            e.printStackTrace();
            result.put("status", "1");
            result.put("msg", "修改教师信息失败,出现异常");
        }finally {
            return result;
        }
    }


    @ResponseBody
    @RequestMapping(value = "/delete/{number}", method = RequestMethod.GET)
    public Object delete (@PathVariable String number) {
        HashMap<String, Object> result = new HashMap<>();
        try {
            teacherService.deleteTeacher(number);
            result.put("status", "0");
            result.put("msg", "删除成功");
        }catch (Exception e) {
            result.put("status", "1");
            result.put("msg", "删除失败");
        }

        return result;
    }

    // get/set

    public TeacherService getTeacherService() {
        return teacherService;
    }

    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
}
