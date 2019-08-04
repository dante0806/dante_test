var board = {
    init : function () {
        var _this = this;
        
        //글쓰기 페이지
		$('#btn_board_write').on('click', function(){
			location.href='/boardWrite?board_id=';	
		});
		
		//글목록 페이지
		$('#btn_board_list').on('click', function(){
			location.href='/boardList';	
		});
		
		//글등록
		$("#btn_reg_board").on('click', function(){
			if(check_field()){
				if(confirm('등록하시겠습니까?')){
					$("#boardForm").attr("action","/regBoard");
					$("#boardForm").submit();
				}
			}
		});
		
		//글수정
		$("#btn_modify_board").on('click',function(){
			if(check_field()){
				if(confirm('수정하시겠습니까?')){
					
					var data = {
			            board_title: $('#board_title').val(),
			            board_content: $('#board_content').val(),
			            board_id:$("#board_id").val()
			        };
			        $.ajax({
			            type: 'POST',
			            url: '/modifyBoard',
			            dataType: 'json',
			            contentType:'application/json; charset=utf-8',
			            data: JSON.stringify(data)
			        }).done(function(result) {
			        	alert("수정되었습니다.");
			        }).fail(function (error) {
			        	alert("에러발생! 관리자에게 문의하세요.");
					});
				}
			}
		});
		
		//글삭제
		$("#btn_del_board").on('click',function(){
			if(confirm('삭제하시겠습니까?')){
				location.href="/delBoard?board_id="+$("#board_id").val();
			}
		});
		
    },
    save : function () {
    	
        		
    }

};

board.init();


//밸리데이션 체크
function check_field(){	
	if($("#user_id").val()==""){
		alert("로그인 후 등록해주세요.");
		return false;	
	}
	if($("#board_title").val()==""){
		alert("제목을 입력해주세요.");
		$("#board_title").focus();
		return false;
	}
	if($("#board_content").val()==""){
		alert("비밀번호를 입력해주세요.");
		$("#board_content").focus();
		return false;
	}
	return true;
}
