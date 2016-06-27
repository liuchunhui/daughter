/**
 * 专业信息管理
 * Created by huihui on 16-6-11.
 */

new Vue({
    el: '#adminProfession',
    data: {
        profession: {
            id: null,  // 专业id
            number: null,  // 专业编号
            name: null,  // 专业名称
            description: null,  // 专业描述
            collegeNum: null  // 专业对应的学院编号
        },
        professions: [],
        colleges: [],
        filterKey: null  // 过滤条件
    },
    created: function () {},
    beforeCompile: function () {},
    compiled: function () {
        var me = this;

        $.ajax({
            url: "/college/get",
            method: "get",
            type: "json",
            success: function (data) {
                console.log(data);
                if (data.status == "0") {
                    me.colleges = data.college;
                }else {
                    console.log(data);
                }
            },
            error: function (data) {
                console.log("获取学院信息数据出错");
            }
        });

        $.ajax({
            url: "/profession/get",
            method: "get",
            type: "json",
            success: function (data) {
                if (data.status == "0") {
                    me.professions = data.profession.map(function (e, i) {

                        if (e.college == null) {
                            e.college = {};
                            e.college.name = '';
                        }

                        e.createTime = common.timestampTdate(e.createTime);
                        e.updateTime = common.timestampTdate(e.updateTime);
                        return {
                            number: e.number,
                            name: e.name,
                            collegeName: e.college.name,
                            description: e.description,
                            createTime: e.createTime,
                            updateTime: e.updateTime
                        };
                    });
                }else {
                    alert("获取专业息数据出错");
                }
            },
            error: function () {
                alert("获取专业信息数据出错");
            }
        });
    },
    ready: function () {},
    beforeDestroy: function () {},
    destroyed: function () {},
    methods: {
        addClick: function () {  // 初始化专业信息参数
            this.profession = {
                id: null,  // 专业id
                number: null,  // 专业编号
                name: null,  // 专业名称
                description: null,  // 专业描述
                collegeNum: null  // 专业对应的学院编号
            };

            // 定制展示添加模态框
            $('#addProfession').modal();
        },
        addProfession: function () {  // 添加专业信息
            var me = this;

            console.log(me.profession);
            $.ajax({
                url: "/profession/add",
                method: "post",
                type: "json",
                data: {
                    number: me.profession.number,
                    name: me.profession.name,
                    description: me.profession.description,
                    collegeNum: me.profession.collegeNum
                },
                success: function (data) {
                    if (data.status == "0") {
                        alert("创建专业信息成功");
                        location.reload();
                    }
                },
                error: function () {
                    alert("创建专业信息失败");
                }
            });
        },
        editClick: function (index) {  // 点击班级信息中的编辑按钮

            var me = this;
            me.profession.id = me.professions[index].id;
            me.profession.number = me.professions[index].number;
            me.profession.name = me.professions[index].name;
            me.profession.description = me.professions[index].description;
            if (null == me.professions[index].college) {  // 判断所属的学院是否被删除
                me.profession.collegeNum = null;
            }else {
                me.profession.collegeNum = me.professions[index].college.number;
            }

            // 定制展示编辑模态框
            $('#editProfession').modal();
        },
        editProfession: function () {  // 编辑学院信息
            var me = this;
            $.ajax({
                url: "/profession/edit",
                method: "post",
                type: "json",
                data: {
                    id: me.profession.id,
                    number: me.profession.number,
                    name: me.profession.name,
                    description: me.profession.description,
                    collegeNum: me.profession.collegeNum
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
        deleteProfession: function (index) {  // 删除专业信息
            var url = "/profession/delete/" + this.professions[index].id;

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