<%@ page language="java" pageEncoding="GBK" contentType="text/html;charset=GBK"%>
<%@ include file="includes/common.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<link rel="stylesheet" type="text/css" href="css/login.css"  >
<title>用户行为分析推荐平台</title>
<script type="text/javascript">
if ( window.parent.frames.length!=0 )
	{
		window.parent.location.href= "<c:url value='/'/>";
	}
$(document).ready(function(){
	$('#j_username').focus();
});
</script>
</head>
<body>
<div id="wrap">
		<table height="100%" width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td>
					<div id="loginHead">
						<div id="powerBy"></div>
					</div>
				</td>
			</tr>
			<tr>
				<td height="100%" id="loginBody">
				  <div>
				       <div>
						<table width="100%" border="0" height="100%">
							<tbody>
							<tr>
								<td id="loginImage" width="100%" align="center" style="width:55%; padding-bottom:60px;">
									<div></div>
								</td>
								<td id="loginFormCont">
									  <table border="0" cellpadding="5" cellspacing="2">
											<tbody>
											<form name="loginForm" action="login.do?method=login" method="post">
											<x27:token/>
												<tr>
											  <td colspan="2" style="padding-right:5px;font-size:12px;">
											  </td>
											  </tr>
											<tr>
												<td nowrap><label style="color: white">用户名:</label></td>
												<td><input type='text' id='j_username' name='j_username' value="${account}"></td>
												<c:if test="${iserror!=4}"><td><font color="white">${errormessage}</font></td></c:if>
											</tr>
											<tr>
												<td><label style="color: white">密　码:</label></td>
												<td><input type='password' id='j_password' name='j_password'></td>
												<c:if test="${iserror==4}"><td><font color="white">${errormessage}</font></td></c:if>
											</tr>
											<tr>
												<td colspan="2" style="padding-top:20px;"><input name="image" type="image" id="buttLogin" style="width:222px;height:41px;border:0px"  src="images/login.gif" border="0" tppabs="images/login.gif"/></td>
											</tr>
											</form>
											</tbody>
											
										</table>
								</td>
							</tr>
							</tbody>
						</table>
				     </div>
				  </div>
				</td>
			</tr>
			<tr>
				<td>
					<div id="loginFoot">
						<div id="copyright"></div>
					</div>
				</td>
			</tr>
		</table>
</div>

</body>
</html>