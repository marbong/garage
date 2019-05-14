package kt.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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

    @Column(nullable = false)
    private LocalDateTime req_time;

    @Column(nullable = false)
    private LocalDateTime complete_time;

    @Column(nullable = false)
    private String status;

    @Builder
    public FoodOrder(FoodServiceMenu foodServiceMenu, Room room, int count, LocalDateTime req_time, LocalDateTime complete_time, String status) {
    	this.foodServiceMenu = foodServiceMenu;
    	this.room = room;
    	this.count = count;
    	this.req_time = req_time;
    	this.complete_time = complete_time;
    	this.status = status;
    }
	
}