class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private double hoursWorked;
    public PartTimeEmployee(String id, String name, double hourlyRate, double hoursWorked) {
        super(id, name, 0);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }
    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
    @Override
    public String getEmployeeInfo() {
        return String.format("ID: %s, 姓名: %s, 时薪: %.2f, 工作时长: %.1f小时, 实际工资: %.2f [兼职员工]",
                id, name, hourlyRate, hoursWorked, calculateSalary());
    }
}