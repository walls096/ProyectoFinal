<%@page import="com.walls.repositorio.RepositorioCita"%>
<%@page import="com.walls.repositorio.RepositorioMascota"%>
<%@page import="com.walls.controlador.ControladorMascota"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="com.walls.repositorio.RepositorioCliente"%>
<%@page import="com.walls.repositorio.RepositorioMascota"%>
<%@page import="com.walls.repositorio.RepositorioCita"%>
<%@page import="com.walls.entidades.Cita"%>
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

<script>
	function seguro(id) {

		if (window.confirm("¿ Esta seguro que desea eliminar la cita ?")) {
			window.location = "borrarCita?id="+id;
		} else {
			window.location = "administrarCitas";
		}
	}
	

	function modificar(id) {
		window.location = "modificarCita?id="+id;
	}
	
	function filtrar(){

		var item = document.getElementById("filtrar");
		var compruebaClase = item.classList ;
		
		if(compruebaClase.contains('hidden')){
			item.classList.replace('hidden','visible');
		}else{
			item.classList.replace('visible','hidden');
		}
		
	}
</script>

<style>
.separacion {
	padding-top: 1%;
}

.borde {
	border: 2px solid red;
}

.margin {
	margin: 2%;
}

.hidden {
	visibility: hidden;
}

.visible {
	visibility: visible;
}

.center {
	text-align: center;
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

			<div class="container-fluid">
				<h3 class="text-center separacion">Todas las citas</h3>

				<section class="container">

					<section class="main row">

						<article class="col-xs-12 col-sm-12 col-md-2	">
							<div class="text-center text-md-left">
								<a class="btn btn-primary" href="pedirCita">Pedir cita</a>
							</div>
						</article>
						<%if (RepositorioCita.obtenerCitasCliente().size() != 0) { %>
						<article class="col-xs-12 col-sm-12 col-md-6">
							<div class="text-center text-md-left">
								<a class="btn btn-primary" onclick="filtrar()">Organizar</a>
							</div>
						</article>
						<%} %>
					</section>
					<section id="filtrar" class="main row hidden separacion">

						<form method="POST" action="campoFiltrado">
							<div class="form-row align-items-center">
								<div class="col-auto my-1">
									<select class="custom-select mr-sm-2"
										name="filtroMascota">
										<option selected>-MASCOTAS-</option>
										<% 
											for(Mascota m : RepositorioMascota.getTodasLasMascotas()){
										%>
											<option><%=m.getNombre()%></option>
										<%
											}
										%> 
									</select>
								</div>
								<div class="col-auto my-1">
									<select class="custom-select mr-sm-2"
										name="filtroTipo">
										<option selected>-TIPO CITA-</option>
										<option>REVISION</option>
										<option>URGENCIA</option>
										<option>VACUNACION</option>
										<option>PELUQUERIA</option>
									</select>
								</div>
								<div class="col-auto my-4 ">
									<div class="col-auto my-1">
									<button type="submit" class="btn btn-primary">Filtrar</button>
								</div>
								</div>
								
							</div>
						</form>
					</section>
					<%
						try {

						if (RepositorioCita.getCitasCliente().size() == 0) {
					%>
					<h5 class="separacion">Actualmente no tiene citas registradas</h5>
					<%
						} else {
					%>
					<section class="main row separacion">

						<article class="col-xs-12 col-sm-12 col-md-12">
							<table class="table table-striped">
								<thead class="thead-light">
									<tr>
										<th scope="col">FECHA</th>
										<th scope="col">HORA</th>
										<th scope="col">MASCOTA</th>
										<th scope="col">TIPO</th>
										<th scope="col">DETALLES</th>
										<th scope="col"></th>
									</tr>
								</thead>
								<tbody>
									<%
										
										for (Cita c : RepositorioCita.getCitasCliente()) {
									%>


									<tr>
										<td><%=c.getFechaToString()%></td>
										<td><%=c.getHora()%></td>
										<td><%=RepositorioMascota.obtenerUnaMascota(c.getCodMascota()).get(0).getNombre()%></td>
										<td><%=c.getTipoCita()%></td>
										<td>
											<%
												String[] observaciones = c.getObservacion().split("#");
												for (String todasObservaciones : observaciones) {
											%>
													<p><%=todasObservaciones%></p> <%
										 		}
											%>
										</td>
										<td>
											<a href="#" onclick="modificar(<%=c.getCodCita()%>)" class="btn btn-sm btn-warning">editar</a> 
											<a href="#" onclick="seguro(<%=c.getCodCita()%>)" class="btn btn-sm btn-danger">borrar</a>
										</td>
									</tr>



									<%
										}
									%>
								</tbody>
							</table>
						</article>

					</section>
					<%
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
