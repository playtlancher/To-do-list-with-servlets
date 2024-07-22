<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title>Title</title>
</head>
<body>
<div id="limiter" class="limiter fade-in">
    <div class="container-login100">
        <div id="reg-log-wrap" class="wrap">
            <form action="<%= request.getContextPath()%>/login" id="login-form" class="login100-form validate-form"
                  method="post">
                    <span class="login100-form-title p-b-26">
                        Welcome
                    </span>
                <%
                    String enteredUsername = (String) session.getAttribute("enteredUsername");
                    String enteredPassword = (String) session.getAttribute("enteredPassword");
                %>

                <div class="wrap-input100 validate-input" data-validate="Enter username">
                    <input id="log-username" class="input100" type="text" name="username"
                           value="<%= enteredUsername != null ? enteredUsername : "" %>">
                    <span class="focus-input100" data-placeholder="Username"></span>
                </div>
                <div class="wrap-input100 validate-input" data-validate="Enter password">
                    <input id="log-password" class="input100" type="password" name="password"
                           value="<%= enteredPassword != null ? enteredPassword : "" %>">
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
            <%
                String message = (String) session.getAttribute("message");
                if (message != null) {
                    out.print("<div class='p-t-16 text-center fs-16'>" + message + "</div>");
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

</body>
</html>
