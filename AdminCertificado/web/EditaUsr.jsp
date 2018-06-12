<meta charset="utf-8">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
  
<div class="col-md-12">
            <!-- Horizontal Form -->
            <div class="card card-primary">
              <div class="card-header">
                <h3 class="card-title">Editar Usuario</h3>
              </div>
               <form method="post" action="./editaUsr">  
              <div class="card-body">
                  
              
                  <div class="row">
                      <div class="col-4">
                        <label for="rut">Rut</label>
                        <input type="text" class="form-control" id="rut" disabled="" value="${usuario.rutUsrCv}" >  
                      </div>
                      
                      <div class="col-4">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" id="nombre" name="txtNombre" value="${usuario.nomUsrCv}" >  
                      </div>
                      
                      <div class="col-4">
                        <label for="apellido">Apellido</label>
                        <input type="text" class="form-control" id="apellido" name="txtApellido" value="${usuario.apellUsrCv}" >  
                      </div>
                      
                      <div class="col-7">
                        <label for="cargo">Cargo</label>
                        <select class="form-control" id="cargo" name="cmbCargo">
                            <c:forEach items="${cargos}" var="cargo">
                                <c:choose>
                                    <c:when test="${cargo.idCargoUsr==usuario.tipoUsrCv.idCargoUsr}">
                                    <option value="${cargo.idCargoUsr}" selected=""><c:out value="${cargo.nomCargoUsr}"/></option>  
                                    </c:when>
                                    <c:otherwise>
                                    <option value="${cargo.idCargoUsr}"><c:out value="${cargo.nomCargoUsr}"/></option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select> 
                      </div>
                      
                      <div class="col-5">
                        <label for="estado">Estado</label>
                        <select class="form-control" id="estado" name="cmbEstado">
                            <c:choose>
                                <c:when test="${usuario.estadoUsrCv==0}">
                                    <option value="0" selected="">Vigente</option>
                                    <option value="1"> No Vigente</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="0">Vigente</option>
                                    <option value="1" selected=""> No Vigente</option>
                                </c:otherwise>
                            </c:choose>
                        </select>
                      </div>
                      
                  </div>
                  
                  
                      <input type="hidden" name="rut_usr" value="${usuario.rutUsrCv}"/>
                                                      
                </div>
                
                <div class="card-footer">
                    <button type="submit" class="btn btn-primary">Actualizar</button>
                </div>
                
               </form>  
              
            </div>
             
            
              
                <!-- /.card-footer -->
</div>
