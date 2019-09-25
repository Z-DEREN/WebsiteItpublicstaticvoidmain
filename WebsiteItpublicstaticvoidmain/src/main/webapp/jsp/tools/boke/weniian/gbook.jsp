<%--
  Created by IntelliJ IDEA.
  User: ytwl
  Date: 2019/6/10
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="gbk">
    <title>留言_杨青个人博客 - 一个站在web前端设计之路的女技术员个人博客网站</title>
    <meta name="keywords" content="个人博客,杨青个人博客,个人博客模板,杨青" />
    <meta name="description" content="杨青个人博客，是一个站在web前端设计之路的女程序员个人网站，提供个人博客模板免费资源下载的个人原创网站。" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath }/statics/bokestyle/css/base.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/statics/bokestyle/css/index.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/statics/bokestyle/css/m.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath }/statics/bokestyle/js/jquery.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath }/statics/bokestyle/js/jquery.easyfader.min.js"></script>
    <script src="${pageContext.request.contextPath }/statics/bokestyle/js/scrollReveal.js"></script>
    <script src="${pageContext.request.contextPath }/statics/bokestyle/js/common.js"></script>

    <script src="${pageContext.request.contextPath }/statics/bokestyle/js/modernizr.js"></script>

</head>
<body>
<header>
    <!--menu begin-->
    <div class="menu">
        <nav class="nav" id="topnav">
            <h1 class="logo"><a href="http://www.yangqq.com">杨青博客</a></h1>
            <li><a href="index.html">网站首页</a> </li>
            <li><a href="about.html">关于我</a> </li>
            <li><a href="share.html">模板分享</a>
                <ul class="sub-nav">
                    <li><a href="share.html">个人博客模板</a></li>
                    <li><a href="share.html">国外Html5模板</a></li>
                    <li><a href="share.html">企业网站模板</a></li>
                </ul>
            </li>
            <li><a href="list.html">学无止境</a>
                <ul class="sub-nav">
                    <li><a href="list.html">心得笔记</a></li>
                    <li><a href="list.html">CSS3|Html5</a></li>
                    <li><a href="list.html">网站建设</a></li>
                    <li><a href="list.html">推荐工具</a></li>
                    <li><a href="list.html">JS实例索引</a></li>
                </ul>
            </li>
            <li><a href="life.html">慢生活</a>
                <ul class="sub-nav">
                    <li><a href="life.html">日记</a></li>
                    <li><a href="life.html">欣赏</a></li>
                    <li><a href="life.html">程序人生</a></li>
                    <li><a href="life.html">经典语录</a></li>
                </ul>
            </li>
            <li><a href="time.html">时间轴</a> </li>
            <li><a href="gbook.html">留言</a> </li>
            <li><a href="info.html">内容页</a> </li>
            <!--search begin-->
            <div id="search_bar" class="search_bar">
                <form  id="searchform" action="[!--news.url--]e/search/index.php" method="post" name="searchform">
                    <input class="input" placeholder="想搜点什么呢..." type="text" name="keyboard" id="keyboard">
                    <input type="hidden" name="show" value="title" />
                    <input type="hidden" name="tempid" value="1" />
                    <input type="hidden" name="tbname" value="news">
                    <input type="hidden" name="Submit" value="搜索" />
                    <span class="search_ico"></span>
                </form>
            </div>
            <!--search end-->
        </nav>
    </div>
    <!--menu end-->
    <!--mnav begin-->
    <div id="mnav">
        <h2><a href="http://www.yangqq.com" class="mlogo">杨青博客</a><span class="navicon"></span></h2>
        <dl class="list_dl">
            <dt class="list_dt"> <a href="index.html">网站首页</a> </dt>
            <dt class="list_dt"> <a href="about.html">关于我</a> </dt>
            <dt class="list_dt"> <a href="#">模板分享</a> </dt>
            <dd class="list_dd">
                <ul>
                    <li><a href="share.html">个人博客模板</a></li>
                    <li><a href="share.html">国外Html5模板</a></li>
                    <li><a href="share.html">企业网站模板</a></li>
                </ul>
            </dd>
            <dt class="list_dt"> <a href="#">学无止境</a> </dt>
            <dd class="list_dd">
                <ul>
                    <li><a href="list.html">心得笔记</a></li>
                    <li><a href="list.html">CSS3|Html5</a></li>
                    <li><a href="list.html">网站建设</a></li>
                    <li><a href="list.html">推荐工具</a></li>
                    <li><a href="list.html">JS实例索引</a></li>
                </ul>
            </dd>
            <dt class="list_dt"> <a href="#">慢生活</a> </dt>
            <dd class="list_dd">
                <ul>
                    <li><a href="life.html">日记</a></li>
                    <li><a href="life.html">欣赏</a></li>
                    <li><a href="life.html">程序人生</a></li>
                    <li><a href="life.html">经典语录</a></li>
                </ul>
            </dd>
            <dt class="list_dt"> <a href="time.html">时间轴</a> </dt>
            <dt class="list_dt"> <a href="gbook.html">留言</a> </dt>
        </dl>
    </div>
    <!--mnav end-->
</header>
<div class="pagebg ab"> </div>
<div class="container">
    <h1 class="t_nav"><span>你，我生命中一个重要的过客，我们之所以是过客，因为你未曾会为我停留。</span><a href="/" class="n1">网站首页</a><a href="/" class="n2">留言</a></h1>
    <div class="news_infos">
        <ul>
            此处安装评论插件
        </ul>
    </div>
    <div class="sidebar">
        <div class="about">
            <p class="avatar"> <img src="images/avatar.jpg" alt=""> </p>
            <p class="abname">dancesmile | 杨青</p>
            <p class="abposition">Web前端设计师、网页设计</p>
            <p class="abtext"> 一个80后草根女站长！09年入行。一直潜心研究web前端技术，一边工作一边积累经验，分享一些个人博客模板，以及SEO优化等心得。 </p>
        </div>
        <div class="weixin">
            <h2 class="hometitle">微信关注</h2>
            <ul>
                <img src="images/wx.jpg">
            </ul>
        </div>
    </div>
</div>
<footer>
    <p>Design by <a href="http://www.yangqq.com" target="_blank">杨青个人博客</a> <a href="/">蜀ICP备11002373号-1</a></p>
</footer>
<a href="#" class="cd-top">Top</a>
</body>
</html>
