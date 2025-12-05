class SalesEmployee extends Employee {
    private double salesAmount;
    public SalesEmployee(String id, String name, double baseSalary, double salesAmount) {
        super(id, name, baseSalary);
        this.salesAmount = salesAmount;
    }
    @Override
    public double calculateSalary() {
        return baseSalary + salesAmount * 0.05;
    }
    @Override
    public String getEmployeeInfo() {
        return super.getEmployeeInfo() + String.format(" [销售员, 销售额: %.2f, 提成: %.2f]",
                salesAmount, salesAmount * 0.05);
    }
}