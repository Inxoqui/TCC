<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alterar Produto</title>
</head>
<body>
	<form name="formProduto" action="editarP" method="get">
		<table>
			<tr>
				<td><input type="text" name="idPro" readonly="readonly"
					value="<%out.print(request.getAttribute("idPro"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="nome"
					value="<%out.print(request.getAttribute("nome"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="valor"
					value="<%out.print(request.getAttribute("valor"));%>"></td>
			</tr>
		</table>
		<input type="button" value="Salvar" onclick="validaForm()">
	</form>

	<script type="text/javascript">
		function validaForm() {
			let nome = formProduto.nome.value
			let valor = formProduto.valor.value

			if (nome === "") {
				alert('O campor NOME deve ser preenchido!')
				formProduto.nome.focus()
				return false
			} else if (valor === "") {
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