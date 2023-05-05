package business.entities;

import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.Set;

public class Order {

    private Integer id = null;
    private Calendar date = null;
    private Customer customer = null;
    private Set<OrderLine> orderLines = new LinkedHashSet<>();

    public Order() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(final Calendar date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(final Customer customer) {
        this.customer = customer;
    }

    public Set<OrderLine> getOrderLines() {
        return orderLines;
    }
}
