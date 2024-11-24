<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>InserirProdutos</title>
</head>
<body>
	<h1>Criar novo produto</h1>

	<form name="formProduto" action="inserirP" method="get">
		<table>
			<tr>
				<td><input type="text" name="nome" placeholder="Nome">
				</td>
			</tr>
			<tr>
				<td><input type="text" name="valor" placeholder="Valor">
				</td>
			</tr>
		</table>
		<input type="button" value="Salvar" onclick="validaForm()">
	</form>

	<script type="text/javascript">
		function validaForm(){
			let nome = formProduto.nome.value
			let valor = formProduto.valor.value
			
			if (nome === ""){
				alert('O campor NOME deve ser preenchido!')
				formProduto.nome.focus()
				return false
			} else if (valor ===""){
				alert('O campor VALOR deve ser preenchido!')
				formProduto.valor.focus()
				return false
			} else {
				document.forms["formProduto"].submit()
			}
		}
		
	</script>

</body>
</html>