package kt.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.*;

@Builder(toBuilder=true)
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter @ToString
@Entity
public class FoodServiceMenu {
    @Id
    @GeneratedValue
    private Long id;

    @Column(columnDefinition = "TEXT",  nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;
}