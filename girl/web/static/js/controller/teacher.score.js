/**
 * 教师 成绩管理
 * Created by huihui on 16-6-14.
 */

new Vue({
    el: '#teacherScore',
    data: {
        score: {
            id: null,  // 成绩记录id
            score: null,  // 分数
            studentNum: null,  // 学生编号
            studentName: null,  // 学生姓名
            syllabusId: null,  // 课程表id
            syllabusName: null  // 课程表名称
        },
        scores: {},
        filterKey: null  // 过滤条件
    },
    created: function () {},
    beforeCompile: function () {},
    compiled: function () {
        var me = this;
        var param = window.parent.location.search;
        var number = param.substr(param.indexOf("=") + 1);

        $.ajax({
            url: "/score/get/teacher/" + number,
            method: "get",
            type: "json",
            success: function (data) {
                if (data.status == "0") {
                    me.scores = data.score.map(function (e, i) {
                        e.createTime = common.timestampTdate(e.createTime);
                        e.updateTime = common.timestampTdate(e.updateTime);
                        return e;
                    });

                }else {
                    alert("获取成绩信息出错");
                }
            },
            error: function () {
                alert("获取成绩数据出错");
            }
        });
    },
    ready: function () {},
    beforeDestroy: function () {},
    destroyed: function () {},
    methods: {
        editClick: function (index) {

            var me = this;
            me.score.id = me.scores[index].id;
            me.score.studentNum = me.scores[index].student.number;
            me.score.studentName = me.scores[index].student.name;
            me.score.syllabusId = me.scores[index].syllabus.id;
            me.score.syllabusName = me.scores[index].syllabus.course.name;
            me.score.score = me.scores[index].score;

            // 定制展示编辑模态框
            $('#editScore').modal();
        },
        editScore: function () {  // 编辑学院信息
            var me = this;
            $.ajax({
                url: "/score/edit",
                method: "post",
                type: "json",
                data: {
                    id: me.score.id,
                    scorenum: me.score.score,
                    studentNum: me.score.studentNum,
                    syllabusId: me.score.syllabusId
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
        deleteScore: function (index) {  // 删除学院信息
            var url = "/score/delete/" + this.scores[index].id;

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