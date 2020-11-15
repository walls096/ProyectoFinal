<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="com.walls.repositorio.RepositorioCliente"%>
<%@page import="com.walls.repositorio.RepositorioCita"%>
<%@page import="com.walls.repositorio.RepositorioMascota"%>
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
								<a class="btn btn-light" href="administrarCitas">←</a>
							</div>
				<div class="cotainer">
				
					<div class="row justify-content-center">
					
						<div class="col-md-8">
							<div class="card">
								<div class="card-header">Datos actuales de la cita</div>
								<div class="card-body">

									<form method="POST" action="modificarCitaFormulario">
									
									<div class="col-md-6 offset-md-4 colorRed">

											<h5>${mensaje}</h5>

										</div>

										<div class="form-group row">
											<label class="col-md-4 col-form-label text-md-right">Fecha y hora</label>
											<div class="col-md-4">
												<input type="text" class="form-control" autofocus disabled 
												placeholder="<%=RepositorioCita.getUnaCita().get(0).getFechaToString()%>">
												<input type="text" class="form-control" autofocus disabled 
												placeholder="<%=RepositorioCita.getUnaCita().get(0).getHora()%>">
											</div>
											<div class="col-md-2 separacion">
												<input id="btn-abrir-popup" class="btn-abrir-popup btn btn-warning" type="button" value="editar"> 
											</div>
										</div>
										<div class="form-group row">
											<label 
												class="col-md-4 col-form-label text-md-right">Nombre de mascota</label>
											<div class="col-md-6">
												<input type="text" class="form-control"
													 disabled autofocus placeholder="<%=RepositorioMascota.obtenerUnaMascota(RepositorioCita.getUnaCita().get(0).getCodMascota()).get(0).getNombre()%>">
											</div>
										</div>

										<div class="form-group row">
											<label for="tipoCita"
												class="col-md-4 col-form-label text-md-right">Tipo Cita</label>
											<div class="col-md-6">
												<select class="custom-select mr-sm-2"
													name="tipoCita">
													<option selected><%=RepositorioCita.getUnaCita().get(0).getTipoCita()%></option>
													<%if(!RepositorioCita.getUnaCita().get(0).getTipoCita().equals("REVISION")){ %>
														<option>REVISION</option>
													<%} %>
													<%if(!RepositorioCita.getUnaCita().get(0).getTipoCita().equals("URGENCIA")){ %>
														<option>URGENCIA</option>
													<%} %>
													<%if(!RepositorioCita.getUnaCita().get(0).getTipoCita().equals("VACUNACION")){ %>
														<option>VACUNACION</option>
													<%} %>
													<%if(!RepositorioCita.getUnaCita().get(0).getTipoCita().equals("PELUQUERIA")){ %>
														<option>PELUQUERIA</option>
													<%} %>
												</select>
											</div>
										</div>
										
										<div class="form-group row">
											<label for="observaciones"
												class="col-md-4 col-form-label text-md-right">Observaciones</label>
											<div class="col-md-6">
											<p class="colorRed">(Acaba cada observacion con una ,)</p>
											<%String[] split = RepositorioCita.getUnaCita().get(0).getObservacion().split("#");
													
													if(split[0].equals("SIN OBSERVACIONES"))
														split[0] = "";
													%>
											
											
												<textarea class="form-control" id="observaciones" rows="5" cols="200"><%for(String s : split){%><%=s+",\n"%><%}%></textarea>
												
												
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
		
			<div class="overlay" id="overlay">
				<div class="popup" id="popup">
					<h4>Cambiar fecha y hora</h4>
					<form action="modificarFechaHora" method="POST">
						<div class="contenedor-inputs">
							<input name="fecha" type="date" required>
							<select class="custom-select mr-sm-2"
								id="hora" name="hora" required>
								<option>HH : MM</option>
								<%for (String h : RepositorioCita.getHorasDisponibles()){ %>
								
									<option><%=h%></option>
								
								<%}%>
							</select>
						</div>
						<div class="contenedor-inputs separacion">
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