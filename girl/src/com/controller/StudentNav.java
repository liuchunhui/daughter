package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 学生角色下页面路由
 * Created by huihui on 16-6-6.
 */
@Controller
@RequestMapping(value = "student/")
public class StudentNav {

    /**
     * 学生角色的整个框架页面
     * @return
     */
    @RequestMapping(value = "frame/page")
    public String frame () {
        return "student/frame";
    }

    /**
     * 框架的header页面
     * @return
     */
    @RequestMapping(value = "header/page")
    public String header () {
        return "student/header";
    }

    /**
     * 框架的body页面
     * @return
     */
    @RequestMapping(value = "body/page")
    public String body () {
        return "student/body";
    }

    /**
     * 框架的footer页面
     * @return
     */
    @RequestMapping(value = "footer/page")
    public String footer () {
        return "student/footer";
    }

    /**
     * 导航页面
     * @return
     */
    @RequestMapping(value = "nav/page")
    public String nav () {
        return "student/nav";
    }

    /**
     * 首页
     * @return
     */
    @RequestMapping(value = "index/page")
    public String index () {
        return "student/index";
    }

    /**
     * 课程表信息页面
     * @return
     */
    @RequestMapping(value = "syllabus/page")
    public String syllabus () {
        return "student/syllabus";
    }

    /**
     * 成绩信息页面
     * @return
     */
    @RequestMapping(value = "score/page")
    public String score () {
        return "student/score";
    }

    /**
     * 公告管理页面
     * @return
     */
    @RequestMapping(value = "annunciate/page")
    public String annunciate () {
        return "student/annunciate";
    }

    /**
     * 个人信息页面
     * @return
     */
    @RequestMapping(value = "info/page")
    public String admin () {
        return "student/info";
    }

    /**
     * 修改密码
     * @return
     */
    @RequestMapping(value = "password/page")
    public String password () {
        return "student/password";
    }
}
