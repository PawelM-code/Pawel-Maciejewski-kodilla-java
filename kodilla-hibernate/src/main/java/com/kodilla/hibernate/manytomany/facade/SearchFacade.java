package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class SearchFacade {
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    public void saveCompany(Company company) {
        companyDao.save(company);
    }

    public Iterator<Company> getAllCompanies() {
        return companyDao.findAll().iterator();
    }

    public void deleteCompanyById(int id) {
        companyDao.deleteById(id);
    }

    public List<Company> searchCompanyWhoseNameContains(String comapny) {
        List<Company> companies = companyDao.retrieveCompanyNameAfterPartOfName(comapny);
        for (Company company : companies) {
            System.out.println(company.getCompanyName());
        }
        return companies;
    }

    public List<Employee> searchEmployeeWhoseLastNameContains(String employee) {
        List<Employee> employees = employeeDao.retrieveEmployeeLastNameAfterPartOfName(employee);
        for (Employee employee1 : employees) {
            System.out.println(employee1.getLastName());
        }
        return employees;
    }
}
