var signup = {
    init : function () {
        var _this = this;
        $('#reg_member').on('click', function () {
        	if(check_field()){
        		_this.save();
        	}
        });
    },
    save : function () {
        var data = {
            username: $('#mem_id').val(),
            password: $('#mem_pw').val(),
            mem_nm: $('#mem_nm').val(),
            mem_addr: $('#mem_addr').val(),
            mem_phone: $('#mem_phone').val(),
            mem_auth1: "1",
            mem_type:"1",
            use_yn:"Y"
        };

        $.ajax({
            type: 'POST',
            url: '/regMember',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('회원가입 되었습니다.');
            location.reload();
        }).fail(function (error) {
        	alert("에러발생! 관리자에게 문의하세요.");
            alert(data);
        });
    }

};

signup.init();

//밸리데이션 체크
function check_field(){	
	if($("#mem_id").val()==""){
		alert("아이디를 입력해주세요.");
		$("#mem_id").focus();
		return false;	
	}
	if($("#mem_nm").val()==""){
		alert("이름을 입력해주세요.");
		$("#mem_nm").focus();
		return false;
	}
	if($("#mem_pw").val()==""){
		alert("비밀번호를 입력해주세요.");
		$("#mem_pw").focus();
		return false;
	}
	if($("#mem_pw_re").val()==""){
		alert("비밀번호 확인을 입력해주세요.");
		$("#mem_pw_re").focus();
		return false;
	}
	if($("#mem_pw").val()!=$("#mem_pw_re").val()){
		alert("비밀번호가 서로 다릅니다. 비밀번호를 확인해주세요.");
		$("#mem_pw_re").focus();
		return false;
	}
	if(!$("#check_agree").is(":checked")){
		alert("개인정보 수집·이용에 동의해주세요.");
		$("#check_agree").focus();
		return false;
	}
	return true;
}