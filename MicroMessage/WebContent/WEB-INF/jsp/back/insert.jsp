<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%String path=request.getContextPath();
  String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Test</title>
	<style type="text/css">
	   *{
	      margin:0;
	      padding:0;
	      }
	   .wrap{
	      width:600px;
	      border:1px solid red;
	      margin:50px auto;
	      }
	   .wrap li{
	      list-style:none;
	      margin:20px;
	      }
	   .wrap #submit{
	      margin-left:100px;
	      font-size:20px;
	      }
	   .opera{
	      margin-left:200px;
	      }
	   .opera a{
	      font-size:30px;
	      text-decoration:none;
	      color:#900;
	      margin:10px;
	      }
	      </style>
    </head> 
   
    <body>
     <div class="wrap">
        <form id="form" action="<%=basePath %>InsertOne.action" name="form" method="post">
          <ul>
            <li><label>指令名称</label><input name="command" class="command" type="text"></li>
            <li><label>指令描述</label><input name="description" class="description" type="text"></li>
            <li><label>指令内容</label><input name="content" class="contentcontent" type="text"></li>
           </ul>
           <button type="submit" id="submit">提交</button>
   
        <div class="opera">
            <a href="#" class="add" onclick="javascript:add();">加</a>
            <a href="#" class="sub" onclick="javascript:sub();">减</a>
            </div>
            <input type="hidden">
       </form>
            </div>
          
        <script type="text/javascript">
       
        function add(){

			// var form = document.form;
		
			var nodes = document.getElementsByTagName("input");
			var ul = document.getElementsByTagName("ul");
			var li = document.createElement("li");
			li.innerHTML = '<label>指令内容</label><input name="content" class="content" type="text">';
			ul[0].appendChild(li);

			// nodes[nodes.length];
			//<input name="content" class="content" type="text">
		}
		function sub(){
			alert(2);
		}
		</script>
	</body>
</html>