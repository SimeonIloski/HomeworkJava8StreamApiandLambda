import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeesExample {


    public static void main(String []args)
    {

        List<Employee> employeeList = GenerateEmployees.generateEmployees(30);

        //filter the employees that have salary> 900 euros and live in Skopje
        //show them grouped by their working position

        Map<String,List<Employee>> map=employeeList.stream()
            .filter(employee -> employee.getCity().equals("Skopje") && employee.getSalary()>900)
            .collect(Collectors.groupingBy(employee -> employee.getWorkingPosition(),Collectors.toList()));

        System.out.println(map.entrySet()
            .stream()
            .map(entry->entry.getKey()+" - "+entry.getValue().toString())
            .collect(Collectors.joining("\n","","\n")));

        //Homework exercise number 1
        Map<String,List<Employee>> map1=employeeList.stream().filter(employee -> employee.getCity().equals("Bitola") && employee.getSalary()>800).
                collect(Collectors.groupingBy(employee -> employee.getWorkingPosition(),Collectors.toList()));

        System.out.println("Number of emloyees from Bitola with salary>800 :"+map1.size());
        System.out.println(map1.entrySet()
                .stream()
                .map(entry->entry.getKey()+" - "+entry.getValue().toString())
                .collect(Collectors.joining("\n","","\n")));




        //Homework exercise 2
        int sum= employeeList.stream().filter(employee -> employee.getCity().equals("Skopje")).mapToInt(Employee::getSalary).sum();
        Map<String,List<Employee>> map2=employeeList.stream().filter(employee -> employee.getCity().equals("Skopje")).
                collect(Collectors.groupingBy(employee -> employee.getWorkingPosition(),Collectors.toList()));
        System.out.println(map2.entrySet()
                .stream()
                .map(entry->entry.getKey()+" - "+entry.getValue().toString())
                .collect(Collectors.joining("\n","","\n")));


        System.out.println("Sum of salaries of all employees in Skopje :"+sum);


        //Homework excercise 3 solition1 sorted per position

        Map<String,List<Employee>> map3=employeeList.stream().sorted(Comparator.comparing(employee -> employee.getSalary())).
                collect(Collectors.groupingBy(employee->employee.getWorkingPosition(),Collectors.toList()));

        System.out.println("Sorted list of all employees grouped by position :");
        System.out.println(map3.entrySet()
                .stream()
                .map(entry->entry.getKey()+" - "+entry.getValue().toString())
                .collect(Collectors.joining("\n","","\n")));

        // Homework 3 excercise solution2 all employees list
        System.out.println("Sorted list of all employees  :");
     employeeList.sort(Comparator.comparing(employee -> employee.getSalary()));
   employeeList.forEach(System.out::println);

   //homework exercise 4
      System.out.println("Employee/Employees with max salary :");
     Optional<Employee> maxSalaryEmployee=(employeeList.stream().max(Comparator.comparing(Employee::getSalary)));
      Employee employee=new Employee(maxSalaryEmployee.get().getName(),maxSalaryEmployee.get().getCity(),maxSalaryEmployee.get().getSalary(),maxSalaryEmployee.get().getWorkingPosition());
      System.out.println(employee.toString());
    }
}

