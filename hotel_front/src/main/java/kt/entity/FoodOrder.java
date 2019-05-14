package kt.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

@Builder(toBuilder=true)
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter @ToString
@Entity
public class FoodOrder {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
	@JoinColumn(name ="foodServiceMenu_id")
	private FoodServiceMenu foodServiceMenu;

    @ManyToOne
	@JoinColumn(name ="room_id")
	private Room room;
    
    @Column(nullable = false)
    private int count;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime req_time;

    @Column(nullable = false)
    private LocalDateTime complete_time;

    @Column(nullable = false)
    private String status;
}