<?php
$servername = "localhost";
$username = "root";
$password = "";
$database = "SMS_DB";

$con = mysqli_connect($servername,$username,$password,$database);

$total=$_POST["total_amount"];
$due=$_POST["due_amount"];
$username=$_POST["username"];
$message=$_POST["fees_message"];

$sql = "update fees set total_amnt = '$total', due_amnt = '$due', fee_message ='$message' where username = '$username' ";
if ($con->query($sql) === TRUE) {
    echo "New record created successfully";
} else {
    echo "Error: " . $sql . "<br>" . $con->error;
}

$con->close();
