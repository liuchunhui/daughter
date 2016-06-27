package com.controller;

import com.service.AdminService;
import com.service.StudentService;
import com.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Created by huihui on 16-6-4.
 */

@Controller
public class LoginController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;

    /**
     * 系统登陆接口
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login",
            method = RequestMethod.POST)
    public Object login (HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String usertype = request.getParameter("usertype");
        HashMap<String, String> hashMap = new HashMap<String, String>();

        try {
            switch (usertype) {
                case "admin":
                    hashMap = adminService.loginAdmin(username, password);
                    break;
                case "teacher":
                    hashMap = teacherService.loginTeacher(username, password);
                    break;
                case "student":
                    hashMap = studentService.loginStudent(username, password);
                    break;
            }
        }catch (Exception e) {
            e.printStackTrace();
            hashMap.put("msg", "登陆出现异常");
        }

        return hashMap;
    }

    /**
     * 系统登陆界面接口
     * @return
     */
    @RequestMapping(value = "login/page")
    public String loginPage() {
        return "login";
    }

    // get/set 方法


    public AdminService getAdminService() {
        return adminService;
    }

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }
}
