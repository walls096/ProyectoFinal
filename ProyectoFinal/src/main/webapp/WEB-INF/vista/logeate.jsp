<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="com.walls.repository.BrokerLogin"%>
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

<style>
.separacion {
	padding-top: 5%;
}
.colorRed{
	color:red;
}
</style>
</head>

<div class="d-flex" id="wrapper">

	<!-- Page Content -->
	<div id="page-content-wrapper">

		<nav
			class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
			<img class="img_frame"
				src="${pageContext.request.contextPath}/static/img/boot.png" alt="">
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
							<a class="dropdown-item" href="iniciaSesion">Inicia sesión</a> <a
								class="dropdown-item" href="registrate">Regístrate</a>
							<!-- 							<div class="dropdown-divider"></div> -->
							<!-- 							<a class="dropdown-item" href="#">Cerrar sesion</a> -->
						</div></li>
				</ul>
			</div>
		</nav>

		<%
			//lista.get(0).getId().getNombre()
		%>
		<div class="container-fluid separacion">
			<main class="login-form">
	    
	    <div class="cotainer">
	        <div class="row justify-content-center">
	            <div class="col-md-8">
	                <div class="card">
	                    <div class="card-header colorRed">${nombre}</div>
	                    <div class="card-body">
	                    
	                        <form method="POST" action="compruebaPass">
	                        
	                            <div class="form-group row">
	                                <label for="pass" class="col-md-4 col-form-label text-md-right">Password</label>
	                                <div class="col-md-6">
	                                    <input type="password" id="pass" class="form-control" name="pass" required autofocus>
	                                </div>
	                            </div>
	
	
	                            <div class="col-md-6 offset-md-4">
	                                <input type="submit" value="Enviar" class="btn btn-primary">
	                                               
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