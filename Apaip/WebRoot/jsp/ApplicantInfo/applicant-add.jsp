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
  <link rel="icon" type="<%=basePath %>/image/png" href="<%=basePath %>/i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="<%=basePath %>/i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="<%=basePath %>/css/amazeui.min.css"/>
  <link rel="stylesheet" href="<%=basePath %>/css/admin.css">
  <link rel="stylesheet" href="<%=basePath %>/css/hss/picture.css">
  <script type="text/javascript" src="<%=basePath %>/plugin//My97DatePicker/WdatePicker.js"></script>
  <script type="text/javascript" src="<%=basePath %>/plugin/ckeditor/ckeditor.js"></script>


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
        <li><a href="#"><span class="am-icon-home"></span> 首页</a></li>
        
        <li><a href="#" data-am-collapse="{target: '#collapse-nav-three'}"><span class="am-icon-table"></span> 后台管理</a></li>
          <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav-three">
            <li><a href="user-table.html" class="am-cf"><span class="am-icon-check"></span> 用户管理<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
            <li><a href="dictionary-table.html"><span class="am-icon-check"></span> 字典管理</a></li>
          </ul>

        <li><a href="#" data-am-collapse="{target: '#collapse-nav-one'}"><span class="am-icon-table"></span> 精确识别</a></li>
          <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav-one">
            <li><a href="selection-notes-table.html" class="am-cf"><span class="am-icon-check"></span> 申请评选须知<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
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
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">添加申请人信息</strong></div>
      </div>

      <hr/>

      <div class="am-g">
        <div class="am-u-sm-12 am-u-md-4 am-u-md-push-8">
          <div class="am-panel am-panel-default">
            <div class="am-panel-bd">
              <div class="am-g">
                <div class="am-u-md-4">
                  <img class="right-logo" id="right-logo" src="<%=basePath %>/img/pic4.png" alt=""/>
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
          <form class="am-form am-form-horizontal" action = "ApplicantServlet?action=add" method = "post">

            <div class="am-form-group">
              <label for="applicantName" class="am-u-sm-3 am-form-label">姓名</label>
              <div class="am-u-sm-9">
                <input type="text" id="applicantName"  name = "applicantName" value = "" placeholder="输入你的真实姓名">
              </div>
            </div>

            <div class="am-form-group">
              <label for="applicantSex"class="am-u-sm-3 am-form-label">性别</label>
              <div class="am-u-sm-9">
                <label class="am-radio-inline">
                  <input type="radio" name="applicantSex" value = "男" required> 男
                </label>
                <label class="am-radio-inline">
                  <input type="radio" name="applicantSex" value = "女"> 女
                </label>
              </div>
            </div>

             <div class="am-form-group">
              <label for="applicantNation" class="am-u-sm-3 am-form-label">民族</label>
              <div class="am-u-sm-9">
                <input type="text" id="applicantNation" name = "applicantNation" value = "" placeholder="民族信息">
              </div>
            </div>

            <div class="am-form-group">
              <label for="applicantAddress" class="am-u-sm-3 am-form-label">户籍所在地</label>
              <div class="am-u-sm-9">
                <input type="text" id="applicantAddress" name = "applicantAddress" value = "" placeholder="输入你的户籍所在地">
              </div>
            </div>

             <div class="am-form-group">
                <label for="education" class="am-u-sm-3 am-form-label">受教育情况</label>
                <div class="am-u-sm-9">
                  <select id="education" name = "education" style="width:494px margin-left">
                    <option value="其他">其他</option>
                    <option value="小学">小学</option>
                    <option value="初中">初中</option>
                    <option value="高中">高中</option>
                    <option value="大学">大学</option>
                  </select>
                  <span class="am-form-caret"></span>
                </div>                
            </div>

            <div class="am-form-group">
                <label for="marriage" class="am-u-sm-3 am-form-label">婚姻状况</label>
                <div class="am-u-sm-9">
                  <select id="marriage" name = "marriage" style="width:494px margin-left">
                    <option value="已婚">已婚</option>
                    <option value="未婚">未婚</option>
                  </select>
                  <span class="am-form-caret"></span>
                </div>                
            </div>

             <div class="am-form-group">
              <label for="applicantIdNumber" class="am-u-sm-3 am-form-label">身份证号</label>
              <div class="am-u-sm-9">
                <input type="text" id="applicantIdNumber" name = "applicantIdNumber" value = "" placeholder="输入你的身份证号">
              </div>
            </div>

            <div class="am-form-group">
              <label for="applicantPhone" class="am-u-sm-3 am-form-label">联系方式</label>
              <div class="am-u-sm-9">
                <input type="tel" id="applicantPhone" name = "applicantPhone" value = "" placeholder="输入你的联系方式">
              </div>
            </div>


            <div class="am-form-group">
              <label for="applicantDisabilityNumber" class="am-u-sm-3 am-form-label">残疾证号</label>
              <div class="am-u-sm-9">
                <input type="text" id="applicantDisabilityNumber" name = "applicantDisabilityNumber" value = ""  placeholder="输入你的残疾证号">
              </div>
            </div>

            <div class="am-form-group">
              <label for="applicantDisablityCondition" name = "applicantDisablityCondition" value = "" class="am-u-sm-3 am-form-label">残疾情况</label>
              <div class="am-u-sm-9">
                <input type="text" id="applicantDisablityCondition" placeholder="残疾情况">
              </div>
            </div>

            <div class="am-form-group">
              <label for="applicantFamilyNumber" class="am-u-sm-3 am-form-label">家庭人数</label>
              <div class="am-u-sm-9">
                <input type="text" id="applicantFamilyNumber" name = "applicantFamilyNumber" value = "" placeholder="家庭人数（单位人）">
              </div>
            </div>

            <div class="am-form-group">
              <label for="houseArea" class="am-u-sm-3 am-form-label">家庭住房面积</label>
              <div class="am-u-sm-9">
                <input type="text" id="houseArea" name = "houseArea" value = "" placeholder="家庭住房面积（单位平方米）">
              </div>
            </div>

            <div class="am-form-group">
              <label for="applicantIncome" class="am-u-sm-3 am-form-label">家庭收入</label>
              <div class="am-u-sm-9">
                <input type="text" id="applicantIncome" name = "applicantIncome" value = ""  placeholder="家庭收入（单位元）">
              </div>
            </div>

            <div class="am-form-group">
              <label for="applicationTime" class="am-u-sm-3 am-form-label">申请时间</label>
              <div class="am-u-sm-9">
                 <input type="text" name = "applicationTime" value="" onfocus="WdatePicker()" placeholder="请输入申请时间">
              </div>
            </div>

             <div class="am-form-group">
              <label for="bankCardNumber" class="am-u-sm-3 am-form-label">银行卡号</label>
              <div class="am-u-sm-9">
                <input type="text" id="bankCardNumber" name = "bankCardNumber" value = "" placeholder="请输入银行卡号">
              </div>
            </div>

            <div class="am-form-group" id="editorSpace">
                <label for="bankCardNumber" class="am-u-sm-3 am-form-label">需求情况</label> 
                <div class="am-u-sm-9">
                 
                      <label class="am-checkbox-inline">
                        <input type="checkbox" value="需求1" name="docVlCb"> 需求1
                      </label>
                      <label class="am-checkbox-inline">
                        <input type="checkbox" value="需求2" name="docVlCb"> 需求2
                      </label>
                      <label class="am-checkbox-inline">
                        <input type="checkbox" value="需求3" name="docVlCb"> 需求3
                      </label>
                      <label class="am-checkbox-inline">
                        <input type="checkbox" value="需求4" name="docVlCb"> 需求4
                      </label>
                      <label class="am-checkbox-inline">
                        <input type="checkbox" value="需求5" name="docVlCb"> 需求5
                      </label>
                      <label class="am-checkbox-inline">
                        <input type="checkbox" value="需求6" name="docVlCb"> 需求6
                      </label>
                      <label class="am-checkbox-inline">
                        <input type="checkbox" value="需求7" name="docVlCb"> 需求7
                      </label>
                      <label class="am-checkbox-inline">
                        <input type="checkbox" value="需求8" name="docVlCb"> 需求8
                      </label>
                      <label class="am-checkbox-inline">
                        <input type="checkbox" value="需求9" name="docVlCb"> 需求9
                      </label>
                      <label class="am-checkbox-inline">
                        <input type="checkbox" value="需求10" name="docVlCb"> 需求10
                      </label>
                 </div>            
            </div>

            <div class="am-form-group" id="editorSpace">
                <label for="bankCardNumber" class="am-u-sm-3 am-form-label">申请理由</label> 
                <div class="am-u-sm-9">
                  <textarea id="applicantReason" name = "applicantReason" value = " " cols="20" rows="2" class="ckeditor"></textarea>
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
<script src="/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="<%=basePath %>/js/jquery.js"></script>
<script src="<%=basePath %>/js/jquery.min.js"></script>
<!--<![endif]-->
<script src="<%=basePath %>/js/amazeui.min.js"></script>

<script src="<%=basePath %>/js/app.js"></script>
<script src="<%=basePath %>/js/hss/logout.js"></script>
  </body>
</html>
