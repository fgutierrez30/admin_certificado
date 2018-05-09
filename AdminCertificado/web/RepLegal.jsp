<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
   
  
 <%@include file="master/head.jsp" %>
</head>
<body class="hold-transition sidebar-mini">
    <jsp:include page="./EmpresasVigente" flush="true"/>
    <jsp:useBean id="empresas" class="cl.circuloverde.certificado.entidades.Empresa" scope="page"></jsp:useBean>
<!-- Site wrapper -->
<div class="wrapper">
  <!-- Navbar -->
  <nav class="main-header navbar navbar-expand bg-white navbar-light border-bottom">
    
  </nav>
  <!-- /.navbar -->


  
  
  
  <%@include file="master/menu.jsp" %>
  
  
  
  
  
  

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Repesentantes Legales Vigentes</h1>
          </div>
          
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">

      <!-- Default box -->
      <div class="card">
        <div class="card-header">
          <h3 class="card-title">Mantenedor de Representales Legales</h3>

         
        </div>
        <div class="card-body">
          
            <table id="ejemplo" class="table table-bordered table-hover">
                
              <thead>
                    <th>Rut</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Correo</th>
                    <th>Estado</th>
              </thead>
              
              <tbody>
                  <c:forEach items="${reprensentanteVig}" var="representante">
                  <tr>
                      <td><c:out value="${representante.r}"/></td>
                      <td><c:out value="${representante.razonSocial}"/></td>
                      <td><c:out value="${representante.idHolding.nomHolding}"/></td>
                      <td><a href="./detEmpresa?rut_emp=${empresa.rutEmpresa}"><small class="badge badge-danger"> Ver Detalle</small></a> </td>
                      
                      
                  </tr>
                  </c:forEach>                
              </tbody>
                
            </table> 
            
            
            
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

 <script>
    
    $(document).ready( function () {
        
    $('#ejemplo').DataTable(
            {
                language:{
                    
                    search: "Buscar:",
                    sInfoEmpty:"Mostrando registros del 0 al 0 de un total de 0 registros",
                    sInfo:"Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
                    oPaginate: {
                                sFirst:    "Primero",
                                sLast:     "�ltimo",
                                sNext:     "Siguiente",
                                sPrevious: "Anterior"
                                },
                    sInfoFiltered:   "(filtrado de un total de _MAX_ registros)",
                    sLengthMenu:     "Mostrar _MENU_ registros"
                }
            } 
                );
    
    } );
    
</script>
<!-- jQuery -->

</body>
</html>
