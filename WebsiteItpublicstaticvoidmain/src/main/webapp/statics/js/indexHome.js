$(function () {
    //注意：导航 依赖 element 模块，否则无法进行功能性操作
    layui.use('element', function(){
        var element = layui.element;
    });
    $("#nav-default").click(function () {
        $("#nav-show").attr("class","layui-nav")
    })
    $("#nav-navyBlue").click(function () {
        $("#nav-show").attr("class","layui-nav layui-bg-cyan")

    })
    $("#nav-brilliantblue").click(function () {
        $("#nav-show").attr("class","layui-nav layui-bg-blue")

    })
    $("#nav-blackishgreen").click(function () {
        $("#nav-show").attr("class","layui-nav layui-bg-green")
    })
})