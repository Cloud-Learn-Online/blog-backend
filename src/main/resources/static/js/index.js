$(".update").click(function(){
	showModal("update",$(this));
})

$(".create").click(function(){
	showModal("create",$(this));
})

$(".like").click(function(){
	if ($(this).children("i").hasClass("fa-thumbs-o-up")) {
		$(this).children("i").removeClass("fa-thumbs-o-up");
		$(this).children("i").addClass("fa-thumbs-up");
		count = $(this).siblings("span").text();
		$(this).siblings("span").text(parseInt(count)+1);
	}
	else {
		$(this).children("i").addClass("fa-thumbs-o-up");
		$(this).children("i").removeClass("fa-thumbs-up");
		count = $(this).siblings("span").text();
		$(this).siblings("span").text(parseInt(count)-1);
		
	}
})

function showModal(title, obj){
	if(title==="update"){
		cbody = $(obj).parents(".card-header").siblings(".card-body");
		let title = $(cbody).children(".card-title").text();
		description = $(cbody).children(".card-text").text();
		$("#exampleFormControlInput1").val(title);
		$("#exampleFormControlTextarea1").val(description);
	}
	else {
		$("#exampleFormControlInput1").val("");
		$("#exampleFormControlTextarea1").val("");		
	}
	$("#exampleModal").find(".modal-title").text(title.toUpperCase() +" POST")
	$("#exampleModal").modal("show");
}