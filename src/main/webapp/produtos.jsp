<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Produtos"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<Produtos> lista = (ArrayList<Produtos>) request.getAttribute("produtos");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Produtos</title>
</head>
<body>
	<h1>Produtos</h1>
	<a href="formP">Novo Produto</a>
	
	<table border = 1 >
		<thead>
			<tr>
				<th>
					ID
				</th>
				<th>
					NOME
				</th>
				<th>
					VALOR
				</th>
				<th>
					AÇÃO
				</th>
			</tr>
		</thead>
		<tbody>
			<%for (int i = 0; i < lista.size(); i++) { %>
				<tr>
					<td> <%=lista.get(i).getIdPro() %> </td>
					<td> <%=lista.get(i).getNome() %> </td>
					<td> <%=lista.get(i).getValor() %> </td>
					<td> <a href="carregarP?idPro=<%=lista.get(i).getIdPro() %>">EDITAR </a>
						<a href="javascript: confirmar(<%=lista.get(i).getIdPro() %>)">EXCLUIR </a> </td>
				</tr>
			
			<% } %>
		</tbody>
	</table>
	
	<script type="text/javascript">
	function confirmar(idPro){
		let resposta = confirm("Tem certeza que deseja excluir este produto?")
		
		if(resposta === true){
			alert("Produto excluido com sucesso!")
			window.location.href = "excluirP?idPro=" + idPro
		}
	}
	</script>
</body>
</html>