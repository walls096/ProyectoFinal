<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="com.walls.repository.Sentencias"%>
<%@page import="java.util.List"%>
<%@page import="com.walls.entidades.Clinica"%>
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

<div class="d-flex" id="wrapper">

	<!-- Page Content -->
	<div id="page-content-wrapper">

		<nav
			class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
			<img class="img_frame" src="${pageContext.request.contextPath}/static/img/boot.png" alt="">
			<div id="page-content-wrapper">
			<h2>TITULO</h2>
			</div>

			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ml-auto mt-2 mt-lg-0">
					<li class="nav-item active"><a class="nav-link" href="index">Inicio
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="contacta">Contáctanos</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> Sesión </a>
						<div class="dropdown-menu dropdown-menu-right"
							aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="bienvenido">Inicia sesión</a> <a
								class="dropdown-item" href="registrate">Regístrate</a>
<!-- 							<div class="dropdown-divider"></div> -->
<!-- 							<a class="dropdown-item" href="#">Cerrar sesion</a> -->
						</div>
					</li>
				</ul>
			</div>
		</nav>


		<div class="container-fluid">
			<section class="container">
				<section class="main row">
					<section class="mb-4">

		<!--Section heading-->
		<h2 class="h1-responsive font-weight-bold text-center my-4">Contact
			us</h2>
		<!--Section description-->
		<p class="text-center w-responsive mx-auto mb-5">Do you have any
			questions? Please do not hesitate to contact us directly. Our team
			will come back to you within a matter of hours to help you.</p>

		<div class="row">

			<!--Grid column-->
			<div class="col-md-9 mb-md-0 mb-5">
				<form id="contact-form" name="contact-form" action="mail.php"
					method="POST">

					<!--Grid row-->
					<div class="row">

						<!--Grid column-->
						<div class="col-md-6">
							<div class="md-form mb-0">
								<input type="text" id="name" name="name" class="form-control">
								<label for="name" class="">Your name</label>
							</div>
						</div>
						<!--Grid column-->

						<!--Grid column-->
						<div class="col-md-6">
							<div class="md-form mb-0">
								<input type="text" id="email" name="email" class="form-control">
								<label for="email" class="">Your email</label>
							</div>
						</div>
						<!--Grid column-->

					</div>
					<!--Grid row-->

					<!--Grid row-->
					<div class="row">
						<div class="col-md-12">
							<div class="md-form mb-0">
								<input type="text" id="subject" name="subject"
									class="form-control"> <label for="subject" class="">Subject</label>
							</div>
						</div>
					</div>
					<!--Grid row-->

					<!--Grid row-->
					<div class="row">

						<!--Grid column-->
						<div class="col-md-12">

							<div class="md-form">
								<textarea type="text" id="message" name="message" rows="2"
									class="form-control md-textarea"></textarea>
								<label for="message">Your message</label>
							</div>

						</div>
					</div>
					<!--Grid row-->

				</form>

				<div class="text-center text-md-left">
					<a class="btn btn-primary"
						onclick="document.getElementById('contact-form').submit();">Send</a>
				</div>
				<div class="status"></div>
			</div>
			<!--Grid column-->

			<!--Grid column-->
			<div class="col-md-3 text-center">
				<ul class="list-unstyled mb-0">
					<li><i class="fas fa-map-marker-alt fa-2x"></i>
						<p>San Francisco, CA 94126, USA</p></li>

					<li><i class="fas fa-phone mt-4 fa-2x"></i>
						<p>+ 01 234 567 89</p></li>

					<li><i class="fas fa-envelope mt-4 fa-2x"></i>
						<p>contact@mdbootstrap.com</p></li>
				</ul>
			</div>
			<!--Grid column-->

		</div>

	</section>

			<footer>
				<div class="container foot">
					<h4>© 2020 Todos los derechos reservados</h4>
				</div>
			</footer>
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