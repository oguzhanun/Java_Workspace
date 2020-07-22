<!DOCTYPE html>
<html>


	<head>
		<title>Hello World -- Input Form</title>
	</head>

	<body>
	
		<!--  action a yazılan ifadenin başında / işareti konursa base url ye kadar siliniip action
		ifadesi ekleniyor ve bu şekilde form işleniyor. Ama / işareti konmazsa son mapping teki ifade
		sadece değiştiriliyor. -->
		<form action="processFormVersionThree" method="GET">
				<input type="text" name="studentName" placeholder="What's your name?"/>
				<input type="submit">
		</form>
		
	</body>

</html>