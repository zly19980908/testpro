/*遍历所有单元数*/
function getUnitNum(){
	var unit_num_group=[];
	var num_unit=$('.num-unit');
	num_unit.each(function(index){
		unit_num_group.push($(this).text());
	});
}

/*重置所有单元数*/
function resetUnitNum(){
	var num_unit=$('.num-unit');
	num_unit.each(function(index){
		$(this).text(index+1);
	});
}

/*遍历所有课时数*/
function getPartNum(){
	var part_num_group=[];
	var num_part=$('.part_num_xixi');
	num_part.each(function(index){
		part_num_group.push($(this).text());
	});
}

/*重置所有课时数*/
function resetPartNum(){
	alert("调用了重置课时函数");
	var num_part=$('.part_num_xixi');
	num_part.each(function(index){
		$(this).text(index+1);
	});
}

$(function(){
//	resetUnitNum();
//	resetPartNum();
//	getUnitNum();
//	getPartNum();
});