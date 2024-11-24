package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Produtos;
import model.ProdutosDAO;

@WebServlet(urlPatterns = { "/mainP", "/formP", "/inserirP", "/carregarP", "/editarP", "/excluirP" })
public class ProdutosController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// CRIANDO OS OBJETOS
	ProdutosDAO dB = new ProdutosDAO();
	Produtos p = new Produtos();

	public ProdutosController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);

		if (action.equals("/mainP")) {
			produtos(request, response);
		} else if (action.equals("/formP")) {
			produtosForm(request, response);
		} else if (action.equals("/inserirP")) {
			novoProduto(request, response);
		} else if (action.equals("/carregarP")) {
			carregarProduto(request, response);
		} else if (action.equals("/editarP")) {
			editarProduto(request, response);
		} else if (action.equals("/excluirP")) {
			excluirProduto(request, response);
		} else {
			response.sendRedirect("index.jsp");
		}

	}

	protected void produtos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Produtos> lista = dB.listarProdutos();

		request.setAttribute("produtos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("produtos.jsp");
		rd.forward(request, response);
	}

	protected void produtosForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("inserirProdutos.jsp");
	}

	protected void novoProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// SETNANDO OS OBJETO
		p.setNome(request.getParameter("nome"));
		double valor = Double.parseDouble(request.getParameter("valor"));
		p.setValor(valor);

		try {
			dB.inserir(p);
		} catch (Exception e) {
			System.out.println(e);
		}

		response.sendRedirect("mainP");
	}

	// EDITAR PRODUTO
	protected void carregarProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idPro = Integer.parseInt(request.getParameter("idPro"));
		p.setIdPro(idPro);
		dB.carregarPorID(p);

		/*
		 * TESTE DE RECEBIMENTO System.out.println(p.getIdPro());
		 * System.out.println(p.getNome()); System.out.println(p.getValor());
		 */

		// SETAR OS ATRIBUTOS DO FUMULÁRIO
		request.setAttribute("idPro", p.getIdPro());
		request.setAttribute("nome", p.getNome());
		request.setAttribute("valor", p.getValor());

		// ECAMINHAR OS DADOS PARA O DOCUMENTO DE EDITAR
		RequestDispatcher rd = request.getRequestDispatcher("alterarProdutos.jsp");
		rd.forward(request, response);
	}

	protected void editarProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * TESTE DE RECEBIMENTO System.out.println(request.getParameter("idPro"));
		 * System.out.println(request.getParameter("nome"));
		 * System.out.println(request.getParameter("valor"));
		 */

		// RECEBENDO OS DADOS
		int idPro = Integer.parseInt(request.getParameter("idPro"));
		String nome = request.getParameter("nome");
		double valor = Double.parseDouble(request.getParameter("valor"));
		
		//SETANDO AS VARIÁVEIS
		p.setIdPro(idPro);
		p.setNome(nome);
		p.setValor(valor);

		// EXECUTANDO O MÉTODO ALTERAR
		try {
			dB.alterarProduto(p);
		} catch (Exception e) {
			System.out.println(e);
		}
		

		// REDIRECIONANDO PARA A TELA DE PRODUTOS
		response.sendRedirect("mainP");
	}

	protected void excluirProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// RECEBENDO O ID
		int idPro = Integer.parseInt(request.getParameter("idPro"));
		p.setIdPro(idPro);

		// SETANDO A VARIAVEL
		p.setIdPro(idPro);

		// EXECUTANDO O MÉTODO DE EXCLUIR
		dB.excluir(p);

		response.sendRedirect("mainP");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
