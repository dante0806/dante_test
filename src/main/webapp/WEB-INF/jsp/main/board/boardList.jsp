<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<jsp:include page="../template/header.jsp"></jsp:include>
<html class="no-js">
	<style type="text/css">
		table.type10 {
		    border-collapse: collapse;
		    text-align: left;
		    line-height: 1.5;
		    border-top: 1px solid #ccc;
		    border-bottom: 1px solid #ccc;
		    margin: 20px 10px;
		}
		table.type10 thead th {
		    width: 150px;
		    padding: 10px;
		    font-weight: bold;
		    vertical-align: top;
		    color: #fff;
		    background: #3399CC;
		    margin: 20px 10px;
		}
		table.type10 tbody th {
		    padding: 10px;
		}
		table.type10 td {
		    padding: 10px;
		    vertical-align: top;
		}
		table.type10 .even {
		    background: #CCFFCC;
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
	                                	<input type="button" value="글쓰기" id="btn_board_write" >
                                	</div>
                                    <form class="form-horizontal" role="form" action="/loginProcess" method="POST">
                                    	<table class="type10">
										    <thead>
										    <tr>
										        <th>번호</th>
										        <th>작성자</th>
										        <th>제목</th>
										        <th>등록일시</th>
										    </tr>
										    </thead>
										    <tbody>
										    <c:forEach items="${list}" var="list" varStatus="status">
											    <tr>
											        <th scope="row">${status.count}</th>
											        <td>${list.user_id}</td>
											        <td>${list.board_title}</td>
											        <td>2019-07-30 12:53</td>
											    </tr>
										    </c:forEach>
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

