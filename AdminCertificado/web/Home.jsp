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
            <h1>Empresas Vigentes</h1>
          </div>
          
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">

      <!-- Default box -->
      <div class="card">
        <div class="card-header">
          <h3 class="card-title">Mantenedor de Clientes  <div align="right">
          <button class="btn btn-sm btn-danger" data-toggle="modal" data-target="#view-modal"  id="getEmp" >Agregar Empresa</button>
          <button class="btn btn-sm btn-danger" data-toggle="modal" data-target="#hdl-modal"  id="getHdl" >Crear Holding</button>
          </div></h3>
            
                    
        </div>
        
        <div class="card-body">   
            <table id="ejemplo" class="table table-hover table-bordered">
                
              <thead>
                    <th>Rut</th>
                    <th>Razon Social</th>
                    <th>Holding</th>
                    <th></th>
              </thead>
              
              <tbody>
                  <c:forEach items="${empresasVig}" var="empresa">
                  <tr>
                      <td style="width:11%"><c:out value="${empresa.rutEmpresa}"/></td>
                      <td><c:out value="${empresa.razonSocial}"/></td>
                      <td style="width:26%"><c:out value="${empresa.idHolding.nomHolding}"/></td>
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


<div id="hdl-modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
      <div class="modal-dialog" role="document"> 
            <div class="modal-content">  

               

               <div class="modal-body">                     
                  <div id="modal-loader1" style="display: none; text-align: center;">




                      <!-- ajax loader -->
                  <img src="ajax-loader.gif">
                  </div>

                  <!-- mysql data will be load here -->                          
                  <div id="dynamic-content1"></div>
               </div> 


           </div> 
    </div>
</div> 




<script>
$(document).ready(function(){
	
	$(document).on('click', '#getEmp', function(e){
		
		e.preventDefault();
		
		
		
		$('#dynamic-content').html(''); // leave it blank before ajax call
		$('#modal-loader').show();      // load ajax loader
		
		$.ajax({
			url: './nvaEmpresa',
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



<script>
$(document).ready(function(){
	
	$(document).on('click', '#getHdl', function(e){
		
		e.preventDefault();
		
		
		
		$('#dynamic-content1').html(''); // leave it blank before ajax call
		$('#modal-loader1').show();      // load ajax loader
		
		$.ajax({
			url: './hdlServlet',
			type: 'GET',
			dataType: 'html'
		})
		.done(function(data){
			console.log(data);	
			$('#dynamic-content1').html('');    
			$('#dynamic-content1').html(data); // load response 
			$('#modal-loader1').hide();		  // hide ajax loader	
		})
		.fail(function(){
			$('#dynamic-content1').html('<i class="glyphicon glyphicon-info-sign"></i> Something went wrong, Please try again...');
			$('#modal-loader1').hide();
		});
		
	});
	
});

</script>




</body>
</html>
