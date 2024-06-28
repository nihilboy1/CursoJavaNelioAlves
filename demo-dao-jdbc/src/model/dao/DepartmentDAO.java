package model.dao;

import model.entities.Department;

import java.util.List;

public interface DepartmentDAO{

    void insert(Department department);
    void update(Department department);
    void deleteById(Integer Id);
    Department findById(Integer Id);
    List<Department> findAll();


}
