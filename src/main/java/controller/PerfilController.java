package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Perfil;
import model.PerfilDAO;

@WebServlet(urlPatterns = { "/mainPerfil", "/formPerfil", "/inserirPerfil", "/carregarPerfil", "/editarPerfil",
		"/excluirPerfil" })
public class PerfilController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// CRIANDO OS OBJETOS
	Perfil perfil = new Perfil();
	PerfilDAO dB = new PerfilDAO();

	public PerfilController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);

		if (action.equals("/mainPerfil")) {
			perfil(request, response);
		} else if (action.equals("/formPerfil")) {
			perfilForm(request, response);
		} else if (action.equals("/inserirPerfil")) {
			novoPerfil(request, response);
		} else if (action.equals("/carregarPerfil")) {
			carregarPerfil(request, response);
		} else if (action.equals("/editarPerfil")) {
			editarPerfil(request, response);
		} else if (action.equals("/excluirPerfil")) {
			excluirPerfil(request, response);
		} else {
			response.sendRedirect("index.jsp");
		}
	}

	protected void perfil(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Perfil> lista = dB.listarPerfil();

		request.setAttribute("perfil", lista);
		RequestDispatcher rd = request.getRequestDispatcher("perfis.jsp");
		rd.forward(request, response);
	}

	protected void perfilForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("inserirPerfis.jsp");
	}

	protected void novoPerfil(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		perfil.setPerfil(request.getParameter("perfil"));
		try {
			dB.inserirPerfil(perfil);
		} catch (Exception e) {
			System.out.println(e);
		}

		response.sendRedirect("mainPerfil");
	}

	// EDITAR SERVIÇO
	protected void carregarPerfil(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idPerfil = Integer.parseInt(request.getParameter("idPerfil"));
		perfil.setIdPerfil(idPerfil);
		;
		dB.carregarPorID(perfil);

		// SETAR OS ATRIBUTOS DO FUMULÁRIO
		request.setAttribute("idPerfil", perfil.getIdPerfil());
		request.setAttribute("perfil", perfil.getPerfil());

		// ECAMINHAR OS DADOS PARA O DOCUMENTO DE EDITAR
		RequestDispatcher rd = request.getRequestDispatcher("alterarPerfis.jsp");
		rd.forward(request, response);
	}

	protected void editarPerfil(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Perfil p = new Perfil();
		
		// RECEBENDO OS DADOS
		int idPerfil = Integer.parseInt(request.getParameter("idPerfil"));
		String perfil = request.getParameter("perfil");
		
		// SETANDO AS VARIÁVEIS
		p.setIdPerfil(idPerfil);
		p.setPerfil(perfil);

		// EXECUTANDO O MÉTODO ALTERAR
		try {
			dB.alterarPerfil(p);
		} catch (Exception e) {
			System.out.println(e);
		}
		// REDIRECIONANDO PARA A TELA DE SERVIÇOS
		response.sendRedirect("mainPerfil");
	}

	protected void excluirPerfil(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// RECEBENDO O ID
		int idPerfil = Integer.parseInt(request.getParameter("idPerfil"));
		perfil.setIdPerfil(idPerfil);

		// SETANDO A VARIAVEL
		perfil.setIdPerfil(idPerfil);

		// EXECUTANDO O MÉTODO DE EXCLUIR
		dB.excluir(perfil);

		response.sendRedirect("mainPerfil");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
