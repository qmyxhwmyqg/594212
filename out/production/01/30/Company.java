import java.util.*;
import java.util.stream.Collectors;

class Company {
    private List<Employee> employees;
    private String companyName;
    public Company(String companyName) {
        this.companyName = companyName;
        this.employees = new ArrayList<>();
    }
    public boolean addEmployee(Employee employee) {
        if (!employees.contains(employee)) {
            employees.add(employee);
            System.out.println("添加员工成功: " + employee.getName());
            return true;
        }
        System.out.println("员工已存在: " + employee.getName());
        return false;
    }
    public boolean removeEmployee(String employeeId) {
        return employees.removeIf(emp -> emp.getId().equals(employeeId));
    }
    public double calculateTotalSalary() {
        double total = 0;
        for (Employee emp : employees) {
            total += emp.calculateSalary();  // 多态调用
        }
        return total;
    }
    public void displayEmployeesSortedBySalary() {
        System.out.println("\n=== 按工资排序的员工列表（从低到高） ===");
        List<Employee> sortedList = new ArrayList<>(employees);
        Collections.sort(sortedList, Comparator.comparingDouble(Employee::calculateSalary));
        sortedList.forEach(emp -> System.out.println(emp.getEmployeeInfo()));
    }
    public Optional<Employee> findHighestPaidEmployee() {
        return employees.stream()
                .max(Comparator.comparingDouble(Employee::calculateSalary));
    }
    public Optional<Employee> findLowestPaidEmployee() {
        return employees.stream()
                .min(Comparator.comparingDouble(Employee::calculateSalary));
    }
    public void displaySalaryStatistics() {
        System.out.println("\n=== 工资统计信息 ===");
        DoubleSummaryStatistics stats = employees.stream()
                .mapToDouble(Employee::calculateSalary)
                .summaryStatistics();
        System.out.printf("员工总数: %d%n", stats.getCount());
        System.out.printf("总工资支出: %.2f%n", stats.getSum());
        System.out.printf("平均工资: %.2f%n", stats.getAverage());
        System.out.printf("最低工资: %.2f%n", stats.getMin());
        System.out.printf("最高工资: %.2f%n", stats.getMax());
    }
    public void displayEmployeesByType() {
        System.out.println("\n=== 按员工类型分组 ===");
        Map<String, List<Employee>> groupedByType = employees.stream()
                .collect(Collectors.groupingBy(emp -> {
                    if (emp instanceof FullTimeEmployee) return "全职员工";
                    if (emp instanceof PartTimeEmployee) return "兼职员工";
                    if (emp instanceof SalesEmployee) return "销售员";
                    return "其他";
                }));
        groupedByType.forEach((type, empList) -> {
            System.out.printf("%s (%d人):%n", type, empList.size());
            empList.forEach(emp ->
                    System.out.println("  - " + emp.getName() + ": " + emp.calculateSalary()));
        });
    }
    public void displayAllEmployees() {
        System.out.println("\n=== " + companyName + " 所有员工信息 ===");
        employees.forEach(emp -> System.out.println(emp.getEmployeeInfo()));
    }
    public static void main(String[] args) {
        Company company = new Company("ABC科技有限公司");
        Employee fullTime1 = new FullTimeEmployee("E001", "张三", 8000, 2000);
        Employee fullTime2 = new FullTimeEmployee("E002", "李四", 10000, 3000);
        Employee partTime1 = new PartTimeEmployee("E003", "王五", 50, 120);
        Employee partTime2 = new PartTimeEmployee("E004", "赵六", 60, 80);
        Employee sales1 = new SalesEmployee("E005", "钱七", 5000, 100000);
        Employee sales2 = new SalesEmployee("E006", "孙八", 6000, 150000);
        company.addEmployee(fullTime1);
        company.addEmployee(fullTime2);
        company.addEmployee(partTime1);
        company.addEmployee(partTime2);
        company.addEmployee(sales1);
        company.addEmployee(sales2);
        company.displayAllEmployees();
        company.displayEmployeesSortedBySalary();
        company.displaySalaryStatistics();
        company.displayEmployeesByType();
        System.out.println("\n=== 工资极值员工 ===");
        company.findHighestPaidEmployee().ifPresent(emp ->
                System.out.println("工资最高的员工: " + emp.getEmployeeInfo()));
        company.findLowestPaidEmployee().ifPresent(emp ->
                System.out.println("工资最低的员工: " + emp.getEmployeeInfo()));
        System.out.printf("%n公司总工资支出: %.2f%n", company.calculateTotalSalary());
        System.out.println("\n=== 测试删除员工 ===");
        company.removeEmployee("E003");
        System.out.println("删除王五后:");
        company.displayAllEmployees();
        System.out.println("\n=== 测试equals和hashCode ===");
        Employee testEmp1 = new FullTimeEmployee("E001", "张三", 8000, 2000);
        Employee testEmp2 = new FullTimeEmployee("E001", "张三三", 9000, 3000);
        System.out.println("两个相同ID的员工是否相等: " + testEmp1.equals(testEmp2));
        System.out.println("testEmp1的hashCode: " + testEmp1.hashCode());
        System.out.println("testEmp2的hashCode: " + testEmp2.hashCode());
    }
}