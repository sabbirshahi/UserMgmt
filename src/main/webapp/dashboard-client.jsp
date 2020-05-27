<%-- 
    Document   : dashboard-client
    Created on : May 21, 2020, 1:49:55 PM
    Author     : Shahi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Dashboard</title>
    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,500,600,700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
    <link rel="stylesheet" href="https://cdn.linearicons.com/free/1.0.0/icon-font.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.2.1/assets/owl.carousel.min.css">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.2.1/assets/owl.theme.default.min.css">

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css"
          integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">

    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>


    <link rel="stylesheet" href="https://cdn.linearicons.com/free/1.0.0/icon-font.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.2.1/assets/owl.carousel.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.2.1/assets/owl.theme.default.min.css">
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">

    

    <link href="https://fonts.googleapis.com/css?family=Roboto:300i,400,400i,500,500i" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,400i" rel="stylesheet">
    <link rel="stylesheet" href="css/app.min.css">

</head>
<body >

        <c:if test="${editerror != null}">
            <div id="error" style="width: 100%;
                 height: 22px;
                 font-size: 14px;
                 background-color: #0a84ae;
                 display: flex;
                 align-items: center;
                 color: white;
                 padding-left: 20px;"
                 >${editerror}</div>
        </c:if>


<div class="dashboard-header">

        <div class="header-container">
            <div class="logo">User.</div>
            <!-- Search form -->
            <div class="md-form mt-0 dashboard-search">
                <input class="form-control" type="text" placeholder="Search" aria-label="Search">
            </div>

            <div class="header-user">
                <div class="header-user-name">
                    ${username}
                </div>
                <div class="header-user-img">
                    <img src="https://fiverr-res.cloudinary.com/images/q_auto,f_auto/gigs/115909667/original/7d79dd80b9eecaa289de1bc8065ad44aa03e2daf/do-a-simple-but-cool-profile-pic-or-logo-for-u.jpeg" alt="">
                </div>

            </div>
            
            
            
            

            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
        </div>
</div>




