 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
  
<div class="col-md-12">
            <!-- Horizontal Form -->
            <div class="card card-danger">
              <div class="card-header">
                <h3 class="card-title">Crear Holding</h3>
              </div>
               <form method="post" action="./hdlServlet">  
              <div class="card-body">
                  
              
                  <div class="row">
                      <div class="col-12">
                        <label for="rut">Nombre</label>
                        <input type="text" class="form-control" id="rut" name="txtNombre">  
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
