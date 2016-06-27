package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 管理员角色下页面路由
 * Created by huihui on 16-6-6.
 */
@Controller
@RequestMapping(value = "admin/")
public class AdminNav {

    /**
     * admin角色的整个框架页面
     * @return
     */
    @RequestMapping(value = "/frame/page")
    public String frame () {
        return "admin/frame";
    }

    /**
     * 框架的header页面
     * @return
     */
    @RequestMapping(value = "header/page")
    public String header () {
        return "admin/header";
    }

    /**
     * 框架的body页面
     * @return
     */
    @RequestMapping(value = "body/page")
    public String body () {
        return "admin/body";
    }

    /**
     * 框架的footer页面
     * @return
     */
    @RequestMapping(value = "footer/page")
    public String footer () {
        return "admin/footer";
    }

    /**
     * 导航页面
     * @return
     */
    @RequestMapping(value = "nav/page")
    public String nav () {
        return "admin/nav";
    }

    /**
     * 首页
     * @return
     */
    @RequestMapping(value = "index/page")
    public String index () {
        return "admin/index";
    }

    /**
     * 个人信息页面
     * @return
     */
    @RequestMapping(value = "info/page")
    public String admin () {
        return "admin/info";
    }

    /**
     * 公告管理页面
     * @return
     */
    @RequestMapping(value = "annunciate/page")
    public String annunciate () {
        return "admin/annunciate";
    }

    /**
     * 学院管理页面
     * @return
     */
    @RequestMapping(value = "college/page")
    public String college () {
        return "admin/college";
    }

    /**
     * 课程管理页面
     * @return
     */
    @RequestMapping(value = "course/page")
    public String course () {
        return "admin/course";
    }

    /**
     * 班级管理页面
     * @return
     */
    @RequestMapping(value = "grade/page")
    public String grade () {
        return "admin/grade";
    }

    /**
     * 专业管理页面
     * @return
     */
    @RequestMapping(value = "profession/page")
    public String profession () {
        return "admin/profession";
    }

    /**
     * 成绩管理页面
     * @return
     */
    @RequestMapping(value = "score/page")
    public String score () {
        return "admin/score";
    }

    /**
     * 学生管理页面
     * @return
     */
    @RequestMapping(value = "student/page")
    public String student () {
        return "admin/student";
    }

    /**
     * 课程表管理页面
     * @return
     */
    @RequestMapping(value = "syllabus/page")
    public String syllabus () {
        return "admin/syllabus";
    }

    /**
     * 教师管理页面
     * @return
     */
    @RequestMapping(value = "teacher/page")
    public String teacher () {
        return "admin/teacher";
    }
}
