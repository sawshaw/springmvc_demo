<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
    
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
<head>
    <head>
        <title>Hello jQuery</title>
        <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
        <script>
        var basepath = '<%=basePath %>';
        $(document).ready(function() {
            $.ajax({
                url: basepath+"/me/greeting"
            }).then(function(data) {
            	var obj=JSON.parse(data);
               $('.greeting-id').append(obj.id);
               $('.greeting-content').append(obj.content);
            });
        });
        </script>
    </head>

    <body>
    <h1>hello,world,web-inf,jsp</h1>
        <div>
            <p class="greeting-id">The ID is </p>
            <p class="greeting-content">The content is </p>
        </div>
        <form action="<%=basePath %>/me/postData" method="post">
      	  用户名：<input type="text" name="userName"/>
        <input type="button" value="提交数据"/>
        </form>
    </body>
</html>