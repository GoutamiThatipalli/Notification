
<!doctype html>
<html lang = "en">
   <head>
      <meta charset = "utf-8">
      <title>Notifications</title>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
      <link href = "https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel = "stylesheet">
      <script src = "https://code.jquery.com/jquery-1.10.2.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
      <script src = "https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment.js"></script>
      <script>    
      var ajaxData; 
      $(document).ready(function(){
         
          	var url= 'http://localhost:8086/notifications/getAllNotifications';
              var x =$.ajax({
                  url: url,
                  crossOrigin: true,
                  type: 'GET',
                  dataType: 'json',
                 accept: 'application/json'
              }).done(function (data) {          	
              	ajaxData = data;
              	var str = '';
              	str += '<table class="table table-bordered table-striped">';
              	str += '<thead><tr align=center class="active" >';
              	str += '<th>ID</th>';
              	str += '<th>NOTIFICATION NAME</th>';
              	str += '<th>MESSAGE</th>';
              	str += '<th>CREATED TIME</th>';
              	str += '<th>SCHEDULE DATE</th>';
              	str += '<th>EMAILID</th>';
              	str += '<th colspan=2 >Events</th>'
              	str += '</tr></thead>';
              	
              	str += '<tbody>';
              	$.each(data, function(i, obj){
  					var uid=obj.id;
          
              		str += '<tr>';
              		str += '<td> <label class="formfield">'+obj.id+'</label> </td>'
              		str += '<td> <label class="formfield">'+obj.notificationName+'</label> </td>'
              		str += '<td> <label class="formfield">'+obj.message+'</label> </td>'
              		str += '<td> <label class="formfield">'+obj.createdTime+'</label> </td>'
              		str += '<td> <label class="formfield">'+obj.scheduleDate+'</label> </td>'
              		str += '<td> <label class="formfield">'+obj.emailId+'</label> </td>'
              		str +='<td><button data-id="'+uid+'" class="btn btn-danger" id="deleteBtn">Delete</button></td>';
              		str += '</tr>';
              	
              	});
              	str += '</tbody>';
              	str += '</table>';
              	$('#tableDiv').html(str);
              	 $( "#tableDiv tbody tr #deleteBtn" ).on( "click", function(e) {
              		var targetElmt = e.target;
              		console.log($(targetElmt).data("id"));
              		if (confirm("Do you want to delete")){
              			deleteNotification($(targetElmt).data("id"));
              		    }
              		else{
              			window.location.href="index.jsp";
              		}
            		  
            		});
              });
      });
      
      
         $(function() {
            $( "#dialog-1" ).dialog({
               autoOpen: false,  
               width: 500,
               modal: true,
              	closeOnEscape: true
            });
            $( "#opener" ).click(function() {
               $( "#dialog-1" ).dialog( "open");
            });
           $('#notifyForm').submit(function(event){ 
                event.preventDefault();
              	var data={};
              	data.notificationName=$("#notificationName").val();
    	    	data.message=$("#message").val();
    	    	data.scheduleDate=$("#scheduleDate").val();
    	    	data.emailId=$("#emailId").val();
    	    	if(data.scheduleDate==""){
    	    		 var dateTime=new Date();  
    	    		data.scheduleDate = moment(dateTime).format("YYYY-MM-DD HH:mm:ss"); 
    	    		data.scheduleNow=1;
    	    	}
    	    	else{
    	    		data.scheduleNow=0;
    	    	} 
    		    $.ajax({
    		    	type: "POST",
    		    	url: "http://localhost:8086/notifications/addNotification",
    		        data: JSON.stringify(data),
    		        dataType: "json", 	
    		        crossOrigin: true,
    		        contentType: 'application/json'
    			    }).done(function (data,status) {
    			            alert(status); 
    			    }).fail(function (xhr, textStatus, error) {
    			    	alert("Failed to Insert");
    			    }); 
    		   	return false;
            }); 
         });
        
         function deleteNotification(id){
        	    
         	var url= 'http://localhost:8086/notifications/deleteNotification/'+id;
             var x =$.ajax({
                 url: url,
                 crossOrigin: true,
                 type: 'DELETE',
                 dataType: 'json',
                accept: 'application/json'
             	
             }).done(function (data) {           	 
             	alert(data);
             	window.location.href="index.jsp";
             })
             .fail(function (xhr, textStatus, error) {
			    	alert("Failed to delete");
			    }); 
         	
         }
         
      </script>
   </head>
   
   <body>
   
	<button id="opener" class="btn btn-primary">Add New Notifications</button> 
	<div id="tableDiv" class="table-responsive"></div>
	     
      <div id = "dialog-1" title = "Schedule Message">
      <form id="notifyForm">
      	<div class="form-group row">
         	<label class="col-sm-4 control-label">Email id</label>
            <div class="col-sm-8">
            	<input type="email" name="emailid" id="emailId" class="form-control" required>
            </div>
         </div>     
         <div class="form-group row">
         	<label class="col-sm-4 control-label">Notification name</label>
            <div class="col-sm-8">
            	<input type="text" name="name" id="notificationName" class="form-control">
            </div>
         </div>   
         <div class="form-group row">
         	<label class="col-sm-4 control-label">Message</label>
            <div class="col-sm-8">
            	<textarea  rows="2" name="message" id="message" class="form-control" required></textarea>
            </div>
         </div>      
         <div class="form-group row">
         	<label class="col-sm-4 control-label">Schedule date and time</label>
            <div class="col-sm-8">
            	<input type="datetime-local" name="date" id="scheduleDate" class="form-control" min="2017-11-06 12:27:00">
            </div>
         </div>       
         
         <div class="modal-footer">       
         	<button type="Submit" class="btn btn-primary">Save</button>
         	<button type="Submit" class="btn btn-primary">Send</button>
         </div>
         </form>
     </div>
   </body>
</html>