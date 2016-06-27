package com.controller;

import com.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * 课程 controller
 * Created by huihui on 16-6-11.
 */
@Controller
@RequestMapping(value = "/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @ResponseBody
    @RequestMapping(value = "/add",
        method = RequestMethod.POST)
    public Object add (HttpServletRequest request) {

        String number = request.getParameter("number");
        String name = request.getParameter("name");
        String period = request.getParameter("period");

        HashMap<String, String> result = new HashMap<>();
        try {
            Integer id = courseService.addCourse(number, name, period);
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
            result.put("course", courseService.getAllCourse());
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
            result.put("course", courseService.getCourseByNumber(number));
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
        String period = request.getParameter("period");

        HashMap<String, Object> result = new HashMap<>();
        try {
            result = courseService.editCourse(id, number, name, period);

        }catch (Exception e) {
            e.printStackTrace();
            result.put("status", "1");
            result.put("msg", "修改课程信息失败,出现异常");
        }finally {
            return result;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/delete/{number}", method = RequestMethod.GET)
    public Object delete (@PathVariable String number) {
        HashMap<String, Object> result = new HashMap<>();
        try {
            courseService.deleteCourse(number);
            result.put("status", "0");
            result.put("msg", "删除成功");
        }catch (Exception e) {
            e.printStackTrace();
            result.put("status", "1");
            result.put("msg", "删除失败");
        }

        return result;
    }

    // get/set方法

    public CourseService getCourseService() {
        return courseService;
    }

    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }
}
