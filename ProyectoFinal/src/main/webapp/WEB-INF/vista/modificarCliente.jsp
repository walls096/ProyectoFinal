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
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/menu.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/estilos.css" />

<style>

.colorRed{
	color:red;
}

.colorGreen{
	color: green;
}
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
				<a href="panelPrincipal"
					class="list-group-item list-group-item-action bg-light">Próximas citas</a> <a
					href="administrarCitas" class="list-group-item list-group-item-action bg-light">Administrar
					Citas</a> <a href="listadoMascotas"
					class="list-group-item list-group-item-action bg-light">Mascotas</a>
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
								<a class="dropdown-item" href="modificarCliente">Modificar
									Datos</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="cerrarSesion">Cerrar sesión</a>
							</div></li>
					</ul>
				</div>
			</nav>
		
		
		<div class="container-fluid separacion">
			<main class="login-form weight-auto">
							<div class="text-center text-md-left">
								<a class="btn btn-light" href="panelPrincipal">←</a>
							</div>
				<div class="cotainer">
				
					<div class="row justify-content-center">
					
						<div class="col-md-8">
							<div class="card">
								<div class="card-header">Datos actuales del cliente</div>
								<div class="card-body">

									<form method="POST" action="modificarCliente">
									
									<div class="col-md-6 offset-md-4 colorRed">

											<h5>${mensaje}</h5>

										</div>
										
										<div class="col-md-6 offset-md-4 colorGreen">

											<h5>${mensajeExito}</h5>

										</div>

										<div class="form-group row">
											<label for="dni"
												class="col-md-4 col-form-label text-md-right">DNI</label>
											<div class="col-md-6">
												<input type="text" id="dni" class="form-control"
													name="dni" autofocus disabled placeholder="<%=RepositorioCliente.getDatosCliente().get(0).getDni()%>">
											</div>
										</div>
										<div class="form-group row">
											<label for="nombre"
												class="col-md-4 col-form-label text-md-right">Nombre</label>
											<div class="col-md-6">
												<input type="text" id="nombre" class="form-control"
													name="nombre" autofocus placeholder="<%=RepositorioCliente.getDatosCliente().get(0).getNombre()%>">
											</div>
										</div>

										<div class="form-group row">
											<label for="mail"
												class="col-md-4 col-form-label text-md-right">Correo
												electrónico</label>
											<div class="col-md-6">
												<input type="text" id="mail" class="form-control"
													name="mail" placeholder="<%=RepositorioCliente.getDatosCliente().get(0).getMail()%>">
											</div>
										</div>
										
										<div class="form-group row">
											<label for="fecha_nac"
												class="col-md-4 col-form-label text-md-right">Fecha de nacimiento</label>
											<div class="col-md-6">
												<input type="text" id="fecha_nac" class="form-control"
													name="fecha_nac" placeholder="<%=RepositorioCliente.getDatosCliente().get(0).getFechaNac()%>" disabled>
											</div>
										</div>
										
										<div class="form-group row">
											<label for="direccion"
												class="col-md-4 col-form-label text-md-right">Dirección</label>
											<div class="col-md-6">
												<input type="text" id="direccion" class="form-control"
													name="direccion" placeholder="<%=RepositorioCliente.getDatosCliente().get(0).getDireccion()%>">
											</div>
										</div>
										
										<div class="form-group row">
											<label for="localidad"
												class="col-md-4 col-form-label text-md-right">Localidad</label>
											<div class="col-md-6">
												<input type="text" id="localidad" class="form-control"
													name="localidad" placeholder="<%=RepositorioCliente.getDatosCliente().get(0).getLocalidad()%>">
											<input id="btn-abrir-popup" class="btn-abrir-popup btn btn-link" type="button" value="Cambiar contraseña">
											</div>											
										</div>

										<div class="col-md-6 offset-md-4">

											<input id="boton" type="submit" value="Guardar" class="btn btn-primary">

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
		
		<div class="overlay" id="overlay">
			<div class="popup" id="popup">
				<h4>Cambiar Contraseña</h4>
				<form action="modificarPass" method="POST">
					<div class="contenedor-inputs">
						<input name="passActual" type="password" placeholder="Contraseña actual" required>
						<input name="passNueva" type="password" placeholder="Nueva contraseña" required>
						<input name="repitePass" type="password" placeholder="Repita contraseña" required>
					</div>
					<div class="contenedor-inputs">
						<input type="submit" class="btn-submit" value="Aceptar">
						<input type="button" id="btn-cerrar-popup" class="btn-danger" value="Cancelar">
					</div>
					
				</form>
			</div>
		</div>
	</div>

	</div>
	<!-- /#page-content-wrapper -->

</div>
<!-- Bootstrap core JavaScript -->
<script
	src="${pageContext.request.contextPath}/static/js/popup.js"></script>
<script
	src="${pageContext.request.contextPath}/static/jquery/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath}/static/js/bootstrap.bundle.min.js"></script>
</body>
</html>