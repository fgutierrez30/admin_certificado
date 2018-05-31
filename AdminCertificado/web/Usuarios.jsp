<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
   
  
 <%@include file="master/head.jsp" %>
</head>
<body class="hold-transition sidebar-mini">
    <jsp:include page="./usrServlet" flush="true"/>
    <jsp:useBean id="usersCV" class="cl.circuloverde.certificado.entidades.UsuarioCv" scope="page"></jsp:useBean>
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
            <h1>Usuarios Circulo Verde</h1>
          </div>
          
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">

      <!-- Default box -->
      <div class="card">
        <div class="card-header">
           
          <h3 class="card-title">Mantenedor de Usuarios  <div align="right">
          <button class="btn btn-sm btn-danger" data-toggle="modal" data-target="#view-modal"  id="getUsr" >Agregar Usuario</button>
          </div></h3>
          
        </div>
        <div class="card-body">
          
            <table id="ejemplo" class="table table-bordered table-hover">
                
              <thead>
                    <th>Rut</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Estado</th>
                    <th></th>
              </thead>
              
              <tbody>
                  <c:forEach items="${usuariosCV}" var="usr">
                  <tr>
                      <td><c:out value="${usr.rutUsrCv}"/></td>
                      <td><c:out value="${usr.nomUsrCv}"/></td>
                      <td><c:out value="${usr.apellUsrCv}"/></td>
                      <td>
                      <c:choose>
                          <c:when test="${usr.estadoUsrCv==0}">
                              Vigente
                          </c:when>
                          <c:otherwise>
                              Bloqueado
                          </c:otherwise>
                      
                      </c:choose>
                      </td>
                      <td align="center"><a href="./detUsr?rut_usr=${usr.rutUsrCv}"><small class="badge badge-danger"> Ver Detalle</small></a> </td>
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


  <div id="view-modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
      <div class="modal-dialog" role="document"> 
            <div class="modal-content">  

               

               <div class="modal-body">                     
                  <div id="modal-loader" style="display: none; text-align: center;">




                      <!-- ajax loader -->
                  <img src="ajax-loader.gif">
                  </div>

                  <!-- mysql data will be load here -->                          
                  <div id="dynamic-content"></div>
               </div> 


           </div> 
    </div>
</div> 






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
                                sLast:     "Último",
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





<script>
$(document).ready(function(){
	
	$(document).on('click', '#getUsr', function(e){
		
		e.preventDefault();
		
		var uid = $(this).data('id');   // it will get id of clicked row
		
		$('#dynamic-content').html(''); // leave it blank before ajax call
		$('#modal-loader1').show();      // load ajax loader
		
		$.ajax({
			url: './nvoUsr',
			type: 'GET',
			dataType: 'html'
		})
		.done(function(data){
			console.log(data);	
			$('#dynamic-content').html('');    
			$('#dynamic-content').html(data); // load response 
			$('#modal-loader').hide();		  // hide ajax loader	
		})
		.fail(function(){
			$('#dynamic-content').html('<i class="glyphicon glyphicon-info-sign"></i> Something went wrong, Please try again...');
			$('#modal-loader').hide();
		});
		
	});
	
});

</script>


</body>
</html>
