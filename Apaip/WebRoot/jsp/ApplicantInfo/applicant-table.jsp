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
    
    <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>精准扶贫信息化平台后台管理</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="<%=basePath%>/image/png" href="<%=basePath%>/i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="<%=basePath%>/i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="<%=basePath%>/css/amazeui.min.css"/>
  <link rel="stylesheet" href="<%=basePath%>/css/admin.css">
   <link rel="stylesheet" href="<%=basePath%>/css/hss/table.css">

  </head>
  
  <body>
    <header class="am-topbar am-topbar-inverse admin-header">
  <div class="am-topbar-brand">
    <strong>精准扶贫信息化平台</strong>
  </div>

  <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>

  <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

    <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
     
      <li class="am-dropdown" data-am-dropdown>
        <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
          haoshasha
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
            <li><a href="user-table.html" class="am-cf"><span class="am-icon-check"></span> 用户管理<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
            <li><a href="<%=basePath%>DictionaryServlet?main=List"><span class="am-icon-check"></span> 字典管理</a></li>
          </ul>

        <li><a href="#" data-am-collapse="{target: '#collapse-nav-one'}"><span class="am-icon-table"></span> 精确识别</a></li>
          <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav-one">
            <li><a href="<%=basePath %>SelectionNotesServlet?action=select" class="am-cf"><span class="am-icon-check"></span> 申请评选须知<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
            <li><a href="<%=basePath %>ApplicantServlet?action=select"><span class="am-icon-check"></span> 申请人信息管理</a></li>
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
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">申请人信息</strong></div>
      </div>

      <hr>

      <!-- operation start -->
      <div class="am-g">
        <div class="am-u-sm-12 am-u-md-6">
          <div class="am-btn-toolbar">
            <div class="am-btn-group am-btn-group-xs">
            <form action = "ApplicantServlet?action=getDic&use=poorDemand&go=add" method = "post">
              <button type="submit" class="am-btn am-btn-default" id="addApplicantBtn" ><span class="am-icon-plus"></span> 新增</button>
             </form>
             <!-- <button type="button" class="am-btn am-btn-default" id="delApplicantBtn"><span class="am-icon-trash-o"></span> 删除</button> --> 
            </div>
          </div>
        </div>
      </div>
      <!-- operation end -->

      <!-- condition start -->
      <div id="select">
       <div class="am-u-sm-12 am-u-md-3">
          <div class="user-condition">
            <form action = "ApplicantServlet?action=select" method = "post">
            <span > 姓名</span>
            <input type="text" class="applicantName" name = "applicantName" value = "">
            <span > 户籍所在地</span>
            <input type="text" class="address" name = "applicantAddress" value = "">

            <span > 受教育程度</span>
            <select id="doc-select-1" name = "education">
              <option value="">-=请选择一项=-</option>
              <option value="小学">小学</option>
              <option value="初中">初中</option>
              <option value="大学">大学</option>
            </select>

            <button class="select-btn" type="submit">查询</button>
            </form>
          </div>
        </div>
      </div>
      <!-- condition end -->



      <div class="am-g">
        <div class="am-u-sm-12">
          <form class="am-form">

            <!-- table start -->
            <table class="am-table am-table-striped am-table-hover table-main">
              <thead>
              <tr>
                <th class="table-check"><input type="checkbox" id="total-choose"/></th>
                <th class="table-id">序号</th>
                <th class="table-name">姓名</th>
                <th class="table-gender">性别</th>
                <th class="table-nation">民族</th>
                <th class="table-address">户籍所在地</th>
                <th class="table-address">受教育程度</th>
                <th class="table-nation">联系方式</th>
                <th class="table-set">操作</th>
              </tr>
              </thead>
              <tbody>
              <c:forEach var="applicant_list" items="${list}">
              <tr>
                <td><input type="checkbox" /><input type="hidden" name="applicantID" value="${applicant_list.applicantID }"></td>
                <td>1</td>
                <td>${applicant_list.applicantName }</td>
                <td>${applicant_list.applicantSex }</td>
                <td>${applicant_list.applicantNation }</td>
                <td>${applicant_list.applicantAddress }</td>
                <td>${applicant_list.education }</td>
                <td>${applicant_list.applicantPhone }</td>
                <td>
                 
                      <a href="<%=basePath%>ApplicantServlet?action=select&applicantID=${applicant_list.applicantID}&go=detail">详情</a>
                      <a href="<%=basePath%>ApplicantServlet?action=select&applicantID=${applicant_list.applicantID}&go=update">修改</a>
                      <a href="<%=basePath%>ApplicantServlet?action=delete&applicantID=${applicant_list.applicantID}">删除</a>
                   
                </td>
              </tr>
              </c:forEach>
              

              </tbody>
            </table>

            <!-- table end -->

            <!-- page start -->
            <div class="am-cf">
              共  ${totalRecords} 条记录
              <div class="am-fr">
                <ul class="am-pagination">
                  <li><a href="<%=basePath%>ApplicantServlet?action=select&currentPage=1">首页</a></li>
                  <li><a href="<%=basePath%>ApplicantServlet?action=select&currentPage=${currentPage-1}">上一页</a></li>
                  <li><a href="<%=basePath%>ApplicantServlet?action=select&currentPage=${currentPage+1}">下一页</a></li>
                  <li><a href="<%=basePath%>ApplicantServlet?action=select&currentPage=${totalRecords/10+1}">尾页</a></li>
                </ul>
              </div>
            </div>
            <!-- page end -->
          </form>
        </div>

      </div>
    </div>

<footer>
  <hr>
  <p class="am-padding-left">© 2016 AllMobilize, Inc. Licensed under MIT license.</p>
</footer>

<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="../js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="<%=basePath%>/js/jquery.js"></script>
<script src="<%=basePath%>/js/jquery.min.js"></script>
<!--<![endif]-->
<script src="<%=basePath%>/js/amazeui.min.js"></script>
<script src="<%=basePath%>/js/app.js"></script>
<script src="<%=basePath%>/js/hss/logout.js"></script>
<script src="<%=basePath%>/js/hss/table.js"></script>


</script>
  </body>
</html>
