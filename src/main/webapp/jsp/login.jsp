<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="../css/index.css"/>
		<title>滇宏教育信息管理系统</title>
	</head>
	<body>
		<form action="stu.do">
			<input type="hidden" name="keyword" value="login">
			<div class="bg">
				<div class="wel">滇宏教育信息管理系统</div>
		        <div class="user">
		       	    <div id="yonghu" style="">用户名</div>
		       	    <input  type="text" name="username"  value="admin" />
		        </div>
		        <div class="password" >
		        	<div id="password" >密&nbsp;&nbsp;&nbsp;码</div>
		       	    <input class="" type="password" name="password" value="admin" />
		        </div>
		        <div class="rem" >
		       	  <input type="checkbox" name="" id="" value="" />
		        	 <div id="reb">
		        	 	记住密码ini
		        	 </div>
		        </div>
		        <div class="fg" >
		       	    <div style="font-size: 11px;margin-top: 11px;">
		       	    	<a style="font-size: 11px;" href="#">忘记密码？</a>
		       	    </div>
		        </div>
		        
		        <input class="btn" type="submit" value="登录"/>
			</div>
		</form>
	</body>
</html>