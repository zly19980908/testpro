<?php
include ('DBUtil.php');
$cNo = $_GET['cNo'];
$sql = "SELECT titleGather FROM coursepartsequence WHERE cNo='$cNo'";
$titleGather = "";
$json = "";
if ($result = mysqli_query($conn, $sql)) {
	/* 返回查询的结果 */
	while ($row = mysqli_fetch_assoc($result)) {
		$titleGather = $row["titleGather"];
	}
	/* 结束查询释放内存 */
	mysqli_free_result($result);
	/*传值*/
	$json = json_encode($titleGather); //把数据转换为JSON数据.
	echo $json;
} else {
	echo "查询失败";
}
/* 关闭连接 */
mysqli_close($conn);
?>
