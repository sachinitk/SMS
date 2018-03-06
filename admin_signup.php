<?php
$servername = "localhost";
$username = "root";
$password = "";
$database = "SMS_DB";

$con = mysqli_connect($servername,$username,$password,$database);

$name = $_POST['admin_name'];
 $insti = $_POST['admin_insti_token'];
 $email = $_POST['admin_email'];
 $password = $_POST['admin_pass'];

 $CheckSQL = "SELECT * FROM admin WHERE email='$email'";
 
 $check = mysqli_fetch_array(mysqli_query($con,$CheckSQL));
 
 if(isset($check)){

 echo 'Email Already Exist';

 }
else{ 
$Sql_Query = "INSERT INTO admin (name,email,password,institute_token) values ('$name','$email','$password','$insti')";

 if(mysqli_query($con,$Sql_Query))
{
 echo 'Registration Successfully';
}
else
{
 echo 'Something went wrong';
 }
 
}
 mysqli_close($con);
?>
