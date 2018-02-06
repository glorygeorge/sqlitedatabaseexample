<?php
$connection = mysql_connect("localhost", "root", "");
mysql_select_db("george");
$jsondata=file_get_contents('simple.json');
$json=file_get_contents('');
$data=json_decode($jsondata,true);
$id=$data['empid'];
 $empname = $data['personal']['name'];
    $gender = $data['personal']['gender'];
    $age = $data['personal']['age'];
    $streetaddress = $data['personal']['address']['streetaddress'];
    $city = $data['personal']['address']['city'];
    $state = $data['personal']['address']['state'];
    $postalcode = $data['personal']['address']['postalcode'];
    $designation = $data['profile']['designation'];
    $department = $data['profile']['department'];
 
$sql="INSERT INTO emp(empid,empname,gender,age,streetaddress,city,state,postalcode,designation,department)VALUES('$id','$empname','$gender','$age','$streetaddress','$city','$state','$postalcode','$designation','$department')";
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