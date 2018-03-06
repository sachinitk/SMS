<?php
$servername = "localhost";
$username = "root";
$password = "";
$database = "SMS_DB";

$con = mysqli_connect($servername,$username,$password,$database);


$username=$_POST["username"];
$message=$_POST["indi_msg"];

$sql = "update student set indi_msg ='$message' where username = '$username' ";
if ($con->query($sql) === TRUE) {
    echo "New record created successfully";
} else {
    echo "Error: " . $sql . "<br>" . $con->error;
}

$con->close();
