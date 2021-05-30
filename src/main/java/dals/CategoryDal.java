package dals;

import models.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CategoryDal extends DB implements IDAL{
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
    public boolean update(int id, Category category) {
        String query = "UPDATE from " + this.tableName + " SET name=? WHERE id=?";
        try {
            PreparedStatement prp = this.connection.prepareStatement(query);
            prp.setString(1, category.getName());
            prp.setInt(2, category.getId());
        } catch (Exception e) {
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
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}