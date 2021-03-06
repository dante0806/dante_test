<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<jsp:include page="../template/header.jsp"></jsp:include>
<html class="no-js">
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
                                <h2 class="h2-page-desc">글목록</h2>
                                    
                                <!-- BreadCrumb -->
                                <div class="breadcrumb-container">
                                	<ol class="breadcrumbs">
                                    	<li>
                                        	<a href="/">Home</a>
                                        </li>
                                        <li class="active">글목록</li>
                                        <li>
                                        	<a href="/boardWrite?board_id=">글쓰기</a>
                                        </li>
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
	                                	<input type="button" value="글쓰기" id="btn_board_write" >
                                	</div>
                                    <form class="form-horizontal" role="form" action="" method="POST">
                                    	<table class="type10">
                                    		<colgroup>
                                    			<col width="5%">
                                    			<col width="10%">
                                    			<col width="*">
                                    			<col width="18%">
                                    		</colgroup>
										    <thead>
										    <tr>
										        <th>번호</th>
										        <th>작성자</th>
										        <th>제목</th>
										        <th>등록일시 (마지막 수정일시)</th>
										    </tr>
										    </thead>
										    <tbody>
										    <c:if test="${!empty boardPage.content}">
											    <c:forEach items="${boardPage.content}" var="boardPage" varStatus="status">
												    <tr>
												        <th scope="row" align="center">${status.count}</th>
												        <td align="center">${boardPage.user_id}</td>
												        <td style="padding-left: 40px;"><a href="/boardWrite?board_id=${boardPage.id}">${boardPage.board_title}</a></td>
												        <td align="center">
												        	<c:if test="${boardPage.reg_dt == boardPage.upd_dt}">
													        	<tf:formatDateTime value="${boardPage.reg_dt}" pattern="yyyy-MM-dd HH:mm:ss"/>
												        	</c:if>
												        	<c:if test="${boardPage.reg_dt != boardPage.upd_dt}">
												        		<tf:formatDateTime value="${boardPage.upd_dt}" pattern="yyyy-MM-dd HH:mm:ss"/>
												        	</c:if>
												        </td>
												    </tr>
											    </c:forEach>
											    
											    <!-- 페이지 버튼 -->
											    <ul class="pager">
													<c:if test="${!boardPage.first}">
													<li class="previous">
														<a href="?page=${boardPage.number-1}">&larr; 이전 글</a>
													</li>
													</c:if>
													<c:if test="${!boardPage.last}">
													<li class="next">
														<a href="?page=${boardPage.number+1}">다음 글 &rarr;</a>
													</li>
													</c:if>
												</ul>
												
										    </c:if>
										    <c:if test="${empty boardPage.content}">
										    	<tr>
										    		<td colspan="4" align="center">게시글이 없습니다.</td>
										    	</tr>
										    </c:if>
										    </tbody>
										</table>
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

