<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ include file="includes/common.jsp"%>
<%@ page import="net.ufida.info.common.listener.SessionListener" %>

<html>
<head>
<title>XTree (with Velocity) Example</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link rel="stylesheet" type="text/css" media="screen"
	href="css/menuExpandable.css" />

<script type="text/javascript" src="js/menuExpandable.js"></script>

</head>
<body class="SysMenuContainer">
<div>
<ul class="menuList">
		<li class="menubar"><a href="#" id="himenu1Actuator" class="actuator">相似度数据分析</a>
		<ul id="himenu1Menu" class="submenu">
			<li><a href="userCf.do?method=process" title="UserCF" target="main">基于用户的CF</a></li>
			<li><a href="productCf.do?method=process" title="productCF" target="main">基于商品内容的CF</a></li>
			<li><a href="slopeOne.do?method=process" title="SlopeOne" target="main">基于slogeOne推荐</a></li>
		</ul>
		</li>
		
		<li class="menubar"><a href="#" id="himenu5Actuator" class="actuator">相似度计算数据模型</a>
		<ul id="himenu5Menu" class="submenu">
			<li><a href="topic.do?method=add_view" title="基于 Tanimoto 系数计算相似度"
				target="main">基于 Tanimoto 系数</a></li>
			<li><a href="topic.do" title="基于欧几里德距离计算相似度"
				target="main">基于欧几里德距离</a></li>
			<li><a href="topic_class.do" title="基于皮尔逊相关系数计算相似度"
				target="main">基于皮尔逊相关系数</a></li>
		</ul>
		</li>
	</ul>
</div>
</body>
</html>

