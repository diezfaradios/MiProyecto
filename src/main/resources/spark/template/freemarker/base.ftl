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
        <br><p>Realizado por Alumno Juan Jose Alemany usando Spark & Freemarker</p>
        <nav>
  <ul class="pager">
    <li><a href="#">Previous</a></li>
    <li><a href="#">Next</a></li>
  </ul>
</nav>
    </div>  

    </body>
    </html>

</#macro>