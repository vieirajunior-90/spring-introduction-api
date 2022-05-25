package com.learningspring.intro.model.entities.pk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learningspring.intro.model.entities.Order;
import com.learningspring.intro.model.entities.Product;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serial;
import java.io.Serializable;

@Data
@Embeddable
public class OrderItemPK implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;
}
