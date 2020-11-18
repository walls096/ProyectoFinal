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

<title>Pets´ Clinic</title>

<!--     Bootstrap core CSS  -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/simple-sidebar.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/menu.css" />
<style>
.colorRed {
	color: red;
}

.separacion {
	padding-top: 5%;
}
</style>
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
					<li class="nav-item font-weight-bold"><a class="nav-link"
						href="index">Inicio <span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item font-weight-bold"><a class="nav-link"
						href="contacta">Contáctanos</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle font-weight-bold" href="#"
						id="navbarDropdown" role="button" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> Cuenta </a>
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
			<section class="container">
				<section class="main row separacion">
					<article class="content col-xs-12 col-sm-12 col-md-6">

						<h4 class="text-center">¿Quienes somos?</h4>
						<p>
							Abrimos nuestra clínica en
							<mark>Sevilla</mark>
							en el año 1993. Ya ha llovido mucho desde entonces aunque aquel
							fue un año especialmente seco. Desde entonces han pasado por
							nuestras manos muchos animales. Todos han dejado una huella más o
							menos profunda y a todos los cuidamos como si fueran nuestros. En
							la clínica trabajamos Pepe Díaz y Cristina Candelaria como
							veterinarios y nuestra auxiliar Rocío Ruiz. Estaremos encantados
							de atenderle en cualquier momento </br>
							</br>¡ Ah se nos olvidaba! el de la derecha es Donete, nuestro bedel y
							el que seguro que os da la bienvenida cuando lleguéis. Muchos de
							vosotros ya lo conocéis
						</p>
					</article>
					<article class="content col-xs-12 col-sm-12 col-md-3">
						<img
							src="${pageContext.request.contextPath}/static/img/quienes_somos.jpg"
							alt="">
					</article>
				</section>

				<section class="main row separacion">
					<article class="content col-xs-12 col-sm-12 col-md-6">
					<h4 class="text-center">¿Que hacemos?</h4>
						<p>Nos mantenemos al día en todas las investigaciones
							realizadas en medicina veterinaria para ello intentamos acudir a
							todos los congresos, cursos y seminarios que no es posible. Vamos
							incorporando a nuestra clínica todos los avances tecnológicos a
							nuestro alcance de forma que nuestros clientes no tengan que
							esperar para obtener los resultados de pruebas diagnósticas y el
							tratamiento de su animal.</br></br>Además tenemos servicios de peluquería
							para todo tipo de mascotas. Nos preocupamos por el aspecto de nuestros seres queridos
							ofreciéndoles la mejor atención posible.</br></br>Contamos con un servicio
							de urgencia disponible las 24H para todos los clientes registrados.</p>
					</article>

						<article class="content col-xs-12 col-sm-12 col-md-3">
							<img
								src="${pageContext.request.contextPath}/static/img/que_hacemos.jpg"
								alt="">
						</article>
						
				</section>



			</section>
			<!-- Fin del div container	 -->


			<section id="contact" class="map separacion">
				<h4 class="text-center	">¿Donde nos encontramos?</h4>
				<div class="separacion" style="width: 100%">
					<iframe scrolling="no" marginheight="0" marginwidth="0"
						src="https://maps.google.com/maps?width=100%25&amp;height=600&amp;hl=es&amp;q=trabajo,%201%20Sevilla,%20Spain+(Pet%C2%B4s%20Clinic)&amp;t=&amp;z=15&amp;ie=UTF8&amp;iwloc=B&amp;output=embed"
						width="100%" height="600" frameborder="0"></iframe>
				</div>
			</section>

		</div>

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
