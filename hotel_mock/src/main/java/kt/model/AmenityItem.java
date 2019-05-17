package kt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter @ToString
@Entity
public class AmenityItem {
    @Id
    @GeneratedValue
    private Long id;

    @Column(columnDefinition = "TEXT", length = 500, nullable = true)
    private String name;

    @Column(nullable = false)
    @ColumnDefault("0")
    private int available_count;

    @Builder
    public AmenityItem(String name, int available_count) {
        this.name = name;
        this.available_count = available_count;
    }

	public void setId(Long item_no) {
		// TODO Auto-generated method stub
		this.id = item_no;
	}
	
}