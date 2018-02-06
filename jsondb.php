<?php
 $connection = mysql_connect("localhost", "root", "");
mysql_select_db("george");
//$json_obj='{"name":"alex","age":25,"city":"New jercy"}';
//$json_obj=file_get_contents('php://input');
//error_log('george'.$json_obj);
/*$emp_data=json_decode($json_obj);
$name=$emp_data->name;
$age=$emp_data->age;
$city=$emp_data->city;
*/


$name = $_POST["name"];
$age= $_POST["age"];
$city = $_POST["city"];

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