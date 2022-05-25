package com.learningspring.intro.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learningspring.intro.model.entities.pk.OrderItemPK;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "TB_ORDER_ITEM")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
public class OrderItem implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();

    @NonNull
    private Integer quantity;

    @NonNull
    private Double price;

    public OrderItem(Order order, Product product, @NonNull Integer quantity, @NonNull Double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    @JsonIgnore
    public Order getOrder() {
        return id.getOrder();
    }

    public void setOrder(Order order) {
        id.setOrder(order);
    }

    public Product getProduct() {
        return id.getProduct();
    }

    public void setProduct(Product product) {
        id.setProduct(product);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OrderItem other = (OrderItem) obj;
        if (id == null) {
            return other.id == null;
        } else return id.equals(other.id);
    }
}
