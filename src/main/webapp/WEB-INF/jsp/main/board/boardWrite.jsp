<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
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
		    vertical-align: top;
		    color: #fff;
		    background: #3399CC ;
		}
		table.type11 td {
		    padding: 10px;
		    vertical-align: top;
		    border-bottom: 1px solid #ccc;
		    background: #eee;
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
                                    <form class="form-horizontal" name="boardForm" role="form" action="/regBoard" method="POST">
                                    
                                    	<input type="hidden" name="user_id" value="<sec:authorize access="isAuthenticated()">
                                    	<sec:authentication property='principal.username'/>
                                    </sec:authorize>">
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
										        	<input type="text" name="board_title" id="board_title">
										        </td>
										    </tr>
										    <tr>
										        <th>내용</th>
										        <td>
										        	<textarea name="board_content" rows="20" cols="60" style="resize: none;"></textarea>
										        </td>
										    </tr>
										    </tbody>
										</table>
										<div align="center" style="padding-left: 20px;">
											<input type="submit" class="btn btn-block btn-primary" value="등록" id="btn_reg_board" style="background-color: #E7708D;">
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

