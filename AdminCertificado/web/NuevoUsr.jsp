 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
  
<div class="col-md-12">
            <!-- Horizontal Form -->
            <div class="card card-danger">
              <div class="card-header">
                <h3 class="card-title">Crear Usuario</h3>
              </div>
               <form method="post" action="./nvoUsr">  
              <div class="card-body">
                  
              
                  <div class="row">
                      <div class="col-4">
                        <label for="rut">Rut</label>
                        <input type="text" class="form-control" id="rut" name="txtRut">  
                      </div>
                      
                      <div class="col-4">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" id="nombre" name="txtNombre" >  
                      </div>
                      
                      <div class="col-4">
                        <label for="apellido">Apellido</label>
                        <input type="text" class="form-control" id="apellido" name="txtApellido" >  
                      </div>
                      
                      <div class="col-7">
                        <label for="cargo">Cargo</label>
                        <select class="form-control" id="cargo" name="cmbCargo">
                            <option selected="">(Seleccione)</option>
                            <c:forEach items="${cargo}" var="cargos">
                              
                                    <option value="${cargos.idCargoUsr}"><c:out value="${cargos.nomCargoUsr}"/></option>  
                             
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
                    <button type="submit" class="btn btn-danger">Actualizar</button>
                </div>
                
               </form>  
              
            </div>
             
            
              
                <!-- /.card-footer -->
</div>
