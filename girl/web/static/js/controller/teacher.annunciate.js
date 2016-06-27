/**
 * 教师 公告
 * Created by huihui on 16-6-14.
 */
new Vue({
    el: '#teacherAnnunciate',
    data: {
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
    methods: {}
});