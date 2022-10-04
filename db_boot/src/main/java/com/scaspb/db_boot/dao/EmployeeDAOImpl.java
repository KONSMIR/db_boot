package com.scaspb.db_boot.dao;

import com.scaspb.db_boot.model.Employee;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;


    public List<Employee> getAllEmployees() {

        Session session = entityManager.unwrap(Session.class);
        List<Employee> allEmployees = session.createQuery("FROM Employee", Employee.class).getResultList();

        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployees(int id) {
        Session session = entityManager.unwrap(Session.class);
        Employee employee = session.get(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = entityManager.unwrap(Session.class);

        session.createQuery("delete from Employee where id =:employeeID")
        .setParameter("employeeID", id)
        .executeUpdate();
    }
}
