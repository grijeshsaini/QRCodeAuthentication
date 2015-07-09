<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script type="text/javascript" src="resources/js/jquery-1.11.1.js"></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/DWRUtil.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>

<script type="text/javascript">
$(document).ready(function(){
     getImage();
    setInterval(getImage,15000);
   });



function getImage()
{

	DWRUtil.getImage(imageCallback);
}

function imageCallback(data)
{
	document.getElementById("qrCode").src=data;
}

</script>
</head>
<body>
<h2>Scan Below QR CODE</h2>
<br/>
<image id="qrCode" src="" />
</body>
</html>
