/**
 * 教师信息
 * Created by huihui on 16-6-13.
 */

new Vue({
    el: '#teacherInfo',
    data: {
        teacher: {
            id: null,
            number: null,
            name: null,
            sex: null,
            birth: null,
            tel: null,
            email: null,
            address: null,
            password: null,
            college: {}
        }
    },
    created: function () {},
    beforeCompile: function () {},
    compiled: function () {
        var me = this;

        var param = window.parent.location.search;
        var number = param.substr(param.indexOf("=") + 1);
        var url = "/teacher/get/" + number;

        $.ajax({
            url: url,
            method: "get",
            type: "json",
            success: function (data) {
                if (data.status == "0") {
                    me.teacher.id = data.teacher.id;
                    me.teacher.number = data.teacher.number;
                    me.teacher.name = data.teacher.name;
                    me.teacher.sex = data.teacher.sex;
                    me.teacher.birth = data.teacher.birth;
                    me.teacher.tel = data.teacher.tel;
                    me.teacher.email = data.teacher.email;
                    me.teacher.address = data.teacher.address;
                    me.teacher.password = data.teacher.password;
                    if ( data.teacher.college != null) {
                        me.teacher.college = data.teacher.college;
                    }else {
                        me.teacher.college.name = '';
                    }

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
        editClick: function (index) {  // 点击信息中的编辑按钮

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
                    collegeNum: me.teacher.college.number
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
        }
    }
});
