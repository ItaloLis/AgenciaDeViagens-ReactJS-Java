package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.MySqlConnection;
import model.Cliente;

public class ClienteDao implements CRUD {
	
	private static Connection connection = MySqlConnection.createConnection();
	private static String sql;

	public static void create(Cliente cliente) {
		sql = "INSERT INTO clientes VALUES (null, ?, ?, ?, ?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getCpf());
			preparedStatement.setString(3, cliente.getNascimento());
			preparedStatement.setString(4, cliente.getSituacao());
			
			preparedStatement.executeUpdate();
			
			System.out.println("--Dados inseridos corretamente na Base de Dados");
			
		} catch(SQLException e) {
			System.out.println("--Dados inseridos incorretamente na Base de Dados" + e.getMessage());
		}
	}
	
	public static void delete(int clienteID) {
		
		sql = "DELETE FROM clientes WHERE id = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, clienteID);
			
			preparedStatement.executeUpdate();
			
			System.out.println("--Cliente deletado.");
			
		} catch(SQLException e) {
			System.out.println("--Não foi possível deletar cliente." + e.getMessage());
		}
	}
	
	public static void update(Cliente cliente) {
		
		sql = "UPDATE clientes SET nome=?, cpf=?, nascimento=?, situacao=? WHERE id=?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getCpf());
			preparedStatement.setString(3, cliente.getNascimento());
			preparedStatement.setString(4, cliente.getSituacao());
			preparedStatement.setInt(5, cliente.getId());
			
			preparedStatement.executeUpdate();
			
			System.out.println("--Dados atualizados corretamente na Base de Dados");
			
		} catch(SQLException e) {
			System.out.println("--Dados atualizados incorretamente na Base de Dados" + e.getMessage());
		}
		
	}

	
	public static List<Cliente> find(String search) {
		
		sql = String.format("SELECT * FROM clientes WHERE cpf LIKE '%s%%'", search);
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				Cliente cliente = new Cliente();
				
				cliente.setId(resultSet.getInt("id"));
				cliente.setNome(resultSet.getString("nome"));
				cliente.setCpf(resultSet.getString("cpf"));
				cliente.setNascimento(resultSet.getString("nascimento"));
				cliente.setSituacao(resultSet.getString("situacao"));
				
				clientes.add(cliente);
			}
			
			System.out.println("--Clientes localizados.");
			return clientes;
			
		} catch(SQLException e) {
			
			System.out.println("--Não foi possível localizar cliente." + e.getMessage());
			return null;
			
		}
		
	}
	
	public static Cliente findByPk(int clienteId) {
		
		sql = String.format("SELECT * FROM clientes WHERE id = '%d'", clienteId);
		
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			Cliente cliente = new Cliente();
			
			while(resultSet.next()) {
				cliente.setId(resultSet.getInt("id"));
				cliente.setNome(resultSet.getString("nome"));
				cliente.setCpf(resultSet.getString("cpf"));
				cliente.setNascimento(resultSet.getString("nascimento"));
				cliente.setSituacao(resultSet.getString("situacao"));
				
				return cliente;
			}
			
			System.out.println("--Clientes localizados.");
			
		} catch(SQLException e) {
			
			System.out.println("--Não foi possível localizar cliente." + e.getMessage());
			return null;
			
		}
		
	}
	
}
