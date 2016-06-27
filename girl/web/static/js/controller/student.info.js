/**
 * 学生信息
 * Created by huihui on 16-6-14.
 */

new Vue({
    el: '#studentInfo',
    data: {
        student: {
            id: null,
            number: null,
            name: null,
            sex: null,
            birth: null,
            tel: null,
            email: null,
            address: null,
            password: null,
            college: null,
            grade: {
                profession: {
                    college: {}
                }
            }
        }
    },
    created: function () {},
    beforeCompile: function () {},
    compiled: function () {
        var me = this;

        var param = window.parent.location.search;
        var number = param.substr(param.indexOf("=") + 1);
        var url = "/student/get/" + number;

        $.ajax({
            url: url,
            method: "get",
            type: "json",
            success: function (data) {
                if (data.status == "0") {
                    me.student.id = data.student.id;
                    me.student.number = data.student.number;
                    me.student.name = data.student.name;
                    me.student.sex = data.student.sex;
                    me.student.birth = data.student.birth;
                    me.student.tel = data.student.tel;
                    me.student.email = data.student.email;
                    me.student.address = data.student.address;
                    me.student.password = data.student.password;

                    // 太恶心
                    if ( data.student.grade != null) {
                        me.student.grade = data.student.grade;
                    }else {
                        me.student.grade.name = null;
                    }

                    if (data.student.grade.profession != null) {
                        me.student.grade.profession = data.student.grade.profession;
                    }else {
                        me.student.grade.profession.name = null;
                    }

                    if (data.student.grade.profession.college != null) {
                        me.student.grade.profession.college = data.student.grade.profession.college;
                    }else {
                        me.student.grade.profession.college.name = null;
                    }
                }else {
                    alert("获取学生息数据出错");
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
        editClick: function (index) {  // 点击信息中的编辑按钮

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
                    gradeNum: me.student.grade.number
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
