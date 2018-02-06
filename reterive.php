<?php
$connection = mysql_connect("localhost", "root", "");
mysql_select_db("george");
$result="SELECT * FROM info";
$row=mysql_query($result);
while($x=mysql_fetch_assoc($row))
{
	
	$output[]=$x;
}
print(json_encode($output));
mysql_close($connection);
?>