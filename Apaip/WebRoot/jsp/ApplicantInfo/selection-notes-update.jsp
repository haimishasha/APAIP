<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>精准扶贫信息化平台后台管理</title>
<!--   <meta name="description" content="这是一个 table 页面">
  <meta name="keywords" content="table"> -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="<%=basePath%>/image/png" href="<%=basePath%>/i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="<%=basePath%>/i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="<%=basePath%>/css/amazeui.min.css"/>
  <link rel="stylesheet" href="<%=basePath%>/css/admin.css">
  <link rel="stylesheet" href="<%=basePath%>/css/hss/picture.css">
  <link rel="stylesheet" href="<%=basePath%>/css/hss/detail.css">
  <script type="text/javascript" src="<%=basePath%>/plugin//My97DatePicker/WdatePicker.js"></script>
  <script type="text/javascript" src="<%=basePath%>/plugin/ckeditor/ckeditor.js"></script>
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
            <li><a href="dictionary-table.html"><span class="am-icon-check"></span> 字典管理</a></li>
          </ul>

        <li><a href="#" data-am-collapse="{target: '#collapse-nav-one'}"><span class="am-icon-table"></span> 精确识别</a></li>
          <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav-one">
            <li><a href="<%=basePath %>SelectionNotesServlet?action=select" class="am-cf"><span class="am-icon-check"></span> 申请评选须知<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
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
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">修改申请评选须知</strong></div>
      </div>

      <hr/>

      <div class="am-g">
        <div class="am-u-sm-12 am-u-md-4 am-u-md-push-8">
          <div class="am-panel am-panel-default">
            <div class="am-panel-bd">
              <div class="am-g">
                <div class="am-u-md-4">
                  <img class="right-logo" id="right-logo" src="<%=basePath%>/img/pic4.png" alt=""/>
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
          <form class="am-form am-form-horizontal" action = "SelectionNotesServlet?action=update&selectionNotesID=${selectionNotes.selectionNotesID }" method = "post">

            <div class="am-g am-margin-top">
              <div class="am-u-sm-4 am-u-md-2 am-text-right">
                评选须知名称
              </div>
              <div class="am-u-sm-8 am-u-md-4">
                <input type="text" class="am-input-sm" name = "notesName" value = "${selectionNotes.notesName }">
              </div>
              <div class="am-hide-sm-only am-u-md-6">发布单位+时间+名称</div>
            </div>

            <div class="am-g am-margin-top">
              <div class="am-u-sm-4 am-u-md-2 am-text-right">
               申请开始时间
              </div>
              <div class="am-u-sm-8 am-u-md-10">
              
                  <div class="am-form-group am-form-icon">
                    <i class="am-icon-calendar"></i>
                    <input class="am-form-field am-input-sm" name = "applyStartTime" value= "${selectionNotes.applyStartTime }" type="text" style="width:230px" value="" onfocus="WdatePicker()">
                  </div>
                
              </div>
            </div>

            <div class="am-g am-margin-top">
              <div class="am-u-sm-4 am-u-md-2 am-text-right">
               申请结束时间
              </div>
              <div class="am-u-sm-8 am-u-md-10" style="margin-top:0px">
               
                  <div class="am-form-group am-form-icon">
                    <i class="am-icon-calendar"></i>
                    <input class="am-form-field am-input-sm" name = "applyEndTime"  value = "${selectionNotes.applyEndTime }" type="text" style="width:230px" value="" onfocus="WdatePicker()">
                  </div>
               
              </div>
            </div>

            <div class="am-g am-margin-top-sm" id="id="editorSpace"">
              <div class="am-u-sm-12 am-u-md-2 am-text-right admin-form-text">
                内容描述
              </div>
              <div class="am-u-sm-12 am-u-md-10">
                <textarea id="TextArea1" cols="20" rows="2" class="ckeditor" name = "applyContent">${selectionNotes.applyContent }</textarea>
                
              </div>
            </div>
            <script type="text/javascript">CKEDITOR.appendTo( 'editorSpace' );</script>

            <br/>
            <!-- <div class="am-form-group">
              <div class="am-u-sm-9 am-u-sm-push-3">
                <button type="button" class="am-btn am-btn-primary">保存</button>
              </div>
            </div> -->
             <div class="btn-selection-note-group">
              <div class="am-form-group am-form-icon">
                <button type="submit" id="btn-selection-add" class="am-btn am-btn-primary am-btn-xs">确认保存</button>
                <button type="button" id="btn-selection-cancel"class="am-btn am-btn-primary am-btn-xs">重置</button>
              </div>
            </div>

          </form>
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
<script src="<%=basePath%>/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="<%=basePath%>/js/jquery.js"></script>
<script src="<%=basePath%>/js/jquery.min.js"></script>
<!--<![endif]-->
<script src="<%=basePath%>/js/amazeui.min.js"></script>

<script src="<%=basePath%>/js/app.js"></script>
<script src="<%=basePath%>/js/hss/logout.js"></script>

  </body>
</html>
