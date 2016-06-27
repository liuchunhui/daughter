/**
 * 课程
 * Created by huihui on 16-6-11.
 */

new Vue({
    el: '#adminCourse',
    data: {
        course: {
            id: null,  // 课程id
            number: null,  // 课程编号
            name: null,  // 课程名称
            period: null  // 课程学时
        },
        courses: [],
        filterKey: null  // 过滤条件
    },
    created: function () {},
    beforeCompile: function () {},
    compiled: function () {
        var me = this;
        $.ajax({
            url: "/course/get",
            method: "get",
            type: "json",
            success: function (data) {
                console.log(data);
                if (data.status == "0") {
                    me.courses = data.course.map(function (e, i) {
                        e.createTime = common.timestampTdate(e.createTime);
                        e.updateTime = common.timestampTdate(e.updateTime);

                        return e;
                    });
                }else {
                    alert("获取课程息数据出错");
                }
            },
            error: function () {
                alert("获取课程信息数据出错");
            }
        });
    },
    ready: function () {},
    beforeDestroy: function () {},
    destroyed: function () {},
    methods: {
        addClick: function () {
            this.course = {
                id: null,  // 课程id
                number: null,  // 课程编号
                name: null,  // 课程名称
                period: null  // 课程学时
            };

            // 定制展示添加模态框
            $('#addCourse').modal();
        },

        addCourse: function () {  // 添加学院信息
            var me = this;

            $.ajax({
                url: "/course/add",
                method: "post",
                type: "json",
                data: {
                    number: me.course.number,
                    name: me.course.name,
                    period: me.course.period
                },
                success: function (data) {
                    if (data.status == "0") {
                        alert("创建公告信息成功");
                        location.reload();
                    }
                },
                error: function () {
                    alert("创建公告信息失败");
                }
            });
        },
        editClick: function (index) {

            var me = this;
            me.course.id = me.courses[index].id;
            me.course.number = me.courses[index].number;
            me.course.name = me.courses[index].name;
            me.course.period = me.courses[index].period;

            // 定制展示编辑模态框
            $('#editCourse').modal();
        },
        editCourse: function () {  // 编辑学院信息
            var me = this;
            $.ajax({
                url: "/course/edit",
                method: "post",
                type: "json",
                data: {
                    id: me.course.id,
                    number: me.course.number,
                    name: me.course.name,
                    period: me.course.period
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
        deleteCourse: function (index) {  // 删除学院信息
            var url = "/course/delete/" + this.courses[index].id;

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