/**
 * 教师课程表
 * Created by huihui on 16-6-14.
 */

new Vue({
    el: '#teacherSyllabus',
    data: {
        score: {
            gradeId: null,  // 班级编号
            studentNum: null,  // 学生编号
            syllabusId: null,  // 课程表编号
            score: null  // 成绩
        },
        student: null,  // 学生列表
        grade: null,  // 班级
        syllabus: null,  // 课程表
        filterKey: null  // 过滤条件
    },
    created: function () {},
    beforeCompile: function () {},
    compiled: function () {
        var me = this;
        var param = window.parent.location.search;
        var number = param.substr(param.indexOf("=") + 1);

        $.ajax({
            url: "/syllabus/get/teacher/" + number,
            method: "get",
            type: "json",
            success: function (data) {
                if (data.status == "0") {
                    me.syllabus = data.syllabus.map(function (e, i) {
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
        addClick: function (index) {
            var me = this;
            me.score.syllabusId = me.syllabus[index].id;
            me.score.gradeNum = me.syllabus[index].grade.number;

            $.ajax({
                url: "/student/get/grade/" + me.score.gradeNum,
                method: "get",
                type: "json",
                success: function (data) {
                    if (data.status == "0") {
                        me.student = data.student;
                        $("#addScore").modal();
                    }else {
                        alert("获取学生信息出错");
                        console.log("获取学生息数据出错");
                    }
                },
                error: function () {
                    alert("获取学生信息出错");
                }
            });
        },
        addScore: function () {

            var me = this;

            $.ajax({
                url: "/score/add",
                method: "post",
                type: "json",
                data: {
                    scorenum: me.score.score,
                    studentNum: me.score.studentNum,
                    syllabusId: me.score.syllabusId
                },
                success: function (data) {
                    if (data.status == "0") {
                        alert("添加成绩成功");
                    }else {
                        alert("添加成绩信息出错");
                    }
                },
                error: function () {
                    alert("添加成绩信息出错");
                }
            });
        }
    }
});
