<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="./css/style.css"/>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="css/util.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <!--===============================================================================================-->



    <title>DemoServlet</title>
</head>
<body>
<div id="limiter" class="limiter fade-in">
    <div class="container-login100">
        <div id="reg-log-wrap" class="wrap">
            <form id="login-form" class="login100-form validate-form" onsubmit="return false">
                    <span class="login100-form-title p-b-26">
                        Welcome
                    </span>


                <div class="wrap-input100 validate-input" data-validate="Enter username">
                    <input id="log-username" class="input100" type="text" name="Username">
                    <span class="focus-input100" data-placeholder="Username"></span>
                </div>

                <div class="wrap-input100 validate-input" data-validate="Enter password">
                        <span class="btn-show-pass">
                            <i class="zmdi zmdi-eye"></i>
                        </span>
                    <input id="log-password" class="input100" type="password" name="pass">
                    <span class="focus-input100" data-placeholder="Password"></span>
                </div>

                <div class="container-login100-form-btn">
                    <div class="wrap-login100-form-btn">
                        <div class="login100-form-bgbtn"></div>
                        <button id="login-button" class="login100-form-btn">
                            Login
                        </button>
                    </div>
                </div>
            </form>
            <div id="switch-sign-up-button-conteiner" class="text-center p-t-115">
                    <span class="txt1">
                        Don’t have an account?
                    </span>

                <button id="switch-registration" class="txt2 guidance">
                    Sign Up
                </button>
            </div>
            <form id="registration-form" class="login100-form validate-form display-none" onsubmit="return false">
                    <span class="login100-form-title p-b-26">
                        Welcome
                    </span>


                <div class="wrap-input100 validate-input" data-validate="Enter username">
                    <input id="reg-username" class="input100" type="text" name="Username">
                    <span class="focus-input100" data-placeholder="Username"></span>
                </div>

                <div class="wrap-input100 validate-input" data-validate="Enter password">
                        <span class="btn-show-pass">
                            <i class="zmdi zmdi-eye"></i>
                        </span>
                    <input id="reg-password1" class="input100" type="password" name="pass">
                    <span class="focus-input100" data-placeholder="Password"></span>
                </div>
                <div class="wrap-input100 validate-input" data-validate="Enter password">
                        <span class="btn-show-pass">
                            <i class="zmdi zmdi-eye"></i>
                        </span>
                    <input id="reg-password2" class="input100" type="password" name="pass">
                    <span class="focus-input100" data-placeholder="Password"></span>
                </div>

                <div class="container-login100-form-btn">
                    <div class="wrap-login100-form-btn">
                        <div class="login100-form-bgbtn"></div>
                        <button id="sign-up-button" class="login100-form-btn">
                            Sign Up
                        </button>
                    </div>
                </div>
            </form>
            <div id="switch-login-button-conteiner" class="text-center p-t-115 display-none">
                    <span class="txt1">
                        Have an account?
                    </span>

                <button id="switch-login" class="txt2 guidance">
                    Log in
                </button>
            </div>
        </div>
    </div>
</div>

<div class="right">
    <button class="display-none" id="personal-account-button"><img src="./images/abstract-user-flat-3.png"
                                                                   alt="personal-account"></button>
    <button class="display-none" id="task-button"><img src="./images/notebook-logo.png"></button>
</div>


<div class="modal-window fade-in colum-center" id="modal">

</div>
<div id="personal-account" class="fade-in display-none profile-card ">
    <div class="profile-cover">
        <div class="profile-avatar">
            <img id="avatar-img" src="https://th.bing.com/th/id/OIP.kUFzwD5-mfBV0PfqgI5GrAHaHa?rs=1&pid=ImgDetMain"
                 alt=""/>
        </div>
        <div class="profile-details">
            <h1 id="username-h1"></h1>
            <ul class="content-center fs-20 fw-b" class="m-r-20">
                <li id="number-of-complited" class="m-r-20"></li>
                <li id="number-of-tasks" class="m-r-20"></li>
                <li id="tasks-at-this-moment" class="m-r-20"></li>
            </ul>
            <div class="content-center">
                <button class="avatar-change-button m-r-20" id="change-avatar-button">Change avatar</button>
                <button class="change-password-button m-r-20" id="change-password-button">Change password</button>
                <button class="logout-button m-r-20" id="log-out-button">Log out</button>
                <button class="delete-account-button m-r-20" id="delete-account-button">Delete account</button>
            </div>

        </div>


    </div>

</div>

<div id="task-page" class="grid-container display-none fade-in">
    <div></div>
    <div>
        <header class="content-center m-t-20">
            <h1>My To-Do List</h1>
        </header>
        <form id="task-form" class="wrap" onsubmit="return false">
            <div class="wrap-input100">
                <input id="header-input" class="input100">
                <span class="focus-input100" data-placeholder="Header"></span>
            </div>
            <div class="wrap-input100">
                <input id="text-input" class="input100">
                <span class="focus-input100" data-placeholder="Description"></span>
            </div>
            <div class="wrap-input100">
                <input id="deadline" class="input100" type="date">
                <span class="focus-input100"></span>
            </div>
            <div class="container-login100-form-btn">
                <div class="wrap-login100-form-btn">
                    <div class="login100-form-bgbtn"></div>
                    <button id="add-button" class="login100-form-btn">
                        Add task
                    </button>
                </div>
            </div>
        </form>

        <ul class="colum-center flex-end wrap m-t-10 fade-in" id="task-list">

        </ul>
        <ul id="pagination-container" class="content-center fade-in">

        </ul>
    </div>
</div>
<footer>
    <p>&copy; 2024 My To-Do List App by <a href="https://github.com/playtlancher">playtlancher</a></p>
</footer>
<script src="./vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="./vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="./vendor/bootstrap/js/popper.js"></script>
<script src="./vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="./vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="./vendor/daterangepicker/moment.min.js"></script>
<script src="./vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
<script src="./vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
<script type="module" src="./js/main.js"></script>

<script src="./js/login.js"></script>

</body>
</html>