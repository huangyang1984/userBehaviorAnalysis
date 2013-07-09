<%@ page language="java" pageEncoding="GBK" contentType="text/html;charset=GBK"%>
<%@ include file="/includes/common.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK"/>
<title>用户行为分析推荐平台</title>
<link rel="stylesheet" type="text/css" href="styles/bluewithstyle/css/style.css"/>
</head>
<body>
<form id="slopeOneComputer" name="slopeOneComputer" method="post" action="slopeOne.do?method=computerWithSlopeOne" onsubmit="return check()">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
		<td width="120" class="SearchTableTop">查询条件</td>
		<td >&nbsp;</td>
		<td width="15">&nbsp;</td>
		<td width="64"></td>
		<td width="15">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="10" height="1"></td>
		</tr>
      </table>
      <td valign="top" class="SearchForm">
		  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="SearchTable">
	        <tr>
		  	  <td class="SearchTableLabel">客户号:<input type="text" name="userId" id="userId" style="width:100px" class="SearchTableDataText"/></td>
		  	  <td class="SearchTableLabel">商品分类:
			  	  <select name="catId" id="catId" >
			  	    <option value="0" selected="selected">全部</option> 
			  	    <option value="1" >笔记本专区</option> 
	                <option value="67">GPS导航仪</option> 
	                <option value="69">数码相机</option>
	                <option value="70">电子电玩</option>
	                <option value="76">手机通讯</option>
	                <option value="157">配件专区</option>
	                <option value="159">沃.联通3G靓号</option>
	                <option value="164">MP3</option>
	                <option value="172">IT设备</option>
	                <option value="173">办公用品</option>
	                <option value="174">营销物资</option>
	                <option value="194">充值卡</option>
	              </select>
             </td>
		  	  <td class="SearchTableLabel">优先推荐记录数:</td>
		  	  <td><input type="text" name="count" id="count" style="width:100px" class="SearchTableDataText" /></td>
		  	  <td width="64"><input type="submit" value="查询" class="button1" /></td>
		  	</tr>
		  </table>
     </td>		  
</form>

    <td valign="top" class="ListTableBody">
	    <table width="100%" border="0" cellspacing="0" cellpadding="0">
             <tr>
               <td width="10%" class="ListTableBodyLabel">商品编号</td>
			   <td width="35%" class="ListTableBodyLabel">商品名称</td>
			   <td width="20%" class="ListTableBodyLabel">商品分类</td>
               <td width="25%" class="ListTableBodyLabel">优先级指数</td>
             </tr>
             <c:forEach var="computerList" items="${rsList}" varStatus="var">
             <tr>
             	<td class="ListTableBodyData">${computerList.productId}&nbsp;</td>
             	<td class="ListTableBodyData">${computerList.goodsName}&nbsp;</td>
             	<td class="ListTableBodyData">${computerList.catName}&nbsp;</td>
             	<td class="ListTableBodyData">${computerList.priority}&nbsp;</td>
             </tr>
             </c:forEach>
	    </table>
    </td>
</body>

<script type="text/javascript">
<c:if test="${flag == 'false'}">
alert("没有该客户对应数据！");
</c:if> 

function check(){
	var userId = document.getElementById("userId").value;
	var count = document.getElementById("count").value;
	if(userId == ""){
		alert("客户号不能为空!");
		return false;
	}else if(count == ""){
		alert("输入相关记录数");
		return false;
	}
	return true;
}

</script>
</html>