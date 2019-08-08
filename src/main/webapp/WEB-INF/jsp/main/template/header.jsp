<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html class="no-js">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dante Home</title>
        <meta name="description" content="Kanzi HTML5 Template">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="../resources/template/css/revolution_settings.css">
        <link rel="stylesheet" href="../resources/template/css/bootstrap.css">
        <link rel="stylesheet" href="../resources/template/css/font-awesome.css">
        <link rel="stylesheet" href="../resources/template/css/axfont.css">
        <link rel="stylesheet" href="../resources/template/css/tipsy.css">
        <link rel="stylesheet" href="../resources/template/css/prettyPhoto.css">
        <link rel="stylesheet" href="../resources/template/css/isotop_animation.css">
        <link rel="stylesheet" href="../resources/template/css/animate.css">
        <link href='../resources/template/css/style.css' rel='stylesheet' type='text/css'> 
        <link href='../resources/template/css/responsive.css' rel='stylesheet' type='text/css'>
        <link href="../resources/template/css/skins/light-blue.css" rel='stylesheet' type='text/css' id="skin-file">
        <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&amp;sensor=false"></script>
        <script src="../resources/js/jquery-3.4.1.min.js"></script>
        <!-- Fonts -->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,600' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Raleway:400,100,200,300,500,600' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="../resources/template/css/color-chooser.css">
        <link rel="stylesheet" href="../resources/css/custom_table.css">
    </head>
    <body>
        <div id="wrapper"  >
            <div class="top_wrapper">
                <div class="top-bar">
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-7">
                                <div class="call-us top-bar-block">
                                    <i class="icon-phone"></i>
                                    <span>
                                        Call us at 010-9589-2875
                                    </span>
                                </div>
                                <div class="mail-us top-bar-block">
                                    <i class="icon-email"></i>                            
                                    <span>
                                        E-mail: dante0806@naver.com
                                    </span>                            
                                </div>

                            </div>
                            <div class="col-sm-5">

                                <!-- Search Box -->
                                <div class="searchbox">
                                    <form action="#" method="get">
                                        <input type="text" class="searchbox-inputtext" id="searchbox-inputtext" name="s" placeholder="검색"/>
                                        <label class="searchbox-icon" for="searchbox-inputtext"></label>
                                        <input type="submit" class="searchbox-submit" value="Search"/>
                                    </form>
                                </div>
                                <!-- //Search Box// -->
                                <div class="social-icons">
                                    <ul>
                                   	<sec:authorize access="isAnonymous()">
                                    	<li>
                                            <a href="/signUp" style="margin-right: 15px;">회원가입</a>
                                        </li>
                                    	<li>
                                            <a href="/login" style="margin-right: 15px;">로그인</a>
                                        </li>
                                        <li>
                                            <a href="#" target="_blank" class="social-media-icon facebook-icon" data-original-title="facebook">facebook</a>
                                        </li>
                                        <li>
                                            <a href="#" target="_blank" class="social-media-icon googleplus-icon" data-original-title="googleplus">googleplus</a>
                                        </li>
                                    </sec:authorize>
                                    <sec:authorize access="isAuthenticated()">
                                    	<li>
                                            <a href="/logout" style="margin-right: 15px;">로그아웃</a>
                                        </li>
                                        <li>
                                            <a href="/myInfo" style="margin-right: 15px;">회원정보</a>
                                        </li>
                                       	<li>
											<span  style="margin-right: 15px;">
												<sec:authentication property="principal.username"/> 님
												<c:set var="login_id" scope="session"><sec:authentication property='principal.username'/></c:set>
											</span>
                                       	</li>
                                    </sec:authorize>
                                    </ul>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Header -->
                <header id="header">
                    <div class="container">

                        <div class="row header">

                            <!-- Logo -->
                            <div class="col-xs-2 logo">
                                <a href="../resources/template/home-version1.html">
                                    <img src="../resources/template/images/main_logo.png" alt="Kanzi HTML5 Template"/>
                                </a>
                            </div>
                            <!-- //Logo// -->


                            <!-- Navigation File -->
                            <div class="col-md-10"  style="z-index: 30">

                                <!-- Mobile Button Menu -->
                                <div class="mobile-menu-button">
                                    <i class="fa fa-list-ul"></i>
                                </div>
                                <!-- //Mobile Button Menu// -->




                                <nav  style="z-index: 30">
                                    <ul class="navigation">
                                    	<li>
                                            <a href="/">
                                                <span class="label-nav">
                                                    Home
                                                </span>
                                                <span class="label-nav-sub" data-hover="Main">
                                                    Main
                                                </span>
                                            </a>
                                        </li>
                                    	<li>
                                            <a href="/boardList">
                                                <span class="label-nav">
                                                    Develop
                                                </span>
                                                <span class="label-nav-sub" data-hover="Test">
                                                    Test
                                                </span>
                                            </a>
                                            <ul>
                                                <li>
                                                    <a href="/boardList">Board</a>
                                                </li>
                                                <li>
                                                    <a href="/photoList">Photo</a>
                                                </li>                            
                                            </ul>
                                        </li>
                                        <li>
                                            <a href="../resources/template/about-us.html">
                                                <span class="label-nav">
                                                    Pages
                                                </span>
                                                <span class="label-nav-sub" data-hover="Layouts">
                                                    Layouts
                                                </span>
                                            </a>
                                            <ul>
                                                <li>
                                                    <a href="../resources/template/about-us.html"> About </a>
                                                </li>
                                                <!-- <li>
                                                    <a href="../resources/template/services.html"> Services </a>
                                                </li>
                                                <li>
                                                    <a href="../resources/template/team.html"> Our Team </a>
                                                </li>
                                                <li>
                                                    <a href="../resources/template/sidebar-navigation.html"> Sidebar Navigation </a>
                                                </li>
                                                <li>
                                                    <a href="../resources/template/faq.html"> FAQ </a>
                                                </li>
                                                <li>
                                                    <a href="../resources/template/Contact.html">Contact Us </a>
                                                </li>
                                                <li>
                                                    <a href="../resources/template/sign-up.html">Sign Up </a>
                                                </li>
                                                <li>
                                                    <a href="../resources/template/sign-in.html">Sign In</a>
                                                </li>
                                                <li>
                                                    <a href="../resources/template/404.html"> 404 </a>
                                                </li>
												<li>
                                                    <a href="../resources/template/home-version1.html">Home version 1</a>
                                                </li>
                                                <li>
                                                    <a href="../resources/template/home-version2.html">Home version 2</a>
                                                </li>
                                                <li>
                                                    <a href="../resources/template/home-version3.html">Home version 3</a>
                                                </li>
                                                <li>
                                                    <a href="../resources/template/home-version4.html">Home Version 4</a>
                                                </li>                                    
                                                <li>
                                                    <a href="../resources/template/home-version5.html">Home Version 5</a>
                                                </li> -->
                                            </ul>
                                        </li>
                                        <!-- <li>
                                            <a href="../resources/template/blog.html">
                                                <span class="label-nav">
                                                    Blog
                                                </span>
                                                <span class="label-nav-sub" data-hover="The News">
                                                    the news
                                                </span>
                                            </a>
                                            <ul>
                                                <li>
                                                    <a href="../resources/template/blog.html">Blog</a>
                                                </li>
                                                <li>
                                                    <a href="../resources/template/blog-masonry.html">Blog Masonry</a>
                                                </li>
                                                <li>
                                                    <a href="../resources/template/blog-single.html">Blog Single</a>
                                                </li>
                                            </ul>
                                        </li>
                                        <li>
                                            <a href="../resources/template/portfolio-two-columns.html">
                                                <span class="label-nav">
                                                    Portfolio
                                                </span>
                                                <span class="label-nav-sub" data-hover="Our Work">
                                                    Our Work
                                                </span>
                                            </a>
                                            <ul>
                                                <li>
                                                    <a href="../resources/template/portfolio-two-columns.html">2 Column</a>
                                                </li>
                                                <li>
                                                    <a href="../resources/template/portfolio-three-columns.html">3 Column</a>
                                                </li>
                                                <li>
                                                    <a href="../resources/template/portfolio-four-columns.html">4 Column</a>
                                                </li>
                                                <li>
                                                    <a href="../resources/template/portfolio-single.html">Single</a>
                                                </li>
                                            </ul>
                                        </li>
                                        <li>
                                            <a href="../resources/template/elements.html">
                                                <span class="label-nav">
                                                    Shortcodes
                                                </span>
                                                <span class="label-nav-sub" data-hover="Elements">
                                                    Elements
                                                </span>
                                            </a>
                                            <ul>
                                                <li>
                                                    <a href="../resources/template/accordions.html">Accordions & Toggles</a>
                                                </li>
                                                <li>
                                                    <a href="../resources/template/columns.html">Columns</a>
                                                </li>                                    
                                                <li>
                                                    <a href="../resources/template/elements.html">Elements</a>
                                                </li>                                    
                                                <li>
                                                    <a href="../resources/template/full-block-content.html">Full Block Content</a>
                                                </li>
                                                <li>
                                                    <a href="../resources/template/icon-boxes.html">Icon Boxes</a>
                                                </li>
                                                <li>
                                                    <a href="../resources/template/icons.html">Icons</a>
                                                </li>                                    
                                                <li>
                                                    <a href="../resources/template/price-tables.html">Pricing Tables</a>
                                                </li>                                    
                                                <li>
                                                    <a href="../resources/template/tabs.html">Tabs</a>
                                                </li>
                                                <li>
                                                    <a href="../resources/template/testimonials.html">Testimonials</a>
                                                </li>

                                                <li>
                                                    <a href="../resources/template/typography.html">Typography</a>
                                                </li>

                                            </ul>
                                        </li> -->
                                    </ul>

                                </nav>

                                <!-- Mobile Nav. Container -->
                                <ul class="mobile-nav">
                                    <li class="responsive-searchbox">
                                        <!-- Responsive Nave -->
                                        <form action="#" method="get">
                                            <input type="text" class="searchbox-inputtext" id="searchbox-inputtext-mobile" name="s" />
                                            <button class="icon-search"></button>
                                        </form>
                                        <!-- //Responsive Nave// -->
                                    </li>
                                </ul>
                                <!-- //Mobile Nav. Container// -->
                            </div>
                            <!-- Nav -->
                        </div>
					</div>
                </header>
                <!-- //Header// -->
			</div>
		</div>
		<script src="../resources/js/main/common.js"></script>
	</body>
</html>
                