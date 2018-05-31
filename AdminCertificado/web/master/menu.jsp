 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!-- Main Sidebar Container -->
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="Home.jsp" class="brand-link">
      
      <span class="brand-text font-weight-light">Certificados SII</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user (optional) -->
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        
        <div class="info">
            <a href="#" class="d-block"><c:out value="${sessionScope.usrLogin.nomCompleto}"/></a>
        </div>
      </div>

      <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
          <li class="nav-item has-treeview">
            <a href="Usuarios.jsp" class="nav-link">
              <i class="fas fa-id-card"></i>
              <p>
                Usuarios
                
              </p>
            </a>
            
          </li>
          <li class="nav-item">
            <a href="RepLegal.jsp" class="nav-link">
              
              <p>
                Representantes Legales
                
              </p>
            </a>
          </li>
          <li class="nav-item has-treeview">
            <a href="Home.jsp" class="nav-link">
              <p>
                Empresas
                
              </p>
            </a>
           
          </li>
         
          
         
          
          
          
          
        </ul>
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>
