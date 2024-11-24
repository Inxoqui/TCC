package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProdutosDAO extends DAO {

	public ProdutosDAO() {
		super();
	}

	public void inserir(Produtos produto) throws Exception {
		String sql = "INSERT INTO produtos (nome,valor) VALUES(?,?);";

		try {
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, produto.getNome());
			pst.setDouble(2, produto.getValor());
			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public ArrayList<Produtos> listarProdutos() {
		ArrayList<Produtos> produtos = new ArrayList<Produtos>();
		String sql = "SELECT * FROM produtos order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			// LOOP PARA PEGAR OS PRODUTOS
			while (rs.next()) {
				Produtos p = new Produtos();
				p.setIdPro(rs.getInt("idPro"));
				p.setNome(rs.getString("nome"));
				p.setValor(rs.getDouble("valor"));
				produtos.add(p);
			}
			con.close();
			return produtos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}
	
	//SELECIONAR O PRODUTO
	public void carregarPorID(Produtos produtos) {
		String sql = "SELECT * FROM produtos where idPro = ?";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, produtos.getIdPro());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				produtos.setIdPro(rs.getInt(1));
				produtos.setNome(rs.getString(2));
				produtos.setValor(rs.getDouble(3));
			}
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//EDITAR PRODUTO
	public void alterarProduto(Produtos produtos) {
		String sql = "update produtos set nome=?,valor=? where idPro=?;";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, produtos.getNome());
			pst.setDouble(2, produtos.getValor());
			pst.setInt(3, produtos.getIdPro());
			pst.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	//EXCLUIR PRODUTO
	public void excluir(Produtos produtos) {
		String sql = "DELETE FROM produtos WHERE idPro=?";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, produtos.getIdPro());
			pst.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
