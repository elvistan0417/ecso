<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>

<html>
    <head>
        <title>Life Necessity Enterprise</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/images/home/logo.png" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui.structure.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui.theme.css">
        <link href="${pageContext.request.contextPath}/css/style_login.css" rel="stylesheet" type="text/css" />
        <script src="${pageContext.request.contextPath}/js/modernizr.min.js"></script>
         <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui-1.css">
  <script src="${pageContext.request.contextPath}/js/jquery-1.12.4.js"></script>
  <script src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>    </head>
    <body>
        <div class="background_container">
            <img src="/ecso/images/main.jpg" alt="main background" class="background">
        </div>
        <div class="full_height_container">
            <div class="login">
                <div>
                    <span class="logo_container"><img src="/ecso/images/logo_cen_neg.png" /></span>
                    <h2 style = "text-decoration: underline;text-decoration-color: white;" class="text_center"><font color="white">Life Necessity Enterprise</font></h2>
                     <h2 class="text_center"><font color="green">#Living#Necessity#Eco</font></h2>
                   <form method="post" action="<c:url value='j_spring_security_check' />" >
                        <div class="errorTxt">
                            <div></div>
                        </div>
                        <fieldset class="clearfix">
                            <!--<label>Name:</label>-->
                            <div class="each_input_wrap">
                                <i class="icon-user"></i>
                                <input type="text" name="username" id="name" autocomplete="off" placeholder="User ID" />
                                
                            </div>

                        </fieldset>
                        <fieldset>
                            <!--<label>Name:</label>-->
                            <div class="each_input_wrap">
                                <i class="icon-lock"></i>
                                <input type="password" name="password" id="password" placeholder="Password" />
                                
                            </div>
                          <center><font color="red">${message}</font></center>
                        </fieldset>
                         
                        <div class="btn_wrap text_center">
                            <button type="submit">SUBMIT</button>
                        </div>

                    </form>
                </div>
                <footer></footer>
            </div>
        </div>


        <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/TweenMax.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery-parallax.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.easing.1.3.js"></script>
        <script>
            $(function () {
                $("#login").validate({
                    rules: {
                        name: "required",
                        password: "required"
                    },
                    messages: {
                        name: "User ID is required",
                        password: "Password is required"
                    },                  
                    errorLabelContainer: '.errorTxt'
                });

                if ($(window).width() > 768) {
                    $(document).mousemove(function (e) {
                        $('.background').parallax(-60, e);
                    });
                } else {
                    $(document).mousemove(function () {
                        $('.background').off('parallax');
                    });
                }
            });
        </script>
    </body>
</html>
