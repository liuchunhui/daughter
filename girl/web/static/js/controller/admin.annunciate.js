/**
 * 公告
 * Created by huihui on 16-6-10.
 */

new Vue({
    el: '#adminAnnunciate',
    data: {
        annunciate: {
            id: null,  // 公告id
            title: null,  // 公告标题
            content: null,  // 公告内容
            creator: null  // 创建者
        },

        annunciates: [],
        filterKey: null  // 过滤条件
    },
    created: function () {},
    beforeCompile: function () {},
    compiled: function () {
        var me = this;
        $.ajax({
            url: "/annunciate/get",
            method: "get",
            type: "json",
            success: function (data) {
                console.log(data);
                if (data.status == "0") {
                    me.annunciates = data.annunciate.map(function(e, i) {
                        e.createTime = common.timestampTdate(e.createTime);
                        e.updateTime = common.timestampTdate(e.updateTime);
                        return e;
                    });
                }else {
                    alert("获取公告息数据出错");
                }
            },
            error: function () {
                alert("获取公告信息数据出错");
            }
        });
    },
    ready: function () {},
    beforeDestroy: function () {},
    destroyed: function () {},
    methods: {
        addClick: function () {
            this.annunciate = {
                id: null,  // 公告id
                title: null,  // 公告标题
                content: null,  // 公告内容
                creator: null  // 创建者
            };

            // 定制展示添加模态框
            $('#addAnnunciate').modal();
        },
        addAnnunciate: function () {  // 添加学院信息
            var me = this;

            $.ajax({
                url: "/annunciate/add",
                method: "post",
                type: "json",
                data: {
                    title: me.annunciate.title,
                    creator: me.annunciate.creator,
                    content: me.annunciate.content
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
            me.annunciate.id = me.annunciates[index].id;
            me.annunciate.title = me.annunciates[index].title;
            me.annunciate.creator = me.annunciates[index].creator;
            me.annunciate.content = me.annunciates[index].content;

            // 定制展示编辑模态框
            $('#editAnnunciate').modal();
        },
        editAnnunciate: function () {  // 编辑学院信息
            var me = this;
            $.ajax({
                url: "/annunciate/edit",
                method: "post",
                type: "json",
                data: {
                    id: me.annunciate.id,
                    title: me.annunciate.title,
                    creator: me.annunciate.creator,
                    content: me.annunciate.content
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
        deleteAnnunciate: function (index) {  // 删除学院信息
            var url = "/annunciate/delete/" + this.annunciates[index].id;

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