$(document).ready(function(){
	
	var id1 = 0;
	var id2 = 0;
	var tip1 = "";
	var tip2 = "";
	
	$("#kreirajKom").click(function(event){
		
		var idPrvog = $("#comboSertifikat1 option:selected").val();
		var idDrugog = $("#comboSertifikat2 option:selected").val();
		
		$.ajax({
			type: "POST",
			url: "/Communication/create/"+idPrvog+"/"+idDrugog,
			contentType: 'application/json',
			success: function(data){
				$.ajax({
					type: "GET",
					url: "/Certificate/"+idPrvog,
					contentType: 'application/json',
					success: function(data){
						id1 = data.id;
						tip1 = data.tip;
					},
				});
				$.ajax({
					type: "GET",
					url: "/Certificate/"+idDrugog,
					contentType: 'application/json',
					success: function(data){
						id2 = data.id;
						tip2 = data.tip;
					},
				});
				//$("#tabelaNovihSertifikataKom").html("");
				upisiZaKomunikaciju(id1,id2,tip1,tip2);
			},
		});
	});
	
	function upisiZaKomunikaciju(id1,id2,tip1,tip2) {
		var pom = '<tr><td>'+id1+'</td>'+
				'<td>'+tip1+'</td>'+
				'<td>'+id2+'</td>'+
				'<td>'+tip2+'</td></tr>';
		$("#tabelaNovihSertifikataKom").append(pom);
	}
	
});