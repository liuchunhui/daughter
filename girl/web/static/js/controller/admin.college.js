/**
 * Created by huihui on 16-6-7.
 */

new Vue({
    el: '#adminCollege',
    data: {
        college: {
            id: null,  // 学院id
            number: null,  // 学院编号
            name: null,  // 学院名称
            description: null  // 学院描述
        },
        //collegeColumns: [
        //    {data: "number"},
        //    {data: "name"},
        //    {data: "description"},
        //    {data: "deal"}],
        //collegeData: [],

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
                if (data.status == "0") {
                    me.colleges = data.college.map(function (e, i) {
                        e.createTime = common.timestampTdate(e.createTime);
                        e.updateTime = common.timestampTdate(e.updateTime);
                        return e;
                    });
                    //me.collegeData = data.college.map(function (e, index) {
                    //    return {
                    //        number: e.number,
                    //        name: e.name,
                    //        description: e.description,
                    //        deal: "<span class=\"glyphicon glyphicon-edit\" style=\"color: #337ab7;\" title=\"修改\" v-on:click=\"editCollege\" />&nbsp;" +
                    //            "<span class=\"glyphicon glyphicon-remove\" style=\"color: #D9534F;\" title=\"删除\" v-on:click=\"deleteCollege\" />"};
                    //});
                    // common.initTable("#college-table", me.collegeColumns, me.collegeData);
                }else {
                    alert("获取专业信息数据出错");
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
        addClick: function () {  // 初始化学院参数
            this.college = {
                id: null,  // 学院id
                number: null,  // 学院编号
                name: null,  // 学院名称
                description: null  // 学院描述
            };

            // 定制展示添加模态框
            $('#addCollege').modal();
        },
        addCollege: function () {  // 添加学院信息
            var me = this;

            $.ajax({
                url: "/college/add",
                method: "post",
                type: "json",
                data: {
                    number: me.college.number,
                    name: me.college.name,
                    description: me.college.description
                },
                success: function (data) {
                    console.log(data);
                    if (data.status == "0") {
                        alert("创建学院信息成功");
                        location.reload();
                    }else {
                        alert(data.msg);
                    }
                },
                error: function () {
                    alert("创建学院信息失败");
                }
            });
        },
        editClick: function (index) {  // 初始化所编辑学院信息

            var me = this;
            me.college.id = me.colleges[index].id;
            me.college.name = me.colleges[index].name;
            me.college.number = me.colleges[index].number;
            me.college.description = me.colleges[index].description;

            // 定制展示编辑模态框
            $('#editCollege').modal();
        },
        editCollege: function () {  // 编辑学院信息
            var me = this;
            $.ajax({
                url: "/college/edit",
                method: "post",
                type: "json",
                data: {
                    id: me.college.id,
                    number: me.college.number,
                    name: me.college.name,
                    description: me.college.description
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
        deleteCollege: function (index) {  // 删除学院信息
            console.log("删除学院信息");
            console.log(index);
            var url = "/college/delete/" + this.colleges[index].number;

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