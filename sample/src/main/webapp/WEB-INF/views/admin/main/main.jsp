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
<div class="wrap" style="width: 1024px;margin: 0 auto">
	<div class="_header" style="border: solid 1px #000;background: #422700">
		<div class="_topper" style="overflow: hidden;">[TOP]</div>
	</div>
	<div class="_nav" style="clear: both;overflow: hidden;border-bottom: solid 1px #ccc;background-color: #fff">
		<ul>
			<li>[MENU1]</li>
			<li>[MENU2]</li>
			<li>[MENU3]</li>
			<li>[MENU4]</li>
			<li>[MENU5]</li>
		</ul>
	</div>
	<div class="_container">
		<div class="_aside" style="float: left;">
			<ul>
				<li>[SUB1]</li>
				<li>[SUB2]</li>
				<li>[SUB3]</li>
				<li>[SUB4]</li>
				<li>[SUB5]</li>
			</ul>
		</div>
		<div class="_section" style="float: left;">[MAIN]</div>
	</div>
	<div class="_footer" style="clear: both;">Copyright</div>
</div>
<div class="_loading" style="display: none;position: fixed;left:0;right:0;top:0;bottom:0;background: rgba(0,0,0,0.2);z-index: 100;">
	<div style="position: fixed;top: 50%;left: 50%;margin-left: -25px;margin-top: -25px;width: 50px; height: 50px;">
		<img src="/images/loading32.gif" alt="대기중..." style="width: 50px; height: 50px;">
	</div>
</div>
<div class="_layer_popup" style="display: none;position: fixed;left:0;right:0;top:0;bottom:0;background: rgba(0,0,0,0.2);z-index: 99;">
</div>
</body>
</html>