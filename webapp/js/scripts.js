$(document).ready(function() {
	$(".answerWrite input[type=submit]").click(addAnswer);
});

var addAnswer = function(e) {
	e.preventDefault();
	
	var url = "/api/qna/addAnswer";
	var queryString = $("form[name=answer]").serialize();
	
	$.ajax(url, {
		"data": queryString,
		"type": "post",
		"dataType": "json",
	}).done(function(data, status) {
		console.log(data);
		addAnswerDom(data);
	}).fail(function($xhr, status) {
		console.log(status);
		alert("error!");
	});
};

String.prototype.format = function() {
	var args = arguments;
	return this.replace(/{(\d+)}/g, function(match, number) {
		return typeof args[number] != 'undefined' ? args[number] : match;
	});
};