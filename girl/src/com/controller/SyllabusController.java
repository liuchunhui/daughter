package com.controller;

import com.service.SyllabusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * 课程表 controller
 * Created by huihui on 16-6-12.
 */
@Controller
@RequestMapping(value = "/syllabus")
public class SyllabusController {

    @Autowired
    SyllabusService syllabusService;

    @ResponseBody
    @RequestMapping(value = "/add",
        method = RequestMethod.POST)
    public Object add (HttpServletRequest request) {
        String type = request.getParameter("type");
        String courseNum = request.getParameter("courseNum");
        String teacherNum = request.getParameter("teacherNum");
        String gradeNum = request.getParameter("gradeNum");
        String starttime = request.getParameter("starttime");
        String endtime = request.getParameter("endtime");


        HashMap<String, String> result = new HashMap<>();
        try {
            Integer id = syllabusService.addSyllabus(type, courseNum, teacherNum, gradeNum,
                    starttime, endtime);
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
            result.put("syllabus", syllabusService.getAllSyllabus());
            result.put("status", "0");
        }catch (Exception e) {
            e.printStackTrace();
            result.put("status", "1");
        }finally {
            return result;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/get/student/{number}", method = RequestMethod.GET)
    public Object getByStudentNum (@PathVariable String number) {
        HashMap<String, Object> result = new HashMap<>();
        try {
            result.put("syllabus", syllabusService.getStudentAllSyllabus(number));
            result.put("status", "0");
        }catch (Exception e) {
            e.printStackTrace();
            result.put("status", "1");
        }finally {
            return result;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/get/teacher/{number}", method = RequestMethod.GET)
    public Object getByTeacherNum (@PathVariable String number) {
        HashMap<String, Object> result = new HashMap<>();
        try {
            result.put("syllabus", syllabusService.getTeacherAllSyllabus(number));
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
        String type = request.getParameter("type");
        String courseNum = request.getParameter("courseNum");
        String teacherNum = request.getParameter("teacherNum");
        String gradeNum = request.getParameter("gradeNum");
        String starttime = request.getParameter("starttime");
        String endtime = request.getParameter("endtime");

        HashMap<String, Object> result = new HashMap<>();
        try {
            result = syllabusService.editSyllabus(id, type, courseNum, teacherNum, gradeNum,
                    starttime, endtime);

        }catch (Exception e) {
            e.printStackTrace();
            result.put("status", "1");
            result.put("msg", "修改课程表信息失败,出现异常");
        }finally {
            return result;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public Object delete (@PathVariable String id) {
        HashMap<String, Object> result = new HashMap<>();
        try {
            syllabusService.deleteSyllabus(id);
            result.put("status", "0");
            result.put("msg", "删除成功");
        }catch (Exception e) {
            result.put("status", "1");
            result.put("msg", "删除失败");
        }

        return result;
    }

    // get/set方法

    public SyllabusService getSyllabusService() {
        return syllabusService;
    }

    public void setSyllabusService(SyllabusService syllabusService) {
        this.syllabusService = syllabusService;
    }
}
