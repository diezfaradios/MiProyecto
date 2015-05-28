<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EDITAR DISCOTECA</title>
<link rel="stylesheet" type="text/css" href="/css/view.css" media="all">


</head>
<body id="main_body" >
	
	<img id="top" src="top.png" alt="">
	<div id="form_container">
	
		<h1><a>EDITAR DISCOTECA</a></h1>
		<form id="form_1015054" class="appnitro"  method="post" action="">
					<div class="form_description">
			<h2>EDITAR DISCOTECA</h2>
			<p></p>
		</div>						
			<ul >
			
					<li id="li_1" >
		<label class="description" for="titulo">TITULO </label>
		<div>
			<input id="element_1" name="titulo" class="element text medium" type="text" maxlength="255" value="${disco.titulo}"/> 
		</div> 
		</li>		<li id="li_2" >
		<label class="description" for="autor">AUTOR </label>
		<div>
			<input id="element_2" name="autor" class="element text medium" type="text" maxlength="255" value="${disco.autor}"/> 
		</div> 
		</li>		<li id="li_3" >
		<label class="description" for="año">AÑO </label>
		<div>
			<input id="element_3" name="año" class="element text small" type="text" maxlength="255" value="${disco.año}"/> 
		</div> 
		</li>		<li id="li_4" >
		<label class="description" for="estilo">ESTILO </label>
		<div>
			<input id="element_4" name="estilo" class="element text medium" type="text" maxlength="255" value="${disco.estilo}"/> 
		</div> 
		</li>		<li id="li_5" >
		<label class="description" for="numeroCanciones">NUMERO CANCIONES </label>
		<div>
			<input id="element_5" name="numeroCanciones" class="element text medium" type="text" maxlength="255" value="${disco.numeroCanciones}"/> 
		</div> 
		</li>
			
					<li class="buttons">
			    <input type="hidden" name="form_id" value="1015054" />
			    
				<input id="saveForm" class="button_text" type="submit" name="submit" value="Guardar" />
		</li>
			</ul>
		</form>	
	</div>
	<img id="bottom" src="bottom.png" alt="">
	</body>
</html>