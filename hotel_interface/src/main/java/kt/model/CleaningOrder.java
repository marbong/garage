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
public class CleaningOrder {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
	@JoinColumn(name ="room_id")
	private Room room;
    
    @Column(nullable = false)
    private LocalDateTime req_time;

    @Builder
    public CleaningOrder(Room room, LocalDateTime req_time) {
    	this.room = room;
    	this.req_time = req_time;
    }
	
}