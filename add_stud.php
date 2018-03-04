<?php
$servername = "localhost";
$username = "root";
$password = "";
$database = "SMS_DB";

$con = mysqli_connect($servername,$username,$password,$database);

$name=$_POST['name'];
$email=$_POST['email'];
$username=$_POST['username'];
$password=$_POST['mobile'];
$address=$_POST['password'];
$mobile=$_POST['mobile'];
$semseter=$_POST['semester'];

$sql = "insert into student (name,username,email,password,address,phone,sem) values
('$name','$username','$email','$password','$address','$mobile','$semseter')";
if ($con->query($sql) === TRUE) {
    echo "New record created successfully";
} else {
    echo "Error: " . $sql . "<br>" . $con->error;
}

$con->close();
