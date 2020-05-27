
<%@page import="java.sql.Connection"%>
<%@page import="com.herald.usermgmt.config.MySqlCon"%>
<%@page import="java.sql.DriverManager"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Sign Up and Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, 
              maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        
        <link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,500,600,700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
        <link rel="stylesheet" href="https://cdn.linearicons.com/free/1.0.0/icon-font.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.2.1/assets/owl.carousel.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.2.1/assets/owl.theme.default.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.linearicons.com/free/1.0.0/icon-font.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.2.1/assets/owl.carousel.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.2.1/assets/owl.theme.default.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/css?family=Roboto:300i,400,400i,500,500i" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,400i" rel="stylesheet">
        <link rel="stylesheet" href="css/app.min.css">
        
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.2.6/gsap.min.js" crossorigin="anonymous"></script>
    </head>
    
    <body class="logregpage">
        <div class="left">
            <div class="left-content">
                <div class="page-title">Welcome Back</div>
                <div class="subtitle">To keep connected with us please login with your personal info</div>
                <button id="sign-btn" class="left-btn btn">Sign In</button>
                <button id="reg-btn" class="left-btn btn">Sign Up</button>
                <div class="subtitle" style="color: red; margin-top: 22px;font-weight: 500;">${notmatch}</div>
                <div class="subtitle" style="color: red; margin-top: 22px;font-weight: 500;">${sessionLogin}</div>
                <div class="subtitle" style="color: green; margin-top: 22px;font-weight: 500;">${successMessage}</div>
                
                
            </div>
        </div>
        
        <div class="demo">
            <img src="images/usermanagement.svg" alt="" class="demo-img">
        </div>
        
        <div class="panel">
            <img src="https://image.flaticon.com/icons/svg/427/427735.svg" alt="" id="img">
            
            <div class="panel-head">
                <div class="panel-title">Sign In</div>
                <div class="panel-subtitle subtitle">Enter your details below to continue</div>
            </div>
            
            <!--login form-->
            <form action="LoginRegister" method="post" class="signin form">
                <input type="text" name="username" placeholder="Username">
                <input type="password" name="password" placeholder="Password">
                
                <div class="forgot-password" data-toggle="modal"
                     data-target=".forgot-form">
                    <span>Forgot password? We got you!</span>
                </div>
                
                <!--<button class="form-btn">Sign in</button>-->
                <input type="submit" name="submit" value="login" class="form-btn"/>
                <a href id="signup-link">Don't have an account? <span>Sign Up here</span></a>
            </form>
            
            <div class="box"></div>
        </div>
        
        <div class="panel2">
            <img src="https://image.flaticon.com/icons/svg/427/427735.svg" alt="">
            
            <div class="panel-head">
                <div class="panel-title">Sign Up</div>
                <div class="panel-subtitle subtitle">Enter your details below to continue</div>
            </div>
            
            <!--signup form-->
            <form action="LoginRegister" method="post" class="signup form">
                <input type="text" name="username" placeholder="Username">
                <input type="text" name="name" placeholder="Full name">
                <input type="password" name="password" placeholder="Password">
                <input type="password" name="password2" placeholder="Confirm password">
                <input type="text" name="security_question" placeholder="Your Favourite pet's name">

                <a href="index.html">Read terms and conditions. See features</a>
                <!--<button class="form-btn">Sign up</button>-->
                <input type="submit" name="submit" value="register" class="form-btn"/>
                
                <a href id="signin-link" class="signin-link">Already have an account? <span>Sign In here</span></a>
            </form>
            
            <div class="box"></div>
        </div>
        
      <div class="forgot-form modal fade" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Forgot password?</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <div class="modal-body">
                <div class="body-message">
                    <form class="create-form" method="post" action="LoginRegister">


                        <div class="form-group">

                            <div class="col-lg-11">
                                <input type="text" name="username" class="form-control" placeholder="Username">
                            </div>


                        </div>


                        <div class="form-group">
                            <div class="col-lg-11">
                                <input type="text" name="security_question" class="form-control" placeholder="What is your pet's name?">
                            </div>
                        </div>



                        <div class="form-group">
                                   <input type="submit" name="submit" value="forgot" class="create-btn"/>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/2.1.2/TweenMax.min.js"></script>
        
        
        
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.2.1/owl.carousel.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
        <script src="js/app.min.js"></script>
    </body>
    
</html>

