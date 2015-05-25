<#macro title>
  Base Page Title
</#macro>

<#macro content>
  Here goes content
</#macro>


<#macro display_page>

    <html>
    <head>
        <title><@title/></title>
        <link rel="stylesheet" type="text/css" href="/css/styles.css" media="screen" />
     
    </head>
     
    <body>
    <div id="header">
    <H2><ins>
    <p class="text-center">DISCOTECA</p>
            
    </ins></H2>
    </div>

    <div id="content">

        <@content/>       

    </div>

    <div id ="footer">
        <p>Página realizada por Alumno Juan Jose Alemany usando Spark & Freemarker</p>
    </div>  

    </body>
    </html>

</#macro>