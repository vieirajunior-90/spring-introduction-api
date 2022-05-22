package com.learningspring.intro.model.entities.enums;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum OrderStatus {

    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    @NonNull
    private Integer code;


}
