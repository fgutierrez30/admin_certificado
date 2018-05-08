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
            <h1>Blank Page</h1>
          </div>
          
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">

      <!-- Default box -->
      <div class="card">
        <div class="card-header">
          <h3 class="card-title">Title</h3>

          <div class="card-tools">
            <button type="button" class="btn btn-tool" data-widget="collapse" data-toggle="tooltip" title="Collapse">
              <i class="fa fa-minus"></i></button>
            <button type="button" class="btn btn-tool" data-widget="remove" data-toggle="tooltip" title="Remove">
              <i class="fa fa-times"></i></button>
          </div>
        </div>
        <div class="card-body">
          
            <table>
                
              <thead>
                    <th>Rut</th>
                    <th>Razon Social</th>
                    <th>Holding</th>
                    <th></th>
              </thead>
              
              <tbody>
                  <c:forEach items="${empresasVig}" var="empresa">
                  <tr>
                      <td><c:out value="${empresa.rutEmpresa}"/></td>
                      <td><c:out value="${empresa.razonSocial}"/></td>
                      <td><c:out value="${empresa.idHolding.nomHolding}"/></td>
                      <td><a href="./detEmpresa?rut_emp=${empresa.rutEmpresa}"><small class="badge badge-danger"> Ver Detalle</small></a> </td>
                      
                      
                  </tr>
                  </c:forEach>                
              </tbody>
                
            </table> 
            
            
            
        </div>
        <!-- /.card-body -->
        <div class="card-footer">
          Footer
        </div>
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

<!-- jQuery -->

</body>
</html>
