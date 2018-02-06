<?php
$con=mysql_connect("localhost","root","");
mysql_select_db("george");
$req=$_POST["request"];
$json_data=json_decode($req);
$name=$json_data->name;
$age=$json_data->age;
$city=$json_data->city;
$sql="INSERT INTO student (name,age,city) VALUES ('$name','$age','$city')";
$s=mysql_query($sql);
if($s)
{
	echo "record inserted";
	}
	else
	{
		echo "problem occur";
	}

?>