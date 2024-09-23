package J8;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.maxBy;

public class EmployeeDriverProgram {

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

        //TODO how many male and female?
        Map<String,Long> map = employeeList
                .stream()
                .map(Employee::getGender)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        map.entrySet().stream().forEach(System.out::println);

        Map<String, Long> noOfMaleAndFemaleEmployees=
                employeeList
                        .stream()
                        .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

        System.out.println(noOfMaleAndFemaleEmployees);

        //TODO Print the name of all departments in the organization?
        employeeList.stream()
                .map(Employee::getDepartment)
                .distinct()
                .collect(Collectors.toList())
                .stream().forEach(System.out::println);

        //TODO What is the average age of male and female employees?
        Map<String,Double> avgAgeMap = employeeList
                .stream()
                .collect(Collectors
                        .groupingBy(Employee::getGender,Collectors.averagingInt(Employee::getAge)));

        avgAgeMap.entrySet().stream().forEach(System.out::println);

        //TODO Get the details of highest paid employee in the organization?
        Optional<Employee> highestPaidEmployee = employeeList
                .stream()
                .collect(maxBy(Comparator.comparingDouble(Employee::getSalary)));
        System.out.println("Employee info ------> \n"+highestPaidEmployee.get());

        //TODO Get the names of all employees who have joined after 2015?
        employeeList.stream().filter(employee -> employee.getYearOfJoining() > 2015).map(Employee::getName).forEach(System.out::println);

        //TODO  Count the number of employees in each department?
        employeeList.stream().collect(Collectors.groupingBy(
                Employee::getDepartment,Collectors.counting()))
                .entrySet()
                .stream()
                .forEach(System.out::println);

        //TODO What is the average salary of each department?
        employeeList.stream().collect(Collectors.groupingBy(
                Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary))).entrySet().stream().forEach(System.out::println);

        //TODO Get the details of youngest male employee in the product development department?
        Employee emp = employeeList.stream().filter(employee -> employee.getGender().toLowerCase().equals("male") &&
                        employee.getDepartment().toLowerCase().contains("development"))
                .collect(Collectors.minBy(Comparator.comparing(Employee::getAge))).get();

        System.out.println(emp);

        Optional<Employee> youngestMaleEmployeeInProductDevelopmentWrapper=
                employeeList.stream()
                        .filter(e -> e.getGender()=="Male" && e.getDepartment()=="Product Development")
                        .min(comparingInt(Employee::getAge));

        Employee youngestMaleEmployeeInProductDevelopment = youngestMaleEmployeeInProductDevelopmentWrapper.get();

        System.out.println(youngestMaleEmployeeInProductDevelopment);

        //TODO Who has the most working experience in the organization?
        Employee employee = employeeList.stream().sorted(comparingInt(Employee::getYearOfJoining)).findFirst().get();
        System.out.println("Oldest employee : "+employee);

        //TODO  How many male and female employees are there in the sales and marketing team?
        Map<String, Long> mp = employeeList.stream().filter(empl -> empl.getDepartment().toLowerCase().contains("sales") || empl.getDepartment().toLowerCase().contains("marketing"))
                .collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));

        mp.entrySet().stream().forEach(System.out::println);

        //TODO What is the average salary of male and female employees?
        employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getSalary)))
                .entrySet().stream().forEach(System.out::println);

        //TODO List down the names of all employees in each department?
        Map<String,List<Employee>> mapList = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));

        for (Map.Entry<String, List<Employee>> entry : mapList.entrySet()){
            System.out.println("--------------------------------------");

            System.out.println("Employees In "+entry.getKey() + " : ");

            System.out.println("--------------------------------------");

            List<Employee> list = entry.getValue();

            for (Employee e : list){
                System.out.println(e.getName());
            }
        }

        //TODO What is the average salary and total salary of the whole organization?
        DoubleSummaryStatistics doubleSummaryStatistics = employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("Salary sum : "+doubleSummaryStatistics.getSum());
        System.out.println("Salary avg : "+doubleSummaryStatistics.getAverage());

        //TODO Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
        Map<Boolean, List<Employee>> partitionEmployeesByAge = employeeList.stream().collect(Collectors.partitioningBy(employee1 -> employee1.getAge() > 25));

        for (Map.Entry<Boolean, List<Employee>> entry : partitionEmployeesByAge.entrySet()){
            System.out.println("----------------------------");

            if (entry.getKey()){
                System.out.println("Employees older than 25 years :");
            }else{
                System.out.println("Employees younger than or equal to 25 years :");
            }

            System.out.println("----------------------------");

            List<Employee> list = entry.getValue();

            for (Employee e : list){
                System.out.println(e.getName());
            }
        }
        
        //TODO Who is the oldest employee in the organization? What is his age and which department he belongs to?
        Employee em = employeeList.stream().sorted(comparingInt(Employee::getAge).reversed()).findFirst().get();

        //Optional<Employee> oldestEmployeeWrapper = employeeList.stream().max(Comparator.comparingInt(Employee::getAge));

        System.out.println("-------------- Oldest Employee --------------");

        System.out.println("Name : "+em.getName());
        System.out.println("Age : "+em.getAge());
        System.out.println("Department : "+em.getDepartment());

        //TODO Top salaried employee per department
        Map<String, Employee> topEmployees =
                employeeList.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                collectingAndThen(maxBy(
                                        comparingInt(e -> (int) e.getSalary())), Optional::get)
                        ));

        Map<String, Employee> topSalariedEmployeesPerDept =
                employeeList.stream()
                        .collect(Collectors.toMap(
                                e -> e.department,
                                e -> e,
                                BinaryOperator.maxBy(
                                        Comparator.comparingInt(e -> (int) e.salary))
                        ));

        Map<String, Optional<Employee>> topSalariedEmployeesPerDept_2 =
                employeeList.stream().collect(
                        Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.reducing(BinaryOperator.maxBy(
                                        Comparator.comparingInt(e -> (int) e.salary)))
                        )
                );

        System.out.println("---------- Top Emp per department -------------");
        topEmployees.entrySet().stream().forEach(System.out::println);
    }
}
