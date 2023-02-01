<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entity.User,java.util.*,java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


</head>
<body>
<%

User user=(User)session.getAttribute("loggedinuser");
	%>
<form action="" method="">
		Enter uid : <input type="text" name="uname" value="<%=user.getUid()%>"/> 
		<br/>
		Enter pwd : <input type="password" name="pswd" value="<%=user.getPwd()%>"/>
		<br/>
		Enter fname: <input type="text" name="fname" value="<%=user.getFname()%>" />
		<br/>
		Enter mname: <input type="text" name="mname" value="<%=user.getMname()%>"       />
		<br/>
		Enter lname: <input type="text" name="lname" value="<%=user.getLname()%>"  />
		<br/>
		Enter email: <input type="text" name="email" value="<%=user.getEmail()%>"/>
		<br/>
		Enter contact: <input type="contacts" name="contact" value="<%=user.getContact()%>"   />
		<br/>
		<input type="submit" value="update" onclick="update()"/>
	</form>
	<a href="/update"></a>
</body>
</html>