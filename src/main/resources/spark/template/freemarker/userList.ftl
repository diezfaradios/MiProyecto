<#include "base.ftl">

<#macro content>
 
  <fieldset>
        <cabecera>DISCO</cabecera>
  <form name="disco" action="/disco/create" method="post">
  
        Titulo:<input type="text" name="titulo" /> <br/>
        Autor: <input type="text" name="autor" /> <br/>
        Año: <input type="text" name="año" /> <br/>
        Estilo: <input type="text" name="estilo" /> <br/>
        Numero canciones: <input type="text" name="numeroCanciones" /> 
        <input type="submit" value="Save" />

  </form>
  </fieldset>
  <br/>
  <div class="table-responsive">
  <table class="table">
 
</div>
  <table class="datatable","active">
  
                <th>Titulo</th>  <th>Autor</th> <th>Año</th> <th>Estilo</th> <th>Numero Canciones</th> <hr> <th>Edicion</th>
       
    <td class="active">
       
        <#list discos as disco>
        <tr>
                <td>${disco.titulo}</td> <td>${disco.autor}</td>
                <td>${disco.año}</td> <td>${disco.estilo}</td>
                <td>${disco.numeroCanciones}</td>

                <td>
                         <a href="/disco/borrar/${disco_index}">Borrar</a>
                </td>
                <td>
               
                         <a href="/disco/editar/${disco_index}">Editar</a>

                </td>

        </tr>
        </td>
        </#list>
  </table>
   </table>

</#macro>
   
<@display_page/>    