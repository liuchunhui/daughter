package com.controller;

import com.dao.StudentDao;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Created by huihui on 16-6-12.
 */
@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object add (HttpServletRequest request) {

        String number = request.getParameter("number");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String birth = request.getParameter("birth");
        String address = request.getParameter("address");
        String tel = request.getParameter("tel");
        String email = request.getParameter("email");
        String gradeNum = request.getParameter("gradeNum");

        HashMap<String, String> result = new HashMap<>();
        try {
            Integer id = studentService.addStudent(number, name, sex, birth,
                    address, tel, email, gradeNum);
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
            result.put("student", studentService.getAllStudent());
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
            result.put("student", studentService.getStudentByNumber(number));
            result.put("status", "0");
        }catch (Exception e) {
            e.printStackTrace();
            result.put("status", "1");
        }finally {
            return result;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/get/grade/{number}", method = RequestMethod.GET)
    public Object getByGradeId (@PathVariable String number) {
        HashMap<String, Object> result = new HashMap<>();
        try {
            result.put("student", studentService.getStudentByGradeNum(number));
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
        String gradeNum = request.getParameter("gradeNum");

        HashMap<String, Object> result = new HashMap<>();
        try {
            result = studentService.editStudent(id, number, name, sex, birth, address,
                    tel, email, gradeNum);
            result.put("status", 0);
            result.put("msg", "修改学生信息成功");
        }catch (Exception e) {
            e.printStackTrace();
            result.put("status", "1");
            result.put("msg", "修改学生信息失败,出现异常");
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
            result = studentService.changePassword(id, oldPassword, newPassword);

        }catch (Exception e) {
            e.printStackTrace();
            result.put("status", "1");
            result.put("msg", "修改学生信息失败,出现异常");
        }finally {
            return result;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public Object delete (@PathVariable String id) {
        HashMap<String, Object> result = new HashMap<>();
        try {
            studentService.deleteStudent(id);
            result.put("status", "0");
            result.put("msg", "删除成功");
        }catch (Exception e) {
            result.put("status", "1");
            result.put("msg", "删除失败");
        }

        return result;
    }

    // get/set 方法

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
}
