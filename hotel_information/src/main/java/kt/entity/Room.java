package kt.entity;

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
public class Room {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private int number;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String status;
}