<jsp:useBean id="now" class="java.util.Date"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
   
  
 <%@include file="master/head.jsp" %>
</head>
<body class="hold-transition sidebar-mini">
    
      
      <jsp:useBean id="usuarios" class="cl.circuloverde.certificado.entidades.UsuarioCv" scope="page"></jsp:useBean>
      <jsp:useBean id="users" class="cl.circuloverde.certificado.entidades.UsrPerfilEmpresa" scope="page"></jsp:useBean>
      


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
            <h1>Detalles Representante Legal</h1>
          </div>
          
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">

      <!-- Default box -->
      <div class="card">
        <div class="card-header">
            
            <div class="container-fluid">
        <div class="row">
          
             <div class="col-md-4">
            <!-- Horizontal Form -->
            <div class="card card-primary">
              <div class="card-header">
                <h3 class="card-title">Representante Legal</h3>
              </div>
                 
              <div class="card-body">
                  <div class="form-group">
                    <label for="exampleInputEmail1">Rut:</label>
                    <c:out value="${rpt.rutRptLegal}"/>
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Nombre:</label>
                    <c:out value="${rpt.nomRptLegal} ${rpt.apellRptLegal}"/>
                  </div>
                 <div class="form-group">
                    <label for="exampleInputPassword1">Correo:</label>
                    <c:out value="${rpt.correoRptLegal}"/>
                  </div>
                   <div class="form-group">
                    <label for="exampleInputFile">Estado:</label>
                    <c:choose>
                        <c:when test="${rpt.estadoRptLegal==0}">
                            Vigente
                        </c:when>    
                        <c:otherwise>
                            No Vigente
                        </c:otherwise>
                   </c:choose>
                  </div>                                    
                </div>
                
                <div class="card-footer">
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#edita-modal" data-id="${rpt.rutRptLegal}" id="editaRpt">Modificar</button>
                </div>
                
                
                
            </div>
             
            
              
                <!-- /.card-footer -->
          </div>
                  
                  
                  
           <div class="col-md-6">
            <!-- Horizontal Form -->
            <div class="card card-warning">
              <div class="card-header">
                <h3 class="card-title">Firma Digital</h3>
              </div>
                 
              <div class="card-body">
                  <table class="table">
                      
                      <thead>
                          
                      <th>Compra</th>
                      <th>Vcto</th>
                      <th>Clave</th>
                      <th>Estado</th>
                                                
                      </thead>
                      <tbody>
                          <c:forEach items="${firma}" var="fir">
                          <tr>
                              
                              <td><fmt:formatDate pattern="dd-MM-yyyy" value="${fir.fechaCompra}"/></td>
                              <td><fmt:formatDate pattern="dd-MM-yyyy" value="${fir.fechaVcto}"/></td>
                              <td><c:out value="${fir.claveInstalacion}"/></td>
                              <c:choose>
                                  <c:when test="${fir.fechaVcto<now}">
                                     <td>Vencida</td>  
                                  </c:when>
                              
                                  <c:otherwise>
                                     <td>Vigente</td> 
                                  </c:otherwise>
                              
                              </c:choose>
                                                            
                          </tr>
                         </c:forEach> 
                          
                      </tbody>
                      
                      
                  </table>                                 
                </div>
                
                <div class="card-footer">
                    <button data-toggle="modal" data-target="#firma-modal" data-id="${rpt.rutRptLegal}" id="getFirma" class="btn btn-warning">Agregar Firma</button>
                </div>
                
                
                
            </div>
             
            
              
                <!-- /.card-footer -->
          </div>       
                  
                  
               
                  
                  
                
              
              <div class="card-body col-md-2" >
                  <button data-toggle="modal" data-target="#view-modal" data-id="${rpt.rutRptLegal}" id="getUsr" class="btn btn-sm btn-danger">Asignar Empresa</button>
                           
              </div>
               
            
                  
                  
            <!-- /.card -->
          </div>
          <!--/.col (right) -->
        </div>
            
      
 
          
   <section class="content">
      <div class="container-fluid">
        <div class="row">
          
             <div class="col-md-12">
            <!-- Horizontal Form -->
            <div class="card card-success">
              <div class="card-header">
                <h3 class="card-title">Empresas y Permisos SII</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              
                <div class="card-body table-responsive p-0">


                    
                    <table class="table table-hover">

                        <thead>
                        <th></th>
                        <th>Razon Social</th>
                        <th colspan="6">Permisos</th>
                        
                        </thead>
                        <tbody>
                            <c:forEach items="${empXRpt}" var="emp">
                            <tr>
                                <c:choose>
                                    <c:when test="${emp.rutEmpresa.razonSocial==''}">
                                        <td> </td> 
                                    </c:when>
                                <c:otherwise>
                                <td><a href="#"><small class="badge badge-success">Editar</small></a></td>
                                <td><c:out value="${emp.rutEmpresa.razonSocial}"/></td>
                                
                                <c:forEach items="${permisos}" var="per">
                                    <c:choose>
                                        
                                        <c:when test="${emp.rutEmpresa.rutEmpresa==per.rutEmpresa.rutEmpresa}">
                                            
                                            <td align="center"><c:out value="${per.idPerfil.nomPerfil}"/></td> 
                                            
                                        </c:when>
                                        
                                        
                                    </c:choose>
                                    
                                </c:forEach>
                                
                                
                                
                                
                                
                                </c:otherwise>
                                </c:choose> 
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





  <div id="firma-modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
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





 <div id="edita-modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
      <div class="modal-dialog" role="document"> 
            <div class="modal-content">  

               

               <div class="modal-body">                     
                  <div id="modal-loader2" style="display: none; text-align: center;">




                      <!-- ajax loader -->
                  <img src="ajax-loader.gif">
                  </div>

                  <!-- mysql data will be load here -->                          
                  <div id="dynamic-content2"></div>
               </div> 


           </div> 
    </div>
</div> 












<script>
$(document).ready(function(){
	
	$(document).on('click', '#getUsr', function(e){
		
		e.preventDefault();
		
		var uid = $(this).data('id');   // it will get id of clicked row
		
		$('#dynamic-content').html(''); // leave it blank before ajax call
		$('#modal-loader1').show();      // load ajax loader
		
		$.ajax({
			url: './asigEmpRpt',
			type: 'GET',
			data: 'rut_rpt='+uid,
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
	
	$(document).on('click', '#getFirma', function(e){
		
		e.preventDefault();
		
		var uid = $(this).data('id');   // it will get id of clicked row
		
		$('#dynamic-content1').html(''); // leave it blank before ajax call
		$('#modal-loader1').show();      // load ajax loader
		
		$.ajax({
			url: './regFirma',
			type: 'GET',
			data: 'rut_rpt='+uid,
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





<script>
$(document).ready(function(){
	
	$(document).on('click', '#editaRpt', function(e){
		
		e.preventDefault();
		
		var uid = $(this).data('id');   // it will get id of clicked row
		
		$('#dynamic-content2').html(''); // leave it blank before ajax call
		$('#modal-loader2').show();      // load ajax loader
		
		$.ajax({
			url: './editaRpt',
			type: 'GET',
			data: 'rut_rpt='+uid,
			dataType: 'html'
		})
		.done(function(data){
			console.log(data);	
			$('#dynamic-content2').html('');    
			$('#dynamic-content2').html(data); // load response 
			$('#modal-loader2').hide();		  // hide ajax loader	
		})
		.fail(function(){
			$('#dynamic-content2').html('<i class="glyphicon glyphicon-info-sign"></i> Something went wrong, Please try again...');
			$('#modal-loader2').hide();
		});
		
	});
	
});

</script>





</body>
</html>
