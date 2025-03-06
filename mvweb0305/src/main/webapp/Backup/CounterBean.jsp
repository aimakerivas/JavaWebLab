<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bean Counter</title>
</head>
<body>
	<H1>Using Beans and Session/Application Scope</H1>
	<!-- <jsp.useBean id="bean1" class="bean.CounterBean" scope="application"> -->
	<!-- <jsp.useBean id="bean1" class="bean.CounterBean" scope="request"> -->
	<jsp:useBean id="bean1" class="beans.CounterBean" scope="session" />
	<jsp:useBean id="bean2" class="beans.CounterBean" scope="application" />

	

	 <%
	 bean1.setCounter(bean1.getCounter()+1);
	 bean2.setCounter(bean2.getCounter()+1);
	 %>
	 
	Session Counter: ${sessionScope.bean1.counter}  <BR/>
	Application Counter: ${applicationScope.bean2.counter} <BR/>
	
</body>
</html>