<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>精准扶贫信息化平台</title>	
	<link rel="stylesheet" href="<%=basePath %>css/core.css" />
	<link rel="stylesheet" href="<%=basePath %>css/menu.css" />
	<link rel="stylesheet" href="<%=basePath %>css/amazeui.css" />
	<link rel="stylesheet" href="<%=basePath %>css/component.css" />
	<link rel="stylesheet" href="<%=basePath %>css/page/form.css" />
<title>Insert title here</title>
</head>
<body>
	<div class="account-pages">
			<div class="wrapper-page">
				<!-- title start -->
				<div class="text-center">
	                <a href="index.html" class="logo"><span>精准扶贫信息化平台</span></a>
	            </div>
	            <!-- title start -->
	            <!-- login start -->
	            <div class="m-t-40 card-box">
	            	<div class="text-center">
	                    <h1>登录入口</h1>
	                </div>
	                <div class="panel-body">
	                	<form class="am-form" action="http://localhost:8080/Apaip/servlet" method="POST">
	                		<div class="am-g">

	                			<div class="am-form-group">
							      <input type="text" id="userName" name="userName" class="am-radius"  placeholder="请输入用户名">
							    </div>
								
							    <div class="am-form-group form-horizontal m-t-20">
							      <input type="password" id="userPassword" name="userPassword" class="am-radius"  placeholder="请输入密码">
							    </div>
							    
							   <!--  <div class="am-form-group ">
		                           	<label style="font-weight: normal;color: #999;">
								        <input type="checkbox" class="remeber"> 记住密码
								    </label>
		                        </div> -->
		                        
		                        <div class="am-form-group ">
		                        	<button type="submit" class="am-btn am-btn-primary am-radius" name="cmd" value="login" style="width: 100%;height: 100%;">登 录</button>
		                        </div>
	                		</div>
	                	</form>		
	                </div>
	            </div>
	         	<!-- login end -->

	            </div>
			</div>
	
</body>
</html>