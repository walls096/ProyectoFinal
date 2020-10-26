<%@page import="com.walls.controlador.ControladorMascota"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="com.walls.dao.ClienteDAO"%>
<%@page import="com.walls.entidades.Mascota"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">

<title>Veterinarias</title>

<!--     Bootstrap core CSS  -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/simple-sidebar.css" />


</head>

<body>

	<div class="d-flex" id="wrapper">

		<div class="bg-light border-right" id="sidebar-wrapper">

			<div class="sidebar-heading">-------</div>
			<div class="list-group list-group-flush">
				<a href="panelPrincipal" class="list-group-item list-group-item-action bg-light">Citas</a>
				<a href="#" class="list-group-item list-group-item-action bg-light">Administrar Citas</a>
				<a href="#" class="list-group-item list-group-item-action bg-light">Mascotas</a>
				<a href="#" class="list-group-item list-group-item-action bg-light">Administrar Mascotas</a>
				<a href="#" class="list-group-item list-group-item-action bg-light">Datos personales</a>
			</div>
		</div>

		<!-- Page Content -->
		<div id="page-content-wrapper">

			<nav
				class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
				<button class="btn btn-primary" id="menu-toggle">MENU</button>

				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav ml-auto mt-2 mt-lg-0">
						
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> Ajustes </a>
							<div class="dropdown-menu dropdown-menu-right"
								aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="modificarDatos">Modificar Datos</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="cerrarSesion">Cerrar sesión</a>
							</div></li>
					</ul>
				</div>
			</nav>

			<div class="container-fluid">
				<section class="container">
					<section class="main row">
						<article class="content col-xs-12 col-sm-12 col-md-8">
							<h3>mascotas</h3>
							
							<%
								ControladorMascota mascota = new ControladorMascota();
								for(Mascota m : mascota.obtenerMascotasCliente()){
									
							%>
								<p> <%= m.getNombre() %></p>
							<%
								}
							%>
							
						</article>
						<!-- puedo ocultar el aside para pantallas pequeñas  -->
						
					</section>

					
				</section>
				<!-- Fin del div container	 -->


				
			</div>

		</div>
		<!-- /#page-content-wrapper -->

	</div>

	<!-- Bootstrap core JavaScript -->
	<script
		src="${pageContext.request.contextPath}/static/jquery/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/js/bootstrap.bundle.min.js"></script>

	<!-- Menu Toggle Script -->
	<script>
		$("#menu-toggle").click(function(e) {
			e.preventDefault();
			$("#wrapper").toggleClass("toggled");
		});
	</script>
</body>
</html>
