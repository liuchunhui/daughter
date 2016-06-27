/**
 * 教师
 * Created by huihui on 16-6-12.
 */

new Vue({
    el: '#adminTeacher',
    data: {
        teacher: {
            number: null,  // 教师编号
            name: null,  // 教师名称
            sex: null,  // 教师性别
            birth: null,  // 教师出生日期
            tel: null,  // 教师电话
            email: null,  // 教师邮箱
            address: null,  // 教师家庭住址
            password: null,  // 教师登陆密码
            collegeNum: null  // 教师对应的学院编号
        },
        teachers: [],
        colleges: [],
        filterKey: null  // 过滤条件
    },
    created: function () {},
    beforeCompile: function () {},
    compiled: function () {
        var me = this;

        $.ajax({  // 获取学院信息
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
            url: "/teacher/get",
            method: "get",
            type: "json",
            success: function (data) {
                if (data.status == "0") {
                    me.teachers = data.teacher.map(function (e, i) {
                        if (e.college == null) {
                            e.college = {};
                            e.college.name = null;
                        }
                        e.createTime = common.timestampTdate(e.createTime);
                        e.updateTime = common.timestampTdate(e.updateTime);
                        return e;
                    });
                }else {
                    alert("获取教师息数据出错");
                }
            },
            error: function () {
                alert("获取教师信息数据出错");
            }
        });
    },
    ready: function () {},
    beforeDestroy: function () {},
    destroyed: function () {},
    methods: {
        addClick: function () {  // 点击添加按钮，初始化教师属性参数

            this.teacher.number = null;  // 教师编号
            this.teacher.name = null;  // 教师名称
            this.teacher.sex = null;  // 教师性别
            this.teacher.birth = null;  // 教师出生日期
            this.teacher.tel = null;  // 教师电话
            this.teacher.email = null;  // 教师邮箱
            this.teacher.address = null;  // 教师家庭住址
            this.teacher.password = null;  // 教师登陆密码
            this.teacher.collegeNum = null;  // 教师对应的学院编号

            // 定制展示添加模态框
            $('#addTeacher').modal();
        },

        addTeacher: function () {  // 添加信息
            var me = this;

            $.ajax({
                url: "/teacher/add",
                method: "post",
                type: "json",
                data: {
                    number: me.teacher.number,
                    name: me.teacher.name,
                    sex: me.teacher.sex,
                    birth: me.teacher.birth,
                    tel: me.teacher.tel,
                    email: me.teacher.email,
                    address: me.teacher.address,
                    collegeNum: me.teacher.collegeNum
                },
                success: function (data) {
                    if (data.status == "0") {
                        alert("创建教师信息成功");
                        location.reload();
                    }
                },
                error: function () {
                    alert("创建教师信息失败");
                }
            });
        },
        editClick: function (index) {  // 点击信息中的编辑按钮

            var me = this;
            me.teacher.id = me.teachers[index].id;
            me.teacher.number = me.teachers[index].number;
            me.teacher.name = me.teachers[index].name;
            me.teacher.sex = me.teachers[index].sex;
            me.teacher.birth = me.teachers[index].birth;
            me.teacher.tel = me.teachers[index].tel;
            me.teacher.email = me.teachers[index].email;
            me.teacher.address = me.teachers[index].address;

            if (me.teachers[index].college == null) {
                me.teacher.collegeNum = null;
            }else {
                me.teacher.collegeNum = me.teachers[index].college.number;
            }


            // 定制展示编辑模态框
            $('#editTeacher').modal();
        },
        editTeacher: function () {  // 编辑信息
            var me = this;
            $.ajax({
                url: "/teacher/edit",
                method: "post",
                type: "json",
                data: {
                    id: me.teacher.id,
                    number: me.teacher.number,
                    name: me.teacher.name,
                    sex: me.teacher.sex,
                    birth: me.teacher.birth,
                    tel: me.teacher.tel,
                    email: me.teacher.email,
                    address: me.teacher.address,
                    collegeNum: me.teacher.collegeNum
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
        deleteTeacher: function (index) {  // 删除信息
            var url = "/teacher/delete/" + this.teachers[index].id;

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
