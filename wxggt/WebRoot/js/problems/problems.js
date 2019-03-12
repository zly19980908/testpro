$(document).ready(function() {
		$('#dataTables-example').dataTable();

		/* 将搜索出来的内容标红 */
		var str;
		$("[type='search']").on("keyup", function() {
			str = $(this).val();
			if (str != "") {
				$('td').html(function(i, oldHTML) {
					return oldHTML.replace(new RegExp(str, "g"), '<font color="red">' + str + '</font>');
				});
			} else {
				$("font").attr("color", "#797979")
			}
		});

		/* 选择删除行 */
		var table = $('#dataTables-example').DataTable();

		$('#dataTables-example tbody').on('click', 'tr', function() {
			$(this).toggleClass('selected');
		});

		$('.del-pb').click(function() {
			table.row('.selected').remove().draw(false);
		});
		
		$('.select-all').click(function() {
			$("tr").toggleClass('selected');
		});
		
		$('.edit-pb').click(function() {
			/* 获得题目序号 */
			var pNum=$(".selected:eq(0)").find("td:eq(0)").html();
			console.log("编辑"+pNum);
		});
	});