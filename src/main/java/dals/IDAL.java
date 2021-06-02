package dals;

import models.Category;

import java.util.ArrayList;

public interface IDAL<T> {

    public  ArrayList<T> getList();

    public  boolean update(T updateObject);

    public  boolean delete(int id);

    public boolean insert(T category);

    public T getById(int id);
}
