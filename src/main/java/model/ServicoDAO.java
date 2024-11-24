package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ServicoDAO extends DAO {
	// CRIANDO O CONSTRUTOR
	public ServicoDAO() {
		super();
	}

	public void inserirServico(Servico servico) throws Exception {
		String sql = "INSERT INTO servico (nome,valor) VALUES(?,?);";

		try {
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, servico.getNome());
			pst.setDouble(2, servico.getValor());
			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public ArrayList<Servico> listarServico() {
		ArrayList<Servico> servico = new ArrayList<Servico>();
		String sql = "SELECT * FROM servico order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			// LOOP PARA PEGAR OS SERVIÇOS
			while (rs.next()) {
				Servico s = new Servico();
				s.setidServico(rs.getInt("idServico"));
				s.setNome(rs.getString("nome"));
				s.setValor(rs.getDouble("valor"));
				servico.add(s);
			}
			con.close();
			return servico;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	// SELECIONAR O SERVIÇO
	public void carregarPorID(Servico servico) {
		String sql = "SELECT * FROM servico where idServico = ?";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, servico.getidServico());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				servico.setidServico(rs.getInt(1));
				servico.setNome(rs.getString(2));
				servico.setValor(rs.getDouble(3));
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// EDITAR SERVIÇO
	public void alterarServico(Servico servico) {
		String sql = "update servico set nome=?,valor=? where idServico=?;";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, servico.getNome());
			pst.setDouble(2, servico.getValor());
			pst.setInt(3, servico.getidServico());
			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// EXCLUIR SERVIÇO
	public void excluir(Servico servico) {
		String sql = "DELETE FROM servico WHERE idServico=?";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, servico.getidServico());
			pst.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
