package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Cliente;

public class ClienteDAO {
	
	private Connection conn = null;
	
	public ClienteDAO(){
		try {
			conn = Conexao.getConexao();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void incluir(Cliente cli){
		String sql;
		PreparedStatement ps = null;
		
		sql = "INSERT INTO cliente(codigo, nome, cpf, identidade) VALUES (?, ?, ?, ?)";
		
		try{
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cli.getCodigo());
			ps.setString(2, cli.getNome());
			ps.setString(3, cli.getCpf());
			ps.setString(4, cli.getIdentidade());
			ps.execute();
			ps.close();
		}
		catch(Exception e){
			System.out.println("Erro na operção de incluir registro: " + e.getMessage());
		}
	}

	public void alterar(Cliente cli){
		String sql;
		PreparedStatement ps = null;
		
		sql = "update cliente set nome = ?, cpf = ?, identidade = ? where codigo = ?";
		
		try{
			ps = conn.prepareStatement(sql);
			ps.setString(1, cli.getNome());
			ps.setString(2, cli.getCpf());
			ps.setString(3, cli.getIdentidade());
			ps.setInt(4, cli.getCodigo());
			ps.execute();
			ps.close();
		}
		catch(Exception e){
			System.out.println("Erro na operção de alterar registro: " + e.getMessage());
		}
	}
	
	public void apagar(Cliente cli){
		String sql;
		PreparedStatement ps = null;
		
		sql = "delete from cliente where codigo = ?";
		
		try{
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cli.getCodigo());
			ps.execute();
			ps.close();
		}
		catch(Exception e){
			System.out.println("Erro na operção de apagar registro: " + e.getMessage());
		}
	}
	
	public int proximoCodigo(){
		String sql;
		PreparedStatement ps = null;
		int proximoCodigo = -1;
		
		sql = "select max(codigo) from cliente";
		
		try{
			ps = conn.prepareStatement(sql);
			ResultSet rs = null;
			rs = ps.executeQuery();
			
			if(rs.next()){
				proximoCodigo = rs.getInt(1);
				proximoCodigo++;
			}
			
			ps.close();
		}
		catch(Exception e){
			System.out.println("Erro: " + e.getMessage());
		}
		
		return proximoCodigo;
	}
	
	public ArrayList<Cliente> listar(){
		ArrayList<Cliente> clientes = new ArrayList<>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select codigo, nome, cpf, identidade from cliente";
		try{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Cliente cli = new Cliente();
				
				cli.setCodigo(rs.getInt("codigo"));
				cli.setNome(rs.getString("nome"));
				cli.setCpf(rs.getString("cpf"));
				cli.setIdentidade(rs.getString("identidade"));
				
				clientes.add(cli);
			}
			rs.close();
			ps.close();
		}
		catch(Exception e){
			System.err.println("Erro na operção de listar registros: " + e.getMessage());
		}
		
		return clientes;
	}
	
	public void fecharConexao(){
		try {
			conn.close();
		} catch (SQLException e) {
			System.err.println("Erro fechando conexão: " + e.getMessage());			
		}
	}
}



