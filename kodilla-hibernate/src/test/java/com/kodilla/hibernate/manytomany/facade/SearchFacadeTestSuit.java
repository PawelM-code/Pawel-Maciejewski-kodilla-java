package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchFacadeTestSuit {
    @Autowired
    SearchFacade searchFacade;

    @Before
    public void setTestsCompaniesAndEmployees() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployeeList().add(johnSmith);
        dataMaesters.getEmployeeList().add(stephanieClarckson);
        dataMaesters.getEmployeeList().add(lindaKovalsky);
        greyMatter.getEmployeeList().add(johnSmith);
        greyMatter.getEmployeeList().add(lindaKovalsky);

        johnSmith.getCompanyList().add(softwareMachine);
        johnSmith.getCompanyList().add(greyMatter);
        stephanieClarckson.getCompanyList().add(dataMaesters);
        lindaKovalsky.getCompanyList().add(dataMaesters);
        lindaKovalsky.getCompanyList().add(greyMatter);

        searchFacade.saveCompany(softwareMachine);
        searchFacade.saveCompany(dataMaesters);
        searchFacade.saveCompany(greyMatter);
    }

    @After
    public void cleanUp() {
        Iterator<Company> companyIterator = searchFacade.getAllCompanies();
        try {
            while (companyIterator.hasNext()) {
                searchFacade.deleteCompanyById(companyIterator.next().getId());
            }
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void testSearchCompany() {
        //When
        List<Company> companies = searchFacade.searchCompanyWhoseNameContains("ata");

        //Then
        Assert.assertEquals(1, companies.size());
    }

    @Test
    public void testSearchEmployee() {
        //When
        List<Employee> employees = searchFacade.searchEmployeeWhoseLastNameContains("a");

        //Then
        Assert.assertEquals(2, employees.size());
    }
}
