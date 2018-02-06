<?php
 $connection = mysql_connect("localhost", "root", "");
mysql_select_db("george");

$req = $_POST["request"];
$jsondata = json_decode($req);
$name = $jsondata->name;
$age = $jsondata->age;
	$city = $jsondata->city;

$sql="INSERT INTO student (name,age,city) VALUES ('$name', '$age', '$city')";
$s=mysql_query($sql);
if($s)
{
	echo "Record insert successfully";
}
else
{
	echo "problem occur";
}

?>