 
<div class="col-md-12">
            <!-- Horizontal Form -->
            <div class="card card-primary">
              <div class="card-header">
                <h3 class="card-title">Edita Representante Legal</h3>
              </div>
               <form method="post" action="./editaRpt">  
              <div class="card-body">
                  
                  
                  <div class="row">
                      <div class="col-4">
                        <label for="rut">Rut</label>
                        <input type="text" class="form-control" id="rut" disabled="" value="${rpt.rutRptLegal}" >  
                      </div>
                      
                      <div class="col-4">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" id="nombre" name="txtNombre" value="${rpt.nomRptLegal}" >  
                      </div>
                      
                      <div class="col-4">
                        <label for="apellido">Apellido</label>
                        <input type="text" class="form-control" id="apellido" name="txtApellido" value="${rpt.apellRptLegal}" >  
                      </div>
                      
                      <div class="col-7">
                        <label for="email">Correo</label>
                        <input type="text" class="form-control" id="email" name="txtCorreo" value="${rpt.correoRptLegal}" >  
                      </div>
                      
                      <div class="col-5">
                        <label for="estado">Estado</label>
                        <select class="form-control" id="estado" name="cmbEstado">
                            <option value="0">Vigente</option>
                            <option value="1"> No Vigente</option>
                        </select>
                      </div>
                      
                  </div>
                  
                  
                      <input type="hidden" name="rut_rpt" value="${rpt.rutRptLegal}"/>
                                                      
                </div>
                
                <div class="card-footer">
                    <button type="submit" class="btn btn-primary">Actualizar</button>
                </div>
                
               </form>  
              
            </div>
             
            
              
                <!-- /.card-footer -->
</div>
                
