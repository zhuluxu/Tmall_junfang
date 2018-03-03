//登陆态(阻止反复提交表单)
var login = true;
//用户名
var username;

$(function () {
    //初始化
    initialCookie();
    initialData();

    /******
     * event
     ******/
    //点击面板main时
    $("#div_main").click(function () {
        var div = $("#div_peelPanel");
        if (div.css("display") === "block") {
            div.slideUp();
        }
    });
    //点击顶部换肤img时
    $("#div_peelPanel").find(">li>img").click(function () {
        var background = $("#div_background");
        var url = $(this).parent("li").attr("value");
        if(url !== null && url !== ""){
            if(url !== background.css("background-image")){
                background.css("background-image", url);
                cookieUtil.setCookie("backgroundImageUrl", url,365);
            }
        }
    });
    //点击顶部换肤标签时
    $("#txt_peel").click(function () {
        var div = $("#div_peelPanel");
        if(div.css("display")==="block"){
            div.slideUp();
        } else {
            div.slideDown();
        }
    });
    //点击表单登录按钮时
    $("#btn_login").click(function () {
        if(!login){
            errorShow($("#txt_error_msg"), "用户名或密码错误");
            return;
        }
        //表单验证
        var username = $.trim($("#input_username").val());
        var password = $.trim($("#input_password").val());
        if(username === "" || password === "") {
            errorShow($("#txt_error_msg"),"请输入用户名和密码");
            return;
        }
        $.ajax({
            url: "login/"+username,
            type:"post",
            data: {"password":password},
            dataType:"json",
            success:function (data) {
                if (data.success) {
                    cookieUtil.setCookie("username", username, 30);
                    location.href = "/tmall/admin";
                } else {
                    login = false;
                    errorShow($("#txt_error_msg"), "用户名或密码错误");
                }
            },
            beforeSend:function () {

            },
            error:function (data) {

            }
        });
    });
    //获得文本框焦点时
    $("#input_username,#input_password").focus(function () {
        //移除校验错误
        var msg = $("#txt_error_msg");
        if(msg.css("opacity")!=="0"){
            msg.animate({
                left: "20px",
                opacity: 0
            }, 200);
        }
    });
    //失去文本框焦点时
    $("#input_username,#input_password").blur(function () {
        //允许登录
        login = true;
    });
    //失去用户名文本框焦点时
    $("#input_username").blur(function () {
        getUserProfilePicture($(this).val());
    });
});

//初始化Cookie数据
function initialCookie() {
    var url;
    var username;
    var password;
    if(document.cookie.length>0) {
        username = cookieUtil.getCookie("username");
        url = cookieUtil.getCookie("backgroundImageUrl");
        if(url !== null) {
            $("#div_background").css("background-image", url);
        }
        if(username !== null){
            $("#input_username").val(username);
            getUserProfilePicture(username);
        }
    }
}
//初始化页面数据
function initialData() {
    //顶部时间
    $("#txt_date").text(new Date().toLocaleString());
    setInterval(function () {
        $("#txt_date").text(new Date().toLocaleString());
    }, 1000);
    //表单焦点
    var username = $.trim($("#input_username").val());
    if(username !== null && username !== ""){
        $("#input_password").focus();
        return;
    }
    $("#input_username").focus();
}
//显示校验错误信息
function errorShow(obj,text) {
    obj.text(text);
    if(obj.css("opacity") !== "1"){
        obj.animate({
            left: "0",
            opacity: 1
        }, 200);
    } else {
        obj.css("opacity","0.5");
        obj.animate({
            opacity: 1
        }, 100);
    }
}
//获取用户头像
function getUserProfilePicture(username) {
    if(username === this.username){
        return;
    }
    if(username !== null && username !== ""){
        this.username = username;
        $.getJSON('login/'+username,null,function (data) {
            if(data.success){
                if(data.srcString !== null){
                    $("#img_profile_picture").attr("src",data.srcString);
                    return true;
                }
            }
        });
    }
    $("#img_profile_picture").attr("src","../res/images/admin/loginPage/default_profile_picture-128x128.png");
}