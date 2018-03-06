<?php
$servername = "localhost";
$username = "root";
$password = "";
$database = "SMS_DB";

$con = mysqli_connect($servername,$username,$password,$database);


 
 $email = $_POST['email'];
 $password = $_POST['password'];
 
 $Sql_Query = "select * from student where email = '$email' and password = '$password' ";
 
 $check = mysqli_fetch_array(mysqli_query($con,$Sql_Query));
 
 if(isset($check)){
 
 echo "Logined";
 }
 else{
 echo "Invalid Username or Password Please Try Again";
 }

mysqli_close($con);

