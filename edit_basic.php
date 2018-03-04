<?php
$servername = "localhost";
$username = "root";
$password = "";
$database = "SMS_DB";

$eml = "email";
$mbl = "mobile";
$pwd = "password";
$adr = "address";




$con = mysqli_connect($servername,$username,$password,$database);
$variable=$_POST["var"];
$username = $_POST['username'];
if($variable == $eml)
{
	$txt=$_POST["email"];
	$sql = "update student set email = '$txt' where username = '$username'";
}
if($variable == $mbl)
{	$txt=$_POST["mobile"];
	$sql = "update student set phone = '$txt' where username = '$username'";
}
if($variable == $adr)
{	$txt=$_POST["address"];
	$sql = "update student set address = '$txt' where username = '$username'";
}
if($variable == $pwd)
{	$txt=$_POST["password"];
	$sql = "update student set pasword = '$txt' where username = '$username'";
}

if($con->query($sql)==TRUE)
{
	echo "record created sucessfully";
}
$con->close();
