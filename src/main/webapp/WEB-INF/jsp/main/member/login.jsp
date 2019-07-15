<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<jsp:include page="../template/header.jsp"></jsp:include>
<html class="no-js">
    <body>
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
                                <h2 class="h2-section-title">Sign In</h2>
                                <div class="i-section-title">
                                    <i class="icon-users-outline">
                                    </i>
                                </div>
                                <div class="space-sep20"></div>
                            </div>            
                        </div>
                        <div class="row">
                            <div class="col-md-6 col-sm-6 centered">
                                <div class="classic-form">
                                    <form class="form-horizontal" role="form" action="/loginProcess" method="POST" novalidate>
                                        <div class="form-group">
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
                                        </div>
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

