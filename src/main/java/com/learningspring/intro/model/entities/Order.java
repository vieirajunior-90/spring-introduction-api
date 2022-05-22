package com.learningspring.intro.model.entities;

import lombok.*;
import org.joda.time.Instant;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_order")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Transient
    @Column(name = "date_created", nullable = false)
    private Instant moment;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private User client;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id.equals(order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
