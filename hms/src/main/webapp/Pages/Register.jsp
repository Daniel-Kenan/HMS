<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Patient Registration Page</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <style>
 
        /* Reset */
* {
 margin: 0;
 padding: 0;
 box-sizing: border-box;
 font-family: Arial, sans-serif;
}

/* Navigation Bar */
nav {
   display: flex;
   justify-content: space-between;
   align-items: center;
   background-color: #333;
   padding: 10px 20px;
}

nav .logo a {
   color: #fff;
   font-size: 24px;
   text-decoration: none;
   font-weight: bold;
}

nav .nav-links {
   list-style: none;
   display: flex;
   gap: 20px;
}

nav .nav-links li {
   display: inline;
}

nav .nav-links a {
   color: #fff;
   text-decoration: none;
   padding: 5px 10px;
   transition: background 0.3s ease;
}

nav .nav-links a:hover {
   background-color: #575757;
   border-radius: 5px;
}

/* Center container on the page */
.container {
 display: flex;
 justify-content: center;
 align-items: center;
 min-height: 100vh;
 background-color: #f5f5f5;
}

/* Form container */
form {
 background-color: #ffffff;
 padding: 30px;
 border-radius: 10px;
 box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
 width: 100%;
 max-width: 500px;
}

/* Form heading (Align on top of the form) */
h2 {
 text-align: center;
 margin-bottom: 20px;
 color: #333;
 font-size: 24px;
}

/* Form group (label + input) */
.form-group {
 margin-bottom: 20px;
}

/* Label */
.form-group label {
 display: block;
 margin-bottom: 5px;
 font-size: 14px;
 color: #555;
}

/* Input fields */
.form-group input {
 width: 100%;
 padding: 10px;
 border: 1px solid #ddd;
 border-radius: 5px;
 font-size: 14px;
 transition: border-color 0.3s ease;
}

/* Input focus */
.form-group input:focus {
 border-color: #007bff;
 outline: none;
}

/* Button styling */
.btn {
 width: 100%;
 padding: 10px;
 background-color: #007bff;
 color: white;
 border: none;
 border-radius: 5px;
 font-size: 16px;
 cursor: pointer;
 transition: background-color 0.3s ease;
}

/* Button hover effect */
.btn:hover {
 background-color: #0056b3;
}

           
       </style>

</head>
<body>
    <nav>
        <div class="logo">
            <img src="/hms/WebContent/logo.png"/>
        </div>
        <ul class="nav-links">
            <li><a href="index.html">Home</a></li>
            <li><a href="#">About Us</a></li>
            <li><a href="/Regis">Register</a></li>
            <li><a href="Login.jsp">Login</a></li>
        </ul>
    </nav>

    <div class="container mt-5">
        <form action="RegisterServlet" method="POST"> 
            <h2>Patient Registration</h2>
            <div class="form-group">
                <label for="firstName">First Name:</label>
                <input type="text" class="form-control" name="firstName" placeholder="Please enter your first name" required>
            </div>
            <div class="form-group">
                <label for="lastName">Last Name:</label>
                <input type="text" class="form-control" name="lastName" placeholder="Please enter your last name" required>
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" name="email" placeholder="Please enter your email" required>
            </div>
            <div class="form-group">
                <label for="cellphoneNumber">Cellphone Number:</label>
                <input type="text" class="form-control" name="cellphoneNumber" placeholder="Please enter your cellphone number" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" class="form-control" name="password" placeholder="Please enter your password" required>
            </div> 
            <button type="submit" class="btn btn-primary">Register</button> 
        </form>

    </div>

    <script src="js/bootstrap.min.js"></script> 
</body>
</html>
