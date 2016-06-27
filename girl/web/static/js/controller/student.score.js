/**
 * 学生 成绩
 * Created by huihui on 16-6-14.
 */

new Vue({
    el: '#studentScore',
    data: {
        scores: {},
        filterKey: null  // 过滤条件
    },
    created: function () {},
    beforeCompile: function () {},
    compiled: function () {
        var me = this;
        var param = window.parent.location.search;
        var number = param.substr(param.indexOf("=") + 1);

        $.ajax({
            url: "/score/get/student/" + number,
            method: "get",
            type: "json",
            success: function (data) {
                if (data.status == "0") {
                    me.scores = data.score.map(function (e, i) {
                        e.createTime = common.timestampTdate(e.createTime);
                        e.updateTime = common.timestampTdate(e.updateTime);
                        return e;
                    });

                }else {
                    alert("获取成绩信息出错");
                }
            },
            error: function () {
                alert("获取成绩数据出错");
            }
        });
    },
    ready: function () {},
    beforeDestroy: function () {},
    destroyed: function () {},
    methods: {}
});

