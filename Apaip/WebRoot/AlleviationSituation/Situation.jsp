<%@ page language="java" import="java.util.*,com.cdsecond.dao.*,com.cdsecond.bean.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Situation.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
   <%  
   	List list=new ArrayList();
    AlleviationSituationDao dao=new AlleviationSituationDao();  
 	list=dao.listAlleviationSituation();  
    AlleviationSituation alleviationSituation=null;
   %> 
   
   <h1>扶贫情况展示表</h1><br>

  <body>
  扶贫结果ID:<input type="text"/> 申请人ID:<input type="text"/><input type="button" value="查询"id="select"/>
  
  <form> 
  <table>

  <tr>
  <td>帮扶情况ID </td><td>申请人ID </td><td>开始时间  </td><td>结束时间  </td><td>帮扶描述 </td><td>删除 </td>
  
  
      <%
    for(int i=0;i<list.size();i++)
          {
             alleviationSituation=(AlleviationSituation)list.get(i);
     %>
    <tr>
     <td>
     <%=alleviationSituation.getAlleviationSituationID() %>
     </td>
     <td>
     <%=alleviationSituation.getApplicantID() %>
     </td>
     <td>
     <%=alleviationSituation.getEndTime() %>
     </td>
        <td>
     <%=alleviationSituation.getAlleviationDetail()%>
     </td>
        <td>
     <%=alleviationSituation.getAlleviationDelete() %>
     </td>

    </tr>
<%
}
 %>
  
  </table>
  </form>
  <input type="button" value="录入"/><input type="button" value="修改"/>
  </body>
</html>
