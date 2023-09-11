<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- 웹 페이지에서 버튼을 누르면 Python 코드가 실행되게 -->
	<form action="http://172.30.1.86:5000/form">
		DATA1 : <input name="data1" type="text"><br>
		DATA2 : <input name="data2" type="text"><br>
		
		<button type="submit">전송</button>
	</form>
	
	<button id="ajaxBtn">Ajax</button>
	
	<script src="assets/js/jquery.min.js"></script>
	<script type="text/javascript">
	
		$(document).ready(()=>{ // ()=> 와 function() 은 같다!
			
			$('#ajaxBtn').on('click',flask);
		});
		
		function flask(){
			
			$.ajax({
				
				url : 'http://172.30.1.86:5000/ajax',
				type : 'get',
				
				success : function(res){
					
					console.log('res');
				},
				
				error : function(){
					console.log('error!!');
				}
			});
		}
		
	</script>
</body>
</html>