$('.favorite-icon').click(function() {
    // 在<tr>的id里面截取出log_module_id
    var type_and_id = $(this).attr('id');
    var type = type_and_id.split('_')[0];
    var log_module_id = type_and_id.split('_')[1];
    var icon = $(this)
    if (!icon.hasClass('glyphicon-heart')) {
        $.get('/add_favorite?type=' + type + '&id=' + log_module_id, function (data) {
            if (data.indexOf('成功') != -1) {
                icon.removeClass('glyphicon-heart-empty').addClass('glyphicon-heart');
            } else {
                alert(data);
            }
        });
    } else {
        $.get('/delete_favorite?type=' + type + '&id=' + log_module_id, function (data) {
            if (data.indexOf('成功') != -1) {
                icon.removeClass('glyphicon-heart').addClass('glyphicon-heart-empty');
            } else {
                alert(data);
            }
        });
    }
})
