package mid_term_quiz;

import java.util.ArrayList;
import java.util.List;

public class Problem4 {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("홍길동", 150));
        customers.add(new Customer("우수한", 350));
        customers.add(new Customer("부족한", 50));
        customers.add(new Customer("훌륭한", 450));
        customers.add(new Customer("최고의", 550));
        AbstractReportGenerator simpleGenerator = new SimpleReportGenerator();
        System.out.println(simpleGenerator.generate(customers));
        AbstractReportGenerator complexGenerator = new ComplexReportGenerator();
        System.out.println(complexGenerator.generate(customers));
    }
}
class Customer {
    private final String name;
    private int point;
    public Customer(String name, int point) {
        this.name = name;
        this.point = point;
    }
    public final int getPoint() { return point;}
    public final String getName() { return name; }
}
abstract class AbstractReportGenerator {
    public final String generate(List<Customer> customers) {
        List<Customer> selectedCustomers = select(customers);
        String report = getReportHeader(selectedCustomers);
        for (final Customer customer : selectedCustomers)
            report += getReportForCustomer(customer);
        report += getReportFooter(selectedCustomers);
        return report;
    }
    protected List<Customer> select(List<Customer> customers) {
        List<Customer> selected = new ArrayList<>();
        for (final Customer customer : customers)
            if (customerReportCondition(customer))
                selected.add(customer);
        return selected;
    }
    protected abstract boolean customerReportCondition(Customer customer);
    protected abstract String getReportHeader(List<Customer> customers);
    protected abstract String getReportForCustomer(Customer customer);
    protected abstract String getReportFooter(List<Customer> customers);
}