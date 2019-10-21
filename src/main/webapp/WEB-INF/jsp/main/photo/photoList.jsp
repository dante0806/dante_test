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

            <div class="content-wrapper hide-until-loading">
            	<div class="top-title-wrapper">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-12 col-sm-12">
                                <div class="page-info">
                                    <h1 class="h1-page-title">사진첩</h1>
                                    <h2 class="h2-page-desc">사진목록</h2>

                                    <!-- BreadCrumb -->
                                    <div class="breadcrumb-container">
                                        <ol class="breadcrumbs">
                                            <li>
                                                <a href="/">Home</a>
                                            </li>
                                            <li class="active">사진목록</li>
                                            <li>
                                                <a href="/photoWrite?photo_id=">사진등록</a>
                                            </li>
                                        </ol>
                                    </div>
                                    <!-- BreadCrumb -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="body-wrapper">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-12 col-sm-12">
                                <div class="portfolio-filter-container">
                                    <ul class="portfolio-filter">
                                        <li>
                                            <a href="#" class="portfolio-selected" data-filter="*">전체</a>
                                        </li>
                                        <li>
                                            <a href="#" data-filter=".web-design">앨범1</a>
                                        </li>
                                        <li>
                                            <a href="#" data-filter=".branding">앨범2</a>
                                        </li>
                                        <li>
                                            <a href="#" data-filter=".seo">앨범3</a>
                                        </li>
                                        <li>
                                            <a href="#" data-filter=".videos">앨범4</a>
                                        </li>
                                    </ul>
                                </div>

                                <div class="portfolio-items">
                               	<c:if test="${!empty photoList}">
                               		<c:forEach items="${photoList}" var="photoList">
                               		<div class="thumb-label-item seo">
                                        <div class="img-overlay thumb-label-item-img">
                                            <img src="../upload/images/${photoList.uploadFile.file_name}" alt=""/ width="25%" height="200px;">
                                            <div class="item-img-overlay">
                                                <a class="portfolio-zoom fa fa-plus" href="${photoList.uploadFile.file_path_uri}"
                                                   data-rel="prettyPhoto[portfolio]" title="Title goes here"></a>
                                                <div class="item_img_overlay_content">
                                                    <h3 class="thumb-label-item-title">
                                                        <a href=""> ${photoList.album.album_name}  ${photoList.photo_title} </a>
                                                    </h3>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    </c:forEach>
                               	</c:if>
                               	<c:if test="${empty photoList}">
                               		<div class="thumb-label-item seo">
                                        <div class="img-overlay thumb-label-item-img">	
                               				등록된 사진이 없습니다.
                               			</div>
                               		</div>
                               	</c:if>
                                    <!-- Portfolio Item -->
                                    <!-- <div class="thumb-label-item seo">
                                        <div class="img-overlay thumb-label-item-img">
                                            <img
                                                src="../resources/template/images/placeholders/portfolio1.jpg"
                                                alt=""/>

                                            <div class="item-img-overlay">
                                                <a class="portfolio-zoom fa fa-plus" href="http://www.youtube.com/watch?v=mcw6j-QWGMo"
                                                   data-rel="prettyPhoto[portfolio]" title="Title goes here"></a>
                                                <div class="item_img_overlay_content">
                                                    <h3 class="thumb-label-item-title">
                                                        <a href=""> Aenean llus mtus </a>
                                                    </h3>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                    <div class="thumb-label-item seo">
                                        <div class="img-overlay thumb-label-item-img">
                                            <img
                                                src="../resources/template/images/placeholders/portfolio1.jpg"
                                                alt=""/>

                                            <div class="item-img-overlay">
                                                <a class="portfolio-zoom fa fa-plus" href="http://www.youtube.com/watch?v=mcw6j-QWGMo"
                                                   data-rel="prettyPhoto[portfolio]" title="Title goes here"></a>
                                                <div class="item_img_overlay_content">
                                                    <h3 class="thumb-label-item-title">
                                                        <a href=""> Aenean llus mtus </a>
                                                    </h3>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                    //Portfolio Item//
                                    Portfolio Item
                                    <div class="thumb-label-item branding">
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
                                    //Portfolio Item//
                                    Portfolio Item
                                    <div class="thumb-label-item branding">
                                        <div class="img-overlay thumb-label-item-img">
                                            <img
                                                src="../resources/template/images/placeholders/portfolio3.jpg"
                                                alt=""/>

                                            <div class="item-img-overlay">
                                                <a class="portfolio-zoom fa fa-plus" href="http://www.youtube.com/watch?v=mcw6j-QWGMo"
                                                   data-rel="prettyPhoto[portfolio]" title="Title goes here"></a>
                                                <div class="item_img_overlay_content">
                                                    <h3 class="thumb-label-item-title">
                                                        <a href=""> Maecas nec odio </a>
                                                    </h3>
                                                </div>

                                            </div>
                                        </div>


                                    </div>
                                    //Portfolio Item//
                                    Portfolio Item
                                    <div class="thumb-label-item videos">
                                        <div class="img-overlay thumb-label-item-img">
                                            <img
                                                src="../resources/template/images/placeholders/portfolio4.jpg"
                                                alt=""/>

                                            <div class="item-img-overlay">
                                                <a class="portfolio-zoom fa fa-plus" href="http://www.youtube.com/watch?v=mcw6j-QWGMo"
                                                   data-rel="prettyPhoto[portfolio]" title="Title goes here"></a>
                                                <div class="item_img_overlay_content">
                                                    <h3 class="thumb-label-item-title">
                                                        <a href=""> Vestibum friilla </a>
                                                    </h3>
                                                </div>

                                            </div>
                                        </div>


                                    </div>
                                    //Portfolio Item//
                                    Portfolio Item
                                    <div class="thumb-label-item web-design">
                                        <div class="img-overlay thumb-label-item-img">
                                            <img
                                                src="../resources/template/images/placeholders/portfolio5.jpg"
                                                alt=""/>

                                            <div class="item-img-overlay">
                                                <a class="portfolio-zoom fa fa-plus" href="http://www.youtube.com/watch?v=mcw6j-QWGMo"
                                                   data-rel="prettyPhoto[portfolio]" title="Title goes here"></a>
                                                <div class="item_img_overlay_content">
                                                    <h3 class="thumb-label-item-title">
                                                        <a href=""> Curatur lula </a>
                                                    </h3>
                                                </div>

                                            </div>
                                        </div>


                                    </div>
                                    //Portfolio Item//
                                    Portfolio Item
                                    <div class="thumb-label-item branding">
                                        <div class="img-overlay thumb-label-item-img">
                                            <img
                                                src="../resources/template/images/placeholders/portfolio6.jpg"
                                                alt=""/>

                                            <div class="item-img-overlay">
                                                <a class="portfolio-zoom fa fa-plus" href="http://www.youtube.com/watch?v=mcw6j-QWGMo"
                                                   data-rel="prettyPhoto[portfolio]" title="Title goes here"></a>
                                                <div class="item_img_overlay_content">
                                                    <h3 class="thumb-label-item-title">
                                                        <a href=""> Pellentesque </a>
                                                    </h3>
                                                </div>

                                            </div>
                                        </div>


                                    </div>
                                    //Portfolio Item//
                                    Portfolio Item
                                    <div class="thumb-label-item videos">
                                        <div class="img-overlay thumb-label-item-img">
                                            <img
                                                src="../resources/template/images/placeholders/portfolio7.jpg"
                                                alt=""/>

                                            <div class="item-img-overlay">
                                                <a class="portfolio-zoom fa fa-plus" href="images/placeholders/portfolio7.jpg"
                                                   data-rel="prettyPhoto[portfolio]" title="Title goes here"></a>
                                                <div class="item_img_overlay_content">
                                                    <h3 class="thumb-label-item-title">
                                                        <a href=""> In enim justo </a>
                                                    </h3>
                                                </div>

                                            </div>
                                        </div>


                                    </div>
                                    //Portfolio Item//
                                    Portfolio Item
                                    <div class="thumb-label-item videos">
                                        <div class="img-overlay thumb-label-item-img">
                                            <img
                                                src="../resources/template/images/placeholders/portfolio8.jpg"
                                                alt=""/>

                                            <div class="item-img-overlay">
                                                <a class="portfolio-zoom fa fa-plus" href="http://www.youtube.com/watch?v=mcw6j-QWGMo"
                                                   data-rel="prettyPhoto[portfolio]" title="Title goes here"></a>
                                                <div class="item_img_overlay_content">
                                                    <h3 class="thumb-label-item-title">
                                                        <a href=""> Lutus puvinar </a>
                                                    </h3>
                                                </div>

                                            </div>
                                        </div>


                                    </div> -->
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

