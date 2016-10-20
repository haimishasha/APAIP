<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ResultList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <h1>扶贫结果展示表</h1><br>

  <body>
  扶贫结果ID:<input type="text"/> 申请人ID:<input type="text"/><input type="button" value="查询"id="select"/>
  
  <form> 
  <table>

  <tr>
  <td>帮扶结果ID </td><td>申请人ID </td><td>帮扶开始时间  </td><td>帮扶结束时间  </td><td>登记时间 </td><td>帮扶结果描述 </td><td>帮扶状态 </td><td>登记人</td>
  
  <tr>
  <tr><td>11</td><td>12</td><td>13</td><td>14</td><td>15</td><td>16</td><td>17</td><td>18</td>
  </tr>
  
  <tr>
    <tr><td>21</td><td>22</td><td>23</td><td>24</td><td>25</td><td>26</td><td>27</td><td>28</td>
  </tr>
  
    <tr>
    <tr><td>31</td><td>32</td><td>33</td><td>34</td><td>35</td><td>36</td><td>37</td><td>38</td>
  </tr>
     <tr>
    <tr><td>41</td><td>42</td><td>43</td><td>44</td><td>45</td><td>46</td><td>47</td><td>48</td>
  </tr>
     <tr>
    <tr><td>51</td><td>52</td><td>53</td><td>54</td><td>55</td><td>56</td><td>57</td><td>58</td>
  </tr>
  </table>
  </form>
  <input type="button" value="录入"/><input type="button" value="修改"/>
  </body>
</html>
