<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="master/head.jsp" %>
        <link href="css/datepicker3.css" rel="stylesheet" type="text/css"/>
        
        <script src="js/bootstrap-datepicker.js" type="text/javascript"></script>
        <script> 
            $(function (){
            $('#fechacompra').datepicker({autoclose:true,language:'es',format:'dd/mm/yyyy'}).attr('readonly','readonly');
            $('#fechavcto').datepicker({autoclose:true,language:'es',format:'dd/mm/yyyy'}).attr('readonly','readonly');
            });
        </script>
        
    </head>
    <body>
        
          <div class="card card-warning">
              <div class="card-header">
                <h3 class="card-title">Nueva Firma</h3>
              </div>
              <div class="card-body">
                
                                
                  <form role="form" method="post" action="./regFirma">
                <div class="card-body">
                
                 
                <div class="row">
                    <div class="col-4">
                    <label for="fechacompra">Fecha Compra</label>
                    <input type="text" class="form-control" id="fechacompra" name="txtfCompra" >
                    </div>
                    <div class="col-4">
                    <label for="fechavcto">Fecha Vcto</label>
                    <input type="text" class="form-control" id="fechavcto" name="txtfVcto" >
                    </div>
                    <div class="col-4">
                    <label for="clave">Clave</label>
                    <input type="text" class="form-control" id="clave" name="txtClave" >
                    </div>
                </div>
                 
                
                      <input type="hidden" name="idRpt" value="${rpt.rutRptLegal}" />
                 </div>     
                <div class="card-footer">
                  <button type="submit" class="btn btn-warning">Crear</button>
                </div>
              </form>
                  
                 
                  
                  
              
              <!-- /.card-body -->
            
  
        
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

