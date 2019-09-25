//处理URL地址
function objToString(obj) {
    /**
     * {
            "username":zhangsan,
            "age":30,
        }
     变成
     ?username=zhangsan&age=30;
     */
   var arr=[];
   obj.time=new Date().getTime();
   for(var key in obj){
       arr.push(key+"="+obj[key]);
   }
    var result=arr.join("&");
    return result;
}
//
function Ajax(options) {
    //如果没有obj对象，则不执行
    if(options.obj){
        var str=objToString(options.obj);
    }
//创建异步对象
    var xhr;
    if(window.XMLHttpRequest){
        //IE7+、firefor、谷歌、苹果
        xhr=new XMLHttpRequest();
    }else{
        //IE6、IE5
        xhr=new ActiveXObject("Microsoft.XMLHTTP");
    }
//打开链接
    if(options.type.toLowerCase()=="get"){
        xhr.open(type,options+"?"+str,"true");
//发送数据
        xhr.send();
    }
    if(options.type.toLowerCase()=="post"){
        xhr.open(options.type,options.url+"?"+str,"true");
        //请求头
        xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
        //发送数据
        xhr.send(str);
    }

//    监听服务器状态
    xhr.onreadystatechange=function () {
        if(xhr.readyState==4){
            if((xhr.status>=200&&xhr.status<300)||xhr.status==304){
                options.succes(xhr);
                clearInterval(timer);
            }else{
                options.error(xhr);
                xhr.status;
            }
        }
    }
    //请求不成功
    if(options.timeout){
        var timer=setInterval(function () {
            // document.getElementById("info").innerHTML="请求超时，稍后再试。错误信息："+xhr.status;
             alert("请求超时，稍后再试。");
            xhr.abort();
            clearInterval(timer);
        },options.timeout)
    }
}
