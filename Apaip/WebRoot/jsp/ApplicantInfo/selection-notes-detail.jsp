<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <<meta charset="UTF-8">
  <title>精准扶贫信息化平台</title>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="format-detection" content="telephone=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp"/>
  <link rel="alternate icon" type="<%=basePath%>/image/png" href="<%=basePath%>/i/favicon.png">
  <link rel="stylesheet" href="<%=basePath%>/css/amazeui.min.css"/>
  <link rel="stylesheet" href="<%=basePath%>/css/hss/blog.css"/>

  </head>
  
  <body>
   <header class="am-topbar">
  <h1 class="am-topbar-brand">
    <a href="#">首页</a>
  </h1>
    <form class="am-topbar-form am-topbar-left am-form-inline am-topbar-right" role="search">
      <div class="am-form-group">
        <input type="text" class="am-form-field am-input-sm" placeholder="关键字搜索">
      </div>
      <button type="submit" class="am-btn am-btn-default am-btn-sm">搜索</button>
    </form>
  </div>
</header>

<div class="am-g am-g-fixed blog-g-fixed">
  <div class="am-u-md-8">
    <article class="blog-main">
      <h3 class="am-article-title blog-title" style="text-align:center">
        <a href="#">${selectionNotes.notesName }</a>
      </h3>
      <h4 class="am-article-meta blog-meta" style="text-align:center">by ${selectionNotes.applyPerson }  posted on ${selectionNotes.applyTime } </h4>
        <p>申请时间：${selectionNotes.applyStartTime } 到 ${selectionNotes.applyEndTime }</p>
        <p>申请须知内容：</p>

        <!--article content start  -->
  			${selectionNotes.applyContent }
         <!--article content end  -->
    </article>

    <!-- <hr class="am-article-divider blog-hr"> -->
    <!-- <ul class="am-pagination blog-pagination">
      <li class="am-pagination-prev"><a href="">&laquo; 上一页</a></li>
      <li class="am-pagination-next"><a href="">下一页 &raquo;</a></li>
    </ul> -->
  </div>

  <!-- 以下部分不要修改，只修改上面部分就可以 -->
  <div class="am-u-md-4 blog-sidebar">
    <div class="am-panel-group">
      <section class="am-panel am-panel-default">
        <div class="am-panel-hd">关于精准扶贫内容</div>
        <div class="am-panel-bd">
          <img class="right-logo" id="right-logo" src="<%=basePath%>/img/pg6.png" alt=""/>
        </div>
      </section>

      <section class="am-panel am-panel-default">
        <div class="am-panel-hd">关于精准扶贫目标</div>
        <div class="am-panel-bd">
          <img class="right-logo" id="right-logo" src="<%=basePath%>/img/pic2.png" alt=""/>
        </div>
      </section>
      
    </div>
  </div>

</div>

<footer class="blog-footer">
  <p>blog template<br/>
    <small>© Copyright hss. by the cdSecond Team.</small>
  </p>
</footer>

<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="<%=basePath%>/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="<%=basePath%>/js/jquery.js"></script>
<script src="<%=basePath%>/js/jquery.min.js"></script>
<!--<![endif]-->
<script src="<%=basePath%>/js/amazeui.min.js"></script>

  </body>
</html>
