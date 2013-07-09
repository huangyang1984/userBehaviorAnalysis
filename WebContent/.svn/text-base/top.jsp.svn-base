<%@ page language="java"  pageEncoding="GBK" contentType="text/html;charset=GBK"%>
<%@ page import="net.ufida.info.login.model.SystemUser" %>
<%
SystemUser systemUser = (SystemUser)request.getSession().getAttribute("_login");
String userName = "";
if (systemUser != null) {
	userName = systemUser.getName();
}
%>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<link href="css/top.css" rel="stylesheet" type="text/css" />
</head>

<body>
<table width="100%" height="25" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="25" class="TopBottom"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="TopBottomText">
      <tr>
        <td width="30" align="center"><img src="images/dian.gif" width="12" height="11"  /></td>
        <td align="left">欢迎 【<%= userName %>】 登陆用户行为特征分析平台 </td>
        <td align="right"><a href="index.jsp" target="_parent">[ 首页 ]</a>&nbsp; <a href="login.do?method=loginout" target="_parent">[ 退出 ]</a>&nbsp;&nbsp;</td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>