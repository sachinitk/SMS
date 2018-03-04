<?php
$servername = "localhost";
$username = "root";
$password = "";
$database = "SMS_DB";

$sem1 = "sem1";
$sem2 = "sem2";
$sem3 = "sem3";
$sem4 = "sem4";
$sem5 = "sem5";
$sem6 = "sem6";
$sem7 = "sem7";
$sem8 = "sem8";



$con = mysqli_connect($servername,$username,$password,$database);
$variable=$_POST["var"];
//$variable = "sem1";
$username = $_POST['username'];
//$username = "15it110";
if($variable == $sem1)
{
	$txt=$_POST["sem1"];
	//$txt = "3.0";	
	$sql = "update result set sem1= '$txt' where username = '$username'";
}
else if($variable == $sem2)
{
	$txt=$_POST["sem2"];
	$sql = "update result set sem2 = '$txt' where username = '$username'";
}
else if($variable == $sem3)
{
	$txt=$_POST["sem3"];
	$sql = "update result set sem3 = '$txt' where username = '$username'";
}
else if($variable == $sem4)
{
	$txt=$_POST["sem4"];
	$sql = "update result set sem4 = '$txt' where username = '$username'";
}
else if($variable == $sem5)
{
	$txt=$_POST["sem5"];
	$sql = "update result set sem5 = '$txt' where username = '$username'";
}
else if($variable == $sem6)
{
	$txt=$_POST["sem6"];
	$sql = "update result set sem6 = '$txt' where username = '$username'";
}
else if($variable == $sem7)
{
	$txt=$_POST["sem7"];
	$sql = "update result set sem7 = '$txt' where username = '$username'";
}
else if($variable == $sem8)
{
	$txt=$_POST["sem8"];
	$sql = "update result set sem8 = '$txt' where username = '$username'";
}


if($con->query($sql)==TRUE)
{
	echo "record created sucessfully";
}
else {
    echo "Error updating record: " . mysqli_error($con);
}

$con->close();
