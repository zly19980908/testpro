<?php
include ('DBUtil.php');
$cNo = $_GET['cNo'];
$titleGather = $_GET['titleGather'];
$sql = "UPDATE coursepartsequence SET titleGather='$titleGather' WHERE cNo='$cNo'";
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
