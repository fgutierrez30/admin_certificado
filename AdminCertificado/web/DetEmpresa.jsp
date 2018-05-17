<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
   
  
 <%@include file="master/head.jsp" %>
</head>



<body class="hold-transition sidebar-mini">
      <jsp:useBean id="empresas" class="cl.circuloverde.certificado.entidades.Empresa" scope="page"></jsp:useBean>



      <jsp:useBean id="rpts" class="cl.circuloverde.certificado.entidades.RptlegalPerfilEmpresa" scope="page"></jsp:useBean>



      <jsp:useBean id="rptsLegal" class="cl.circuloverde.certificado.entidades.RptlegalPerfilEmpresa" scope="page"></jsp:useBean>

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

         


          
   <section class="content">
      <div class="container-fluid">
        <div class="row">
          <!-- left column -->
          <div class="col-md-4">
              
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
                        <c:when test="${empresa.estadoEmp==0}">
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
              
                
                <!-- pop up -->
                <div class="Container" style="margin-top: 100px;"  >
                    <button class="btn btn-info" data-toggle="modal" data-target="#miventana">
                     Abrir Ventana
                    </button>                
                </div>
                
                
                <div class="modal fade bd-example-modal-lg" id="miventana" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                   <div class="modal-dialog modal-lg" role="document"> 
                       <div class="modal-content"> 
                           <div class="modal-header">     
                               <table class="table">     
                        <thead>
                         
                        <th>Estado</th>
                        <th>Rut</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Correo</th>
                        <th></th>
                         
                        </thead>
                 
                            <tbody>
                                    
                            <c:forEach items="${rpt}" var="infRpt">
                            <tr>
                                <td><c:choose>
                                        <c:when test="${infRpt.estadoAsigna==2}">
                                                Sin Asignar
                                            </c:when>
                                            <c:when test="${infRpt.estadoAsigna==1}">
                                                No Vigente
                                            </c:when>
                                            <c:when test="${infRpt.estadoAsigna==0}">
                                                Vigente
                                            </c:when>
                                    </c:choose>                             
                                </td>
                                <td> <c:out value="${infRpt.rutRptLegal.rutRptLegal}"/> </td>
                                <td><input type ="text" value="${infRpt.rutRptLegal.nomRptLegal}"/></td>
                                <td><input type ="text" value="${infRpt.rutRptLegal.apellRptLegal}"/></td>                               
                                <td><input type ="text" value="${infRpt.rutRptLegal.correoRptLegal}"/></td> 
                            </tr>
                           </c:forEach> 
                            
                            
                            
                            </tbody>
                       </table>

                               
                               <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                               
                           </div>  
                                
                                <div class="modal-body">
                                    <p class="lead text-xs-center">Modificar usuarios</p>
                                        <div class="lead text-xs-center">
                                            <a class="btn btn-info" href="#">Modificar</a>
                                        </div>
                                </div>
                       </div>
                   </div>
                    
                </div>
                <!-- fin pop up -->
                
                
            </div>
          </div>
          <!-- /.Mantenedor de empresas -->
          
          <!--/.col (left) -->
          <!-- right column -->
          <div class="col-md-8">
            <!-- Horizontal Form -->
            <div class="card card-info">
              <div class="card-header">
                <h3 class="card-title">Representante Legal</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              
                <div class="card-body">


                    
                    <table class="table">

                        <thead>
                         
                        <th>Estado</th>
                        <th>Rut</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Correo</th>
                        <th></th>
                         
                        </thead>
                        <tbody>
                            <c:forEach items="${rpt}" var="infRpt">
                            <tr>
                                <td><c:choose>
                                        <c:when test="${infRpt.estadoAsigna==2}">
                                            Sin Asignar

                                        </c:when>
                                            <c:when test="${infRpt.estadoAsigna==1}">
                                   No Vigente

                                    </c:when>
                                            <c:when test="${infRpt.estadoAsigna==0}">

                                                Vigente
                                             </c:when>
                                           
                                       
                                 </c:choose>
                                
                                </td>
                                <td><c:out value="${infRpt.rutRptLegal.rutRptLegal}"/> </td>
                                <td><c:out value="${infRpt.rutRptLegal.nomRptLegal}"/></td>
                                <td><c:out value="${infRpt.rutRptLegal.apellRptLegal}"/></td>
                                                               
                                <td><c:out value="${infRpt.rutRptLegal.correoRptLegal}"/></td>
                                <td>
                                    
                                    <c:choose>
                                        <c:when test="${infRpt.estadoAsigna==2}">
                                            
                                        </c:when>
                                        <c:otherwise>
                                            <a href="#"><small class="badge badge-info">Editar</small></a>
                                        </c:otherwise>
                                    </c:choose>
                                    
                                </td>
                             
                               
                            </tr>
                            
                           </c:forEach> 
                        </tbody>   
                        
                        
                    </table>

                  </div>
                  
                </div>
                <!-- /.card-body -->
              
                <!-- /.card-footer -->
          </div>
            <!-- /.card -->
            <!-- general form elements disabled -->
           
            <!-- /.card -->
          </div>
          <!--/.col (right) -->
        </div>
        <!-- /.row -->
      
    </section>
    <!-- /.content -->
 
         
      
          
 
        <!-- /.card-body -->

        
        <!-- /.card-footer-->
      </div>
      <!-- /.card -->
      </div>
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

 


  <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->


</body>
</html>
