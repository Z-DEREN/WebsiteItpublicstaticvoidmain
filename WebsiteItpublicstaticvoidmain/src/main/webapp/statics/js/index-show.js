$(function () {

    $(".cat").find(".cat_detail").hide();
    $(".cat").hover(function(){
        $(this).find(".cat_detail").stop().show(500);
        $(this).find("h3").addClass("on");

    },function(){
        $(this).find(".cat_detail").hide();
        $(this).find("h3").removeClass("on");
    });


})