<#import "macro.ftl" as main />

<@main.page title="User Admin"
scripts=['/layout/datatables/js/datatables.js','/layout/schedule/js/user.js']
styles=['/layout/datatables/css/datatables.css','/layout/schedule/css/user.css']>

<table id="user" class="display" cellspacing="0" width="100%">
	<thead>
		<tr>
			<th>ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Login</th>
			<th>Email</th>
			<th>Active</th>
		</tr>
	</thead>
</table>
<script>
	$(document).ready(function() {
		$('#user').DataTable({
			"ajax" : function(data, callback, settings) {
				callback(userViewModel.findAll());
			},
			columns : [ {
				data : 'id'
			}, {
				data : 'firstName'
			}, {
				data : 'lastName'
			}, {
				data : 'login'
			}, {
				data : 'email'
			}, {
				data : 'enabled'
			} ]
		});
	});
</script>
</@main.page>
