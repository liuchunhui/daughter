/**
 * Created by huihui on 16-6-6.
 */

new Vue({
    el: "#loginEl",
    data: {
        username: null,
        password: null,
        usertype: "admin"
    },
    methods: {
        login: function () {
            $.ajax({
                url: "/login",
                type: "json",
                method: "post",
                data: {
                    username: this.username,
                    password: this.password,
                    usertype: this.usertype
                },
                success: function (data) {
                    if ("url" in data) {
                        window.location.href = data.url;
                    }else {
                        console.log(data);
                        alert(data.msg);
                    }
                },
                error: function (data) {

                }
            });
        }
    }
});