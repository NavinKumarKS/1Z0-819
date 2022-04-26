package navin.navinkumar.Z0819;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    Map<Integer,Employee> db = new HashMap<>(){{
        put(1, new Employee(1,"Navin"));
        put(2, new Employee(2,"Kumar"));
    }};

    public Collection<Employee> fetchAllEmployee(){
        return  db.values();
    }

    public Employee getEmployee(Integer id) {
       return db.get(id);
    }
}
