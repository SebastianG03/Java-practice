package business.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Product {

    private Integer id = null;
    private String name = null;
    private BigDecimal price = null;
    private boolean inStock = false;
    private List<Comment> comments = new ArrayList<>();

    public Product() {
        super();
    }

    public Product(final Integer id, final String name, final boolean inStock, final BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.inStock = inStock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public List<Comment> getComments() {
        return comments;
    }
}
