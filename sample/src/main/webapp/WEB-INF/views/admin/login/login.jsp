<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fc" uri="/WEB-INF/tld/fc.tld" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="_csrf" content="${_csrf.token }">
<meta name="_csrf_header" content="${_csrf.headerName }">
<title>admin</title>
<link rel="stylesheet" type="text/css" href="/css/common.css"/>
<link rel="stylesheet" type="text/css" href="/css/admin/common.css"/>
<script type="text/javascript" src="/js/lib/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/js/common.js"></script>
<script type="text/javascript" src="/js/admin/common.js"></script>
<script type="text/javascript">
//<![CDATA[
$(document).ready(function() {
	
});
//]]>	
</script>
</head>
<body>
<div class="wrap">
<form action="login_proc" method="post">
<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
<br>아 이 디 : <input type="text" id="login_id" name="id">
<br>비밀번호 : <input type="text" id="login_pw" name="pw">
<br><input type="submit" id="login_btn" value="로그인">	
</form>
</div>
</body>
</html>