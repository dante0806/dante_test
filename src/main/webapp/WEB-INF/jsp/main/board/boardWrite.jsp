<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<jsp:include page="../template/header.jsp"></jsp:include>
<html class="no-js">
	<style type="text/css">
		table.type11 {
		    border-collapse: separate;
		    border-spacing: 1px;
		    text-align: center;
		    line-height: 1.5;
		    margin: 20px 10px;
		}
		table.type11 th {
		    padding: 10px;
		    font-weight: bold;
		    vertical-align: middle;
		    text-align:center;
		    color: #fff;
		    background: #3399CC ;
		}
		table.type11 td {
		    padding: 10px;
		    vertical-align: top;
		    border-bottom: 1px solid #ccc;
		    background: #eee;
		}
		input.text {
		    font-size: 9pt;
		    text-align: left;
		    border: 1 solid #acacac;
		    background-color: #ffffff;
		    font-family: DOTUM;
		    color: #303030;
		}
		.input {
		    height: 24px;
		    border-radius: 2px;
		    border: 1px solid #929292;
		    margin: 3px 0px;
		}
	</style>
	<script type="text/javascript">
	</script>
    <body>
        <div id="wrapper"  >
            <div class="loading-container">
                <div class="spinner">
                    <div class="double-bounce1"></div>
                    <div class="double-bounce2"></div>
                </div>
            </div>
            <div class="content-wrapper hide-until-loading">
            	<div class="body-wrapper">
            		<div class="container">
                    	<div class="row">
                        	<div class="col-md-12 col-sm-12 animated" data-animtype="flipInY"
                            	 data-animrepeat="0"
                             	data-speed="1s"
                             	data-delay="0.5s">
                        		<h2 class="h2-section-title">게시판</h2>
                            	<div class="i-section-title">
                                	<i class="fa fa-table">
                                	</i>
                            	</div>
                            	<div class="space-sep20"></div>
                        	</div>            
                    	</div>
                        <div class="row">
                            <div class="col-md-12 col-sm-12 centered">
                                <div class="classic-form">
                                <div align="right">
                                	<input type="button" value="목록" id="btn_board_list">
                                </div>
                                    <form class="form-horizontal" name="boardForm" id="boardForm" role="form" action="/regBoard" method="POST">
                                    	<input type="hidden" name="user_id" id="user_id" 
                                    		value="<sec:authorize access="isAuthenticated()">
                                    						<sec:authentication property='principal.username'/>
                                    					</sec:authorize>">                                    	
                                    	<c:if test="${!empty board}">
											<div align="right">등록 일시 : <tf:formatDateTime value="${board.reg_dt}" pattern="yyyy-MM-dd HH:mm:ss"/></div>
											<div align="right">마지막 수정 일시 : <tf:formatDateTime value="${board.upd_dt}" pattern="yyyy-MM-dd HH:mm:ss"/></div>
										</c:if>                                    					
                                    	<table class="type11">
										    <thead>
										    	<tr>
										    		<th colspan="2">글쓰기</th>
										    	</tr>
										    </thead>
										    <tbody>
										    <tr>
										        <th>제목</th>
										        <td>
										        	<input type="text" class="text input" name="board_title" id="board_title"
										        		value="<c:if test="${!empty board}">${board.board_title}</c:if>">
										        </td>
										    </tr>
										    <tr>
										        <th>내용</th>
										        <td>
										        	<textarea name="board_content" id="board_content" rows="20" cols="60" style="resize: none;" ><c:if test="${!empty board}">${board.board_content }</c:if></textarea>
										        </td>
										    </tr>
										    </tbody>
										</table>
										<div align="center" style="padding-left: 20px;">
										<c:if test="${empty board}">	
											<input type="button" class="btn btn-block btn-primary" value="등록" id="btn_reg_board" style="background-color: #E7708D;">
										</c:if>
										<c:if test="${!empty board}">
											<input type="hidden" name="board_id" id="board_id" value="${board.id}">
											<input type="button" class="btn btn-primary" value="수정" id="btn_modify_board">
											<input type="button" class="btn btn-primary" value="삭제" id="btn_del_board" style="background-color: red;">
										</c:if>	
										</div>
                                    </form>                    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--.content-wrapper end -->
		</div>
		<script src="../resources/js/main/board.js"></script>
    </body>
</html>
<jsp:include page="../template/footer.jsp"></jsp:include>

