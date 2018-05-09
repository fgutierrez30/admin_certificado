<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
   
  
 <%@include file="master/head.jsp" %>
</head>
<body class="hold-transition sidebar-mini">
      <jsp:useBean id="empresas" class="cl.circuloverde.certificado.entidades.Empresa" scope="page"></jsp:useBean>
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
<<<<<<< HEAD
          <h3 class="card-title">Mantenedor de Clientes</h3>
=======
          
>>>>>>> 62704c0b3ba89f0fe62bd6ae9f4541d134b81b2a

          
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
              <form class="form-horizontal">
                <div class="card-body">
                    <div class="form-group">
                    <label  class="col-sm-2 control-label">Rut:</label>
                    </div>
                    
                    <div class="form-group">
                    <label  class="col-sm-2 control-label">Nombre:</label>
                    </div>
                  
                    <div class="form-group">
                    <label  class="col-sm-2 control-label">Correo:</label>
                    </div>
                  </div>
                  
                </div>
                <!-- /.card-body -->
                <div class="card-footer">
                  <button type="submit" class="btn btn-info">Sign in</button>
                  <button type="submit" class="btn btn-default float-right">Cancel</button>
                </div>
                <!-- /.card-footer -->
              </form>
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
<<<<<<< HEAD
        <div class="card-body">

        </div>
          
 
=======
       
          
 
        <!-- /.card-body -->
>>>>>>> 62704c0b3ba89f0fe62bd6ae9f4541d134b81b2a
        
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
