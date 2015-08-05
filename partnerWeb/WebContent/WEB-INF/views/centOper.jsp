<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Spring MVC</title>
<link rel="stylesheet" type="text/css" href="css/jquery.dataTables.css" />
<link rel="stylesheet" type="text/css" href="css/plug-ins/dataTables.bootstrap.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />


<script type="text/javascript" src="resources/js/jquery.js"></script>
<script type="text/javascript" src="resources/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="resources/js/dataTables.bootstrap.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	//var tmp = $.ajax({ url: 'currentLocale', 
      //  		async: false,
        //		success: function(data) {}});
//	var locale = "resources/locale/dt_" + tmp.responseText + ".txt";
	//alert(locale);
	var oTable = $('#centOperTBL_ID').dataTable( {
		 	"bProcessing": true,
	        "bServerSide": true,
	        "jQueryUI":       true,
	        "orderMulti": true,
	  //      "oLanguage":  { "sUrl" : locale},        
	        "sAjaxSource": "centOperDT",
	        "sPaginationType": "full_numbers",
	        "fnServerData": function ( sSource, aoData, fnCallback, oSettings ) {
	        	 oSettings.jqXHR = $.ajax( {
	              "dataType": 'json',
	              "type": "POST",
	              "url": sSource,
	              "data": aoData,
	              "success": function (data, textStatus, jqXHR) {
		                fnCallback(data, textStatus, jqXHR);
	                }
	            } );
	          },
	        "aoColumns": [
	  	        	    { "mData": "id", "sTitle" : "el codigo" },
	  	        	    { "mData": "cdes", "sTitle" : " la descripcion" }]
	    } );
} );
</script>
</head>
<body>
	<p>Hello</p>
	<table id="centOperTBL_ID" class="table table-striped table-bordered" cellspacing="0" width="100%" >
		<thead>
			<tr>
				<th>Codigo</th>
				<th>Descripcion</th>
			</tr>
		</thead>
	</table>
</body>
</html>