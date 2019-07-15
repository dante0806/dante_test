var signup = {
    init : function () {
        var _this = this;
        alert("asda");
        $('#reg_member').on('click', function () {
        	if(check_field()){
        		$("#regUserForm").submit();
        		//_this.save();
        	}
        });
    },
    save : function () {
    	
        /*var data = {
            username: $('#username').val(),
            password: $('#password').val(),
            user_nm: $('#user_nm').val(),
            user_addr: $('#user_addr').val(),
            user_phone: $('#user_phone').val(),
            roles:"USER",
            use_yn:"Y"
        };*/

        /*$.ajax({
            type: 'POST',
           // url: '/regMember',
            url: '/registration',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('회원가입 되었습니다.');
            location.reload();
        }).fail(function (error) {
        	alert("에러발생! 관리자에게 문의하세요.");
            alert(data);
        });*/
    }

};

signup.init();

//밸리데이션 체크
function check_field(){	
	if($("#username").val()==""){
		alert("아이디를 입력해주세요.");
		$("#username").focus();
		return false;	
	}
	if($("#user_nm").val()==""){
		alert("이름을 입력해주세요.");
		$("#user_nm").focus();
		return false;
	}
	if($("#password").val()==""){
		alert("비밀번호를 입력해주세요.");
		$("#password").focus();
		return false;
	}
	if($("#password_re").val()==""){
		alert("비밀번호 확인을 입력해주세요.");
		$("#password_re").focus();
		return false;
	}
	if($("#password").val()!=$("#password_re").val()){
		alert("비밀번호가 서로 다릅니다. 비밀번호를 확인해주세요.");
		$("#password_re").focus();
		return false;
	}
	if(!$("#check_agree").is(":checked")){
		alert("개인정보 수집·이용에 동의해주세요.");
		$("#check_agree").focus();
		return false;
	}
	return true;
}