package association;

public class Employee {
    String name;
    String ID;
    EmployeeAddress eaddress; // aggregation

    public Employee(String name, String ID) {
        this.name = name;
        this.ID = ID;
        eaddress = new EmployeeAddress("polashi","dhaka",5200); // association
    }

    void showEmployee(){
        System.out.println("Employee name : "+ name+" " + "iD: "+ ID);
        System.out.println(eaddress.street + " "+ eaddress.city + " " + eaddress.pincode);
    }

    public static void main(String[] args) {
        Employee employee = new Employee("shuvo" ,"Bsse1431");
        employee.showEmployee();
    }
}
