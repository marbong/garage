package kt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

@Builder(toBuilder=true)
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter @ToString
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Component
public class AmenityItem {
    @Id
    @GeneratedValue
    private Long id;

    @Column(columnDefinition = "TEXT", length = 500, nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    @ColumnDefault("0")
    private int available_count;
}