<?php
include ('DBUtil.php');
$cNo = $_GET['cNo'];
$del_title_group = $_GET['del_title_group'];
$flag=1;
foreach ($del_title_group as $title) {
    $sql="DELETE FROM sourceinfo WHERE cNo='$cNo' AND sourceName='$title'";
    if ($result = mysqli_query($conn, $sql)) {
	    $row = mysqli_affected_rows($conn);
	    if ($row == 0) {
		    $flag=0;
	    }
    }
}
if ($flag == 1) {
		echo "1";
	} else {
		echo "0";
	}
/* 关闭连接 */
mysqli_close($conn);
?>
