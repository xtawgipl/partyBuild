<!DOCTYPE html>
<html lang="zh">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>党员先锋指数</title>
		<meta name="description" content="overview &amp; stats" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		<link href="${basePath}static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<link href="${basePath}static/bootstrap-fileinput-master/css/fileinput.css" media="all" rel="stylesheet" type="text/css"/>
		<link href="${basePath}static/bootstrap-fileinput-master/themes/explorer/theme.css" media="all" rel="stylesheet" type="text/css"/>
		<script src="${basePath}static/jQuery/jquery.min.js"></script>
		<script src="${basePath}static/bootstrap-fileinput-master/js/plugins/sortable.js" type="text/javascript"></script>
		<script src="${basePath}static/bootstrap-fileinput-master/js/fileinput.js" type="text/javascript"></script>
		<script src="${basePath}static/bootstrap-fileinput-master/js/locales/zh.js" type="text/javascript"></script>
		<script src="${basePath}static/bootstrap-fileinput-master/themes/explorer/theme.js" type="text/javascript"></script>
		<script src="${basePath}static/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	</head>
<body>
	<div class="container kv-main">
		<form enctype="multipart/form-data">
			<input id="file-0a" class="file" type="file" multiple data-min-file-count="1">
			<br>
			<button type="submit" class="btn btn-primary">提交</button>
			<button type="reset" class="btn btn-default">重置</button>
		</form>
		<hr>
	</div>
</body>
<script>
    $("#file-0").fileinput({
        'allowedFileExtensions': ['jpg', 'png', 'gif']
    });
    $(document).ready(function () {

    });
</script>
</html>
