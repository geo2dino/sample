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
<meta name="format-detection" content="telephone=no">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi">
<meta http-equiv="Content-Type" content="application/xhtml+xml; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta http-equiv="Imagetoolbar" content="no" />
<title>mobile</title>
<link rel="stylesheet" type="text/css" href="/css/mobile/common.css"/>
<script type="text/javascript" src="/js/lib/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/js/common.js"></script>
<script type="text/javascript" src="/js/mobile/common.js"></script>
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