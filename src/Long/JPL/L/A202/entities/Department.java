package JPL.L.A202.entities;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Department {
    private Map<String, Employee> employees;
    private String departmentName;

    public Department() {
    }

    public Department(String departmentName) {
        this.departmentName = departmentName;
        employees=new HashMap<>();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(departmentName);
        return sb.toString();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
