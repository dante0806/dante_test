<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<jsp:include page="../template/header.jsp"></jsp:include>
<html class="no-js">
<!-- jqGrid -->
<link rel="stylesheet" type="text/css" href="../resources/jqgrid/css/ui.jqgrid.css"/>
<script type="text/javascript" src="../resources/jqgrid/js/i18n/grid.locale-kr.js"></script>
<script type="text/javascript" src="../resources/jqgrid/js/jquery.jqGrid.min.js"></script>



<script type="text/javascript">
$(document).ready(function(){
	
	var cnames = ['아이디','이름','전화번호','주소','기타','성별코드'];
	
	$("#jqGrid").jqGrid({
		
		url: "jqgridStartMain.do",
		datatype: "local",
		colNames : cnames,
		colModel:[
			{name:'seq',index:'seq',width:55,key:true,align:"center"},
			{name:'name',index:'name',width:100,align:"center"},
			{name:'phone',index:'phone',width:100},
			{name:'address',index:'address',width:100},
			{name:'etcc',index:'etcc',width:100},
			{name:'gender',index:'gender',width:100}
      	],
      	height: 480,
      	rowNum:10,
      	rowList: [10,20,30],
      	pager: "#jqGridPager",
      	rownumbers : true,
      	ondblClickRow : function(rowId, iRow, iCol, e){
      		if(iCol ==1){
      			alert(rowId+" 째줄 입니다.");
      		}
      	},
      	viewrecords : true,
      	caption:"실습용 테이블"
	});
	
});	

</script>
    <body><!-- jqgrid_test -->
                                    	<div class="row">
                                    		<div>
                                    			<table id="jqGrid"></table>
                                    			<div id="jqGridPager"></div>
                                    			123123
                                    		</div>
                                    	</div>
        <div id="wrapper"  >
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
                                    	
                                    	<!-- jqgrid_test -->
                                    	<!-- <div class="row">
                                    		<div>
                                    			<table id="jqGrid"></table>
                                    			<div id="jqGridPager"></div>
                                    		</div>
                                    	</div> -->
                                    	
                                        <%-- <div class="form-group">
                                            <label for="username" class="col-sm-3 control-label">Email</label>
                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" id="username" name="username" placeholder="username">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="password" class="col-sm-3 control-label">Password</label>
                                            <div class="col-sm-9">
                                                <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-offset-3 col-sm-9">
                                                <div class="checkbox">
                                                    <label>
                                                        <input type="checkbox">Remember Me 
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-offset-3 col-sm-9">
                                                <button type="submit" class="btn btn-block btn-primary">Sign In</button>
                                            </div>
                                            <div>
                                            	${logout}
                                            	${username}
                                            	${error}
                                            </div>
                                        </div> --%>
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

