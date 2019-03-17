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
			$("font").attr("color", "#797979");
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
		/* 获得文件序号 */
		var pNum = $(".selected:eq(0)").find("td:eq(0)").html();
		console.log("编辑" + pNum);
	});
});

/* 设置DataTables初始化的默认值 */
$.extend(true, $.fn.dataTable.defaults, {
	"sDom" : "<'row'<'col-sm-4'l><'col-sm-4'f>r>" + "t" + "<'row'<'col-sm-4'i><'col-sm-4'p>>",
	"oLanguage" : {
		"sLengthMenu" : "_MENU_ 个每页"
	}
});

/* 默认类修改 */
$.extend($.fn.dataTableExt.oStdClasses, {
	"sWrapper" : "dataTables_wrapper form-inline",
	"sFilterInput" : "form-control input-sm",
	"sLengthSelect" : "form-control input-sm"
});

// 在1.10中，我们使用分页渲染器绘制Bootstrap分页,
// 而不是自定义插件
if ($.fn.dataTable.Api) {
	$.fn.dataTable.defaults.renderer = 'bootstrap';
	$.fn.dataTable.ext.renderer.pageButton.bootstrap = function(settings, host, idx, buttons, page, pages) {
		var api = new $.fn.dataTable.Api(settings);
		var classes = settings.oClasses;
		var lang = settings.oLanguage.oPaginate;
		var btnDisplay,
			btnClass;

		var attach = function(container, buttons) {
			var i,
				ien,
				node,
				button;
			var clickHandler = function(e) {
				e.preventDefault();
				if (e.data.action !== 'ellipsis') {
					api.page(e.data.action).draw(false);
				}
			};

			for (i = 0, ien = buttons.length; i < ien; i++) {
				button = buttons[i];

				if ($.isArray(button)) {
					attach(container, button);
				} else {
					btnDisplay = '';
					btnClass = '';

					switch (button) {
						case 'ellipsis' :
							btnDisplay = '&hellip;';
							btnClass = 'disabled';
							break;

						case 'first' :
							btnDisplay = lang.sFirst;
							btnClass = button + (page > 0 ? '' : ' disabled');
							break;

						case 'previous' :
							btnDisplay = lang.sPrevious;
							btnClass = button + (page > 0 ? '' : ' disabled');
							break;

						case 'next' :
							btnDisplay = lang.sNext;
							btnClass = button + (page < pages - 1 ? '' : ' disabled');
							break;

						case 'last' :
							btnDisplay = lang.sLast;
							btnClass = button + (page < pages - 1 ? '' : ' disabled');
							break;

						default :
							btnDisplay = button + 1;
							btnClass = page === button ? 'active' : '';
							break;
					}

					if (btnDisplay) {
						node = $('<li>', {
							'class' : classes.sPageButton + ' ' + btnClass,
							'aria-controls' : settings.sTableId,
							'tabindex' : settings.iTabIndex,
							'id' : idx === 0 && typeof button === 'string' ? settings.sTableId + '_' + button : null
						}).append($('<a>', {
							'href' : '#'
						}).html(btnDisplay)).appendTo(container);

						settings.oApi._fnBindAction(node, {
							action : button
						}, clickHandler);
					}
				}
			}
		};

		attach($(host).empty().html('<ul class="pagination"/>').children('ul'), buttons);
	}
} else {
	// 整合1.9-
	$.fn.dataTable.defaults.sPaginationType = 'bootstrap';

	/* 获取分页信息的API方法 */
	$.fn.dataTableExt.oApi.fnPagingInfo = function(oSettings) {
		return {
			"iStart" : oSettings._iDisplayStart,
			"iEnd" : oSettings.fnDisplayEnd(),
			"iLength" : oSettings._iDisplayLength,
			"iTotal" : oSettings.fnRecordsTotal(),
			"iFilteredTotal" : oSettings.fnRecordsDisplay(),
			"iPage" : oSettings._iDisplayLength === -1 ? 0 : Math.ceil(oSettings._iDisplayStart / oSettings._iDisplayLength),
			"iTotalPages" : oSettings._iDisplayLength === -1 ? 0 : Math.ceil(oSettings.fnRecordsDisplay() / oSettings._iDisplayLength)
		};
	};

	/* Bootstrap样式分页控件 */
	$.extend($.fn.dataTableExt.oPagination, {
		"bootstrap" : {
			"fnInit" : function(oSettings, nPaging, fnDraw) {
				var oLang = oSettings.oLanguage.oPaginate;
				var fnClickHandler = function(e) {
					e.preventDefault();
					if (oSettings.oApi._fnPageChange(oSettings, e.data.action)) {
						fnDraw(oSettings);
					}
				};

				$(nPaging).append('<ul class="pagination">' + '<li class="prev disabled"><a href="#">&larr; ' + oLang.sPrevious + '</a></li>' + '<li class="next disabled"><a href="#">' + oLang.sNext + ' &rarr; </a></li>' + '</ul>');
				var els = $('a', nPaging);
				$(els[0]).bind('click.DT', {
					action : "previous"
				}, fnClickHandler);
				$(els[1]).bind('click.DT', {
					action : "next"
				}, fnClickHandler);
			},

			"fnUpdate" : function(oSettings, fnDraw) {
				var iListLength = 5;
				var oPaging = oSettings.oInstance.fnPagingInfo();
				var an = oSettings.aanFeatures.p;
				var i,
					ien,
					j,
					sClass,
					iStart,
					iEnd,
					iHalf = Math.floor(iListLength / 2);

				if (oPaging.iTotalPages < iListLength) {
					iStart = 1;
					iEnd = oPaging.iTotalPages;
				} else if (oPaging.iPage <= iHalf) {
					iStart = 1;
					iEnd = iListLength;
				} else if (oPaging.iPage >= (oPaging.iTotalPages - iHalf)) {
					iStart = oPaging.iTotalPages - iListLength + 1;
					iEnd = oPaging.iTotalPages;
				} else {
					iStart = oPaging.iPage - iHalf + 1;
					iEnd = iStart + iListLength - 1;
				}

				for (i = 0, ien = an.length; i < ien; i++) {
					// Remove the middle elements
					$('li:gt(0)', an[i]).filter(':not(:last)').remove();

					// 添加新列表项及其事件处理程序
					for (j = iStart; j <= iEnd; j++) {
						sClass = (j == oPaging.iPage + 1) ? 'class="active"' : '';
						$('<li ' + sClass + '><a href="#">' + j + '</a></li>').insertBefore($('li:last', an[i])[0]).bind('click', function(e) {
							e.preventDefault();
							oSettings._iDisplayStart = (parseInt($('a', this).text(), 10) - 1) * oPaging.iLength;
							fnDraw(oSettings);
						});
					}

					// 从静态元素 添加/删除 禁用的类
					if (oPaging.iPage === 0) {
						$('li:first', an[i]).addClass('disabled');
					} else {
						$('li:first', an[i]).removeClass('disabled');
					}

					if (oPaging.iPage === oPaging.iTotalPages - 1 || oPaging.iTotalPages === 0) {
						$('li:last', an[i]).addClass('disabled');
					} else {
						$('li:last', an[i]).removeClass('disabled');
					}
				}
			}
		}
	});
}

/*
 * TableTools Bootstrap兼容性 必需要TableTools 2.1+
 */
if ($.fn.DataTable.TableTools) {
	// 将TableTools使用的类设置为适合Bootstrap的类
	$.extend(true, $.fn.DataTable.TableTools.classes, {
		"container" : "DTTT btn-group",
		"buttons" : {
			"normal" : "btn btn-default",
			"disabled" : "disabled"
		},
		"collection" : {
			"container" : "DTTT_dropdown dropdown-menu",
			"buttons" : {
				"normal" : "",
				"disabled" : "disabled"
			}
		},
		"print" : {
			"info" : "DTTT_print_info modal"
		},
		"select" : {
			"row" : "active"
		}
	});

	// 让集合使用引导程序兼容的下拉列表
	$.extend(true, $.fn.DataTable.TableTools.DEFAULTS.oTags, {
		"collection" : {
			"container" : "ul",
			"button" : "li",
			"liner" : "a"
		}
	});
}