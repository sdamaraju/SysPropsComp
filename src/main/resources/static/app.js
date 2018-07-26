var app = angular.module("myApp", []);


app.controller("myCtrl", function($scope) {
	
	$scope.ResultData='';
	  
	function Error(errorString){
	       alert("Please check the following => "+errorString);
	       return 0;
	     }
	$scope.myFunction = function() {
	var inventoryFile1 = document.querySelector('#path1');
	var errorString="";
	if ((inventoryFile1.value=="")||inventoryFile1.files[0].name.indexOf(".xml")== -1) {
	errorString=errorString+" -File 1 ";
	}
	var inventoryFile2 = document.querySelector('#path2');
	if ((inventoryFile2.value=="")||inventoryFile2.files[0].name.indexOf(".xml")==-1 ) {
	  errorString=errorString+" -File 2 ";
	}

	var inventoryFile3 = document.querySelector('#path3');
	if ((inventoryFile3.value=="")||inventoryFile3.files[0].name.indexOf(".xml")==-1 ) {
	  errorString=errorString+" -File 3 ";
	}

	if(errorString!="")
	{
	  Error(errorString);
	}
	else{
	    
	  var reader1 = new FileReader();
	  reader1.readAsText(inventoryFile1.files[0]);
	  var reader2 = new FileReader(); 
	  var reader3 = new FileReader();
	  
	   reader1.onloadend=function(e){
	    reader2.readAsText(inventoryFile2.files[0]);
	 reader2.onloadend=function(e){
	  reader3.readAsText(inventoryFile3.files[0]);
	  reader3.onloadend=function(e){
	 var ItemJSON;
	 ItemJSON =
	 {
	   "fileData1":"",
	   "fileData2":"",
	   "fileData3":""
	 };
	 ItemJSON.fileData1 = reader1.result;
	    ItemJSON.fileData2 = reader2.result;
	    ItemJSON.fileData3 = reader3.result;
	var ItemJSONFinal=JSON.stringify(ItemJSON);
	jQuery.ajax({
	            url: "http://localhost:8080/compareSystemProperties",
	            type: "POST",
	            data: ItemJSONFinal,
	         
	            contentType: 'application/json; charset=utf-8',
	            success: function(resultData) {
	            //resultData=resultData.replace(/\n/g,"<br><br>");
	            JSONresultData = resultData;
	            
	            $scope.ResultData = JSON.stringify(JSONresultData);
	            
	            console.log(JSON.parse($scope.ResultData));
	           
	            document.getElementById("commonHotfix").innerHTML = resultData;// Current config with return type string
	            },
	            error : function(jqXHR, textStatus, errorThrown) {
	              document.getElementById("commonHotfix").innerHTML =errorThrown;        
	                 },
	            timeout: 120000,
	        });
	    }
	}}
	}
	}
	
});