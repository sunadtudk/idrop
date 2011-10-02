/**
 * Javascript for metadata functions
 * 
 * author: Mike Conway - DICE
 */

/**
 * Global var
 */
var metadataMessageAreaSelector = "#metadataMessageArea";
var metadataDialogMessageAreaSelector = "#metadataDialogMessageArea";
var metadataAddUrl = '/metadata/addMetadata';
var metadataUpdateUrl = '/metadata/updateMetadata';
var metadataLoadUrl = '/metadata/listMetadata';

/**
 * Called by data table upon submit of an acl change
 */
function metadataUpdate(currentAvu, newAvu, path) {

	if (!path) {
		throw "No collection or data object selected";
	}

	if (!newAvu) {
		throw "No newAvu provided";
	}

	if (!currentAvu) {
		throw "no currentAvu provided";
	}

	lcShowBusyIconInDiv(metadataMessageAreaSelector);

	var params = {
		absPath : selectedPath,
		currentAttribute : currentAvu['attribute'],
		currentValue : currentAvu['value'],
		currentUnit : currentAvu['unit'],
		newAttribute : newAvu['attribute'],
		newValue : newAvu['value'],
		newUnit : newAvu['unit']
	}

	var jqxhr = $.post(context + metadataUpdateUrl, params,
			function(data, status, xhr) {
				lcClearDivAndDivClass(metadataMessageAreaSelector);
			}, "html").error(function(xhr, status, error) {
		setMessageInArea(metadataMessageAreaSelector, xhr.responseText);
		throw(xhr.responseText);
	}).success(
			function() {
				setMessageInArea(metadataMessageAreaSelector,
						"Metadata update successful"); // FIXME: i18n
			});
	
	return currentAvu;
}

/**
 * The metadata dialog is prepared and ready to display as a JQuery dialog box,
 * show it
 * 
 */
function prepareMetadataDialog(data) {

	if (selectedPath == null) {
		alert("No path is selected, metadata cannot be entered");
		return;
	}

	var url = "/metadata/prepareMetadataDialog";
	var params = {
		absPath : selectedPath,
		create : true
	}

	lcSendValueWithParamsAndPlugHtmlInDiv(url, params, "", function(data) {
		showMetadataDialog(data);
	});

}

/**
 * The metadata dialog is prepared and ready to display as a JQuery dialog box,
 * show it
 * 
 * @param data
 */
function showMetadataDialog(data) {
	lcPrepareForCall();
	$("#metadataDialogArea").html(data).fadeIn('slow');

}

/**
 * Handle form submit to add AVU Metadata
 */
function submitMetadataDialog() {

	lcPrepareForCall();

	var attribute = $('[name=attribute]').val();
	var value = $('[name=value]').val();
	var unit = $('[name=unit]').val();

	if (selectedPath == null) {
		throw "no collection or data object selected"; // FIXME: alert and i18n
	}
	1
	var isCreate = $('[name=isCreate]').val();

	lcShowBusyIconInDiv(metadataMessageAreaSelector);

	var params = {
		absPath : selectedPath,
		attribute : attribute,
		value : value,
		unit : unit
	}

	var jqxhr = $.post(context + metadataAddUrl, params,
			function(data, status, xhr) {
				lcClearDivAndDivClass(metadataMessageAreaSelector);
			}, "html").error(function(xhr, status, error) {
		setMessageInArea(metadataDialogMessageAreaSelector, xhr.responseText);
	}).success(
			function(data, status, xhr) {
				// on success (no exception), check for valid data or invalid
				// data and update appropriately
				var dataJSON = jQuery.parseJSON(data);
				if (dataJSON.response.errorMessage != null) {
					setMessageInArea(metadataDialogMessageAreaSelector,
							dataJSON.response.errorMessage);
				} else {

					setMessageInArea(metadataMessageAreaSelector,
							"AVU saved successfully"); // FIXME: i18n
					closeMetadataDialog();
					reloadMetadataDetailsTable();
					setMessageInArea(metadataMessageAreaSelector,
							"AVU saved successfully"); // FIXME: i18n
				}
			});
}

function closeMetadataDialog() {
	$("#metadataDialogArea").fadeOut('slow', new function() {
		$("#metadataDialogArea").html("")
	});
}

function addRowToMetadataDetailsTable(attribute, value, unit) {

	var idxs = $("#metaDataDetailsTable")
			.dataTable()
			.fnAddData(
					[
							"<input id=\"selectedAcl\" type=\"checkbox\" name=\"selectedMetadata\">",
							attribute, value, unit ], true);
	var newNode = $("#metaDataDetailsTable").dataTable().fnGetNodes()[idxs[0]];
	$(newNode).attr("id", selectedPath);

}

/**
 * Reload the metadata details as a JQuery data table using an AJAX call to get
 * the data
 * 
 * @returns
 */
function reloadMetadataDetailsTable() {

	lcClearDivAndDivClass(metadataMessageAreaSelector);
	$("#metadataTableDiv").empty();
	lcShowBusyIconInDiv("#metadataTableDiv");

	var params = {
		absPath : selectedPath
	}

	var jqxhr = $.get(context + metadataLoadUrl, params,
			function(data, status, xhr) {
				$('#metadataTableDiv').html(data);
			}, "html").error(function(xhr, status, error) {
		setMessageInArea(metadataMessageArea, xhr.responseText);
	}).success(function() {
		buildMetadataTableInPlace();
	});
}

/**
 * Given that the metadata details table data has been retrieved (as html
 * table), make it a dataTable, and add necessary code to process in-place
 * edit/update of metadata
 * 
 * @returns
 */
function buildMetadataTableInPlace() {

	var metaDataTable = lcBuildTableInPlace("#metaDataDetailsTable", null, null);
	$("#infoDiv").resize();

	$('.editable').editable(function(content, settings) {

		var avu = [];
		var newAvu = [];

		var currentNode = $(this);

		if (currentNode.hasClass("avuAttribute")) {
			avu['attribute'] = origData;
			newAvu['attribute'] = content;
		} else if (currentNode.hasClass("avuValue")) {
			avu['value'] = origData;
			newAvu['value'] = content;
		} else if (currentNode.hasClass("avuUnit")) {
			avu['unit'] = origData;
			newAvu['unit'] = content;
		}

		var siblings = currentNode.siblings();
		siblings.each(function(index) {
			var sib = $(this);
			if (sib.hasClass("avuAttribute")) {
				avu['attribute'] = sib.html();
				newAvu['attribute'] = sib.html();
			} else if (sib.hasClass("avuValue")) {
				avu['value'] = sib.html();
				newAvu['value'] = sib.html();
			} else if (sib.hasClass("avuUnit")) {
				avu['unit'] = sib.html();
				newAvu['unit'] = sib.html();
			}
		});

		if (selectedPath == null) {
			throw "no collection or data object selected";
		}

		try {
			metadataUpdate(avu, newAvu, selectedPath);
		} catch (e) {
			console.log("error, returning:" + e);
			return origData;
		}
		console.log("success, returning:" + content);
		return content;

	}, {
		type : 'textarea',
		submit : 'OK',
		cancel : 'Cancel',
		tooltip : '',
		data : function(value, settings) {
			origData = value;
			return value;
		}

	});

	return metaDataTable;
}