<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>首页_杨青个人博客 - 一个站在web前端设计之路的女技术员个人博客网站</title>
<meta name="keywords" content="个人博客,杨青个人博客,个人博客模板,杨青" />
<meta name="description"
	content="杨青个人博客，是一个站在web前端设计之路的女程序员个人网站，提供个人博客模板免费资源下载的个人原创网站。" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/bokestyle/css/base.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/bokestyle/css/index.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/bokestyle/css/m.css">
<script
	src="${pageContext.request.contextPath }/statics/bokestyle/js/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath }/statics/bokestyle/js/jquery.easyfader.min.js"></script>
<script
	src="${pageContext.request.contextPath }/statics/bokestyle/js/scrollReveal.js"></script>
<script
	src="${pageContext.request.contextPath }/statics/bokestyle/js/common.js"></script>
</head>
<body>

	<header> <!--menu begin-->
	<div class="menu">
		<nav class="nav" id="topnav">
		<h1 class="logo">
			<a href="WebsiteItpublicstaticvoidmain">张德仁博客</a>
		</h1>
		<li><a href="index.html">网站首页</a></li>
		<li><a href="index.html">网站首页</a></li>
		<li><a href="about.html">关于我</a></li>
		<li><a href="share.html">模板分享</a>
			<ul class="sub-nav">
				<li><a href="share.html">个人博客模板</a></li>
				<li><a href="share.html">国外Html5模板</a></li>
				<li><a href="share.html">企业网站模板</a></li>
			</ul></li>
		<li><a href="list.html">学无止境</a>
			<ul class="sub-nav">
				<li><a href="list.html">心得笔记</a></li>
				<li><a href="list.html">CSS3|Html5</a></li>
				<li><a href="list.html">网站建设</a></li>
				<li><a href="list.html">推荐工具</a></li>
				<li><a href="list.html">JS实例索引</a></li>
			</ul></li>
		<li><a href="life.html">慢生活</a>
			<ul class="sub-nav">
				<li><a href="life.html">日记</a></li>
				<li><a href="life.html">欣赏</a></li>
				<li><a href="life.html">程序人生</a></li>
				<li><a href="life.html">经典语录</a></li>
			</ul></li>
		<li><a href="time.html">时间轴</a></li>
		<li><a href="${pageContext.request.contextPath }/MessageInterface/Message">留言00</a></li>
		<li><a href="info.html">内容页</a></li>
		<!--search begin-->
		<div id="search_bar" class="search_bar">
			<form id="searchform" action="[!--news.url--]e/search/index.php"
				method="post" name="searchform">
				<input class="input" placeholder="想搜点什么呢..." type="text"
					name="keyboard" id="keyboard"> <input type="hidden"
					name="show" value="title" /> <input type="hidden" name="tempid"
					value="1" /> <input type="hidden" name="tbname" value="news">
				<input type="hidden" name="Submit" value="搜索" /> <span
					class="search_ico"></span>
			</form>
		</div>
		<!--search end--> </nav>
	</div>
	<!--menu end--> <!--mnav begin-->
	<div id="mnav">
		<h2>
			<a href="http://www.yangqq.com" class="mlogo">杨青博客</a><span
				class="navicon"></span>
		</h2>
		<dl class="list_dl">
			<dt class="list_dt">
				<a href="index.html">网站首页</a>
			</dt>
			<dt class="list_dt">
				<a href="about.html">关于我</a>
			</dt>
			<dt class="list_dt">
				<a href="#">模板分享</a>
			</dt>
			<dd class="list_dd">
				<ul>
					<li><a href="share.html">个人博客模板</a></li>
					<li><a href="share.html">国外Html5模板</a></li>
					<li><a href="share.html">企业网站模板</a></li>
				</ul>
			</dd>
			<dt class="list_dt">
				<a href="#">学无止境</a>
			</dt>
			<dd class="list_dd">
				<ul>
					<li><a href="list.html">心得笔记</a></li>
					<li><a href="list.html">CSS3|Html5</a></li>
					<li><a href="list.html">网站建设</a></li>
					<li><a href="list.html">推荐工具</a></li>
					<li><a href="list.html">JS实例索引</a></li>
				</ul>
			</dd>
			<dt class="list_dt">
				<a href="#">慢生活</a>
			</dt>
			<dd class="list_dd">
				<ul>
					<li><a href="life.html">日记</a></li>
					<li><a href="life.html">欣赏</a></li>
					<li><a href="life.html">程序人生</a></li>
					<li><a href="life.html">经典语录</a></li>
				</ul>
			</dd>
			<dt class="list_dt">
				<a href="time.html">时间轴</a>
			</dt>
			<dt class="list_dt">
				<a href="${pageContext.request.contextPath }/MessageInterface/Message">留言</a>
			</dt>
		</dl>
	</div>
	<!--mnav end--> </header>
	<article> <!--banner begin-->
	<div class="picsbox">
		<div class="banner">
			<div id="banner" class="fader">






				<li class="slide"><a href="/" target="_blank"> <img
						src="${pageContext.request.contextPath }/statics/bokestyle/images/banner01.jpg">
						<span class="imginfo">主页轮流滚动图一</span>
				</a></li>


				<li class="slide"><a href="/" target="_blank"> <img
						src="${pageContext.request.contextPath }/statics/bokestyle/images/banner02.jpg">
						<span class="imginfo">主页轮流滚动图二</span>
				</a></li>

				<li class="slide"><a href="/" target="_blank"> <img
						src="${pageContext.request.contextPath }/statics/bokestyle/images/banner03.jpg">
						<span class="imginfo">主页轮流滚动图三</span>
				</a></li>

				<li class="slide"><a href="/" target="_blank"><img
						src="${pageContext.request.contextPath }/statics/bokestyle/images/banner02.jpg"><span
						class="imginfo">主页轮流滚动图四</span></a></li>


				<li class="slide"><a href="/" target="_blank"><img
						src="${pageContext.request.contextPath }/statics/bokestyle/images/banner03.jpg"><span
						class="imginfo">主页轮流滚动图五</span></a></li>







				<div class="fader_controls">
					<div class="page prev" data-target="prev">&lsaquo;</div>
					<div class="page next" data-target="next">&rsaquo;</div>
					<ul class="pager_list">
					</ul>
				</div>
			</div>
		</div>
		<!--banner end-->
		<div class="toppic">
			<li><a href="/" target="_blank"> <i><img
						src="${pageContext.request.contextPath }/statics/bokestyle/images/toppic01.jpg"></i>
					<h2>别让这些闹心的套路，毁了你的网页设计!</h2> <span>学无止境</span>
			</a></li>
			<li><a href="/" target="_blank"> <i><img
						src="${pageContext.request.contextPath }/statics/bokestyle/images/zd01.jpg"></i>
					<h2>个人博客，属于我的小世界！</h2> <span>学无止境</span>
			</a></li>
		</div>
	</div>
	<div class="blank"></div>
	<!--blogsbox begin-->
	<div class="blogsbox">


		<div class="blogs" data-scroll-reveal="enter bottom over 1s">
			<h3 class="blogtitle">
				<a href="/" target="_blank">无图片样式</a>
			</h3>
			<p class="blogtext">文本内容...</p>
			<div class="bloginfo">
				<ul>
					<li class="author"><a href="/">杨青</a></li>
					<li class="lmname"><a href="/">学无止境</a></li>
					<li class="timer">2018-5-13</li>
					<li class="view">4567已阅读</li>
					<li class="like">9999</li>
				</ul>
			</div>
		</div>


		<div class="blogs" data-scroll-reveal="enter bottom over 1s">
			<h3 class="blogtitle">
				<a href="/" target="_blank">一张图片样式标题内容--标题内容--标题内容</a>
			</h3>
			<span class="blogpic"><a href="/" title=""><img
					src="${pageContext.request.contextPath }/statics/bokestyle/images/toppic01.jpg"
					alt=""></a></span>
			<p class="blogtext">详细内容部分显示...</p>


			<div class="bloginfo">
				<ul>
					<li class="author"><a href="/">作者</a></li>
					<li class="lmname"><a href="/">学无止境</a></li>
					<li class="timer">2018-5-13</li>
					<li class="view"><span>34567</span>已阅读</li>
					<li class="like">9999</li>
				</ul>
			</div>
		</div>



		<div class="blogs" data-scroll-reveal="enter bottom over 1s">
			<h3 class="blogtitle">
				<a href="/" target="_blank">三张图片样式标题内容--标题内容--标题内容</a>
			</h3>
			<span class="bplist"><a href="/" title="">
					<li><img
						src="${pageContext.request.contextPath }/statics/bokestyle/images/avatar.jpg"
						alt=""></li>
					<li><img
						src="${pageContext.request.contextPath }/statics/bokestyle/images/toppic02.jpg"
						alt=""></li>
					<li><img
						src="${pageContext.request.contextPath }/statics/bokestyle/images/banner01.jpg"
						alt=""></li>
			</a></span>

			<p class="blogtext">详细内容部分显示...</p>


			<div class="bloginfo">
				<ul>
					<li class="author"><a href="/">作者</a></li>
					<li class="lmname"><a href="/">学无止境</a></li>
					<li class="timer">2018-5-13</li>
					<li class="view"><span>34567</span>已阅读</li>
					<li class="like">9999</li>
				</ul>
			</div>
		</div>



		<div class="blogs" data-scroll-reveal="enter bottom over 1s">
			<h3 class="blogtitle">
				<a href="/" target="_blank">单张大图片显示样式,标题</a>
			</h3>
			<span class="bigpic"><a href="/" title=""><img
					src="${pageContext.request.contextPath }/statics/bokestyle/images/toppic01.jpg"
					alt=""></a></span>
			<p class="blogtext">内容内容...</p>
			<div class="bloginfo">
				<ul>
					<li class="author"><a href="/">杨青</a></li>
					<li class="lmname"><a href="/">学无止境</a></li>
					<li class="timer">2018-5-13</li>
					<li class="view"><span>34567</span>已阅读</li>
					<li class="like">9999</li>
				</ul>
			</div>
		</div>


	</div>
	<!--blogsbox end-->
	<div class="sidebar">
		<!-- 		<div class="zhuanti"> -->
		<!-- 			<h2 class="hometitle">特别推荐</h2> -->
		<!-- 			<ul> -->
		<!-- 				<li><i><img -->
		<%-- 						src="${pageContext.request.contextPath }/statics/bokestyle/images/banner03.jpg"></i> --%>
		<!-- 					<p> -->
		<!-- 						帝国cms调用方法 <span><a href="/">阅读</a></span> -->
		<!-- 					</p></li> -->
		<!-- 				<li><i><img -->
		<%-- 						src="${pageContext.request.contextPath }/statics/bokestyle/images/b04.jpg"></i> --%>
		<!-- 					<p> -->
		<!-- 						5.20 我想对你说 <span><a href="/">阅读</a></span> -->
		<!-- 					</p></li> -->
		<!-- 				<li><i><img -->
		<%-- 						src="${pageContext.request.contextPath }/statics/bokestyle/images/b05.jpg"></i> --%>
		<!-- 					<p> -->
		<!-- 						个人博客，属于我的小世界！ <span><a href="/">阅读</a></span> -->
		<!-- 					</p></li> -->
		<!-- 			</ul> -->
		<!-- 		</div> -->
		<!-- 		<div class="tuijian"> -->
		<!-- 			<h2 class="hometitle">推荐文章</h2> -->
		<!-- 			<ul class="tjpic"> -->
		<!-- 				<i><img -->
		<%-- 					src="${pageContext.request.contextPath }/statics/bokestyle/images/toppic01.jpg"></i> --%>
		<!-- 				<p> -->
		<!-- 					<a href="/">别让这些闹心的套路，毁了你的网页设计</a> -->
		<!-- 				</p> -->
		<!-- 			</ul> -->
		<!-- 			<ul class="sidenews"> -->
		<!-- 				<li><i><img -->
		<%-- 						src="${pageContext.request.contextPath }/statics/bokestyle/images/toppic01.jpg"></i> --%>
		<!-- 					<p> -->
		<!-- 						<a href="/">别让这些闹心的套路，毁了你的网页设计</a> -->
		<!-- 					</p> <span>2018-05-13</span></li> -->
		<!-- 				<li><i><img -->
		<%-- 						src="${pageContext.request.contextPath }/statics/bokestyle/images/toppic02.jpg"></i> --%>
		<!-- 					<p> -->
		<!-- 						<a href="/">给我模板PSD源文件，我给你设计HTML！</a> -->
		<!-- 					</p> <span>2018-05-13</span></li> -->
		<!-- 				<li><i><img -->
		<%-- 						src="${pageContext.request.contextPath }/statics/bokestyle/images/v1.jpg"></i> --%>
		<!-- 					<p> -->
		<!-- 						<a href="/">别让这些闹心的套路，毁了你的网页设计</a> -->
		<!-- 					</p> <span>2018-05-13</span></li> -->
		<!-- 				<li><i><img -->
		<%-- 						src="${pageContext.request.contextPath }/statics/bokestyle/images/v2.jpg"></i> --%>
		<!-- 					<p> -->
		<!-- 						<a href="/">给我模板PSD源文件，我给你设计HTML！</a> -->
		<!-- 					</p> <span>2018-05-13</span></li> -->
		<!-- 			</ul> -->
		<!-- 		</div> -->
		<!-- 		<div class="tuijian"> -->
		<!-- 			<h2 class="hometitle">点击排行</h2> -->
		<!-- 			<ul class="tjpic"> -->
		<!-- 				<i><img -->
		<%-- 					src="${pageContext.request.contextPath }/statics/bokestyle/images/toppic01.jpg"></i> --%>
		<!-- 				<p> -->
		<!-- 					<a href="/">别让这些闹心的套路，毁了你的网页设计</a> -->
		<!-- 				</p> -->
		<!-- 			</ul> -->
		<!-- 			<ul class="sidenews"> -->
		<!-- 				<li><i><img -->
		<%-- 						src="${pageContext.request.contextPath }/statics/bokestyle/images/toppic01.jpg"></i> --%>
		<!-- 					<p> -->
		<!-- 						<a href="/">别让这些闹心的套路</a> -->
		<!-- 					</p> <span>2018-05-13</span></li> -->
		<!-- 				<li><i><img -->
		<%-- 						src="${pageContext.request.contextPath }/statics/bokestyle/images/toppic02.jpg"></i> --%>
		<!-- 					<p> -->
		<!-- 						<a href="/">给我模板PSD源文件，我给你设计HTML！</a> -->
		<!-- 					</p> <span>2018-05-13</span></li> -->
		<!-- 				<li><i><img -->
		<%-- 						src="${pageContext.request.contextPath }/statics/bokestyle/images/v1.jpg"></i> --%>
		<!-- 					<p> -->
		<!-- 						<a href="/">别让这些闹心的套路，毁了你的网页设计</a> -->
		<!-- 					</p> <span>2018-05-13</span></li> -->
		<!-- 				<li><i><img -->
		<%-- 						src="${pageContext.request.contextPath }/statics/bokestyle/images/v2.jpg"></i> --%>
		<!-- 					<p> -->
		<!-- 						<a href="/">给我模板PSD源文件，我给你设计HTML！</a> -->
		<!-- 					</p> <span>2018-05-13</span></li> -->
		<!-- 			</ul> -->
		<!-- 		</div> -->
		<!-- 		<div class="cloud"> -->
		<!-- 			<h2 class="hometitle">标签云</h2> -->
		<!-- 			<ul> -->
		<!-- 				<a href="/">陌上花开</a> -->
		<!-- 				<a href="/">校园生活</a> -->
		<!-- 				<a href="/">html5</a> -->
		<!-- 				<a href="/">SumSung</a> -->
		<!-- 				<a href="/">青春</a> -->
		<!-- 				<a href="/">温暖</a> -->
		<!-- 				<a href="/">阳光</a> -->
		<!-- 				<a href="/">三星</a> -->
		<!-- 				<a href="/">索尼</a> -->
		<!-- 				<a href="/">华维荣耀</a> -->
		<!-- 				<a href="/">三星</a> -->
		<!-- 				<a href="/">索尼</a> -->
		<!-- 			</ul> -->
		<!-- 		</div> -->
		<!-- 		<div class="links"> -->
		<!-- 			<h2 class="hometitle">友情链接</h2> -->
		<!-- 			<ul> -->
		<!-- 				<li><a href="http://www.yangqq.com" target="_blank">杨青博客</a></li> -->
		<!-- 				<li><a href="http://www.yangqq.com" target="_blank">D设计师博客</a></li> -->
		<!-- 				<li><a href="http://www.yangqq.com" target="_blank">优秀个人博客</a></li> -->
		<!-- 			</ul> -->
		<!-- 		</div> -->
		<!-- 		<div class="guanzhu" id="follow-us"> -->
		<!-- 			<h2 class="hometitle">关注我们 么么哒！</h2> -->
		<!-- 			<ul> -->
		<!-- 				<li class="sina"><a href="/" target="_blank"><span>新浪微博</span>杨青博客</a></li> -->
		<!-- 				<li class="tencent"><a href="/" target="_blank"><span>腾讯微博</span>杨青博客</a></li> -->
		<!-- 				<li class="qq"><a href="/" target="_blank"><span>QQ号</span>476847113</a></li> -->
		<!-- 				<li class="email"><a href="/" target="_blank"><span>邮箱帐号</span>dancesmiling@qq.com</a></li> -->
		<!-- 				<li class="wxgzh"><a href="/" target="_blank"><span>微信号</span>yangqq_1987</a></li> -->
		<!-- 				<li class="wx"><img -->
		<%-- 					src="${pageContext.request.contextPath }/statics/bokestyle/images/wx.jpg"></li> --%>
		<!-- 			</ul> -->
		<!-- 		</div> -->
	</div>
	</article>
	<footer>
	<p>
		<!-- 		Design by <a href="http://www.yangqq.com" target="_blank">杨青个人博客</a> <a -->
		<!-- 			href="/">蜀ICP备11002373号-1</a> -->
	</p>
	</footer>
	<a href="#" class="cd-top">Top</a>
</body>
</body>
</html>