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
        </div>
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