<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="com.walls.repositorio.RepositorioMascota"%>
<%@page import="com.walls.controlador.ControladorMascota"%>
<%@page import="com.walls.controlador.ControladorCita"%>
<%@page import="com.walls.repositorio.RepositorioCliente"%>
<%@page import="com.walls.repositorio.RepositorioCita"%>
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
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/menu.css" />

<script>
	
	function seguro(id,tieneCita) {

		if(tieneCita){
			
			if (window.confirm("La mascota que va a borrar tiene una cita asignada, ¿ desea continuar ?")) {
				window.location = "borrarMascotaConCita?codMascota="+id;
			} else {
				window.location = "listadoMascotas";
			}
			
		}else{
			
			if (window.confirm("¿ Esta seguro que desea eliminar la mascota ?")) {
				window.location = "borrarMascota?id="+id;
			} else {
				window.location = "listadoMascotas";
			}
		}
	}
	

	function modificar(id) {
		window.location = "modificarMascota?id="+id;
	}
</script>

<style>
.separacion {
	padding-top: 5%;
}

.borde {
	border: 3px solid black;
}

.margin {
	margin: 2%;
}
</style>
</head>

<body>

	<div class="d-flex" id="wrapper">

		<div class="bg-light border-right" id="sidebar-wrapper">

			<div class="sidebar-heading">
				Bienvenido
				<%=RepositorioCliente.getDatosCliente().get(0).getNombre()%></div>
			<div class="list-group list-group-flush">
				<a href="panelPrincipal"
					class="list-group-item list-group-item-action bg-light">Próximas citas</a> <a
					href="administrarCitas"
					class="list-group-item list-group-item-action bg-light">Administrar
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

			<div class="container-fluid weight-auto">
				<h3 class="text-center separacion">Listado de Mascotas</h3>

				<section class="container">

					<section class="main row separacion">

						<article class="col-xs-12 col-sm-12 col-md-3">
							<div class="text-center text-md-left">
								<a class="btn btn-primary" href="crearMascota">Agregar
									mascota</a>
							</div>
						</article>
						<%
							if (RepositorioMascota.getTodasLasMascotas().size() != 0) {
						%>
						<article class="col-xs-12 col-sm-12 col-md-5">
							<div class="text-center text-md-left">
								<form class="form-inline md-form mr-auto mb-2" method="POST" action="buscarMascota">
									<input name="nombre" class="form-control mr-sm-2" type="text"
										placeholder="buscar por nombre" aria-label="Search">
									<button class="btn btn-primary btn-rounded "
										type="submit">Buscar</button>
								</form>
							</div>
						</article>
						<%} %>
					</section>
					<section class="main row">

						<%
							try {

							if (RepositorioMascota.getTodasLasMascotas().size() == 0) {
						%>
						<h5 class="separacion">Actualmente no tiene mascotas
							registradas</h5>
						<%
							} else {

							for (Mascota m : RepositorioMascota.getTodasLasMascotas()) {
						%>
						<article class="border margin col-xs-12 col-sm-5">

							<div class="row">
								<div class="border margin col-xs-12 col-sm-6">

									<p>
										Nombre:
										<%=m.getNombre()%></p>
									<p>
										Tipo:
										<%=m.getTipo()%></p>
									<%
										if (m.getRaza().equals(""))
										m.setRaza("Sin especificar");
									else
									%>
									<p>
										Raza:
										<%=m.getRaza()%></p>

								</div>

								<div class="margin col-xs-12 col-sm-4">
									<img alt="imagen"
										src="${pageContext.request.contextPath}/static/img/<%=m.getImagen() %>"
										class="img-fluid">
								</div>



							</div>
							
							<a class="btn btn-warning"
								onclick="modificar(<%=m.getCodMascota()%>)">Modificar
								Mascota</a> <a class="btn btn-danger"
								onclick="seguro(<%=m.getCodMascota()%>,<%= RepositorioCita.tieneCita(m.getCodMascota()) %>)">Eliminar Mascota</a>

						</article>
						<%
							}
						}

						} catch (NullPointerException e) {
						%>
						<meta http-equiv="Refresh"
							content="6;url=http://localhost:8080/ProyectoFinal/iniciaSesion">
						<script>
							alert("La sesion ha caducado, le estamos redirigiendo al login...")
						</script>
						<%
							}
						%>

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
