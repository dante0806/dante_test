<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<jsp:include page="../template/header.jsp"></jsp:include>
<html class="no-js">
	<style type="text/css">
		
		
		
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
            
            <div class="top-title-wrapper">
            	<div class="container">
                	<div class="row">
                    	<div class="col-md-12 col-sm-12">
                        	<div class="page-info">
                            	<h1 class="h1-page-title">게시판</h1>
								<h2 class="h2-page-desc">글쓰기</h2>
									
                                <!-- BreadCrumb -->
                                <div class="breadcrumb-container">
                                	<ol class="breadcrumbs">
                                    	<li>
                                        	<a href="/">Home</a>
                                        </li>
                                        <li>
                                        	<a href="/boardList">글목록</a>
                                        </li>
                                        <li class="active">글쓰기</li>
                                    </ol>
                                </div>
                                <!-- BreadCrumb -->
                            </div>
                        </div>
                    </div>
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
                                	<c:if test="${!empty board}">
										<input type="hidden" name="board_id" id="board_id" value="${board.id}">
                                		<c:if test="${sessionScope.login_id eq board.user_id}">
											<input type="button" class="btn btn-primary" value="수정" id="btn_modify_board">
											<input type="button" class="btn btn-primary" value="삭제" id="btn_del_board" style="background-color: red;">
                                		</c:if>
									</c:if>
                                	<input type="button" value="목록" id="btn_board_list">
                                </div>
                                    <form class="form-horizontal" name="boardForm" id="boardForm" role="form" method="POST">
                                    	<input type="hidden" name="user_id" id="user_id" 
                                    		value="<sec:authorize access="isAuthenticated()"><sec:authentication property='principal.username'/></sec:authorize>">
                                    	<c:if test="${!empty board}">
											<div align="right">등록 일시 : <tf:formatDateTime value="${board.reg_dt}" pattern="yyyy-MM-dd HH:mm:ss"/></div>
											<div align="right">마지막 수정 일시 : <tf:formatDateTime value="${board.upd_dt}" pattern="yyyy-MM-dd HH:mm:ss"/></div>
										</c:if>                                    					
                                    	<table class="type11">
                                    		<colgroup>
                                    			<col width="10%">
                                    			<col width="*">
                                    		</colgroup>
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
										</div>
                                    </form>
                                    <c:if test="${!empty board}">
	                                    <div>
	                                    	<form action="/regBoardReply">
		                                    	<table class="type11">
		                                    		<colgroup>
		                                    			<col width="10%">
		                                    			<col width="*">
		                                    			<col width="10%">
		                                    		</colgroup>
		                                    		<tr>
		                                    			<th align="center" style="background-color: #E7708D;">댓글</th>
		                                    			<td>
					                                    	<textarea name="board_reply_content" id="board_reply_content" rows="3" cols="60" style="resize: none;" ></textarea>
		                                    			</td>
		                                    			<td style="vertical-align: middle;">
		                                    				<input type="button" id="btn_reg_board_reply" value="등록" style="background-color: #E7708D;">
		                                    			</td>
		                                    		</tr>
		                                    	</table>
	                                    	</form>
	                                    </div>                    
                                    </c:if>
                                    <c:if test="${!empty boardReplyList}">
                                   		<div>
                                    		<table class="type12">
                                    			<colgroup>
                                    				<col width="10%">
                                    				<col width="*">
                                    				<col width="15%">
                                    				<col width="10%">
                                    			</colgroup>
                                    			<c:forEach items="${boardReplyList}" var="boardReplyList">
	                                    			<tr>
	                                    				<td align="center">${boardReplyList.user_id}</td>
	                                    				<td>${boardReplyList.board_reply_content}</td>
	                                    				<td align="center"><tf:formatDateTime value="${boardReplyList.reg_dt}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	                                    				<td align="center">
	                                    					<c:if test="${boardReplyList.user_id eq sessionScope.login_id}">
	                                    						<input type="button" value="댓글삭제" style="padding: 0;" onclick="javascript:del_board_reply('${boardReplyList.id}');">
	                                    					</c:if>
	                                    				</td>
	                                    			</tr>
                                    			</c:forEach>
                                    		</table>
                                   		</div>
                                    </c:if>	
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

