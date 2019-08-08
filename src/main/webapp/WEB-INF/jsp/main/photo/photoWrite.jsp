<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
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
                            	<h1 class="h1-page-title">사진첩</h1>
                                <h2 class="h2-page-desc">사진등록</h2>

                                <!-- BreadCrumb -->
                                <div class="breadcrumb-container">
                                	<ol class="breadcrumbs">
                                    	<li>
                                        	<a href="/">Home</a>
                                        </li>
                                        <li>
                                        	<a href="/photoList">사진목록</a>
                                        </li>
                                        <li class="active">사진등록</li>
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
	                    	<div class="col-md-12 col-sm-12">
	                        	<div class="portfolio-single-nextprev">
	                            	<div class="col-md-2 col-sm-2">
	                                	<a href="#" class="portfolio-single-next">
	                                    	<i class="fa fa-chevron-left"></i>
	                                               이전 사진
	                                    </a>
	                                </div>
	                                <div class="col-md-2 col-md-offset-8">
	                                	<a href="#" class="portfolio-single-prev">
	                                       	다음 사진
	                                        <i class="fa fa-chevron-right"></i>
	                                    </a>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
					<form name="photoForm" id="photoForm" method="post">	
                        <div class="space-sep40"></div>
                        <div class="row">
                            <!--  Image or video or slider -->
                            <div class="col-md-12 col-sm-12">
								<c:if test="${!empty photo}">
	                                <div class="portfolio-single-image cycle-slideshow"
	                                     data-cycle-slides="> .slider-img"
	                                     data-cycle-swipe="true"
	                                     data-cycle-prev=".cycle-prev"
	                                     data-cycle-next=".cycle-next"
	                                     data-cycle-timeout=0>
	                                    <div class="fa fa-chevron-right cycle-next"></div>
	                                    <div class="fa fa-chevron-left cycle-prev"></div>
	                                    <div class="cycle-pager"></div>
	                                    <!-- slider item -->
	                                    <div class="slider-img">
	                                        <img src="../resources/template/images/placeholders/portfolio-single1.jpg" alt=""/>
	                                    </div>
	                                    <!-- //slider item// -->
	                                    <!-- slider item -->
	                                    <div class="slider-img">
	                                        <img src="../resources/template/images/placeholders/portfolio-single2.jpg" alt=""/>
	                                    </div>
	                                    <!-- //slider item// -->
	                                </div>
	                            	<!--// Image or video or slider //-->
	                            </c:if>
	                            <c:if test="${empty photo}">
	                            	<div align="center">이미지</div>
	                            </c:if>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-8 col-sm-8">
                                <!-- Project Description -->
                                <div class="title-block clearfix">
                                    <h3 class="h3-body-title">앨범</h3>
                                    <div class="title-seperator"></div>
                                </div>
                                <c:if test="${!empty photo}">
	                                <p>${photo.field_name1}</p>
	                                <p>${photo.photo_title}</p>
	                                <blockquote>${photo.photo_content}</blockquote>
	                                <blockquote>${photo.reg_id} / ${photo.reg_dt}</blockquote>
                                </c:if>                
                                <c:if test="${empty photo}">
	                                <table class="type05">
	                                	<tr>
	                                		<th align="center">파일선택</th>
	                                		<td>
			                                	<input type="file" class="btn btn-default">
	                                		</td>
	                                	</tr>
	                                	<tr>
	                                		<th align="center">앨범선택</th>
	                                		<td>
	                                			<c:if test="${!empty albumList}">
		                                			<select name="album_id" id="album_id">
		                                				<c:forEach items="${albumList}" var="album">
					                                		<option value="${album.album_id}">${album.album_name}</option>
		                                				</c:forEach>
		                                			</select>
	                                			</c:if>
	                                			<c:if test="${empty albumList}">
	                                				우측에서 새앨범을 추가하세요. 
	                                			</c:if>
	                                		</td>
	                                	</tr>	                                		                                	
	                                	<tr>
	                                		<th align="center">사진제목</th>
	                                		<td>
			                                	<input type="text">
	                                		</td>
	                                	</tr>
	                                	<tr>
	                                		<th align="center">사진내용</th>
	                                		<td>
			                                	<textarea rows="3" cols="10">
	                                			</textarea>	
	                                		</td>
	                                	</tr>
	                                </table>
                                </c:if>
                                <!-- //Project Description// -->
                            </div>
                            <div class="col-md-4 col-sm-4">
                                <div class="title-block clearfix">
                                    <h3 class="h3-body-title">파일</h3>
                                    <div class="title-seperator"></div>
                                </div>
                                <c:if test="${!empty photo}">                
	                                <table class="portfolio-single-project-details">
	                                    <tr>
	                                        <th>파일이름</th>
	                                        <td>abc.jpg</td>
	                                    </tr>
	                                    <tr>
	                                        <th>파일용량</th>
	                                        <td>100kb</td>
	                                    </tr>
	                                    <tr>
	                                        <th>등록자</th>
	                                        <td>김시은</td>
	                                    </tr>
	                                    <tr>
	                                        <th>등록일</th>
	                                        <td>2019-08-08</td>
	                                    </tr>
	                                </table>
	                        	</c:if>
	                        	<c:if test="${empty photo}">
	                        		<div>
	                        			앨범추가 : 
	                        			<input type="text" id="add_album_name">
	                                	<input type="button" id="btn_add_album" value="추가">
	                        		</div>
	                        		<div>
	                        			<input type="button" value="사진저장">
	                        		</div>
	                        	</c:if>        
                            </div>
                        </div>
					</form>
					
					
					
					
                        <div class="space-sep40"></div>

                        <div class="row">
                            <div class="col-md-12 col-sm-12">
                                <div class="title-block clearfix">
                                    <h3 class="h3-body-title">related works</h3>
                                    <div class="title-seperator"></div>
                                </div>            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-12 col-sm-12">
                                <div class="portfolio-items">

                                    <!-- Portfolio Item -->
                                    <div class="thumb-label-item web-design">
                                        <div class="img-overlay thumb-label-item-img">
                                            <img
                                                src="../resources/template/images/placeholders/portfolio1.jpg"
                                                alt=""/>

                                            <div class="item-img-overlay">

                                                <a class="portfolio-zoom fa fa-plus" href="../resources/template/images/placeholders/portfolio1.jpg"
                                                   data-rel="prettyPhoto[portfolio]" title="Title goes here"></a>
                                                <div class="item_img_overlay_content">
                                                    <h3 class="thumb-label-item-title">
                                                        <a href=""> Aenean llus mtus </a>
                                                    </h3>
                                                </div>

                                            </div>
                                        </div>



                                    </div>
                                    <!-- //Portfolio Item// -->
                                    <!-- Portfolio Item -->
                                    <div class="thumb-label-item web-design">
                                        <div class="img-overlay thumb-label-item-img">
                                            <img
                                                src="../resources/template/images/placeholders/portfolio2.jpg"
                                                alt=""/>

                                            <div class="item-img-overlay">

                                                <a class="portfolio-zoom fa fa-plus" href="http://www.youtube.com/watch?v=mcw6j-QWGMo"
                                                   data-rel="prettyPhoto[portfolio]" title="Title goes here"></a>
                                                <div class="item_img_overlay_content">
                                                    <h3 class="thumb-label-item-title">
                                                        <a href=""> Donec vitae sapien </a>
                                                    </h3>
                                                </div>

                                            </div>
                                        </div>



                                    </div>
                                    <!-- //Portfolio Item// -->
                                    <!-- Portfolio Item -->
                                    <div class="thumb-label-item seo">
                                        <div class="img-overlay thumb-label-item-img">
                                            <img
                                                src="../resources/template/images/placeholders/portfolio3.jpg"
                                                alt=""/>

                                            <div class="item-img-overlay">

                                                <a class="portfolio-zoom fa fa-plus" href="../resources/template/images/placeholders/portfolio3.jpg"
                                                   data-rel="prettyPhoto[portfolio]" title="Title goes here"></a>
                                                <div class="item_img_overlay_content">
                                                    <h3 class="thumb-label-item-title">
                                                        <a href=""> Maecas nec odio </a>
                                                    </h3>
                                                </div>

                                            </div>
                                        </div>



                                    </div>
                                    <!-- //Portfolio Item// -->
                                    <!-- Portfolio Item -->
                                    <div class="thumb-label-item web-design">
                                        <div class="img-overlay thumb-label-item-img">
                                            <img
                                                src="../resources/template/images/placeholders/portfolio4.jpg"
                                                alt=""/>

                                            <div class="item-img-overlay">

                                                <a class="portfolio-zoom fa fa-plus" href="../resources/template/images/placeholders/portfolio4.jpg"
                                                   data-rel="prettyPhoto[portfolio]" title="Title goes here"></a>
                                                <div class="item_img_overlay_content">
                                                    <h3 class="thumb-label-item-title">
                                                        <a href=""> Vestibum friilla </a>
                                                    </h3>
                                                </div>

                                            </div>
                                        </div>



                                    </div>
                                    <!-- //Portfolio Item// -->


                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--.content-wrapper end -->
		</div>
		<script src="../resources/js/main/photo.js"></script>
    </body>
</html>
<jsp:include page="../template/footer.jsp"></jsp:include>

