package kt.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
    private LocalDateTime orderDate;
    
    @Column(nullable = false)
    private int price;

    @Builder
    public FoodServiceMenu(String name, LocalDateTime orderDate, int price) {
        this.name = name;
        this.orderDate = orderDate;
        this.price = price;
    }
	
}