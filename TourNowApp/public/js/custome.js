function sendDeleteRequest(url, rUrl){
	$.ajax({
		url: url,
		method: "DELETE",
		success: function(){
			window.location = rUrl;
		},
		error: function(){
			window.location=reload();
		}
	});
}


function getLocation(){
	//set endpoint and your access key
	var ip = 'check'
	var access_key = '2dc9de58a43d84d05c924e0c8ab335d3';
	var city=""
	
	// get the API result via jQuery.ajax
	$.ajax({
	    url: 'http://api.ipstack.com/' + ip + '?access_key=' + access_key,   
	    dataType: 'jsonp',
	    success: function(json) {
	        // output the "capital" object inside "location"
			console.log(json.city);
			city = json.city;
	    },
		error: function(){
			alert("error");
		}
	});
}