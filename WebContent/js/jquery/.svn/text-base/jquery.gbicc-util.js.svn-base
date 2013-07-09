/*********************************************
 ************* 获取被选择的checkbox的值*********
 *@param single: 是否是一个被选中 布尔值 
 */
function getSelectCheckbox(single) {
    var checkedItems = $('[type=checkbox][@name=items]:checkbox:checked');
    if (single == true && checkedItems.length != 1) {
        alert('有且仅有一个选项被选择!');
        return '';
    } else if (single == false && checkedItems.length == 0) {
    	alert('请选择需要删除的数据!');
        return '';
    } else {
        var ids = '';
        $('[type=checkbox]:checkbox:checked').each(function(){
                if (ids != '') {
                    ids = ids + ',' + $(this).val();
                } else {
                    ids = $(this).val();;
                }
        });
        
        return ids;
    }
}

/**
 * 
 */
function checkBoxSelectAll(){
	var selectAll = $('#chkAll').attr("checked");
	$("input[type=checkbox][@name=items]").each(function(){
		$(this).attr("checked", selectAll);
	});         
}
