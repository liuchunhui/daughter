/**
 * 班级信息管理
 * Created by huihui on 16-6-11.
 */

new Vue({
    el: '#adminGrade',
    data: {
        grade: {
            id: null,  // 班级id
            number: null,  // 班级编号
            name: null,  // 班级名称
            professionNum: null  // 班级对应的专业编号
        },
        professions: [],  // 专业信息列表
        grades: [],  // 班级信息列表
        filterKey: null  // 过滤条件
    },
    created: function () {},
    beforeCompile: function () {},
    compiled: function () {
        var me = this;

        $.ajax({
            url: "/profession/get",
            method: "get",
            type: "json",
            success: function (data) {
                if (data.status == "0") {
                    me.professions = data.profession;
                }else {
                    console.log(data);
                }
            },
            error: function (data) {
                console.log("获取专业信息数据出错");
            }
        });

        $.ajax({
            url: "/grade/get",
            method: "get",
            type: "json",
            success: function (data) {
                if (data.status == "0") {
                    me.grades = data.grade.map(function (e, i) {

                        if (e.profession == null) {  // 班级对应的专业的信息为空
                            e.profession = {};
                            e.profession.name = null;
                            e.profession.college = {};
                            e.profession.college.name = null;
                        }

                        e.createTime = common.timestampTdate(e.createTime);
                        e.updateTime = common.timestampTdate(e.updateTime);
                        return e;
                    });
                }else {
                    alert("获取班级息数据出错");
                }
            },
            error: function () {
                alert("获取班级信息数据出错");
            }
        });
    },
    ready: function () {},
    beforeDestroy: function () {},
    destroyed: function () {},
    methods: {
        addClick: function () {  // 初始化班级信息参数
            this.grade = {
                id: null,  // 班级id
                number: null,  // 班级编号
                name: null,  // 班级名称
                professionNum: null  // 班级对应的专业编号
            };

            // 定制展示添加模态框
            $('#addGrade').modal();
        },
        addGrade: function () {  // 添加班级信息
            var me = this;

            $.ajax({
                url: "/grade/add",
                method: "post",
                type: "json",
                data: {
                    number: me.grade.number,
                    name: me.grade.name,
                    professionNum: me.grade.professionNum
                },
                success: function (data) {
                    if (data.status == "0") {
                        alert("创建班级信息成功");
                        location.reload();
                    }
                },
                error: function () {
                    alert("创建班级信息失败");
                }
            });
        },
        editClick: function (index) {  // 初始化所编辑班级信息

            var me = this;
            me.grade.id = me.grades[index].id;
            me.grade.number = me.grades[index].number;
            me.grade.name = me.grades[index].name;
            if (me.grades[index].profession == null) {
                me.grade.professionNum = null;
            }else {
                me.grade.professionNum = me.grades[index].profession.number;
            }


            // 定制展示编辑模态框
            $('#editGrade').modal();
        },
        editGrade: function () {  // 编辑学院信息
            var me = this;
            $.ajax({
                url: "/grade/edit",
                method: "post",
                type: "json",
                data: {
                    id: me.grade.id,
                    number: me.grade.number,
                    name: me.grade.name,
                    professionNum: me.grade.professionNum
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
        deleteGrade: function (index) {  // 删除专业信息
            var url = "/grade/delete/" + this.grades[index].id;

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