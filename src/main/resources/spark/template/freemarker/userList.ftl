<#include "base.ftl">

<#macro content>
 
  <fieldset>
        <cabecera>DISCO</cabecera>
  <form name="disco" action="/disco/create" method="post">
        Titulo: <input type="text" name="titulo" /> <br/>
        Autor: <input type="text" name="autor" /> <br/>
        Año: <input type="text" name="año" /> <br/>
        Estilo: <input type="text" name="estilo" /> <br/>
        Numero canciones: <input type="text" name="numeroCanciones" /> <br/>
        <input type="submit" value="   Save   " />
  </form>
  </fieldset>
  <br/>
  <div class="table-responsive">
  <table class="table">
 
</div>
  <table class="datatable","active">
    <td class="active">
        <tr>
                <th>titulo</th>  <th>autor</th> <th>año</th> <th>estilo</th> <th>NumeroCanciones</th>
        </tr> 
        <#list discos as disco>
        <tr>
                <td>${disco.titulo}</td> <td>${disco.autor}</td>
                <td>${disco.año}</td> <td>${disco.estilo}</td>
                <td>${disco.numeroCanciones}</td>

                <td>
                         <a href="/disco/borrar/${disco_index}">borrar</a>
                </td>
                <td>
                         <a href="/disco/editar/${disco_index}">editar</a>
                </td>

              

        </tr>
        </td>
        </#list>
  </table>
   </table>

</#macro>
   
<@display_page/>    