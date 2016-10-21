<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>精准扶贫信息化平台后台管理</title>
<!--   <meta name="description" content="这是一个 table 页面">
  <meta name="keywords" content="table"> -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="<%=basePath %>image/png" href="<%=basePath %>i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="<%=basePath %>i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="<%=basePath %>css/amazeui.min.css"/>
  <link rel="stylesheet" href="<%=basePath %>css/admin.css">
   <link rel="stylesheet" href="<%=basePath %>css/hss/picture.css">
</head>
<body>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->

<header class="am-topbar am-topbar-inverse admin-header">
  <div class="am-topbar-brand">
    <strong>精准扶贫信息化平台</strong>
  </div>

  <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>

  <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

    <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
     
      <li class="am-dropdown" data-am-dropdown>
        <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
          ${loginuser.userName }
        </a>
      </li>
      <li class="am-hide-sm-only"><a href="javascript:;" id="layout">退出</span></a></li>
    </ul>
  </div>
</header>

<div class="am-cf admin-main">
  <!-- sidebar start -->
  <div class="admin-sidebar am-offcanvas" id="admin-offcanvas">
    <div class="am-offcanvas-bar admin-offcanvas-bar">
      <ul class="am-list admin-sidebar-list">
        <li><a href="home.html"><span class="am-icon-home"></span> 首页</a></li>
        
        <li><a href="#" data-am-collapse="{target: '#collapse-nav-three'}"><span class="am-icon-table"></span> 后台管理</a></li>
          <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav-three">
            <li><a href="http://localhost:8080/Apaip/servlet?cmd=relogin&userName=${loginuser.userName }" class="am-cf"><span class="am-icon-check"></span> 用户管理<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
            <li><a href="dictionary-table.html"><span class="am-icon-check"></span> 字典管理</a></li>
          </ul>

        <li><a href="#" data-am-collapse="{target: '#collapse-nav-one'}"><span class="am-icon-table"></span> 精确识别</a></li>
          <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav-one">
            <li><a href="selection-notes-table.html" class="am-cf"><span class="am-icon-check"></span> 申请评选须知<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
            <li><a href="applicant-table.html"><span class="am-icon-check"></span> 申请人信息管理</a></li>
            <li><a href="poverty-table.html"><span class="am-icon-check"></span> 识别贫困户</a></li>
          </ul>
        <li><a href="#" data-am-collapse="{target: '#collapse-nav'}"><span class="am-icon-pencil-square-o"></span> 精确管理</a></li>

          <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav">
            <li><a href="poverty-plan-table.html" class="am-cf"><span class="am-icon-check"></span> 脱贫计划管理</span></a></li>
            <li><a href="poverty-measure-table.html"><span class="am-icon-check"></span> 脱贫措施管理</a></li>
            <li><a href="poverty-table.html"><span class="am-icon-check"></span> 跟踪帮扶情况</a></li>
            <li><a href="poverty-table.html"><span class="am-icon-check"></span> 登记帮扶结果</a></li>
          </ul>

        <li><a href="#"><span class="am-icon-puzzle-piece"></span>帮扶成效</a></li>
        <li><a href="#" data-am-collapse="{target: '#collapse-nav-two'}"><span class="am-icon-th"></span> 大数据分析</a></li>
          <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav-two">
            <li><a href="chart_line.html" class="am-cf"><span class="am-icon-check"></span>折线图分析</span></a></li>
            <li><a href="chart_columnar.html"><span class="am-icon-check"></span> 柱状图分析</a></li>
            <li><a href="chart_pie.html"><span class="am-icon-check"></span> 饼状图分析</a></li>
          </ul>
      </ul>

      <!-- 公告开始 -->
      <div class="am-panel am-panel-default admin-sidebar-panel">
        <div class="am-panel-bd">
          <p><span class="am-icon-bookmark"></span> 公告</p>
          <p>聚焦精准扶贫 共建小康社会—— cdSeconTeam</p>
        </div>
      </div>
      <!-- 公告结束 -->

      <!-- <div class="am-panel am-panel-default admin-sidebar-panel">
        <div class="am-panel-bd">
          <p><span class="am-icon-tag"></span> wiki</p>
          <p>Welcome to the Amaze UI wiki!</p>
        </div>
      </div> -->
    </div>
  </div>
  <!-- sidebar end -->

  <!-- content start -->
  <div class="admin-content">
    <div class="admin-content-body">
      <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">修改用户信息</strong></div>
      </div>

      <hr/>

      <div class="am-g">
        <div class="am-u-sm-12 am-u-md-4 am-u-md-push-8">
          <div class="am-panel am-panel-default">
            <div class="am-panel-bd">
              <div class="am-g">
                <div class="am-u-md-4">
                  <img class="right-logo" id="right-logo" src="<%=basePath %>img/pic4.png" alt=""/>
                </div>
              </div>
            </div>
          </div>

          <div class="am-panel am-panel-default">
            <div class="am-panel-bd">
              <div class="user-info">
                <p>100%推进</p>
                <div class="am-progress am-progress-sm">
                  <div class="am-progress-bar am-progress-bar-success" style="width: 100%"></div>
                </div>
                <p class="user-info-order">聚力扶贫攻坚,推进民生工程</p>
              </div>
               <div class="user-info">
                <p>100%落实</p>
                <div class="am-progress am-progress-sm">
                  <div class="am-progress-bar" style="width: 100%"></div>
                </div>
                <p class="user-info-order">瞄准扶贫开发对象,全面落实扶贫政策</p>
              </div>
            </div>
          </div>

        </div>

        <div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4">
          <form class="am-form am-form-horizontal" action="http://localhost:8080/Apaip/servlet?cmd=edit&username=${param.username }" method="post">

            <div class="am-form-group">
              <label for="user-name" class="am-u-sm-3 am-form-label">用户名</label>
              <div class="am-u-sm-9">
                <label>${param.username }</label>
              </div>
            </div>

            <div class="am-form-group">
              <label for="password" class="am-u-sm-3 am-form-label">密码</label>
              <div class="am-u-sm-9">
                <input type="password" id="userPassWord" name="userPassword" placeholder="输入你的密码/userPassWord">
                <small>用于登录系统哦。</small>
              </div>
            </div>

            <div class="am-form-group">
              <label for="trueName" class="am-u-sm-3 am-form-label">姓名</label>
              <div class="am-u-sm-9">
                <input type="text" id="trueName" name="userTrueName" placeholder="输入你的真实姓名/trueName">
                <small>输入你的名字，让我们记住你。</small>
              </div>
            </div>

            <div class="am-form-group">
              <label for="gender"class="am-u-sm-3 am-form-label">性别</label>
              <div class="am-u-sm-9">
                <label class="am-radio-inline">
                  <input type="radio"  value='男' name="userSex"  required> 男
                </label>
                <label class="am-radio-inline">
                  <input type="radio" name="userSex" value='女'> 女
                </label>
              </div>
            </div>

            <div class="am-form-group">
              <label for="idcard" class="am-u-sm-3 am-form-label">身份证号</label>
              <div class="am-u-sm-9">
                <input type="text" id="IDCard" name="IDCard" placeholder="输入你的身份证号">
              </div>
            </div>

            <div class="am-form-group">
              <label for="user-phone" class="am-u-sm-3 am-form-label">电话</label>
              <div class="am-u-sm-9">
                <input type="tel" id="user-phone" name="userPhone" placeholder="输入你的电话号码 / Telephone">
              </div>
            </div>


            <div class="am-form-group">
              <label for="address" class="am-u-sm-3 am-form-label">家庭住址</label>
              <div class="am-u-sm-9">
                <input type="text" id="address" name="userAddr"placeholder="输入你的家庭住址/address">
              </div>
            </div>

            <div class="am-form-group">
              <div class="am-u-sm-9 am-u-sm-push-3">
                <button type="submit" class="am-btn am-btn-primary">保存</button>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>

    <footer class="admin-content-footer">
      <hr>
      <p class="am-padding-left">© 2014 AllMobilize, Inc. Licensed under MIT license.</p>
    </footer>

  </div>
  <!-- content end -->

</div>

<a href="#" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"></a>

<footer>
  <hr>
  <p class="am-padding-left">© 2014 AllMobilize, Inc. Licensed under MIT license.</p>
</footer>

<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="<%=basePath %>js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="<%=basePath %>js/jquery.js"></script>
<!-- <script src="<%=basePath %>js/jquery.min.js"></script> -->
<!--<![endif]-->
<script src="<%=basePath %>js/amazeui.min.js"></script>

<script src="<%=basePath %>js/app.js"></script>
<script src="<%=basePath %>js/hss/logout.js"></script>
</body>
</html>