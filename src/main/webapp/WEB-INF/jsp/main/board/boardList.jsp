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
		    background: #e7708d;
		    margin: 20px 10px;
		}
		table.type10 tbody th {
		    width: 150px;
		    padding: 10px;
		}
		table.type10 td {
		    width: 350px;
		    padding: 10px;
		    vertical-align: top;
		}
		table.type10 .even {
		    background: #fdf3f5;
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
                                    <form class="form-horizontal" role="form" action="/loginProcess" method="POST">
                                    	<table class="type10">
										    <thead>
										    <tr>
										        <th scope="cols">타이틀</th>
										        <th scope="cols">내용</th>
										    </tr>
										    </thead>
										    <tbody>
										    <tr>
										        <th scope="row">항목명</th>
										        <td>내용이 들어갑니다.</td>
										    </tr>
										    <tr>
										        <th scope="row" class="even">항목명</th>
										        <td class="even">내용이 들어갑니다.</td>
										    </tr>
										    <tr>
										        <th scope="row">항목명</th>
										        <td>내용이 들어갑니다.</td>
										    </tr>
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
    </body>
</html>
<jsp:include page="../template/footer.jsp"></jsp:include>

