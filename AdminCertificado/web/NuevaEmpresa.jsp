 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
  
<div class="col-md-12">
            <!-- Horizontal Form -->
            <div class="card card-danger">
              <div class="card-header">
                <h3 class="card-title">Crear Representante</h3>
              </div>
               <form method="post" action="./nvaEmpresa">  
              <div class="card-body">
                  
              
                  <div class="row">
                      <div class="col-4">
                        <label for="rut">Rut</label>
                        <input type="text" class="form-control" id="rut" name="txtRut">  
                      </div>
                      
                      
                      
                      <div class="col-8">
                        <label for="nombre">Razon Social</label>
                        <input type="text" class="form-control" id="nombre" name="txtRazonSocial" >  
                      </div>
                      
                      <div class="col-7">
                        <label for="apellido">Mail Contacto</label>
                        <input type="text" class="form-control" id="apellido" name="txtMailContacto" >  
                      </div>
                      
                      <div class="col-7">
                        <label for="correo">Mail SII</label>
                        <input type="text" class="form-control" id="correo" name="txtMailSII" >   
                      </div>
                      
                       <div class="col-7">
                        <label for="correo">Mail Administrador</label>
                        <input type="text" class="form-control" id="correo" name="txtMailAdmin" >   
                      </div>
                      
                      <div class="col-7">
                          <label for="holding">Holding</label>
                          <select class="form-control" id="holding" name="cmbHolding">
                              <option>(Seleccione)</option>
                              <c:forEach items="${holding}" var="hdl">
                                  <option value="${hdl.idHolding}"> <c:out value="${hdl.nomHolding}"/></option>
                              </c:forEach>
                              
                              
                          </select>
                          
                          
                          
                      </div>
                     <div class="col-5">
                        <label for="estado">Estado</label>
                        <select class="form-control" id="estado" name="cmbEstado">
                                    <option>(Seleccione)</option>
                                    <option value="0">Vigente</option>
                                    <option value="1"> No Vigente</option>
                              
                        </select>
                      </div> 
                      
                      
                  </div>
                  
                                                                                             
                </div>
                
                <div class="card-footer">
                    <button type="submit" class="btn btn-danger">Crear</button>
                </div>
                
               </form>  
              
            </div>
             
            
              
                <!-- /.card-footer -->
</div>
