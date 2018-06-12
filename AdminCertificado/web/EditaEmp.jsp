<meta charset="utf-8">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-md-12">
            <!-- Horizontal Form -->
            <div class="card card-primary">
              <div class="card-header">
                <h3 class="card-title">Edita Empresa</h3>
              </div>
               <form method="post" action="./editaEmp">  
              <div class="card-body">
                  
                  
                  <div class="row">
                      <div class="col-4">
                        <label for="rut">Rut</label>
                        <input type="text" class="form-control" id="rut" disabled="" value="${emp.rutEmpresa}" >  
                      </div>
                      
                      <div class="col-5">
                        <label for="estado">Estado</label>
                        <select class="form-control" id="estado" name="cmbEstado">
                            <option value="0">Vigente</option>
                            <option value="1"> No Vigente</option>
                        </select>
                      </div>
                      
                      <div class="col-12">
                        <label for="nombre">Razon Social</label>
                        <input type="text" class="form-control" id="nombre" name="txtRazonSocial" value="${emp.razonSocial}" >  
                      </div>
                      
                      <div class="col-8">
                        <label for="apellido">Mail Contacto</label>
                        <input type="text" class="form-control" id="apellido" name="txtMailContacto" value="${emp.mailContacto}" >  
                      </div>
                      
                      <div class="col-8">
                        <label for="email">Mail SII</label>
                        <input type="text" class="form-control" id="email" name="txtMailSII" value="${emp.mailSii}" >  
                      </div>
                      
                      <div class="col-8">
                        <label for="email">Mail Administrador</label>
                        <input type="text" class="form-control" id="email" name="txtMailAdm" value="${emp.mailAdm}" >  
                      </div>
                      
                      <div class="col-12">
                        <label for="estado">Holding</label>
                        <select class="form-control" id="estado" name="cmbHolding">
                            <c:forEach items="${hdl}" var="holding">
                                <c:choose>
                                    <c:when test="${holding.idHolding==emp.idHolding.idHolding}">
                                        <option value="${holding.idHolding}" selected=""><c:out value="${holding.nomHolding}"/></option> 
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${holding.idHolding}"><c:out value="${holding.nomHolding}"/></option>
                                    </c:otherwise>
                                </c:choose>
                                
                            </c:forEach>
                        </select>
                      </div>
                      
                  </div>
                  
                  
                      <input type="hidden" name="rut_emp" value="${emp.rutEmpresa}"/>
                                                      
                </div>
                
                <div class="card-footer">
                    <button type="submit" class="btn btn-primary">Actualizar</button>
                </div>
                
               </form>  
              
            </div>
             
            
              
               
</div>
        