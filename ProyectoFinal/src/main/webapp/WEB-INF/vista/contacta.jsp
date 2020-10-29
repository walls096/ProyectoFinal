<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="com.walls.dao.ClienteDAO"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">

<title>Pets´ Clinic</title>

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
</style>
<script>
function funcionEnviar(){
	alert("Mensaje enviado");
}
</script>
</head>

<div class="d-flex bg-light" id="wrapper">

	<!-- Page Content -->
	<div id="page-content-wrapper">

		<nav
			class="navbar navbar-expand-lg navbar-light bg-info border-bottom text-warning">
			<img class="img_frame"
				src="${pageContext.request.contextPath}/static/img/icon.png" alt="">
			<div id="page-content-wrapper">
				<h2>Clínica Pets</h2>
			</div>

			<!-- 			aparece en la vista movil el boton blanco -->
			<button class="navbar-toggler bg-light" type="button"
				data-toggle="collapse" data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ml-auto mt-2 mt-lg-0">
					<li class="nav-item font-weight-bold"><a
						class="nav-link" href="index">Inicio <span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item font-weight-bold"><a class="nav-link"
						href="contacta">Contáctanos</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle font-weight-bold" href="#"
						id="navbarDropdown" role="button" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> Sesión </a>
						<div class="dropdown-menu dropdown-menu-right bg-info"
							aria-labelledby="navbarDropdown">
							<a class="dropdown-item font-weight-bold" href="iniciaSesion">Inicia
								sesión</a> <a class="dropdown-item font-weight-bold"
								href="registrate">Regístrate</a>
						</div></li>
				</ul>
			</div>
		</nav>


		<div class="container-fluid">
			<section class="mb-4">

				<!--Section heading-->
				<h2 class="h1-responsive font-weight-bold text-center my-4">Contacta
					con nosotros</h2>
				<!--Section description-->
				<p class="text-center w-responsive mx-auto mb-5">Si presenta
					algún tipo de problema a la hora de utilizar la aplicación...
					Contacte con nosotros, estaremos encantados de ayudarle.</p>

				<div class="row">

					<!--Grid column-->
					<div class="col-md-9 mb-md-0 mb-5">
						<form id="contact-form" name="contact-form" action=""
							method="POST">

							<!--Grid row-->
							<div class="row">

								<!--Grid column-->
								<div class="col-md-6">
									<div class="md-form mb-0">
										<label for="name" class="">Nombre</label> <input type="text"
											id="name" name="name" class="form-control">
									</div>
								</div>
								<!--Grid column-->

								<!--Grid column-->
								<div class="col-md-6">
									<div class="md-form mb-0">
										<label for="email" class="">Correo electrónico</label> <input
											type="text" id="email" name="email" class="form-control">

									</div>
								</div>
								<!--Grid column-->

							</div>
							<!--Grid row-->

							<!--Grid row-->
							<div class="row">
								<div class="col-md-12">
									<div class="md-form mb-0">
										<label for="subject" class="">Asunto</label> <input
											type="text" id="subject" name="subject" class="form-control">
									</div>
								</div>
							</div>
							<!--Grid row-->

							<!--Grid row-->
							<div class="row">

								<!--Grid column-->
								<div class="col-md-12">

									<div class="md-form">
										<label for="message">Su mensaje</label>
										<textarea type="text" id="message" name="message" rows="2"
											class="form-control md-textarea"></textarea>

									</div>

								</div>
							</div>
							<!--Grid row-->

						</form>

						<div class="text-center text-md-left separacion">
							<a class="btn btn-primary"
								onclick="funcionEnviar();">Enviar</a>
						</div>
						<div class="status"></div>
					</div>
					<!--Grid column-->

					<!--Grid column-->
					<div class="col-md-3 text-center">
						<ul class="list-unstyled mb-0">
							<li><i class="fas fa-map-marker-alt fa-2x"></i>
								<p>Espartinas, 41807, Sevilla</p></li>

							<li><i class="fas fa-phone mt-4 fa-2x"></i>
								<p>+34 954443322</p></li>

							<li><i class="fas fa-envelope mt-4 fa-2x"></i>
								<p>support@pets.com</p></li>
						</ul>
					</div>
					<!--Grid column-->

				</div>

			</section>


		</div>
		
		<!-- Aqui estaba antes el footer, hasta aqui el div contenedor -->

	</div>
	<!-- /#page-content-wrapper -->
</div>

<footer class="pie-pagina bg-info">
	<div class="container foot text-center texto-footer">
		<h4>© 2020 Todos los derechos reservados</h4>
	</div>
</footer>



<!-- Bootstrap core JavaScript -->
<script
	src="${pageContext.request.contextPath}/static/jquery/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath}/static/js/bootstrap.bundle.min.js"></script>
</body>
</html>