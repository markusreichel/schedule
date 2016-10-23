$(function() {
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});
});

var User = function(data) {
	this.id = null;
	this.login = null;
	this.email = null;
	this.firstName = null;
	this.lastName = null;
	this.enabled = null;
	this.version = null;

	if (data != null) {
		this.id = data.id;
		this.login = data.login;
		this.email = data.email;
		this.firstName = data.firstName;
		this.lastName = data.lastName;
		this.enabled = data.enabled;
		this.version = data.version;
	}
};

var Message = {
	html : function(type, message) {
		return '<div class="alert alert-dismissable alert-'
				+ type
				+ '" role="alert"><span id="alert-message">'
				+ message
				+ '</span><button id="alert-close" type="button" class="close" aria-hidden="true">&times;</button></div>';
	},

	enableClose : function() {
		$("div#alert-container div.alert button.close").click(function(e) {
			$(this).parent().remove();
		});
	},

	close : function() {
		var alert = $("div#alert-container div.alert button.close");
		if (alert.length > 0) {
			alert.parent().remove();
		}
	},

	getAlert : function() {
		return $("div#alert-container div.alert span#alert-message");
	},

	showOrCreate : function(type, message) {
		var alert = Message.getAlert();
		if (alert.length > 0) {
			if (alert.filter('div.alert-' + type).length == 0) {
				$("div#alert-container div.alert")[0].className = 'alert alert-'
						+ type;
			}
			$("div#alert-container div.alert span#alert-message").html(message);
		} else {
			$('#alert-container').html(Message.html(type, message));
			Message.enableClose();
		}
	},

	success : function(message) {
		Message.showOrCreate('success', message);
	},

	info : function(message) {
		Message.showOrCreate('info', message);
	},

	warning : function(message) {
		Message.showOrCreate('warning', message);
	},

	error : function(message) {
		Message.showOrCreate('danger', message);
	}
}
