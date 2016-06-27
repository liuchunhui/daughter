package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 教师角色下页面路由
 * Created by huihui on 16-6-6.
 */
@Controller
@RequestMapping(value = "teacher/")
public class TeacherNav {
    /**
     * 教师角色的整个框架页面
     * @return
     */
    @RequestMapping(value = "frame/page")
    public String frame () {
        return "teacher/frame";
    }

    /**
     * 框架的header页面
     * @return
     */
    @RequestMapping(value = "header/page")
    public String header () {
        return "teacher/header";
    }

    /**
     * 框架的body页面
     * @return
     */
    @RequestMapping(value = "body/page")
    public String body () {
        return "teacher/body";
    }

    /**
     * 框架的footer页面
     * @return
     */
    @RequestMapping(value = "footer/page")
    public String footer () {
        return "teacher/footer";
    }

    /**
     * 导航页面
     * @return
     */
    @RequestMapping(value = "nav/page")
    public String nav () {
        return "teacher/nav";
    }

    /**
     * 首页
     * @return
     */
    @RequestMapping(value = "index/page")
    public String index () {
        return "teacher/index";
    }

    /**
     * 课程表信息页面
     * @return
     */
    @RequestMapping(value = "syllabus/page")
    public String syllabus () {
        return "teacher/syllabus";
    }

    /**
     * 成绩信息页面
     * @return
     */
    @RequestMapping(value = "score/page")
    public String score () {
        return "teacher/score";
    }

    /**
     * 公告管理页面
     * @return
     */
    @RequestMapping(value = "annunciate/page")
    public String annunciate () {
        return "teacher/annunciate";
    }

    /**
     * 修改密码
     * @return
     */
    @RequestMapping(value = "password/page")
    public String password () {
        return "teacher/password";
    }

    /**
     * 个人信息页面
     * @return
     */
    @RequestMapping(value = "info/page")
    public String admin () {
        return "teacher/info";
    }
}
