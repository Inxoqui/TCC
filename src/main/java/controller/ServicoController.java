package controller;

import java.io.IOException;
import java.util.ArrayList;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Servico;
import model.ServicoDAO;

@WebServlet(urlPatterns = { "/mainS", "/formS", "/inserirS", "/carregarS", "/editarS", "/excluirS" })
public class ServicoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// CRIANDO OS OBJETOS
	ServicoDAO dB = new ServicoDAO();
	Servico s = new Servico();

	public ServicoController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);

		if (action.equals("/mainS")) {
			servico(request, response);
		} else if (action.equals("/formS")) {
			servicoForm(request, response);
		} else if (action.equals("/inserirS")) {
			novoServico(request, response);
		} else if (action.equals("/carregarS")) {
			carregarServico(request, response);
		} else if (action.equals("/editarS")) {
			editarServico(request, response);
		} else if (action.equals("/excluirS")) {
			excluirServico(request, response);
		} else {
			response.sendRedirect("index.jsp");
		}
	}

	protected void servico(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Servico> lista = dB.listarServico();

		request.setAttribute("servico", lista);
		RequestDispatcher rd = request.getRequestDispatcher("servicos.jsp");
		rd.forward(request, response);
	}

	protected void servicoForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("inserirServicos.jsp");
	}

	protected void novoServico(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// SETNANDO OS OBJETO
		s.setNome(request.getParameter("nome"));
		double valor = Double.parseDouble(request.getParameter("valor"));
		s.setValor(valor);

		try {
			dB.inserirServico(s);
		} catch (Exception e) {
			System.out.println(e);
		}

		response.sendRedirect("mainS");
	}

	// EDITAR SERVIÇO
	protected void carregarServico(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idServico = Integer.parseInt(request.getParameter("idServico"));
		s.setidServico(idServico);
		;
		dB.carregarPorID(s);

		/*
		 * TESTE DE RECEBIMENTO System.out.println(p.getIdPro());
		 * System.out.println(p.getNome()); System.out.println(p.getValor());
		 */

		// SETAR OS ATRIBUTOS DO FUMULÁRIO
		request.setAttribute("idServico", s.getidServico());
		request.setAttribute("nome", s.getNome());
		request.setAttribute("valor", s.getValor());

		// ECAMINHAR OS DADOS PARA O DOCUMENTO DE EDITAR
		RequestDispatcher rd = request.getRequestDispatcher("alterarServicos.jsp");
		rd.forward(request, response);
	}

	protected void editarServico(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// RECEBENDO OS DADOS
		int idServico = Integer.parseInt(request.getParameter("idServico"));
		String nome = request.getParameter("nome");
		double valor = Double.parseDouble(request.getParameter("valor"));

		// SETANDO AS VARIÁVEIS
		s.setidServico(idServico);
		s.setNome(nome);
		s.setValor(valor);

		// EXECUTANDO O MÉTODO ALTERAR
		try {
			dB.alterarServico(s);
		} catch (Exception e) {
			System.out.println(e);
		}
		// REDIRECIONANDO PARA A TELA DE SERVIÇOS
		response.sendRedirect("mainS");
	}

	protected void excluirServico(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// RECEBENDO O ID
		int idServico = Integer.parseInt(request.getParameter("idServico"));
		s.setidServico(idServico);

		// SETANDO A VARIAVEL
		s.setidServico(idServico);

		// EXECUTANDO O MÉTODO DE EXCLUIR
		dB.excluir(s);

		response.sendRedirect("mainS");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
