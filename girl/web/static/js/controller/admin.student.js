/**
 * 学生
 * Created by huihui on 16-6-12.
 */

new Vue({
    el: '#adminStudent',
    data: {
        student: {
            number: null,  // 教师编号
            name: null,  // 教师名称
            sex: null,  // 教师性别
            birth: null,  // 教师出生日期
            tel: null,  // 教师电话
            email: null,  // 教师邮箱
            address: null,  // 教师家庭住址
            password: null,  // 教师登陆密码
            gradeNum: null  // 教师对应的学院编号
        },
        students: [],
        grades: [],
        filterKey: null  // 过滤条件
    },
    created: function () {},
    beforeCompile: function () {},
    compiled: function () {
        var me = this;

        $.ajax({  // 获取班级信息
            url: "/grade/get",
            method: "get",
            type: "json",
            success: function (data) {
                console.log(data);
                if (data.status == "0") {
                    me.grades = data.grade;
                }else {
                    console.log(data);
                }
            },
            error: function (data) {
                console.log("获取班级信息数据出错");
            }
        });

        $.ajax({
            url: "/student/get",
            method: "get",
            type: "json",
            success: function (data) {
                if (data.status == "0") {
                    me.students = data.student.map(function (e, i) {
                        if (e.grade == null) {
                            e.grade = {};
                            e.grade.name = null;
                            e.grade.profession = {};
                            e.grade.profession.name = null;
                            e.grade.profession.college = {};
                            e.grade.profession.college.name = {};
                        }
                        e.createTime = common.timestampTdate(e.createTime);
                        e.updateTime = common.timestampTdate(e.updateTime);
                        return e;
                    });
                }else {
                    alert("获取学生信息数据出错");
                }
            },
            error: function () {
                alert("获取学生信息数据出错");
            }
        });
    },
    ready: function () {},
    beforeDestroy: function () {},
    destroyed: function () {},
    methods: {
        addClick: function () {  // 点击添加学生按钮，初始化学生属性参数

            this.student.number = null;  // 编号
            this.student.name = null;  // 名称
            this.student.sex = null;  // 性别
            this.student.birth = null;  // 出生日期
            this.student.tel = null;  // 电话
            this.student.email = null;  // 邮箱
            this.student.address = null;  // 家庭住址
            this.student.password = null;  // 登陆密码
            this.student.gradeNum = null;  // 对应的班级编号

            // 定制展示添加模态框
            $('#addStudent').modal();
        },

        addStudent: function () {  // 添加学生信息
            var me = this;

            $.ajax({
                url: "/student/add",
                method: "post",
                type: "json",
                data: {
                    number: me.student.number,
                    name: me.student.name,
                    sex: me.student.sex,
                    birth: me.student.birth,
                    tel: me.student.tel,
                    email: me.student.email,
                    address: me.student.address,
                    gradeNum: me.student.gradeNum
                },
                success: function (data) {
                    if (data.status == "0") {
                        alert("创建信息成功");
                        location.reload();
                    }
                },
                error: function () {
                    alert("创建信息失败");
                }
            });
        },
        editClick: function (index) {  // 点击信息中的编辑按钮

            var me = this;
            me.student.id = me.students[index].id;
            me.student.number = me.students[index].number;
            me.student.name = me.students[index].name;
            me.student.sex = me.students[index].sex;
            me.student.birth = me.students[index].birth;
            me.student.tel = me.students[index].tel;
            me.student.email = me.students[index].email;
            me.student.address = me.students[index].address;
            if (me.students[index].grade == null) {
                me.student.gradeNum = null;
            }else {
                me.student.gradeNum = me.students[index].grade.number;
            }


            // 定制展示编辑模态框
            $('#editStudent').modal();
        },
        editStudent: function () {  // 编辑信息
            var me = this;
            $.ajax({
                url: "/student/edit",
                method: "post",
                type: "json",
                data: {
                    id: me.student.id,
                    number: me.student.number,
                    name: me.student.name,
                    sex: me.student.sex,
                    birth: me.student.birth,
                    tel: me.student.tel,
                    email: me.student.email,
                    address: me.student.address,
                    gradeNum: me.student.gradeNum
                },
                success: function (data) {
                    alert(data.msg);
                    if (data.status == "0") {
                        location.reload();
                    }
                },
                error: function (data) {
                    alert("修改失败");
                }
            });
        },
        deleteStudent: function (index) {  // 删除信息
            var url = "/student/delete/" + this.students[index].id;

            if (confirm("确定删除？")) {
                $.ajax({
                    url: url,
                    method: "get",
                    success: function (data) {
                        alert(data.msg);
                        if (data.status == "0") {
                            location.reload();
                        }
                    },
                    error: function () {
                        alert("删除失败");
                    }
                });
            }
        }
    }
});

