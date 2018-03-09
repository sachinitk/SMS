<?php
$servername = "localhost";
$username = "root";
$password = "";
$database = "SMS_DB";

$con = mysqli_connect($servername,$username,$password,$database);

$name= $_POST['name'];
$email=$_POST['email'];
$username=$_POST['username'];
//$password=$_POST['mobile'];
$address=$_POST['address'];
$mobile=$_POST['mobile'];
$semseter=$_POST['semester'];
//$pemail = "";

$sql = "insert into student (name,username,email,address,phone,sem) values
('$name','$username','$email','$address','$mobile','$semseter')";

if ($con->query($sql) === TRUE) {
	$passset = "UPDATE student SET password = MD5(RAND()) WHERE username = '$username'";
	if($con->query($passset) === TRUE)
		{
		$getpassql = "select password from student where username = '$username'";
		
			
			$result = $con->query($getpassql);

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
       // echo "id: " . $row["id"]. " - Name: " . $row["firstname"]. " " . $row["lastname"]. "<br>";
		$pemail = $row["password"];
		echo $pemail;
    }
} else {
    echo "0 results";
}
			


		




				error_reporting(E_ALL & ~E_DEPRECATED & ~E_NOTICE);
require_once "phpmailer/class.phpmailer.php";


$message = '<html><body>';
$message .= '';
$message .= '<table rules="all" width="600px" style="border-color: #666;" cellpadding="10">';
$message .= '<tr style="background: #eee;"><td><h1><a href="http://www.thesoftwareguy.in/" target="_blank"><img src="http://www.thesoftwareguy.in/thesoftwareguy-logo-small.png" alt="thesoftwareguy blog" /></a></h1></td></tr>';
// add body 
$message .= "<tr style='background: #eee;'><td> Hell0 $name your password $pemail.</td></tr>";

$message .= "</table>";

$message .= "</body></html>";
        
// creating the phpmailer object
$mail = new PHPMailer(true);

// telling the class to use SMTP
$mail->IsSMTP();

// enables SMTP debug information (for testing) set 0 turn off debugging mode, 1 to show debug result
$mail->SMTPDebug = 0;

// enable SMTP authentication
$mail->SMTPAuth = true;

// sets the prefix to the server
$mail->SMTPSecure = 'ssl';

// sets GMAIL as the SMTP server
$mail->Host = 'smtp.gmail.com';

// set the SMTP port for the GMAIL server
$mail->Port = 465;

// your gmail address
$mail->Username = 'sachincoolmit@gmail.com';

// your password must be enclosed in single quotes
$mail->Password = '123rt123';

// add a subject line
$mail->Subject = ' Your Password ';

// Sender email address and name
$mail->SetFrom('sachincoolmit@gmail.com', 'Sachin');

// reciever address, person you want to send
$mail->AddAddress($email);

// if your send to multiple person add this line again
//$mail->AddAddress('tosend@domain.com');

// if you want to send a carbon copy
//$mail->AddCC('tosend@domain.com');


// if you want to send a blind carbon copy
//$mail->AddBCC('tosend@domain.com');

// add message body
$mail->MsgHTML($message);


// add attachment if any
//$mail->AddAttachment('time.png');

try {
    // send mail
    $mail->Send();
    $msg = "Mail send successfully";
} catch (phpmailerException $e) {
    $msg = $e->getMessage();
} catch (Exception $e) {
    $msg = $e->getMessage();
}



























			echo "password Randomized Correctly";
		}
    echo "New record created successfully";
} else {
    echo "Error: " . $sql . "<br>" . $con->error;
}

$con->close();
?>



