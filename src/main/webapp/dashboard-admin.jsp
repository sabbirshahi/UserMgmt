<%-- 
    Document   : dashboard-admin
    Created on : May 21, 2020, 1:49:13 PM
    Author     : Shahi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
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
                <div class="logo">User. </div>
                <!-- Search form -->
                <div class="md-form mt-0 dashboard-search">
                    <input class="form-control" type="text" placeholder="Search" aria-label="Search">
                </div>

                <div class="header-user">
                    <div class="header-user-name">
                        ${username}
                    </div>
                    <div class="header-user-img">
                        <img src="uploadimage?fileName=${image}" height="100px" width="100px" onerror="this.src='https://i.stack.imgur.com/l60Hf.png';">
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


                            <a class="nav-link" data-toggle="pill" href="#user">User</a>
                            <a class="nav-link" data-toggle="pill" href="#historylog" role="tab">History Log</a>
                            <a class="nav-link" data-toggle="pill" href="#report">Reports</a>
                        </div>




                    </div>
                    <div class="dashboard-content tab-content col-lg-10">
                        <div class="tab-pane fade show active" id="dashboard" role="tabpanel">
                            <div class="container">
                                <div class="row">
                                    <div class="dashboard-title col-lg-12">Admin Dashboard</div>

                                    <div class="dashboard-content col-lg-12">
                                        <div class="row">
                                            <div class="col-lg-4">
                                                <div class="content-container ">
                                                    <i class="fas fa-users"></i>
                                                    <div class="content-details">
                                                        <div class="content-value">${totalAdmin}</div>
                                                        <div class="content-label">Admins</div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-lg-4">
                                                <div class="content-container">
                                                    <i class="fas fa-users"></i>
                                                    <div class="content-details">
                                                        <div class="content-value">${totalClient}</div>
                                                        <div class="content-label">Active Clients</div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-lg-4">
                                                <div class="content-container">
                                                    <i class="fas fa-users"></i>
                                                    <div class="content-details">
                                                        <div class="content-value">${totalBlockClient}</div>
                                                        <div class="content-label">Blocked Clients</div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-lg-4">
                                                <div class="content-container">
                                                    <i class="fas fa-users"></i>
                                                    <div class="content-details">
                                                        <div class="content-value">${totalClient + totalBlockClient + totalAdmin}</div>
                                                        <div class="content-label">Total Users</div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--    profile -->
                        <div class="tab-pane fade" id="profile" role="tabpanel">
                            <div class="container profile-container">
                                <div class="row">
                                    <div class="profile">
                                        <div class="profile-img">
                                            <div class="profilepic" data-toggle="modal"
                                                 data-target=".profilepic-form">
                                                <div class="upload-profilepic">
                                                    <i class="fas fa-user-edit"></i>
                                                </div>
                                            </div>
                                            <div class="modal fade profilepic-form" tabindex="-1" role="dialog"
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

                                                                <form action="uploadimage?id=${user_id}" method="post" enctype="multipart/form-data">


                                                                    <div class="form-group">

                                                                        <div class="">
                                                                            Select File to Upload:<input type="file" name="fileName" class="form-control" placeholder="Username">
                                                                        </div>


                                                                    </div>








                                                                    <div class="form-group">
                                                                        <input type="submit" value="Upload" class="create-btn">
                                                                    </div>
                                                                </form>
                                                            </div>
                                                        </div>


                                                    </div>
                                                    <!-- Modal Content: ends -->

                                                </div>

                                            </div>


                                            <img src="uploadimage?fileName=${image}" height="100px" width="100px" onerror="this.src='https://i.stack.imgur.com/l60Hf.png';">
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

                                                    <c:forEach var="admin" items="${listAdmin}">


                                                        <div class="team-img">
                                                            <img src="uploadimage?fileName=<c:out value="${fn:trim(admin.image)}"/>" >
    <!--                                                              <img src="uploadimage?fileName=<c:out value="${admin.image}"/>" onerror="this.src='https://i.stack.imgur.com/l60Hf.png';">-->

                                                        </div>
                                                    </c:forEach>

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

                                                                <form class="create-form" action="edit?id=${user_id}" method="post">
                                                                    <!--edit form form for users-->

                                                                    <div class="form-group">

                                                                        <div class="">
                                                                            <input type="text" name="username" class="form-control" value="${username}">
                                                                        </div>


                                                                    </div>


                                                                    <div class="form-group">
                                                                        <div class="">
                                                                            <input type="text" name="name" class="form-control" value="${name}">
                                                                        </div>
                                                                    </div>

                                                                    <div class="form-group">
                                                                        <div class="">
                                                                            <input type="password" name="password" class="form-control" placeholder="Password">
                                                                        </div>
                                                                    </div>

                                                                    <div class="form-group">
                                                                        <div class="">
                                                                            <input type="password" name="password2" class="form-control" placeholder="Confirm password">
                                                                        </div>
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <div class="">
                                                                            <input type="text" name="security_question" class="form-control" placeholder="Your Favourite pet's name">          
                                                                        </div>
                                                                    </div>






                                                                    <div class="form-group">
                                                                        <input type="submit" name="submit" class="create-btn"/>
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
                        <div class="tab-pane fade" id="user" role="tabpanel">
                            <div class="container userlist">
                                <div class="row">


                                    <div class="dashboard-title col-lg-12">User List</div>

                                    <div class="" data-toggle="modal"
                                         data-target=".user-form">
                                        <button class="create-user"><span class="lnr lnr-plus-circle add-payment-icon"></span> Create user</button>


                                    </div>


                                    <div class="modal fade user-form" tabindex="-1" role="dialog"
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
                                                        <!--create user from admin-->
                                                        <!--                            <form>-->
                                                        <form action="LoginRegister" method="post"  class="create-form">



                                                            <div class="form-group">

                                                                <div class="">
                                                                    <input type="text" name="username" class="form-control" placeholder="Username">
                                                                </div>


                                                            </div>


                                                            <div class="form-group">
                                                                <div class="">
                                                                    <input type="text" name="name" class="form-control" placeholder="Full name">
                                                                </div>
                                                            </div>

                                                            <div class="form-group">
                                                                <div class="">
                                                                    <input type="password" name="password" class="form-control" placeholder="Password">
                                                                </div>
                                                            </div>

                                                            <div class="form-group">
                                                                <div class="">
                                                                    <input type="password" name="password2" class="form-control" placeholder="Confirm password">
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <div class="">
                                                                    <input type="text" name="security_question" class="form-control" placeholder="Your Favourite pet's name">          
                                                                </div>
                                                            </div>

                                                            <div class="form-group">
                                                                <input type="submit" name="submit" value="create" class="create-btn"/>
                                                            </div>
                                                        </form>
                                                    </div>
                                                </div>


                                            </div>
                                            <!-- Modal Content: ends -->

                                        </div>

                                    </div>


                                    <div class="upload-container">
                                        <div class="container upload">


                                            <ul class="nav nav-pills">
                                                <li class="nav-item ">
                                                    <a href="#1" class="active nav-link" data-toggle="tab">
                                                        <h3 class="upload-title">All Users</h3>
                                                    </a>
                                                </li>
                                                <li class="nav-item">
                                                    <a href="#3" class="nav-link" data-toggle="tab">
                                                        <h3 class="upload-title">Active Users</h3>
                                                    </a>
                                                </li>
                                                <li class="nav-item">
                                                    <a href="#2" class="nav-link" data-toggle="tab">
                                                        <h3 class="upload-title">Admin</h3>
                                                    </a>
                                                </li>
                                                <li class="nav-item">
                                                    <a href="#4" class="nav-link" data-toggle="tab">
                                                        <h3 class="upload-title">Blocked Users</h3>
                                                    </a>
                                                </li>


                                            </ul>
                                        </div>

                                        <div class="tab-content clearfix">

                                            <div class="tab-pane active upload-content" id="1">

                                                <table class="all_users">
                                                    <thead class="table-heading">
                                                        <tr>
                                                            <th>User_id</th>
                                                            <th>Username</th>
                                                            <th>Fullname</th>
                                                            <th>Join Date</th>
                                                            <th>option</th>
                                                        </tr>
                                                    </thead>
                                                    <c:forEach var="client" items="${listClient}">
                                                        <tr>
                                                            <td><c:out value="${client.id}" /></td>
                                                            <td><c:out value="${client.username}" /></td>
                                                            <td><c:out value="${client.name}" /></td>
                                                            <td><c:out value="${client.join_date}" /></td>
                                                            <td> <a href="/UserMgmt/block?id=<c:out value='${client.id}'/>"> <button class="block-delete">Block</button></a>
                                                                <a href="/UserMgmt/delete?id=<c:out value='${client.id}'/>"> <button class="block-delete">Delete</button></a></td>
                                                        </tr>
                                                    </c:forEach>
                                                    <c:forEach var="blockClient" items="${listBlockClient}">
                                                        <tr>
                                                            <td><c:out value="${blockClient.id}" /></td>
                                                            <td><c:out value="${blockClient.username}" /></td>
                                                            <td><c:out value="${blockClient.name}" /></td>
                                                            <td><c:out value="${blockClient.join_date}" /></td>
                                                            <td> <a href="/UserMgmt/unblock?id=<c:out value='${blockClient.id}'/>"> <button class="block-delete">Unblock</button></a>
                                                                <a href="/UserMgmt/delete?id=<c:out value='${blockClient.id}'/>"> <button class="block-delete">Delete</button></a></td>
                                                        </tr>
                                                    </c:forEach>
                                                    <c:forEach var="admin" items="${listAdmin}">
                                                        <tr>
                                                            <td><c:out value="${admin.id}" /></td>
                                                            <td><c:out value="${admin.username}" /></td>
                                                            <td><c:out value="${admin.name}" /></td>
                                                            <td><c:out value="${admin.join_date}" /></td>
                                                            <td>Options unavailable for admins</td>
                                                        </tr>
                                                    </c:forEach>
                                                </table>
                                            </div>


                                            <div class="tab-pane upload-content" id="3">
                                                <table class="all_users">
                                                    <thead class="table-heading">
                                                        <tr>
                                                            <th>Client_id</th>
                                                            <th>Username</th>
                                                            <th>Fullname</th>
                                                            <th>Join Date</th>
                                                            <th>option</th>
                                                        </tr>
                                                    </thead>
                                                    <c:forEach var="client" items="${listClient}">
                                                        <tr>
                                                            <td><c:out value="${client.id}" /></td>
                                                            <td><c:out value="${client.username}" /></td>
                                                            <td><c:out value="${client.name}" /></td>
                                                            <td><c:out value="${client.join_date}" /></td>
                                                            <td> <a href="/UserMgmt/block?id=<c:out value='${client.id}'/>"> <button class="block-delete">Block</button></a>
                                                                <a href="/UserMgmt/delete?id=<c:out value='${client.id}'/>"> <button class="block-delete">Delete</button></a></td>
                                                        </tr>
                                                    </c:forEach>

                                                </table>
                                            </div>

                                            <div class="tab-pane upload-content" id="2">
                                                <table class="all_users">
                                                    <thead class="table-heading">
                                                        <tr>
                                                            <th>User_id</th>
                                                            <th>Username</th>
                                                            <th>Fullname</th>
                                                            <th>Join Date</th>
                                                            <th>option</th>
                                                        </tr>
                                                    </thead>
                                                    <c:forEach var="admin" items="${listAdmin}">
                                                        <tr>
                                                            <td><c:out value="${admin.id}" /></td>
                                                            <td><c:out value="${admin.username}" /></td>
                                                            <td><c:out value="${admin.name}" /></td>
                                                            <td><c:out value="${admin.join_date}" /></td>
                                                            <td>Options unavailable for admins</td>
                                                        </tr>
                                                    </c:forEach>


                                                </table>
                                            </div>


                                            <div class="tab-pane upload-content" id="4">
                                                <table class="all_users">
                                                    <thead class="table-heading">
                                                        <tr>
                                                            <th>Client_id</th>
                                                            <th>Username</th>
                                                            <th>Fullname</th>
                                                            <th>Join Date</th>
                                                            <th>option</th>
                                                        </tr>
                                                    </thead>
                                                    <c:forEach var="blockClient" items="${listBlockClient}">
                                                        <tr>
                                                            <td><c:out value="${blockClient.id}" /></td>
                                                            <td><c:out value="${blockClient.username}" /></td>
                                                            <td><c:out value="${blockClient.name}" /></td>
                                                            <td><c:out value="${blockClient.join_date}" /></td>
                                                            <td> <a href="/UserMgmt/unblock?id=<c:out value='${blockClient.id}'/>"> <button class="block-delete">Unblock</button></a>
                                                                <a href="/UserMgmt/delete?id=<c:out value='${blockClient.id}'/>"> <button class="block-delete">Delete</button></a></td>
                                                        </tr>
                                                    </c:forEach>


                                                </table>
                                            </div>


                                        </div>
                                    </div>




                                </div>
                            </div>

                        </div>


                        <div class="tab-pane fade" id="historylog" role="tabpanel">
                            <div class="container">
                                <div class="row">
                                    <div class="dashboard-title col-lg-12">History Log</div>
                                </div>
                            </div>
                            <div class="container">
                                <div class="row">





                                    <div class="history-container col-lg-12">

                                        <c:forEach var="listDate" items="${listDate}" >
                                            <jsp:useBean id="now" class="java.util.Date"/>    

                                            <p style="color:white;">
                                                <fmt:formatDate value="${now}" pattern="yyyy-MM-dd" var="currenttime"/>
                                            </p>




                                            <div class="log-container">
                                                <div class="log-date">  <c:if test="${listDate.date == currenttime}">Today</c:if>  <c:if test="${listDate.date != currenttime}"><c:out value="${listDate.date}"/></c:if> 
                                                    </div>
                                                    <div class="log-content">
                                                    <c:forEach var="listHistory" items="${listHistory}" >
                                                        <c:if test="${listDate.date == listHistory.date}">
                                                            <div class="log-details">

                                                                <c:if test="${listHistory.action =='logged in'}">
                                                                    <c:if test="${listHistory.client_username == 'null'}">    

                                                                        <div><a href="">${listHistory.admin_username} </a> logged in. </div>
                                                                    </c:if>
                                                                    <c:if test="${listHistory.admin_username == 'null'}">    

                                                                        <div><a href="">${listHistory.client_username} </a> logged in. </div>
                                                                    </c:if>
                                                                </c:if>
                                                                <c:if test="${listHistory.action =='logged of'}">
                                                                    <c:if test="${listHistory.client_username == 'null'}">    

                                                                        <div><a href="">${listHistory.admin_username} </a> logged off. </div>
                                                                    </c:if>
                                                                    <c:if test="${listHistory.admin_username == 'null'}">    

                                                                        <div><a href="">${listHistory.client_username} </a> logged off. </div>
                                                                    </c:if>
                                                                </c:if>

                                                                <c:if test="${listHistory.action =='joined'}">
                                                                    <div><a href="">${listHistory.client_username}</a> joined our family </div>
                                                                </c:if>
                                                                <c:if test="${listHistory.action =='create'}">
                                                                    <div><a href="">${listHistory.admin_username}</a> created<a href=""> ${listHistory.client_username} </a></div>
                                                                </c:if>
                                                                <c:if test="${listHistory.action =='blocked'}">
                                                                    <div><a href="">${listHistory.admin_username}</a> blocked<a href=""> ${listHistory.client_username} </a></div>
                                                                </c:if>
                                                                <c:if test="${listHistory.action =='unblocked'}">
                                                                    <div><a href="">${listHistory.admin_username}</a> unblocked<a href=""> ${listHistory.client_username} </a></div>
                                                                </c:if>

                                                                <c:if test="${listHistory.action =='delete'}">
                                                                    <div><a href="">${listHistory.admin_username}</a> deleted<a href=""> ${listHistory.client_username} </a></div>
                                                                </c:if>

                                                                <div class="log-details-datetime">${listHistory.time}</div>
                                                            </div>
                                                        </c:if>
                                                    </c:forEach>
                                                </div>
                                            </div>
                                        </c:forEach>

                                        <%--<c:forEach var="listDate" items="${listDate}" varStatus="loop">--%>
                                        <%--<c:out value="${listDate.date}"/>--%>

                                        <%--</c:forEach>--%>

                                        <!--                                        <div class="log-container">
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
                                                                                </div>-->
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
