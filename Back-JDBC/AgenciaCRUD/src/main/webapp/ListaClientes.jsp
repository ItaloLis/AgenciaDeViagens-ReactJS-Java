<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="ISO-8859-1">
		<title>Listagem dos Clientes</title>
		<!-- CSS do Bootstrap -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
		
		<!-- Link JS do Bootstrap -->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	</head>
	
	<body>
		
		<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		  <div class="container-fluid">
		    <a class="navbar-brand text-light" href="#">Cadastro de Clientes</a>
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarSupportedContent">
		      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
		        <li class="nav-item mx-2">
		          <a class="nav-link active text-light" aria-current="page" href="index.html">Home</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link active text-light" href="#">Listagem dos Clientes</a>
		        </li>
		      </ul>
		      <form action="CreateAndFind" method="get" class="d-flex">
		        <input class="form-control me-2" type="search" placeholder="Digite o CPF do Cliente" aria-label="Search">
		        <button class="btn btn-outline-light" type="submit">Pesquisar</button>
		      </form>
		    </div>
		  </div>
		</nav>
		
		<div class="container">
				<div class="text-center my-5">
					<h3 class="display-3">Nossos Clientes</h3>
				</div>
				
				<div class="row justify-content-center">
					<table>
						<thead>
							<tr>
								<th>#</th>
								<th>Nome</th>
								<th>CPF</th>
								<th>Nascimento</th>
								<th>Situação</th>
							</tr>
						</thead>
						<tbody>
							<c: forEach items="${clientes}" var="cliente">
								<tr>
									<td>${cliente.id}</td>
									<td>${cliente.nome}</td>
									<td>${cliente.cpf}</td>
									<td>${cliente.nascimento}</td>
									<td>${cliente.situacao}</td>
									<td>
										<a href="Delete?clienteId=${cliente.id}">Deletar</a>
										<a href="Update?clienteId=${cliente.id}">Atualizar</a>
									</td>
								</tr>
							</c: forEach>
						</tbody>
					</table>
				</div>
				
		</div>
		
	</body>

</html>