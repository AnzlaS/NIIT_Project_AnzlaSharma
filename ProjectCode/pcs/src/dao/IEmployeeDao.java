package dao;
import java.util.List;
import model.Employee;

public interface IEmployeeDao {
void addEmployee(Employee emp);
List<Employee> getAllEmployees();
Employee getEmployeeById(int id);
Employee getEmployeeByUserId(String userId);
void updateEmployee(Employee emp);
void deactivateEmployee(int id);

}
