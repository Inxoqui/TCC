package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PerfilDAO extends DAO {

	// CONSTRUTOS
	public PerfilDAO() {
		super();
	}

	public void inserirPerfil(Perfil perfil) throws Exception {
		// INSRINDO A QUERY
		String sql = "INSERT INTO perfil (perfil) VALUES (?);";

		// INSERINDO NO BANCO
		try {
			// CONECTANDO NO BANCO
			Connection con = conectar();

			// PASSANDO A QUERY PARA O BANCO
			PreparedStatement pst = con.prepareStatement(sql);

			// SETANDO OS ATRIBUTOS > EXECUTANDO O UPGRADE > FECHANDO A CONEXÃO
			pst.setString(1, perfil.getPerfil());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public ArrayList<Perfil> listarPerfil() {
		ArrayList<Perfil> perfil = new ArrayList<Perfil>();
		String sql = "SELECT * FROM perfil order by perfil";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			// LOOP PARA PEGAR OS PERFIS
			while (rs.next()) {
				Perfil p = new Perfil();
				p.setIdPerfil(rs.getInt("idPerfil"));
				p.setPerfil(rs.getString("perfil"));
				perfil.add(p);
			}
			con.close();
			return perfil;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	// SELECIONAR O PERFIL
	public void carregarPorID(Perfil perfil) {
		String sql = "SELECT * FROM perfil where idPerfil=?";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, perfil.getIdPerfil());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				perfil.setIdPerfil(rs.getInt(1));
				perfil.setPerfil(rs.getString(2));
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// EDITAR PERFIL
	public void alterarPerfil(Perfil perfil) {
		String sql = "update perfil set perfil=? where idPerfil=?;";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, perfil.getPerfil());
			pst.setInt(2, perfil.getIdPerfil());
			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// EXCLUIR PERFIL
	public void excluir(Perfil perfil) {
		String sql = "DELETE FROM perfil WHERE idPerfil=?";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, perfil.getIdPerfil());
			pst.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
