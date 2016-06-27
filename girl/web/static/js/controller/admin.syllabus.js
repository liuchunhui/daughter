/**
 * 课程表
 * Created by huihui on 16-6-13.
 */

new Vue({
    el: '#adminSyllabus',
    data: {
        syllabus: {
            id: null,  // id
            type: null,  // 类型
            teacherNum: null,  // 教师编号
            courseNum: null,  // 课程编号
            gradeNum: null,  // 班级编号
            starttime: null,  // 开始时间
            endtime: null  // 结束时间
        },
        syllabuses: [],  // 课程表信息
        teachers: [],  // 教师信息
        courses: [],  // 课程信息
        grades: [],  // 班级信息
        filterKey: null  // 过滤条件
    },
    created: function () {},
    beforeCompile: function () {},
    compiled: function () {
        var me = this;

        $.ajax({  // 获取教师信息
            url: "/teacher/get",
            method: "get",
            type: "json",
            success: function (data) {
                console.log(data);
                if (data.status == "0") {
                    me.teachers = data.teacher;
                }else {
                    console.log(data);
                }
            },
            error: function (data) {
                console.log("获取教师信息数据出错");
            }
        });

        $.ajax({  // 获取课程信息
            url: "/course/get",
            method: "get",
            type: "json",
            success: function (data) {
                console.log(data);
                if (data.status == "0") {
                    me.courses = data.course;
                }else {
                    console.log(data);
                }
            },
            error: function (data) {
                console.log("获取课程信息数据出错");
            }
        });

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
            url: "/syllabus/get",
            method: "get",
            type: "json",
            success: function (data) {
                if (data.status == "0") {
                    me.syllabuses = data.syllabus.map(function (e, i) {
                        e.createTime = common.timestampTdate(e.createTime);
                        e.updateTime = common.timestampTdate(e.updateTime);
                        return e;
                    });
                }else {
                    alert("获取课程表信息数据出错");
                }
            },
            error: function () {
                alert("获取课程表信息数据出错");
            }
        });
    },
    ready: function () {},
    beforeDestroy: function () {},
    destroyed: function () {},
    methods: {
        addClick: function () {  // 点击添加学生按钮，初始化学生属性参数

            this.syllabus = {
                id: null,  // id
                type: null,  // 类型
                teacherNum: null,  // 教师编号
                courseNum: null,  // 课程编号
                gradeNum: null  // 班级编号
            };

            // 定制展示添加模态框
            $('#addSyllabus').modal();
        },

        addSyllabus: function () {  // 添加学生信息
            var me = this;

            $.ajax({
                url: "/syllabus/add",
                method: "post",
                type: "json",
                data: {
                    type: me.syllabus.type,
                    teacherNum: me.syllabus.teacherNum,  // 教师编号
                    courseNum: me.syllabus.courseNum,  // 课程编号
                    gradeNum: me.syllabus.gradeNum,  // 班级编号
                    starttime: me.syllabus.starttime,  // 开始时间
                    endtime: me.syllabus.endtime  // 结束时间
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

            this.syllabus.id = this.syllabuses[index].id;
            this.syllabus.type = this.syllabuses[index].type;
            this.syllabus.teacherNum = this.syllabuses[index].teacher.number;
            this.syllabus.courseNum = this.syllabuses[index].course.number;
            this.syllabus.gradeNum = this.syllabuses[index].grade.number;
            this.syllabus.starttime = this.syllabuses[index].starttime;
            this.syllabus.endtime = this.syllabuses[index].endtime;

            // 定制展示编辑模态框
            $('#editSyllabus').modal();
        },
        editSyllabus: function () {  // 编辑信息
            var me = this;
            $.ajax({
                url: "/syllabus/edit",
                method: "post",
                type: "json",
                data: {
                    id: me.syllabus.id,
                    type: me.syllabus.type,
                    teacherNum: me.syllabus.teacherNum,  // 教师编号
                    courseNum: me.syllabus.courseNum,  // 课程编号
                    gradeNum: me.syllabus.gradeNum,  // 班级编号
                    starttime: me.syllabus.starttime,  // 开始时间
                    endtime: me.syllabus.endtime  // 结束时间
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
        deleteSyllabus: function (index) {  // 删除信息
            var url = "/syllabus/delete/" + this.syllabuses[index].id;

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

