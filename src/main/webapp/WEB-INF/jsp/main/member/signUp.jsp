<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<jsp:include page="../template/header.jsp"></jsp:include>
<html class="no-js">
<script type="text/javascript">

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
                        <div class="row">
                            <div class="col-md-6 col-sm-6 centered">
                                <div class="classic-form">
                                    <form class="form-horizontal" role="form" novalidate>
                                    	<div class="form-group">
                                            <label for="id" class="col-sm-3 control-label">아이디</label>
                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" id="id" name="id" placeholder="아이디">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="name" class="col-sm-3 control-label">이름</label>
                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" id="name" placeholder="이름">
                                            </div>
                                        </div>                                        
                                        <div class="form-group">
                                            <label for="password" class="col-sm-3 control-label">비밀번호</label>
                                            <div class="col-sm-9">
                                                <input type="password" class="form-control" id="password" name="password" placeholder="비밀번호">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="rptpassword" class="col-sm-3 control-label">비밀번호 확인</label>
                                            <div class="col-sm-9">
                                                <input type="password" class="form-control" id="rptpassword" placeholder="비밀번호 확인">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-offset-3 col-sm-9">
                                                <div class="checkbox">
                                                    <label>
                                                        <input type="checkbox"><a href="#" class="skin-text">개인정보 수집·이용</a>에 동의합니다.
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-offset-3 col-sm-9">
                                                <button type="submit" class="btn btn-block btn-primary">회원가입</button>
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
