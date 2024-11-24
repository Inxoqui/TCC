<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Inserir Serviços</title>

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

<!-- CSS form -->
<link rel="stylesheet" href="css/formCss.css">
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
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="mainS">Serviços</a></li>
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#">Clientes</a></li>
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#">Colaboradores</a></li>
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#">Perfis</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>

	<section id="container">
		<h1>Criar novo Serviço</h1>

		<form name="formServico" action="inserirS" method="get">
			<div class="mb-3">
				<label for="formGroupExampleInput" class="form-label">Nome</label> <input
					type="text" name="nome" class="form-control"
					id="formGroupExampleInput" placeholder="Insira o nome do serviço">
			</div>
			<div class="mb-3">
				<label for="formGroupExampleInput2" class="form-label">Valor</label>
				<input type="text" name="valor" class="form-control"
					id="formGroupExampleInput2" placeholder="Insira o valor do serviço">
			</div>
			<div class="col-12">
				<button type="submit" class="btn btn-primary">Salvar</button>
			</div>
		</form>
	</section>

	<footer class="fixed-bottom">
		<h3>Desenvolvido por Inxoqui Tech todos os diereitos reservados
			&#9400</h3>
	</footer>

	<script type="text/javascript">
		function validaForm() {
			let nome = formServico.nome.value
			let valor = formServico.valor.value

			if (nome === "") {
				alert('O campor NOME deve ser preenchido!')
				formServico.nome.focus()
				return false
			} else if (valor === "") {
				alert('O campor VALOR deve ser preenchido!')
				formServico.valor.focus()
				return false
			} else {
				document.forms["formServico"].submit()
			}
		}
	</script>

</body>
</html>