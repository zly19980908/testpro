<?php
include ('DBUtil.php');
$cNo = $_GET['cNo'];
$part_title = $_GET['part_title'];
$sql = "DELETE FROM sourceinfo WHERE cNo='$cNo' AND sourceName='$part_title'";
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
