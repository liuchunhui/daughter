/**
 * 修改密码
 * Created by huihui on 16-6-13.
 */

new Vue({
    el: '#changePassword',
    data: {
        oldPassword: null,  // 原始代码
        newPassword: null  // 新代码
    },
    created: function () {},
    beforeCompile: function () {},
    compiled: function () {},
    ready: function () {},
    beforeDestroy: function () {},
    destroyed: function () {},
    methods: {
        changePassword: function () {  // 添加学院信息
            var me = this;

            $.ajax({
                url: "/admin/edit",
                method: "post",
                type: "json",
                data: {
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