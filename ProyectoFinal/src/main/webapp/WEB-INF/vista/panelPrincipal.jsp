<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="com.walls.repositorio.RepositorioCita"%>
<%@page import="com.walls.repositorio.RepositorioCliente"%>
<%@page import="com.walls.repositorio.RepositorioMascota"%>
<%@page import="com.walls.entidades.Cita"%>
<%@page import="com.walls.entidades.Utiles"%>
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


<style>
.separacion {
	padding-top: 5%;
}
.hidden{
	visibility:hidden;
}
.visible{
	visibility:visible;
}
.center{
	text-align:center;
}
</style>

<script>

	function mostrarDetalles(id){

		var item = document.getElementById(id);
		var compruebaClase = item.classList ;
		
		if(compruebaClase.contains('hidden')){
			item.classList.replace('hidden','visible');
		}else{
			item.classList.replace('visible','hidden');
		}
		
	}

</script>

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
			<div class="container-fluid border">
				<div class="row justify-content-center border">
				<h3 class="text-center"><%=Utiles.formatearFecha() %></h3>
				</div>
				<h3 class="text-center separacion">Próximas citas</h3>

					<div class="cotainer border">

						<div class="row justify-content-center ">
						
							<%
												
							if (RepositorioCita.obtenerCitasCliente().size() == 0) {
							%>
										<h5 class="separacion">Actualmente no tiene próximas citas</h5>
										<article class="col-xs-12 col-sm-12 col-md-12">
											<div class="text-center text-md-left">
												<a class="btn btn-primary" href="administrarCitas">Administrar Citas</a>
											</div>
										</article>
							<%
							}else
							{	
							%>

							<div class="col-md-8 separacion">
								
							<%
								for (Cita c : RepositorioCita.obtenerCitasCliente()) {
									
									if(!c.getFecha().before(Utiles.getFechaActual())){
							%>
								<table class="table center">
									<thead class="thead-light">
										<tr>
											<th scope="col">FECHA</th>
											<th scope="col">HORA</th>
											<th scope="col">MASCOTA</th>
											<th scope="col">TIPO</th>
											<th scope="col">DETALLES</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<th scope="row"><%=c.getFechaToString() %></th>
											<td><%=c.getHora() %></td> 
											<td><%=RepositorioMascota.obtenerUnaMascota(c.getCodMascota()).get(0).getNombre() %></td> 
											<td><%=c.getTipoCita() %></td>
											<td><a href="#" onclick="mostrarDetalles(<%=c.getCodCita() %>)" class="btn btn-sm btn-success"><span class="glyphicon glyphicon-plus-sign"></span>+</a></td>
										</tr>
									</tbody>
									</table>
									<table class="table">
										<tbody id="<%=c.getCodCita() %>" class="hidden">
										
						
							<%
						
										String[] observaciones = c.getObservacion().split("#");
		
						
											for (String todasObservaciones : observaciones) {
							%>
												<tr>
													<th scope="row">-------</th>
													<%if(!todasObservaciones.equals("")) {%>
														<td colspan="3"><%=todasObservaciones %></td>
													<%}else {%>
													<td colspan="3">Sin observaciones</td> 
													<%} %>
												</tr>
							<%
											}
										}
									}
								}
									
						%>
									</tbody>
								</table>

							</div>
						</div>
					</div>


			</div>

		</div>
		<!-- /#page-content-wrapper -->

	</div>

	<!-- Bootstrap core JavaScript -->
	<script
		src="${pageContext.request.contextPath}/static/jquery/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/js/bootstrap.bundle.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>

	<!-- Menu Toggle Script -->
	<script>
		$("#menu-toggle").click(function(e) {
			e.preventDefault();
			$("#wrapper").toggleClass("toggled");
		});
	</script>
</body>
</html>
