<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="com.walls.repository.Sentencias" %>
<%@page import="java.util.List" %>
<%@page import="com.walls.entidades.Clinica" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        
		
		<link  rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css"/>
<%-- 		<link  rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/index.css"/> --%>
       	
    </head>
    <body>
        <h3>
        <%
			
		%>
         <%//lista.get(0).getId().getNombre() %></h3> 
	    <main class="login-form">
	    
	    <div class="cotainer">
	        <div class="row justify-content-center">
	            <div class="col-md-8">
	                <div class="card">
	                    <div class="card-header">Login</div>
	                    <div class="card-body">
	                    
	                        <form method="POST" action="compruebaLogin">
	                        
	                            <div class="form-group row">
	                                <label for="mail" class="col-md-4 col-form-label text-md-right">Mail</label>
	                                <div class="col-md-6">
	                                    <input type="email" id="mail" class="form-control" name="mail" required autofocus>
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
	        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
	        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    </body>
</html>