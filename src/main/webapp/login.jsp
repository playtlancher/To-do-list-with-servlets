<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title>Sign in</title>
</head>
<body>
<div id="limiter" class="limiter fade-in">
    <div class="container-login100">
        <div class="wrap">
            <form action="<%= request.getContextPath()%>/login" id="login-form" class="login100-form validate-form"
                  method="post">
                    <span class="login100-form-title p-b-26">
                        Welcome
                    </span>
                <%
                    String enteredUsername = (String) session.getAttribute("enteredUsername");
                %>

                <div class="wrap-input100 validate-input" data-validate="Enter username">
                    <input id="log-username" class="input100" type="text" name="username"
                           value="<%= enteredUsername != null ? enteredUsername : "" %>">
                    <span class="focus-input100" data-placeholder="Username"></span>
                </div>
                <div class="wrap-input100 validate-input" data-validate="Enter password">
                    <span class="btn-show-pass">
                        <i class="zmdi zmdi-eye"></i>
                    </span>
                    <input id="log-password" class="input100" type="password" name="password">
                    <span class="focus-input100" data-placeholder="Password"></span>
                </div>
                <div>
                    <input type="checkbox">
                    <span class="poppins-regular">Remember me</span>
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
            <%
                session.removeAttribute("Username");
                String message = (String) session.getAttribute("message");
                if (message != null) {
                    out.print("<div class='p-t-16 text-center fs-16 poppins-regular'>" + message + "</div>");
                    session.removeAttribute("message");
                }
            %>
            <div id="switch-sign-up-button-conteiner" class="text-center p-t-115">
                    <span class="txt1">
                        Don’t have an account?
                    </span>

                <button id="switch-registration" class="txt2 guidance">
                    <a href="registration.jsp">Sign Up</a>
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
<script src="./js/login.js"></script>
<script type="module" src="./js/main.js"></script>
<script>
    document.addEventListener("DOMContentLoaded", function() {
        const params = new URLSearchParams(window.location.search);
        const autoLogin = params.get('autoLogin');

            fetch('<%= request.getContextPath() %>/auto-login')
                .then(response => {
                    if (response.redirected) {
                        window.location.href = response.url;
                    }
                })
                .catch(error => console.error('Error:', error));
    });
</script>

</body>
</html>

</body>
</html>
