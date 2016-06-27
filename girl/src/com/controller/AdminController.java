package com.controller;

import com.service.AdminService;
import org.omg.CORBA.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * 管理员 controller
 * Created by huihui on 16-6-6.
 */
@Controller

public class AdminController {
    @Autowired
    AdminService adminService;

    @ResponseBody
    @RequestMapping(value = "/admin/edit",
        method = RequestMethod.POST)
    public HashMap<String, String> add (HttpServletRequest request) {
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");

        HashMap<String, String> result = new HashMap<>();
        result = (HashMap<String, String>) adminService.editAdmin(oldPassword, newPassword);
        return result;
    }

    // get/set

    public AdminService getAdminService() {
        return adminService;
    }

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }
}
