package com.learningspring.intro.model.entities.enums.converter;

import com.learningspring.intro.model.entities.enums.OrderStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class OrderStatusConverter implements AttributeConverter<OrderStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(OrderStatus orderStatus) {
        if(orderStatus == null) {
            return null;
        }
        return orderStatus.getCode();
    }

    @Override
    public OrderStatus convertToEntityAttribute(Integer code) {
        if(code == null) {
            return null;
        }

        return Stream.of(OrderStatus.values())
                .filter(orderStatus -> orderStatus.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

    }
}
