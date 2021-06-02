package dals;

import models.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CategoryDal extends DB implements IDAL<Category>{
    public CategoryDal() {
        super();
        setTableName("category");
    }

    @Override
    public ArrayList<Category> getList() {
        ArrayList<Category> categories = new ArrayList<>();
        String query = "SELECT * FROM " + this.tableName;
        try {
            Statement stm = this.connection.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                Category category = new Category();
                category.setName(rs.getString("name"));
                category.setId(rs.getInt("id"));
                categories.add(category);
            }
        } catch (Exception e) {
            return null;
        }
        return categories;
    }

    @Override
    public boolean update(Category category) {
        String query = "UPDATE " + this.tableName + " SET name=? WHERE id=?";
        try {
            PreparedStatement prp = this.connection.prepareStatement(query);
            prp.setString(1, category.getName());
            prp.setInt(2, category.getId());
            prp.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        String query = "DELETE from " + this.tableName + " WHERE id=?";
        try {
            PreparedStatement prp = this.connection.prepareStatement(query);
            prp.setInt(1, id);
            prp.execute();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean insert(Category category) {
        String query = "INSERT INTO " + this.tableName + "(name) VALUES(?)";
        try {
            PreparedStatement prp = this.connection.prepareStatement(query);
            prp.setString(1, category.getName());
            prp.execute();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Category getById(int id) {
        Category category = null;
        String query = "SELECT * FROM " + this.tableName+" WHERE id="+id;
        try {
            Statement stm = this.connection.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                category = new Category();
                category.setName(rs.getString("name"));
                category.setId(rs.getInt("id"));
            }
        } catch (Exception e) {
            return null;
        }
        return category;
    }
}
