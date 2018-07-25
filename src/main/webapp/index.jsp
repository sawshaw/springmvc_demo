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
        $(document).ready(function() {
            $.ajax({
                url: "hello/greeting"
            }).then(function(data) {
            	var obj=JSON.parse(data);
            	console.log(obj.id);
               $('.greeting-id').append(obj.id);
               $('.greeting-content').append(obj.content);
            });
        });
        </script>
    </head>

    <body>
        <div>
            <p class="greeting-id">The ID is </p>
            <p class="greeting-content">The content is </p>
        </div>
    </body>
</html>