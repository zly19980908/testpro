<?php
include ('DBUtil.php');
$cNo = $_GET['cNo'];
$unit_title = $_GET['unit_title'];
$new_unit_title = $_GET['new_unit_title'];
$sql = "UPDATE sourceinfo SET sourceName='$new_unit_title' WHERE cNo='$cNo' AND sourceName='$unit_title'";
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
