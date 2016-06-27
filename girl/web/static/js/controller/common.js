/**
 * Created by huihui on 16-6-7.
 */

var common = {

    /**
     * 初始化datatable组件
     * @param id 元素id
     * @param cloumns 列名称
     * @param data 展示数据
     */
    initTable: function (id, cloumns, data) {
        $(document).ready( function () {
            $(id).DataTable({
                data: data,
                columns: cloumns,
                language: {
                    "sProcessing": "处理中...",
                    "sLengthMenu": "显示 _MENU_ 项结果",
                    "sZeroRecords": "没有匹配结果",
                    "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                    "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                    "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                    "sInfoPostFix": "",
                    "sSearch": "搜索:",
                    "sUrl": "",
                    "sEmptyTable": "表中数据为空",
                    "sLoadingRecords": "载入中...",
                    "sInfoThousands": ",",
                    "oPaginate": {
                        "sFirst": "首页",
                        "sPrevious": "上页",
                        "sNext": "下页",
                        "sLast": "末页"
                    },
                    "oAria": {
                        "sSortAscending": ": 以升序排列此列",
                        "sSortDescending": ": 以降序排列此列"
                    }
                },
                scrollX: '100%',
                scrollXInner: '100%'
            });
        });
    },

    timestampTdate: function (timestamp) {
        if (timestamp == null) {
            return null;
        }else {
            var d = new Date(timestamp);
            return d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d.getDate() + " "
                + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
        }
    }
};