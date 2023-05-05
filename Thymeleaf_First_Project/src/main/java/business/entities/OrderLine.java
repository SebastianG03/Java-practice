package business.entities;

import java.math.BigDecimal;

public class OrderLine {

    private Product product = null;
    private Integer amount = null;
    private BigDecimal purchasePrice = null;

    public OrderLine() {
        super();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(final Product product) {
        this.product = product;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(final Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(final BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
}
