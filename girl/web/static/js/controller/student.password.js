/**
 * 学生 修改密码
 * Created by huihui on 16-6-14.
 */

new Vue({
    el: '#changePassword',
    data: {
        oldPassword: null,  // 原始代码
        newPassword: null,  // 新代码
        id: null  // 教师id
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
                    me.id = data.student.id;

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
        changePassword: function () {  // 添加学院信息
            var me = this;

            $.ajax({
                url: "/student/change/password",
                method: "post",
                type: "json",
                data: {
                    id: me.id,
                    oldPassword: me.oldPassword,
                    newPassword: me.newPassword
                },
                success: function (data) {
                    console.log(data);
                    if (data.status == "0") {
                        alert("修改成功");
                        location.reload();
                    }else {
                        alert(data.msg);
                    }
                },
                error: function () {
                    alert("修改失败");
                }
            });
        }
    }
});
