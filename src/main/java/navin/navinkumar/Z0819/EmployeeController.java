package navin.navinkumar.Z0819;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/fetchall")
    public Collection<Employee> fetchAllEmployee() {
        return employeeService.fetchAllEmployee();
    }

    @RequestMapping("/wish")
    public String getWish() {
        return "Hello World";
    }

    @RequestMapping("/fetch/{id}")
    public  Employee getEmployee(@PathVariable Integer id){
        return  employeeService.getEmployee(id);
    }
}
