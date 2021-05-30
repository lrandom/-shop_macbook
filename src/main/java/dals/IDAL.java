package dals;

import models.Category;

import java.util.ArrayList;

public interface IDAL {

    public  ArrayList<Category> getList();

    public  boolean update(int id, Category updateObject);

    public  boolean delete(int id);

    public boolean insert(Category category);
}
