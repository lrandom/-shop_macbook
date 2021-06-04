package dals;

import models.Category;
import models.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductDal extends DB implements IDAL<Product> {
    public ProductDal() {
        super();
        setTableName("products");
    }

    @Override
    public ArrayList<Product> getList() {
        ArrayList<Product> products = new ArrayList<>();
        String query = "SELECT * FROM " + this.tableName;
        try {
            Statement stm = this.connection.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                Product product = new Product();
                product.setName(rs.getString("name"));
                product.setId(rs.getInt("id"));
                product.setImage(rs.getString("image"));
                product.setQuantity(rs.getInt("quantity"));
                product.setPrice(rs.getFloat("price"));
                product.setDescription(rs.getString("description"));
                products.add(product);
            }
        } catch (Exception e) {
            return null;
        }
        return products;
    }

    @Override
    public boolean update(Product updateObject) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean insert(Product product) {
        String query = "INSERT INTO " + this.tableName + "" +
                "(name,quantity,category_id,image,description,price,keyword,sku) " +
                "VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement prp = this.connection.prepareStatement(query);
            prp.setString(1, product.getName());
            prp.setInt(2, product.getQuantity());
            prp.setInt(3, product.getCategory());
            prp.setString(4, product.getImage());
            prp.setString(5, product.getDescription());
            prp.setFloat(6, product.getPrice());
            prp.setString(7, product.getKeyword());
            prp.setString(8, product.getSku());
            prp.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Product getById(int id) {
        Product product = null;
        String query = "SELECT * FROM " + this.tableName+" WHERE id="+id;
        try {
            Statement stm = this.connection.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                product = new Product();
                product.setName(rs.getString("name"));
                product.setId(rs.getInt("id"));
                product.setImage(rs.getString("image"));
                product.setQuantity(rs.getInt("quantity"));
                product.setPrice(rs.getFloat("price"));
                product.setDescription(rs.getString("description"));
            }
        } catch (Exception e) {
            return null;
        }
        return product;
    }
}
