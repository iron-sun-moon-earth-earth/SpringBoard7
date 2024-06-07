<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8" %>

<%@ include file="include/header.jsp" %>

<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<input type="button" value="버튼" class="btn-lg btn-success">

<button type="button" class="btn btn-block btn-danger btn-xs">Danger</button>

<a class="btn btn-block btn-social btn-github">
<i class="fa fa-github"></i> Sign in with GitHub
</a>

<%@ include file="include/footer.jsp" %>

