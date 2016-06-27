package com.controller;

import com.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * 成绩 controller
 * Created by huihui on 16-6-12.
 */
@Controller
@RequestMapping(value = "/score")
public class ScoreController {

    @Autowired
    ScoreService scoreService;

    @ResponseBody
    @RequestMapping(value = "/add",
            method = RequestMethod.POST)
    public Object add (HttpServletRequest request) {

        String scorenum = request.getParameter("scorenum");
        String studentNum = request.getParameter("studentNum");
        String syllabusId = request.getParameter("syllabusId");

        HashMap<String, String> result = new HashMap<>();
        try {
            Integer id = scoreService.addScore(scorenum, studentNum, syllabusId);
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
            result.put("score", scoreService.getAllScore());
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
            result.put("score", scoreService.getScoreByTeacherNum(number));
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
            result.put("score", scoreService.getScoreByStudentNum(number));
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
        String scorenum = request.getParameter("scorenum");
        String studentNum = request.getParameter("studentNum");
        String syllabusId = request.getParameter("syllabusId");

        HashMap<String, Object> result = new HashMap<>();
        try {
            result = scoreService.editScore(id, scorenum,studentNum, syllabusId);

        }catch (Exception e) {
            e.printStackTrace();
            result.put("status", "1");
            result.put("msg", "修改成绩信息失败,出现异常");
        }finally {
            return result;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public Object delete (@PathVariable String id) {
        HashMap<String, Object> result = new HashMap<>();
        try {
            scoreService.deleteScore(id);
            result.put("status", "0");
            result.put("msg", "删除成功");
        }catch (Exception e) {
            result.put("status", "1");
            result.put("msg", "删除失败");
        }

        return result;
    }

    // get/set方法

    public ScoreService getScoreService() {
        return scoreService;
    }

    public void setScoreService(ScoreService scoreService) {
        this.scoreService = scoreService;
    }
}
