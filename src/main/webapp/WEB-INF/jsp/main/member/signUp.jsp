<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<jsp:include page="../template/header.jsp"></jsp:include>
<style>
<!--
.important{	color:#FF0000;		}
-->
</style>
<html class="no-js">
<script type="text/javascript">
//회원등록 
function go_reg_mem(){
	if(check_field()){
		alert("asd");
	}
}

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



</script>	
    <body>
        <div id="wrapper"  >
            <div class="loading-container">
                <div class="top-title-wrapper">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-12 col-sm-12">
                                <div class="page-info">
                                    <h1 class="h1-page-title">Sign Up</h1>
                                    <!-- BreadCrumb -->
                                    <div class="breadcrumb-container">
                                        <ol class="breadcrumbs">
                                            <li>
                                                <a href="">Home</a>
                                            </li>
                                            <li class="active">회원가입</li>
                                        </ol>
                                    </div>
                                    <!-- BreadCrumb -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--.top wrapper end -->
            <div class="loading-container">
                <div class="spinner">
                    <div class="double-bounce1"></div>
                    <div class="double-bounce2"></div>
                </div>
            </div>
            <div class="content-wrapper hide-until-loading"><div class="body-wrapper">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-12 col-sm-12 animated" data-animtype="flipInY"
                                 data-animrepeat="0"
                                 data-speed="1s"
                                 data-delay="0.5s">
                                <h2 class="h2-section-title">회원가입</h2>
                                <div class="i-section-title">
                                    <i class="icon-users-outline">
                                    </i>
                                </div>
                                <div class="space-sep20"></div>
                            </div>            
                        </div>
                       	<div class="col-md-6 col-sm-6 centered" style="text-align: right; margin-bottom: 5px;">
                       		<span class="important"> * </span>는 필수입력사항 입니다.
                       	</div>
                        <div class="row">
                            <div class="col-md-6 col-sm-6 centered">
                                <div class="classic-form">
                                    <form class="form-horizontal" role="form" novalidate>
                                    	<div class="form-group">
                                            <label for="mem_id" class="col-sm-3 control-label"><span class="important"> * </span>아이디</label>
                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" id="mem_id" name="mem_id" placeholder="아이디">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="mem_nm" class="col-sm-3 control-label"><span class="important"> * </span>이름</label>
                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" id="mem_nm" placeholder="이름">
                                            </div>
                                        </div>                                        
                                        <div class="form-group">
                                            <label for="mem_pw" class="col-sm-3 control-label"><span class="important"> * </span>비밀번호</label>
                                            <div class="col-sm-9">
                                                <input type="password" class="form-control" id="mem_pw" name="mem_pw" placeholder="비밀번호">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="mem_pw_re" class="col-sm-3 control-label"><span class="important"> * </span>비밀번호 확인</label>
                                            <div class="col-sm-9">
                                                <input type="password" class="form-control" id="mem_pw_re" placeholder="비밀번호 확인">
                                            </div>
                                        </div>
                                        <div class="form-group" style="margin-bottom: 0;">
                                            <label for="mem_addr" class="col-sm-3 control-label">주소</label>
                                            <div class="col-sm-4">
                                            	<input type="button" value="우편번호 찾기">
                                            </div>
                                            <div class="col-sm-1"></div>
                                            <div class="col-sm-5">
                                                <input type="text" class="form-control" id="mem_addr" placeholder="우편번호" disabled="disabled">
                                            </div>
                                       	</div>
										<div class="form-group" style="margin-bottom: 5px;">	
                                            <div class="col-sm-3"></div>
                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" id="mem_addr" placeholder="우편번호 찾기 사용" disabled="disabled">
                                            </div>
                                        </div>    
                                        <div class="form-group">    
                                            <div class="col-sm-3"></div>
                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" id="mem_addr" placeholder="나머지주소">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="mem_phone" class="col-sm-3 control-label">연락처</label>
                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" id="mem_phone" placeholder="연락처">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-offset-3 col-sm-9">
                                                <div class="checkbox">
                                                    <label>
                                                        <input type="checkbox" id="check_agree"><a href="#" class="skin-text">개인정보 수집·이용</a>에 동의합니다.
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-offset-3 col-sm-9">
                                                <button type="button" class="btn btn-block btn-primary" onclick="go_reg_mem();">회원가입</button>
                                            </div>
                                        </div>
                                    </form>                    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--.content-wrapper end -->
		</div>
    </body>
</html>
<jsp:include page="../template/footer.jsp"></jsp:include>
