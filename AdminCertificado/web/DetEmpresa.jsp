<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
   
  
 <%@include file="master/head.jsp" %>
</head>
<body class="hold-transition sidebar-mini">
      <jsp:useBean id="empresas" class="cl.circuloverde.certificado.entidades.Empresa" scope="page"></jsp:useBean>
<<<<<<< HEAD
      <jsp:useBean id="rpt" class="cl.circuloverde.certificado.entidades.RptlegalPerfilEmpresa" scope="page"></jsp:useBean>
=======
      <jsp:useBean id="rptsLegal" class="cl.circuloverde.certificado.entidades.RptlegalPerfilEmpresa" scope="page"></jsp:useBean>
>>>>>>> 21e97296691c8ab8f2b0045f8cd17621ac02b36c
<!-- Site wrapper -->
<div class="wrapper">
  <!-- Navbar -->
  <nav class="main-header navbar navbar-expand bg-white navbar-light border-bottom">
    
  </nav>
  <!-- /.navbar -->


  
  <%@include file="master/menu.jsp" %>
  


  
  
  
  <%@include file="master/menu.jsp" %>
  
  
  
  
  
  


  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Detalle Empresa</h1>
          </div>
          
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">

      <!-- Default box -->
      <div class="card">
        <div class="card-header">

          <h3 class="card-title">Mantenedor de Clientes</h3>


          
   <section class="content">
      <div class="container-fluid">
        <div class="row">
          <!-- left column -->
          <div class="col-md-6">
              
          <!-- /.Mantenedor de empresas --> 
            <div class="card card-primary">
              <div class="card-header">
                <h3 class="card-title">Empresa</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              
                <div class="card-body">
                  <div class="form-group">
                    <label for="exampleInputEmail1">Rut:</label>
                    <c:out value="${empresa.rutEmpresa}"/>
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Razon Social:</label>
                    <c:out value="${empresa.razonSocial}"/>
                  </div>
                  <div class="form-group">
                    <label for="exampleInputFile">Estado</label>
                    <c:choose>
                        <c:when test="${empresas.estadoEmp==0}">
                            VIGENTE
                        </c:when>    
                        <c:otherwise>
                            NO VIGENTE
                        </c:otherwise>
                   </c:choose>
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Mail Contacto:</label>
                    <c:out value="${empresa.mailContacto}"/>
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Mail SII:</label>
                    <c:out value="${empresa.mailSii}"/>
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Mail Administrador:</label>
                    <c:out value="${empresa.mailAdm}"/>
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Holding:</label>
                    <c:out value="${empresa.idHolding.nomHolding}"/>
                  </div>
                  
                </div>
                <!-- /.card-body -->

                <div class="card-footer">
                    <button type="button" class="btn btn-primary">Modificar</button>
                </div>
              
            </div>
          </div>
          <!-- /.Mantenedor de empresas -->
          
          <!--/.col (left) -->
          <!-- right column -->
          <div class="col-md-6">
            <!-- Horizontal Form -->
            <div class="card card-info">
              <div class="card-header">
                <h3 class="card-title">Representante Legal</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              
                <div class="card-body">
<<<<<<< HEAD
                    <div class="form-group">
                    <label  class="col-sm-2 control-label">Rut:</label>
                    <c:out value="${rpt.rutRptLegal.rutRptLegal}"/>
                    </div>
                    
                    <div class="form-group">
                    <label  class="col-sm-2 control-label">Nombre:</label>
                    </div>
                  
                    <div class="form-group">
                    <label  class="col-sm-2 control-label">Correo:</label>
                    </div>
=======
                    <table>
                        
                        <thead>
                            
                        <th>Rut</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Estado</th>
                        <th>Correo</th>
                         
                        </thead>
                        <tbody>
                            <c:forEach items="${rpt}" var="infRpt">
                            <tr>
                                <td><c:out value="${infRpt.rutRptLegal.rutRptLegal}"/> </td>
                                <td><c:out value="${infRpt.rutRptLegal.nomRptLegal}"/></td>
                                <td><c:out value="${infRpt.rutRptLegal.apellRptLegal}"/></td>
                                <c:choose>
                                    <c:when test="${infRpt.rutRptLegal.estadoRptLegal==2}">
                                            Sin Asignar
                                        </c:when>
                                            <c:when test="${infRpt.rutRptLegal.estadoRptLegal==0}">
                                            No Vigente
                                        </c:when>
                                        <c:otherwise>
                                            Vigente
                                        </c:otherwise>
                                 </c:choose>
                                
                                
                                
                                <td><c:out value="${infRpt.rutRptLegal.correoRptLegal}"/></td>
                                
                                       
                                
                                
                            </tr>
                            
                           </c:forEach> 
                        </tbody>   
                        
                        
                    </table>
>>>>>>> 21e97296691c8ab8f2b0045f8cd17621ac02b36c
                  </div>
                  
                </div>
                <!-- /.card-body -->
                <div class="card-footer">
                  <button type="submit" class="btn btn-info">Sign in</button>
                  <button type="submit" class="btn btn-default float-right">Cancel</button>
                </div>
                <!-- /.card-footer -->
                </div>
            <!-- /.card -->
            <!-- general form elements disabled -->
           
            <!-- /.card -->
          </div>
          <!--/.col (right) -->
        </div>
        <!-- /.row -->
      </div><!-- /.container-fluid -->
    </section>
    <!-- /.content -->
 
         
        </div>

        <div class="card-body">

        </div>
          
 

       
          
 
        <!-- /.card-body -->

        
        <!-- /.card-footer-->
      </div>
      <!-- /.card -->

    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

 

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
  </aside>
  <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->


</body>
</html>
