package com.idoso.microservice.controller;

import com.idoso.microservice.model.Employee;
import com.idoso.microservice.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    private final UsuarioService usuarioService;
    private List<Employee> employees = createList();

    public EmployeeController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET, produces = "application/json")
    public List<Employee> firstPage() {
        return employees;
    }

    @DeleteMapping(path = { "/{id}" })
    public Employee delete(@PathVariable("id") int id) {
        Employee deletedEmp = null;
        for (Employee emp : employees) {
            if (emp.getEmpId().equals(id)) {
                employees.remove(emp);
                deletedEmp = emp;
                break;
            }
        }
        return deletedEmp;
    }

    @PostMapping
    public Employee create(@RequestBody Employee user) {
        employees.add(user);
        System.out.println(employees);
        return user;
    }
    @PostMapping(path = { "/login/username/{username}/password/{password}" })
    public String login(@PathVariable("username") String username, @PathVariable("password") String password) {
        usuarioService.adicionaUsuario(username, password);
        return "Usuário adicionado com sucesso!";
    }

    private static List<Employee> createList() {
        List<Employee> tempEmployees = new ArrayList<>();
        Employee emp1 = new Employee();
        emp1.setName("emp1");
        emp1.setDesignation("manager");
        emp1.setEmpId("1");
        emp1.setSalary(3000);

        Employee emp2 = new Employee();
        emp2.setName("emp2");
        emp2.setDesignation("developer");
        emp2.setEmpId("2");
        emp2.setSalary(3000);
        tempEmployees.add(emp1);
        tempEmployees.add(emp2);
        return tempEmployees;
    }
}