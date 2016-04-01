<!DOCTYPE html>
<html>
<head>
	<title>Chat</title>
	<link rel="stylesheet" type="text/css" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<?=$api_host?>socket.io/socket.io.js"></script>
	<script type="text/javascript" src="js/core.js"></script>
</head>
<body>

<div class="container">
	<form action="start_chat.php" method="GET">
		<legend>Chat settings:</legend>
		<div class="form-group">
			<input type="text" class="form-control" name="api_host" placeholder="Host">
		</div>
		<div class="form-group">
			<input type="text" class="form-control" name="token" placeholder="User Token">
		</div>		
		<div class="form-group">
			<input type="submit" class="btn btn-primary" value="Star Chat">
		</div>
	</form>
</div>

</body>
</html>