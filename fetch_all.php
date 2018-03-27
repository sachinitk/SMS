<?php
 $con=mysql_connect("localhost","root","");

 if(!$con)
 die('could not connect: ' .mysql_error());

 mysql_select_db("SMS_DB",$con);

 $result = mysql_query("SELECT *
FROM student s
JOIN fees f ON s.username = f.username
JOIN result r ON s.username = r.username
WHERE email = 'sachinitk@gmail.com' ");

 while($row=mysql_fetch_assoc($result)){
 $output[]=$row;
 }

 print(json_encode($output));
mysql_close($con); ?>
