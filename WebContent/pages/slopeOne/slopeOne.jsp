<%@ page language="java" pageEncoding="GBK" contentType="text/html;charset=GBK"%>
<%@ include file="/includes/common.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK"/>
<title>�û���Ϊ�����Ƽ�ƽ̨</title>
<link rel="stylesheet" type="text/css" href="styles/bluewithstyle/css/style.css"/>
</head>
<body>
<form id="slopeOneComputer" name="slopeOneComputer" method="post" action="slopeOne.do?method=computerWithSlopeOne" onsubmit="return check()">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
		<td width="120" class="SearchTableTop">��ѯ����</td>
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
		  	  <td class="SearchTableLabel">�ͻ���:<input type="text" name="userId" id="userId" style="width:100px" class="SearchTableDataText"/></td>
		  	  <td class="SearchTableLabel">��Ʒ����:
			  	  <select name="catId" id="catId" >
			  	    <option value="0" selected="selected">ȫ��</option> 
			  	    <option value="1" >�ʼǱ�ר��</option> 
	                <option value="67">GPS������</option> 
	                <option value="69">�������</option>
	                <option value="70">���ӵ���</option>
	                <option value="76">�ֻ�ͨѶ</option>
	                <option value="157">���ר��</option>
	                <option value="159">��.��ͨ3G����</option>
	                <option value="164">MP3</option>
	                <option value="172">IT�豸</option>
	                <option value="173">�칫��Ʒ</option>
	                <option value="174">Ӫ������</option>
	                <option value="194">��ֵ��</option>
	              </select>
             </td>
		  	  <td class="SearchTableLabel">�����Ƽ���¼��:</td>
		  	  <td><input type="text" name="count" id="count" style="width:100px" class="SearchTableDataText" /></td>
		  	  <td width="64"><input type="submit" value="��ѯ" class="button1" /></td>
		  	</tr>
		  </table>
     </td>		  
</form>

    <td valign="top" class="ListTableBody">
	    <table width="100%" border="0" cellspacing="0" cellpadding="0">
             <tr>
               <td width="10%" class="ListTableBodyLabel">��Ʒ���</td>
			   <td width="35%" class="ListTableBodyLabel">��Ʒ����</td>
			   <td width="20%" class="ListTableBodyLabel">��Ʒ����</td>
               <td width="25%" class="ListTableBodyLabel">���ȼ�ָ��</td>
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
alert("û�иÿͻ���Ӧ���ݣ�");
</c:if> 

function check(){
	var userId = document.getElementById("userId").value;
	var count = document.getElementById("count").value;
	if(userId == ""){
		alert("�ͻ��Ų���Ϊ��!");
		return false;
	}else if(count == ""){
		alert("������ؼ�¼��");
		return false;
	}
	return true;
}

</script>
</html>