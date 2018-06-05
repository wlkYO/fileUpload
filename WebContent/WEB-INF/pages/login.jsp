<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>Bootstrap 101 Template</title>

<!-- Bootstrap -->
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="<%=path%>/dist/ladda-themeless.min.css">
<link rel="stylesheet" href="<%=path%>/css/prism.css">
<!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
<!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<style>
#forms {
	width: 300px;
	margin: 150px auto;
	border: 1px solid #ccc;
	padding: 10px;
	border-radius: 8px;
}
</style>
</head>
<body>
	<div id="forms">
		<form id="iForm" encType="multipart/form-data">
			<div class="form-group">
				<label for="exampleInputEmail1">请选择：</label> <input id="file"
					type="file" name="file" class="form-control"
					id="exampleInputEmail1" placeholder="Email">
			</div>


		</form>
		<button id="btn" class="btn btn-info ladda-button"
			data-style="zoom-in">
			<span class="ladda-label">文件上传 </span>
		</button>
	</div>



	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
	<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
	<script
		src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="<%=path%>/dist/spin.min.js"></script>
	<script src="<%=path%>/dist/ladda.min.js"></script>
	<script>
		~function() {
			Ladda.bind('div:not(.progress-demo) button', {
				timeout : 2000
			});
			// Bind progress buttons and simulate loading progress
			Ladda.bind('.progress-demo button', {
				callback : function(instance) {
					var progress = 0;
					var interval = setInterval(function() {
						progress = Math.min(progress + Math.random() * 0.1, 1);
						instance.setProgress(progress);
						if (progress === 1) {
							instance.stop();
							clearInterval(interval);
						}
					}, 200);
				}
			});
		}();

		$("#btn").click(function() {

			var formData = new FormData($("#iForm")[0]);
			$.ajax({
				url : 'upload',
				type : 'POST',
				data : formData,
				async : false,
				cache : false,
				contentType : false,
				processData : false,
				success : function(d) {
					console.log(d);
				},
				error : function(d) {
					alert(d);
				}
			});

		});
	</script>
</body>
</html>