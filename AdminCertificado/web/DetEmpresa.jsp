<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
   
  
 <%@include file="master/head.jsp" %>
</head>



<body class="hold-transition sidebar-mini">
      <jsp:useBean id="empresas" class="cl.circuloverde.certificado.entidades.Empresa" scope="page"></jsp:useBean>



      <jsp:useBean id="rpts" class="cl.circuloverde.certificado.entidades.RptlegalPerfilEmpresa" scope="page"></jsp:useBean>



      <jsp:useBean id="users" class="cl.circuloverde.certificado.entidades.UsrPerfilEmpresa" scope="page"></jsp:useBean>


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
                    <label for="exampleInputFile">Estado:</label>
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
                    <c:out value="${empresa.mailAdm}"/>
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Holding:</label>
                    <c:out value="${empresa.idHolding.nomHolding}"/>
                  </div>
                  
                </div>
                <!-- /.card-body -->

                <div class="card-footer">
                    <button type="button" class="btn btn-primary" id="editEmp" data-toggle="modal" data-target="#edita-modal" data-id="${empresa.rutEmpresa}">Modificar</button>
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
             <div class="col-md-12">
            <!-- Horizontal Form -->
            <div class="card card-success">
              <div class="card-header">
                <h3 class="card-title">Usuarios y Permisos SII</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              
                <div class="card-body table-responsive p-0">


                    
                    <table class="table table-hover">

                        <thead>
                        <th></th>
                        <th>Nombre</th>
                        <th colspan="6">Permisos</th>
                        
                         
                        </thead>
                        <tbody>
                            <c:forEach items="${rpt}" var="usr" >
                            
                                
                            <tr>
                                 
                                <td><a href="#"><small class="badge badge-success">Editar</small></a></td>
                                <td>${usr.rutRptLegal.nomRptLegal} ${usr.rutRptLegal.apellRptLegal}</td>
                                
                                <c:forEach items="${permisos}" var="per">
                                    <c:choose>
                                        <c:when test="${usr.rutRptLegal.rutRptLegal==per.rutRptLegal.rutRptLegal && per.estadoAsigna==0}"> 
                                            <td align="center"><c:out value="${per.idPerfil.nomPerfil}"/></td>
                                        </c:when>
                                      
                                    </c:choose>
                                </c:forEach>
                                    
                                         
                            </tr> 
                                            
                           
                           
                            </c:forEach>
                            
                                                        
                            <c:forEach items="${usr}" var="usrCV">
                            
                                <tr>
                                    
                                  <td><a href="#"><small class="badge badge-success">Editar</small></a></td>
                                  <td>${usrCV.rutUsrCv.nomUsrCv} ${usrCV.rutUsrCv.apellUsrCv}</td>
                                   
                                  <c:forEach items="${usrPermisos}" var="usrPermisosCV">
                                      <c:choose>
                                          
                                          <c:when test="${usrCV.rutUsrCv.rutUsrCv==usrPermisosCV.rutUsrCv.rutUsrCv}">
                                              <td align="center"><c:out value="${usrPermisosCV.idPerfil.nomPerfil}"/></td> 
                                              
                                          </c:when>
                                          
                                      </c:choose>
                                      
                                      
                                  </c:forEach>
                                  
                                    
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


<div id="edita-modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
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
$(document).ready(function(){
	
	$(document).on('click', '#editEmp', function(e){
		
		e.preventDefault();
		
		var uid = $(this).data('id');   // it will get id of clicked row
		
		$('#dynamic-content').html(''); // leave it blank before ajax call
		$('#modal-loader1').show();      // load ajax loader
		
		$.ajax({
			url: './editaEmp',
			type: 'GET',
			data: 'rut_emp='+uid,
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
