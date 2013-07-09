<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="../../includes/common.jsp"%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="styles/bluewithstyle/css/style.css"  >
</head>
<body>
  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td height="22" class="EditTableHeader">系统错误异常页面</td>
    </tr>
    <tr>
      <td valign="top" class="EditTableBackground">
			  <c:if test="${errMsg != ''}">
			  	<span style="font-size: 12px;">${errMsg}</span>
			  </c:if>
			  <br/>
			  <input name="reback" type="button" id="reback" value="返回" class="Button2" onclick="javascript:history.go(-1)"  >
      </td>
    </tr>
  </table>
</body>
</html>