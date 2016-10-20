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
  <title>Amaze UI Admin form Examples</title>
  <meta name="description" content="这是一个form页面">
  <meta name="keywords" content="form">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="<%=basePath%>/image/png" href="<%=basePath%>/i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="<%=basePath%>/i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="<%=basePath%>/css/amazeui.min.css"/>
  <link rel="stylesheet" href="<%=basePath%>/css/admin.css">
  <link rel="stylesheet" href="<%=basePath%>/css/hss/detail.css">
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
      <div class="am-fl am-cf">
        <strong class="am-text-primary am-text-lg">申请人详细信息</strong>
      </div>
    </div>

    <hr>

    <div class="am-tabs am-margin" data-am-tabs>
      <ul class="am-tabs-nav am-nav am-nav-tabs">
        <li class="am-active"><a href="#tab1">基本信息</a></li>
        <li><a href="#tab2">贫困信息</a></li>
        <li><a href="#tab3">需求信息</a></li>
      </ul>

      <div class="am-tabs-bd">
        <div class="am-tab-panel am-fade am-in am-active" id="tab1">
          <div class="am-g am-margin-top">
            <div class="am-u-sm-4 am-u-md-2 am-text-right">姓名:</div>
            <div class="am-u-sm-8 am-u-md-10">
                 <label >张某某</label>
            </div>
          </div>


          <div class="am-g am-margin-top">
            <div class="am-u-sm-4 am-u-md-2 am-text-right">性别:</div>
            <div class="am-u-sm-8 am-u-md-10">
              <div class="am-btn-group" data-am-button>
                 <label >女</label>
              </div>
            </div>
          </div>

          <div class="am-g am-margin-top">
            <div class="am-u-sm-4 am-u-md-2 am-text-right">民族:</div>
            <div class="am-u-sm-8 am-u-md-10">
              <div class="am-btn-group" data-am-button>
                <label >汉族</label>
              </div>
            </div>
          </div>

          <div class="am-g am-margin-top">
            <div class="am-u-sm-4 am-u-md-2 am-text-right">户籍所在地:</div>
            <div class="am-u-sm-8 am-u-md-10">
              <div class="am-btn-group" data-am-button>
                <label >xx省xx市xx县xx乡</label>
              </div>
            </div>
          </div>


           <div class="am-g am-margin-top">
            <div class="am-u-sm-4 am-u-md-2 am-text-right">受教育情况:</div>
            <div class="am-u-sm-8 am-u-md-10">
              <div class="am-btn-group" data-am-button>
                 <label >初中</label>
              </div>
            </div>
          </div>

          <div class="am-g am-margin-top">
            <div class="am-u-sm-4 am-u-md-2 am-text-right">婚姻状况:</div>
            <div class="am-u-sm-8 am-u-md-10">
              <div class="am-btn-group" data-am-button>
                <label >已婚</label>
              </div>
            </div>
          </div>

          <div class="am-g am-margin-top">
            <div class="am-u-sm-4 am-u-md-2 am-text-right">身份证号:</div>
            <div class="am-u-sm-8 am-u-md-10">
              <div class="am-btn-group" data-am-button>
                 <label >154214542545214525</label>
              </div>
            </div>
          </div>

          <div class="am-g am-margin-top">
            <div class="am-u-sm-4 am-u-md-2 am-text-right">联系方式:</div>
            <div class="am-u-sm-8 am-u-md-10">
              <div class="am-btn-group" data-am-button>
                 <label >18435155335</label>
              </div>
            </div>
          </div>
        </div>

        <div class="am-tab-panel am-fade" id="tab2">
          <div class="am-g am-margin-top">
            <div class="am-u-sm-4 am-u-md-2 am-text-right">残疾证号:</div>
            <div class="am-u-sm-8 am-u-md-10">
              <div class="am-btn-group" data-am-button>
                 <label >14341431415341</label>
              </div>
            </div>
          </div>


          <div class="am-g am-margin-top">
            <div class="am-u-sm-4 am-u-md-2 am-text-right">残疾情况:</div>
            <div class="am-u-sm-8 am-u-md-10">
              <div class="am-btn-group" data-am-button>
                 <label >脑残</label>
              </div>
            </div>
          </div>

          <div class="am-g am-margin-top">
            <div class="am-u-sm-4 am-u-md-2 am-text-right">家庭人数:</div>
            <div class="am-u-sm-8 am-u-md-10">
              <div class="am-btn-group" data-am-button>
                 <label >6</label>个人
              </div>
            </div>
          </div>

          <div class="am-g am-margin-top">
            <div class="am-u-sm-4 am-u-md-2 am-text-right">家庭住房面积:</div>
            <div class="am-u-sm-8 am-u-md-10">
              <div class="am-btn-group" data-am-button>
                 <label >50</label>平方米
              </div>
            </div>
          </div>

          <div class="am-g am-margin-top">
            <div class="am-u-sm-4 am-u-md-2 am-text-right">家庭收入:</div>
            <div class="am-u-sm-8 am-u-md-10">
              <div class="am-btn-group" data-am-button>
                 <label >6000</label>元/年
              </div>
            </div>
          </div>

           <div class="am-g am-margin-top">
            <div class="am-u-sm-4 am-u-md-2 am-text-right">贫困等级:</div>
            <div class="am-u-sm-8 am-u-md-10">
              <div class="am-btn-group" data-am-button>
                 <label >三等特困</label>
              </div>
            </div>
          </div>

        </div>

        <div class="am-tab-panel am-fade am-in am-active" id="tab3">
          <div class="am-g am-margin-top">
            <div class="am-u-sm-4 am-u-md-2 am-text-right">申请时间:</div>
            <div class="am-u-sm-8 am-u-md-10">
              <div class="am-btn-group" data-am-button>
                 <label >2016-09-08</label>
              </div>
            </div>
          </div>

          <div class="am-g am-margin-top">
            <div class="am-u-sm-4 am-u-md-2 am-text-right">需求情况:</div>
            <div class="am-u-sm-8 am-u-md-10">
              <div class="am-btn-group" data-am-button>
                 <label >社会保险、教育、医疗</label>
              </div>
            </div>
          </div>

          <div class="am-g am-margin-top">
            <div class="am-u-sm-4 am-u-md-2 am-text-right">申请理由:</div>
            <div class="am-u-sm-8 am-u-md-10">
              <div class="am-btn-group" data-am-button>
                 <label >工作不稳定，收入不稳定</label>
              </div>
            </div>
          </div>
        </div>
        </div>
      </div>

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
  <script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
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
