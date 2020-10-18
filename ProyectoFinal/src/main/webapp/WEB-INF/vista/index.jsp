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
</head>

<body>

	<div class="d-flex" id="wrapper">

<%-- 		<jsp:include page="cabeceraLogin.jsp" flush="false"></jsp:include> --%>


		<!-- Page Content -->
		<div id="page-content-wrapper">

			<jsp:include page="cabeceraMenu.jsp" flush="false"></jsp:include>


			<div class="container-fluid">
				<section class="container">
					<section class="main row">
						<article class="content col-xs-12 col-sm-12 col-md-8">
							<h3>Descripcion del trabajo</h3>
							<p>
								He realizado esta práctica haciendo uso de diferentes frameworks
								los cuales enlazo gracias a su CDN. La mayoria de frameworks
								permite la posibilidad de descargar sus librerias de manera
								local pero para hacer mas liviano el proyecto las uso de manera
								online. </br>
								</br> He seguido un modelo responsivo gracias a
								<mark>Bootstrap</mark>
								el cual utilizo como código base en todas las paginas de mi
								proyecto. Además utilizo
								<mark>Jquery</mark>
								para agregar funcionalidad tales como imagenes en carrusel o
								algunas funciones gráficas, tambien utilizo este framework para
								la implantación de datos transformados en
								<mark>Json</mark>
								. Json es una estructura de datos, el cual sustituye a xml y el
								cual implemento en mi página , recogiendo los datos de una base
								de datos (MySql) dentro de un contenedor Docker. </br>
								</br> Por último, utilizo el framework mantenido por google
								<mark>AngularJs</mark>
								para acceder a un json externo y formateando su contenido para
								mostrarlo de una manera mas vistosa en mi pagina e incorporando
								un formulario de comentarios además de un poco de documentación
								explicando esta tencología.
							</p>
						</article>
						<!-- puedo ocultar el aside para pantallas pequeñas  -->
						<aside
							class="d-none d-xs-block d-md-block col-xs-12 col-sm-4 col-md-3">
							<h4>Front-end</h4>
							<p>Frontend es la parte de un programa o dispositivo a la que
								un usuario puede acceder directamente. Son todas las tecnologías
								de diseño y desarrollo web que corren en el navegador y que se
								encargan de la interactividad con los usuarios.</p>
							<h4>Back-end</h4>
							<p>Backend es la capa de acceso a datos de un software o
								cualquier dispositivo, que no es directamente accesible por los
								usuarios, además contiene la lógica de la aplicación que maneja
								dichos datos. El Backend también accede al servidor, que es una
								aplicación especializada que entiende la forma de como el
								navegador solicita datos.</p>
						</aside>
					</section>

					<section id="framework" class="row">

						<div class="color1 col-xs-12 col-sm-6 col-md-3">
							<h4>Bootstrap</h4>
							<p>
<%-- 					<img class="img_frame" src="${pageContext.request.contextPath}/static/img/boot.png" alt=""> --%>
								Bootstrap es una biblioteca o conjunto de herramientas de código
								abierto para diseño de sitios y aplicaciones web. Contiene
								plantillas de diseño con tipografía, formularios, botones,
								cuadros, menús de navegación y otros elementos de diseño basado
								en HTML y CSS.
							</p>
						</div>
						<div class="color2 col-xs-12 col-sm-6 col-md-3">
							<h4>Jquery</h4>
							<p>
								<img class="img_frame" src="" alt=""> jQuery es una
								biblioteca de manipulación de Modelo de Objetos del Documento
								(DOM). El DOM es una representación en estructura de árbol de
								todos los elementos de una página web. JQuery simplifica la
								sintaxis para buscar, seleccionar y manipular estos elementos
								DOM.
							</p>
						</div>
						<div class="color3 col-xs-12 col-sm-6 col-md-3">
							<h4>Json</h4>
							<p>
								<img class="img_frame" src="" alt=""> Json es un formato
								de texto sencillo para el intercambio de datos. Se trata de un
								subconjunto de la notación literal de objetos de JavaScript,
								aunque, debido a su amplia adopción como alternativa a XML, se
								considera un formato independiente del lenguaje.
							</p>
						</div>
						<div class="color4 col-xs-12 col-sm-6 col-md-3">
							<h4>Angular Js</h4>
							<p>
								<img class="img_frame" src="" alt=""> AngularJs es un
								framework de JavaScript de código abierto, mantenido por google,
								que se utiliza para crear y mantener aplicaciones web de una
								sola página. Su objetivo es aumentar las aplicaciones basadas en
								navegador con capacidad de Modelo Vista Controlador (MVC)
							</p>
						</div>

					</section>



				</section>
				<!-- Fin del div container	 -->


				<section id="contact" class="map">
					<iframe width="100%" height="100%" frameborder="0" scrolling="no"
						marginheight="0" marginwidth="0"
						src="https://maps.google.com/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=Twitter,+Inc.,+Market+Street,+San+Francisco,+CA&amp;aq=0&amp;oq=twitter&amp;sll=28.659344,-81.187888&amp;sspn=0.128789,0.264187&amp;ie=UTF8&amp;hq=Twitter,+Inc.,+Market+Street,+San+Francisco,+CA&amp;t=m&amp;z=15&amp;iwloc=A&amp;output=embed"></iframe>
					<br /> <small> <a
						href="https://maps.google.com/maps?f=q&amp;source=embed&amp;hl=en&amp;geocode=&amp;q=Twitter,+Inc.,+Market+Street,+San+Francisco,+CA&amp;aq=0&amp;oq=twitter&amp;sll=28.659344,-81.187888&amp;sspn=0.128789,0.264187&amp;ie=UTF8&amp;hq=Twitter,+Inc.,+Market+Street,+San+Francisco,+CA&amp;t=m&amp;z=15&amp;iwloc=A"></a>
					</small>
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

	<!-- Menu Toggle Script -->
	<script>
		$("#menu-toggle").click(function(e) {
			e.preventDefault();
			$("#wrapper").toggleClass("toggled");
		});
	</script>
</html>
