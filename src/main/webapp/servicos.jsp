<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Servico"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<Servico> lista = (ArrayList<Servico>) request.getAttribute("servico");
%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Perfis</title>

<!-- JS BOOTSTRAP -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
<!--CSS BOOTSTRAP-->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.1/css/all.min.css">


<!-- CSS form -->
<link rel="stylesheet" href="css/tableCss.css">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-lg bg-body-tertiary">
			<div class="container-fluid">
				<a class="navbar-brand" href="index.jsp"><img
					src="imagens/logo.jpg"></a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarNav"
					aria-controls="navbarNav" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="index.jsp">Home</a></li>
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#">Agendamento</a></li>
						<li class="nav-item"><a class="nav-link disabled"
							aria-current="page" href="mainS">Serviços</a></li>
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#">Clientes</a></li>
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#">Colaboradores</a></li>
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="mainPerfil">Perfis</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>

	<section id="container">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">SERVIÇOS</th>
					<th scope="col">VALOR</th>
					<th scope="col">AÇÕES</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>ADICIONAR SERVIÇO</td>
					<td></td>
					<td><a href="formS"><i class="fa-solid fa-plus"></i></a></td>
				</tr>
				<%
				for (int i = 0; i < lista.size(); i++) {
				%>
				<tr>
					<td><%=lista.get(i).getidServico()%></td>
					<td><%=lista.get(i).getNome()%></td>
					<td><%=lista.get(i).getValor()%></td>
					<td><a
						href="carregarS?idServico=<%=lista.get(i).getidServico()%>"><i
							class="fa-solid fa-pen"></i></a> <a
						href="javascript: confirmar(<%=lista.get(i).getidServico()%>)"><i
							class="fa-solid fa-trash"></i></a></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>

	</section>

	<footer class="fixed-bottom">
		<h3>Desenvolvido por Inxoqui Tech todos os diereitos reservados
			&#9400</h3>
	</footer>

	<script type="text/javascript">
		function confirmar(idServico) {
			let resposta = confirm("Tem certeza que deseja excluir este serviço?")

			if (resposta === true) {
				alert("Serviço excluido com sucesso!")
				window.location.href = "excluirS?idServico=" + idServico
			}
		}
	</script>
</body>
</html>