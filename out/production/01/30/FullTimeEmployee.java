class FullTimeEmployee extends Employee {
    private double performanceBonus;
    public FullTimeEmployee(String id, String name, double baseSalary, double performanceBonus) {
        super(id, name, baseSalary);
        this.performanceBonus = performanceBonus;
    }
    @Override
    public double calculateSalary() {
        return baseSalary + performanceBonus;
    }
    @Override
    public String getEmployeeInfo() {
        return super.getEmployeeInfo() + String.format(" [全职员工, 绩效奖金: %.2f]", performanceBonus);
    }
}
