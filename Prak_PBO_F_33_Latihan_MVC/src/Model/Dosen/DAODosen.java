package Model.Dosen;

import Model.Connector;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAODosen implements InterfaceDAODosen {
    @Override
    public void insert(ModelDosen dosen) {
        try {
            String query = "INSERT INTO dosen (nama, nidn) VALUES (?, ?);";
            PreparedStatement statement = Connector.Connect().prepareStatement(query);
            statement.setString(1, dosen.getNama());
            statement.setString(2, dosen.getNidn());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Input Failed: " + e.getLocalizedMessage());
        }
    }

    @Override
    public void update(ModelDosen dosen) {
        try {
            String query = "UPDATE dosen SET nama=?, nidn=? WHERE id=?;";
            PreparedStatement statement = Connector.Connect().prepareStatement(query);
            statement.setString(1, dosen.getNama());
            statement.setString(2, dosen.getNidn());
            statement.setInt(3, dosen.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Update Failed: " + e.getLocalizedMessage());
        }
    }

    @Override
    public void delete(String id) {
        try {
            String query = "DELETE FROM dosen WHERE id=?;";
            PreparedStatement statement = Connector.Connect().prepareStatement(query);
            statement.setInt(1, Integer.parseInt(id));
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Delete Failed: " + e.getLocalizedMessage());
        }
    }

    @Override
    public List<ModelDosen> getAll() {
        List<ModelDosen> listDosen = new ArrayList<>();

        try {
            Statement statement = Connector.Connect().createStatement();
            String query = "SELECT * FROM dosen;";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                ModelDosen dsn = new ModelDosen();
                dsn.setId(resultSet.getInt("id"));
                dsn.setNama(resultSet.getString("nama"));
                dsn.setNidn(resultSet.getString("nidn"));
                listDosen.add(dsn);
            }

            statement.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return listDosen;
    }

    @Override
    public List<ModelDosen> getByNip(String id) {
        List<ModelDosen> listDosen = new ArrayList<>();

        try {
            String query = "SELECT * FROM dosen WHERE id=?;";
            PreparedStatement statement = Connector.Connect().prepareStatement(query);
            statement.setInt(1, Integer.parseInt(id));
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ModelDosen dsn = new ModelDosen();
                dsn.setId(resultSet.getInt("id"));
                dsn.setNama(resultSet.getString("nama"));
                dsn.setNidn(resultSet.getString("nidn"));
                listDosen.add(dsn);
            }

            statement.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return listDosen;
    }
}
