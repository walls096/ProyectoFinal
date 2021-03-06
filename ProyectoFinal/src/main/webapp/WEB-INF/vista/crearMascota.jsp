<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="com.walls.repositorio.RepositorioCliente"%>
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

<style>
.separacion {
	padding-top: 5%;
}
</style>

</head>

<body>

	<div class="d-flex" id="wrapper">

		<div class="bg-light border-right" id="sidebar-wrapper">

			<div class="sidebar-heading">Bienvenido <%=RepositorioCliente.getDatosCliente().get(0).getNombre()%></div>
			<div class="list-group list-group-flush">
				<a href="panelPrincipal" class="list-group-item list-group-item-action bg-light">Próximas citas</a>
				<a href="administrarCitas" class="list-group-item list-group-item-action bg-light">Administrar Citas</a>
				<a href="listadoMascotas" class="list-group-item list-group-item-action bg-light">Mascotas</a>
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
								<a class="dropdown-item" href="modificarCliente">Modificar Datos</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="cerrarSesion">Cerrar sesión</a>
							</div></li>
					</ul>
				</div>
			</nav>
		
		
		<div class="container-fluid separacion">
			<main class="login-form weight-auto">
							<div class="text-center text-md-left">
								<a class="btn btn-light" href="listadoMascotas">←</a>
							</div>
				<div class="cotainer">
				
					<div class="row justify-content-center">
					
						<div class="col-md-8">
							<div class="card">
								<div class="card-header">Agrega una nueva mascota</div>
								<div class="card-body">

									<form method="POST" action="crearMascota">
									
										<div class="form-group row">
											<label for="nombre"
												class="col-md-4 col-form-label text-md-right">Nombre</label>
											<div class="col-md-6">
												<input type="text" id="nombre" class="form-control"
													name="nombre" required autofocus>
											</div>
										</div>

										<div class="form-group row">
											<label for="tipo"
												class="col-md-4 col-form-label text-md-right">Tipo mascota</label>
											<div class="col-md-6">
												<input type="text" id="tipo" class="form-control"
													name="tipo" required>
											</div>
										</div>
										
										<div class="form-group row">
											<label for="raza"
												class="col-md-4 col-form-label text-md-right">Raza</label>
											<div class="col-md-6">
												<input type="text" id="raza" class="form-control"
													name="raza">
											</div>
										</div>


										<div class="col-md-6 offset-md-4">

											<input type="submit" value="Aceptar" class="btn btn-primary">

										</div>

										<div class="col-md-6 offset-md-4 colorRed">

											<h5>${mensaje}</h5>

										</div>

									</form>

								</div>
							</div>
						</div>
					</div>
				</div>

			</main>
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
</body>
</html>