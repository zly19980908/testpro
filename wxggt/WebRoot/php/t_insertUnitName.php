<?php
include ('DBUtil.php');
$cNo = $_GET['cNo'];
$unit_title = $_GET['unit_title'];
$part_sort=$_GET['part_sort'];
$download_date = date_format(date_create(), 'Y-m-d H:i:s');
$sql = "INSERT INTO sourceinfo(cNo,sourceName,sourceSort,downloadDate) " .
		"VALUE('$cNo','$unit_title','$part_sort','$download_date')";
if ($result = mysqli_query($conn, $sql)) {
	$row = mysqli_affected_rows($conn);
	if ($row == 1) {
		echo "1";
	} else {
		echo "0";
	}
}
/* 关闭连接 */
mysqli_close($conn);
?>