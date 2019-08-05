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
			        	if(result==1){
			        		alert("수정되었습니다.");
			        		location.href="/boardList";
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
		
		//글삭제
		$("#btn_del_board").on('click',function(){
			if(confirm('이 게시물의 댓글도 모두 삭제됩니다.\n삭제하시겠습니까?')){
				location.href="/delBoard?board_id="+$("#board_id").val();
			}
		});
		
		//댓글 등록
		$("#btn_reg_board_reply").on('click', function(){
			if(reply_check_field()){
				if(confirm('댓글을 등록 하시겠습니까?')){					
					var data = {
			            board_reply_content: $('#board_reply_content').val(),
			            board_id:$("#board_id").val(), 
			            user_id:$("#user_id").val()
			        };
			        $.ajax({
			            type: 'POST',
			            url: '/regBoardReply',
			            dataType: 'json',
			            contentType:'application/json; charset=utf-8',
			            data: JSON.stringify(data)
			        }).done(function(resultList) {
			        	alert("등록되었습니다.");
			        	window.location.reload();
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

board.init();


//밸리데이션 체크(글등록/글수정)
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
		alert("내용을 입력해주세요.");
		$("#board_content").focus();
		return false;
	}
	return true;
}

//밸리데이션 체크(댓글등록)
function reply_check_field(){	
	if($("#user_id").val()==""){
		alert("로그인 후 등록해주세요.");
		return false;	
	}
	if($("#board_reply_content").val()==""){
		alert("내용을 입력해주세요.");
		$("#board_reply_content").focus();
		return false;
	}
	return true;
}

function del_board_reply(val){
	var id = val;
	if(confirm('댓글을 삭제 하시겠습니까?')){
        $.ajax({
            type: 'POST',
            url: '/delBoardReply',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: id
        }).done(function(result) {
        	if(result==1){
        		alert("삭제되었습니다.");
        		window.location.reload();
        	}else{
        		alert("에러발생! 관리자에게 문의하세요.");
        	}
        }).fail(function (error) {
        	alert(error);
        	alert("에러발생! 관리자에게 문의하세요.");
		});
	}
}
