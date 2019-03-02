<?php
include ('DBUtil.php');
$cNo = $_GET['cNo'];
$part_title = $_GET['part_title'];
$new_part_title = $_GET['new_part_title'];
$part_path = $_GET['part_path'];
$source_desc = $_GET['source_desc'];
$download_date = date_format(date_create(), 'Y-m-d H:i:s');
$sql = "UPDATE sourceinfo SET sourceName='$new_part_title',sourceOrgin='$part_path',sourceDesc='$source_desc',downloadDate='$download_date' WHERE sourceName='$part_title' AND cNo='$cNo'";
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
