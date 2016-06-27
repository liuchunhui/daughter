/**
 * 学生课程表
 * Created by huihui on 16-6-14.
 */

new Vue({
    el: '#studentSyllabus',
    data: {
        syllabus: null,
        filterKey: null  // 过滤条件
    },
    created: function () {},
    beforeCompile: function () {},
    compiled: function () {
        var me = this;
        var param = window.parent.location.search;
        var number = param.substr(param.indexOf("=") + 1);

        $.ajax({
            url: "/syllabus/get/student/" + number,
            method: "get",
            type: "json",
            success: function (data) {
                if (data.status == "0") {
                    me.syllabus = data.syllabus.map(function (e, i) {
                        e.createTime = common.timestampTdate(e.createTime);
                        e.updateTime = common.timestampTdate(e.updateTime);
                        return e;
                    });
                }else {
                    alert("获取课程表信息数据出错");
                }
            },
            error: function () {
                alert("获取课程表信息数据出错");
            }
        });
    },
    ready: function () {},
    beforeDestroy: function () {},
    destroyed: function () {},
    methods: {}
});
