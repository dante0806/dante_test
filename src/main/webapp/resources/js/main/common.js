function return_num(str){
	var num;
	num = str.replace(/[^0-9]/g,"");
	return num;
}

function go_query_test(){
	window.open("../resources/test/query.html", "1000","500");
}