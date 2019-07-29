function return_num(str){
	var num;
	num = str.replace(/[^0-9]/g,"");
	return num;
}