<div class="dashboard-layover">
    <div class="admin-dashboard container">
        <div class="row">
            <div class="side-bar col-lg-2">
                <div class="sidebar-header">
                    <div class="header-container">
                        <div class="user-container">
                            <div class="user-label">Signed in as</div>
                            <div class="user-name"> ${user_type}</div>
                        </div>
                           <a href="Logout"><span class="lnr lnr-exit"></span></a>
                    </div>

                </div>


                <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                    <a class="nav-link active" data-toggle="pill" href="#dashboard">Dashboard</a>
                    <a class="nav-link" data-toggle="pill" href="#profile">Profile</a>



                    <a class="nav-link" data-toggle="pill" href="#historylog" role="tab">History Log</a>
                    <a class="nav-link" data-toggle="pill" href="#report">Reports</a>
                </div>




            </div>
            <div class="dashboard-content tab-content col-lg-10">
                <div class="tab-pane fade show active" id="dashboard" role="tabpanel">
                    <div class="container">
                        <div class="row">
                            <div class="dashboard-title col-lg-12">Client Dashboard</div>

                            <div class="dashboard-content col-lg-12">

                                <div class="content-container">
                                    <i class="fas fa-users"></i>
                                    <div class="content-details">
                                        <div class="content-value">${totalClient}</div>
                                        <div class="content-label">Active Users</div>
                                    </div>
                                </div>

                                <div class="content-container">
                                    <i class="fas fa-users"></i>
                                    <div class="content-details">
                                        <div class="content-value">${totalBlockClient}</div>
                                        <div class="content-label">Blocked Users</div>
                                    </div>
                                </div>

                                <div class="content-container">
                                    <i class="fas fa-users"></i>
                                    <div class="content-details">
                                        <div class="content-value">${totalClient + totalBlockClient}</div>
                                        <div class="content-label">Total Users</div>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                                        <a href="../java/com/herald/usermgmt/registration/DeleteServlet.java"></a>
                </div>
                <!--    profile -->
                <div class="tab-pane fade" id="profile" role="tabpanel">
                    <div class="container profile-container">
                        <div class="row">
                            <div class="profile">
                                <div class="profile-img">
                                    <img src="https://www.wallpaperflare.com/static/26/331/805/one-piece-anime-monkey-d-luffy-monkey-wallpaper.jpg" alt="">
                                </div>
                                <div class="profile-details">
                                    <div class="profile-name">
                                        <span class="profile-label">Name</span>
                                        <span class="profile-fullname profile-value">${name}</span>
                                    </div>
                                    <div class="profile-name">
                                        <span class="profile-label">Position</span>
                                        <span class=" profile-value">${user_type}</span>
                                    </div>
                                    <div class="profile-subdetails">
                                        <div class="profile-name">
                                            <span class="profile-label">Users Created</span>
                                            <span class=" profile-value">64</span>
                                        </div>
                                        <div class="profile-name">
                                            <span class="profile-label">Users Deleted</span>
                                            <span class=" profile-value">326</span>
                                        </div>


                                    </div>

                                    <div class="profile-name">
                                        <span class="profile-label">Team</span>
                                        <div class="team-container">
                                            <div class="team-img">
                                                <img src="https://i.pinimg.com/236x/0c/d1/1f/0cd11f29b29f6d3a1136712ad7dd813b.jpg" alt="">
                                            </div>
                                            <div class="team-img">
                                                <img src="https://i.pinimg.com/236x/0c/d1/1f/0cd11f29b29f6d3a1136712ad7dd813b.jpg" alt="">
                                            </div>
                                            <div class="team-img">
                                                <img src="https://i.pinimg.com/236x/0c/d1/1f/0cd11f29b29f6d3a1136712ad7dd813b.jpg" alt="">
                                            </div>
                                            <div class="team-img">
                                                <img src="https://i.pinimg.com/236x/0c/d1/1f/0cd11f29b29f6d3a1136712ad7dd813b.jpg" alt="">
                                            </div>
                                        </div>
                                    </div>


                                    <div class="profile-label" data-toggle="modal"
                                         data-target=".edit-form">
                                        <button class="edit-details">Edit Details</button>


                                    </div>


                                    <div class="modal fade edit-form" tabindex="-1" role="dialog"
                                         aria-labelledby="myLargeModalLabel" aria-hidden="true">

                                        <div class="modal-dialog">

                                            <!-- Modal Content: begins -->
                                            <div class="modal-content">

                                                <!-- Modal Header -->
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                        <span aria-hidden="true">&times;</span></button>
                                                </div>

                                                <!-- Modal Body -->
                                                <div class="modal-body">
                                                    <div class="body-message">

                                                        <form class="create-form">


                                                            <div class="form-group">

                                                                <div class="">
                                                                    <input type="text" class="form-control" placeholder="Username">
                                                                </div>


                                                            </div>


                                                            <div class="form-group">
                                                                <div class="">
                                                                    <input type="password" class="form-control" placeholder="Password">
                                                                </div>
                                                            </div>

                                                            <div class="form-group">
                                                                <div class="">
                                                                    <input type="password" class="form-control" placeholder="Confirm password">
                                                                </div>
                                                            </div>

                                                            <div class="form-group">
                                                                <div class="">
                                                                    <input type="text" class="form-control" placeholder="Full Name">
                                                                </div>
                                                            </div>

                                                            
                                                            
                                                            
                                                            
                                                            

                                                            <div class="form-group">
                                                                <button class="create-btn">Edit User</button>
                                                            </div>
                                                        </form>
                                                    </div>
                                                </div>


                                            </div>
                                            <!-- Modal Content: ends -->

                                        </div>

                                    </div>





                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--                create user content-->



                <div class="tab-pane fade" id="historylog" role="tabpanel">
                    <div class="container">
                        <div class="row">
                            <div class="dashboard-title col-lg-12">History Log</div>
                        </div>
                    </div>
                    <div class="container">
                        <div class="row">



                            <div class="history-container col-lg-12">
                                <div class="log-container">
                                    <div class="log-date">Today</div>
                                    <div class="log-content">
                                        <div class="log-details">
                                            <div><a href="">Sishir</a> deleted User <a href="">John Doe</a></div>
                                            <div class="log-details-datetime">4/12/2020 4:12</div>
                                        </div>
                                    </div>
                                </div>

                                <div class="log-container">
                                    <div class="log-date">Yesterday</div>
                                    <div class="log-content">
                                        <div class="log-details">
                                            <div><a href="">Sishir</a> blocked User <a href="">John Doe</a></div>
                                            <div class="log-details-datetime">4/12/2020 4:12</div>
                                        </div>
                                        <div class="log-details">
                                            <div><a href="">Sishir</a> created User <a href="">John Doe</a></div>
                                            <div class="log-details-datetime">4/12/2020 4:12</div>

                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>

                </div>
                <div class="tab-pane fade" id="report" role="tabpanel"></div>


            </div>
        </div>

    </div>
</div>























</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/2.1.2/TweenMax.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.2.6/gsap.min.js" integrity="sha256-3arngJBQR3FTyeRtL3muAGFaGcL8iHsubYOqq48mBLw=" crossorigin="anonymous"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.2.1/owl.carousel.min.js"></script>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>


<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/2.0.2/TweenMax.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/2.0.2/TimelineMax.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/ScrollMagic/2.0.6/plugins/animation.gsap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/ScrollMagic/2.0.6/plugins/animation.gsap.min.js"></script>

<script src="js/app.min.js"></script>
</body>
</html>
