<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="master/head.jsp" %>
        
    </head>
    <body>
        
          <div class="card card-danger">
              <div class="card-header">
                <h3 class="card-title">Asigna Empresa</h3>
              </div>
              <div class="card-body">
                
                                
                  <form role="form" method="post" action="./asigEmpRpt">
                <div class="card-body">
                 <div class="row">
                  
                  <div class="col-12">
                      <select class="form-control" name="cmbHolding">
                          <option>(Seleccione Holding)</option>
                          <c:forEach items="${holding}" var="hdl">
                              <option value="${hdl.idHolding}"><c:out value="${hdl.nomHolding}"/> </option>  
                              
                          </c:forEach>
                      </select>
                  </div>
                  
                </div>
                  <br> 
                  <div class="row"> 
                    <div class="col-12">
                        <select class="form-control" name="cmbEmpresa">
                          <option>(Seleccione Empresa)</option>
                         
                      </select>
                  </div>
                  
                </div>
                  <br>
                
                  
                  <fieldset>
                      <legend>Permisos SII</legend>
                      <input type="checkbox" name="chkAdm" value="1"/>Administrador<br />
                      <input type="checkbox" name="chkFD" value="3" />Firmar Docto<br />
                      <input type="checkbox" name="chkReg" value="4" />Registros<br />
                      <input type="checkbox" name="chkSF" value="5" />Solicitar Folios<br />
                      <input type="checkbox" name="chkAF" value="6" />Anular Folios<br />
                      <input type="checkbox" name="chkED" value="7" />Enviar Doctos<br />
                      <input type="checkbox" name="chkConsult" value="8" />Consulta<br />
                      <input type="checkbox" name="chkConsult" value="9" />LCE<br />
                      <input type="checkbox" name="chkConsult" value="10" />Sin Permiso<br />
                  </fieldset>
                  
                </div>
                
                      <input type="hidden" name="idRpt" value="${rpt.rutRptLegal}" />

                <div class="card-footer">
                  <button type="submit" class="btn btn-danger">Asignar</button>
                </div>
              </form>
                  
                 
                  
                  
              </div>
              <!-- /.card-body -->
            </div>
  
        
  <script>
$(document).ready(function(){
	
	$('select[name=cmbHolding]').on('change', function(){
            
            $.ajax({
                type: 'POST',
                url: './asignaEmpresa',
                data: 'id_holding='+$('select[name=cmbHolding]').val(),
                statusCode:{
                    404:function ()
                    {
                        alert('Pagina no encontrada');
                    },
                    500:function ()
                    {
                        alert('Servidor no encontrado');
                    }
                },
                success: function (data) {
                        $('select[name=cmbEmpresa] option').remove();
                        var pegados=data.split(":");
                        for(var i=0;i<pegados.length-1;i++)
                        {
                            var rut_emp=pegados[i].split("_")[0];
                            var rz=pegados[i].split("_")[1];
                            $('select[name=cmbEmpresa]').append('<option value='+rut_emp+'>'+rz+'</option>');
                        }
                    }
            });
        
	});	
    
});

</script>      
        
        
        
        
        
    </body>
</html>

