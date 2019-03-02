<?php
include ('DBUtil.php');
$cNo = $_GET['cNo'];
$part_title = $_GET['part_title'];
$part_sort=$_GET['part_sort'];
$part_time=$_GET['part_time'];
$download_date = date_format(date_create(), 'Y-m-d H:i:s');
$part_path = $_GET['part_path'];
$is_major=$_GET['is_major'];
$source_desc = $_GET['source_desc'];
$sql = "INSERT INTO sourceinfo(cNo,sourceName,sourceSort,sourceTime,downloadDate,sourceOrgin,isMajorType,sourceDesc) " .
		"VALUE('$cNo','$part_title','$part_sort',$part_time,'$download_date','$part_path',$is_major,'$source_desc')";
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