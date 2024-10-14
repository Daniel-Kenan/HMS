

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Appointment booking</title>
        <link re="stylesheet" href="css/bootstrap.min.css">
        <style>
            * {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: Arial, sans-serif;
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
        <div class="container mt-5">
            
            <form action="RegisterServlet" method="post" > 
                <h2> Appointment Bookings</h2>
                <div class="form-group">
                    <label for="name">Name:</label>
                    <input type="text" class="form-control" name="Name" placeholder="Please enter your Name" required>
                </div>
                <div class="form-group">
                    <label for="email">Surname:</label>
                    <input type="text" class="form-control" name="Surname" placeholder="Please enter your Surname" required>
                </div>
                <div class="form-group">
                    <label for="email">Gender:</label>
                    <input type="text" class="form-control" name="text" placeholder="Gender" required>
                </div>
                
                
                <div class="form-group">
                    <label for="password">Age:</label>
                    <input type="number" class="form-control" name="age" placeholder="Please enter your age" required>
                </div> 
                 <div class="form-group">
                    <label for="password">Appointment Date:</label>
                    <input type="date" class="form-control" name="AppointmentDate" placeholder="Date" required>
                </div> 
                 <div class="form-group">
                    <label for="password">Phone Number:</label>
                    <input type="tel" class="form-control" name="PhoneNumber" placeholder="Please enter your Phone Number" required>
                </div> 
                 <div class="form-group">
                    <label for="password">Address:</label>
                    <input type="text" class="form-control" name="Address" placeholder="Please enter your Address" required>
                </div> 
                 <div class="form-group">
                    <label for="password">Disease:</label>
                    <input type="textarea" class="form-control" name="Disease"  required>
                </div> 
                <button type="submit" class="btn btn-primary">Book Appointment</button> 
    </body>
    <script src="js/bootstrap.min.js"></script> 
</html>
