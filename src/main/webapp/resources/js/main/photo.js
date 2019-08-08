var photo = {
    init : function () {
        var _this = this;
		
        //앨범추가 
        $("#btn_add_album").on("click", function(){
        	if(album_check_field){
        		if(confirm('새앨범을 추가 하시겠습니까?')){
        			var data = {
			            album_name: $('#album_name').val(),
			            reg_id: ${sessionScope.login_id}
			        };
			        $.ajax({
			            type: 'POST',
			            url: '/addAlbum',
			            dataType: 'json',
			            contentType:'application/json; charset=utf-8',
			            data: JSON.stringify(data)
			        }).done(function(result) {
			        	if(result==1){
			        		alert("앨범을 추가했습니다.");
			        		location.href="/photoWrite";
			        	}else{
			        		alert("에러발생! 관리자에게 문의하세요.");
			        	}
			        }).fail(function (error) {
			        	alert(error);
			        	alert("에러발생! 관리자에게 문의하세요.");
					});
				}
        	}
        });
        
    },
    save : function () {
    	
        		
    }
};

photo.init();

//밸리데이션 체크 - 앨범추가
function album_check_field(){	
	if($("#add_album_name").val()==""){
		alert("추가할 앨범이름을 입력해주세요.");
		$("#add_album_name").focus();
		return false;	
	}else{
		return true;
	}
}

