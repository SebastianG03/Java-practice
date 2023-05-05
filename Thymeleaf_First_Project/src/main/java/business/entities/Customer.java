package business.entities;

import java.util.Calendar;

public class Customer {

    private Integer id = null;
    private String name = null;
    private Calendar customerSince = null;

    public Customer() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Calendar getCustomerSince() {
        return customerSince;
    }

    public void setCustomerSince(final Calendar customerSince) {
        this.customerSince = customerSince;
    }
}
