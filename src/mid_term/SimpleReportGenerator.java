import java.util.ArrayList;
import java.util.List;

public class SimpleReportGenerator extends AbstractReportGenerator {
    @Override
    public boolean customerReportCondition(Customer customer) {
        return true;
    }

    @Override
    public String getReportHeader(List<Customer> customers) {
        return "고객의 수: " + customers.size() + " 명\n";
    }

    @Override
    public String getReportForCustomer(Customer customer) {
        return String.format("%s: %d\n", customer.getName(), customer.getPoint());
    }

    @Override
    public String getReportFooter(List<Customer> customers) {
        return "";
    }
}

class ComplexReportGenerator extends AbstractReportGenerator {
    @Override
    public boolean customerReportCondition(Customer customer) {
        return customer.getPoint() >= 100;
    }

    @Override
    public String getReportHeader(List<Customer> customers) {
        return "고객의 수: " + customers.size() + " 명입니다\n";
    }

    @Override
    public String getReportForCustomer(Customer customer) {
        return String.format("%d: %s\n", customer.getPoint(), customer.getName());
    }

    @Override
    public String getReportFooter(List<Customer> customers) {
        int total = customers.stream().mapToInt(Customer::getPoint).sum();
        return String.format("점수 합계: %d\n", total);
    }
}