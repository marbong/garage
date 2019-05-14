package kt.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.stereotype.Component;

@Builder(toBuilder=true)
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter @ToString
@Entity
@Component
public class AmenityOrder {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
	@JoinColumn(name ="amenityItem_id")
	private AmenityItem amenityItem;

    @ManyToOne
	@JoinColumn(name ="room_id")
	private Room room;
    
    @Column(nullable = false)
    private int count;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime req_time;

    private LocalDateTime complete_time;

    @Column(nullable = false)
    private String status;
}