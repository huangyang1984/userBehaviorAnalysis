$.format = function(source, params) {
	if ( arguments.length == 1 ) 
		return function() {
			var args = $.makeArray(arguments);
			args.unshift(source);
			return $.format.apply( this, args );
		};
	if ( arguments.length > 2 && params.constructor != Array  ) {
		params = $.makeArray(arguments).slice(1);
	}
	if ( params.constructor != Array ) {
		params = [ params ];
	}
	$.each(params, function(i, n) {
		source = source.replace(new RegExp("\\{" + i + "\\}", "g"), n);
	});
	return source;
};
function addType(id,typeid){
    location.href="disease.do?method=add_disease_type&diseaseId="+id+"&typeid="+typeid ;
}
function delDisAsssitRef(id,fid,index){
	if(confirm("您确认要删除该数据吗？")){
		$.getJSON("disease.do?method=deleteDiseaseAssistRef", {disease_assist_id:fid,disease_assist_ref_id:id,t:new Date().getTime()}, function(data){
			if(data.flag == "1"){
    			alert("删除成功!") ;
    			$('#infoTable'+index).remove() ;
    		}else{
    			alert("删除失败!") ;
    		}
		}); 
	}
}

function delDrugGoodsRef(id,did){
	if(confirm("你确定要删除该商品吗?")){
		$.getJSON("drug.do?method=deleteDrugGoodsRef",{drugId:did,dgruId:id,t:new Date().getTime()},function(data){
			if(data.flag == "1"){
    			alert("删除成功!") ;
    		}else{
    			alert("删除失败!") ;
    		}
		});
	}
}

function delAreaContentLink(id){
	if(confirm("您确认删除该关联数据吗？")){
		$.getJSON("area_define.do?method=deleteAreaContentLink", {areaContentLinkId:id,t:new Date().getTime()}, function(data){
			if(data.flag != "1"){
    			alert("删除失败!");
    		}
		}); 
	}
}

function makeHtml(url){
	if(confirm("您确认生成静态页面吗？")){
		$.getJSON(url, {t:new Date().getTime()}, function(data){
			if(data == true){
    			alert("生成成功!");
    		} else {
    			alert("生成失败!");
    		}
		}); 
	}
}
