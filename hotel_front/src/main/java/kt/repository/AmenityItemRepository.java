package kt.repository;

import kt.entity.AmenityItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmenityItemRepository extends JpaRepository<AmenityItem, Long> {
    AmenityItem findByName(String name);
}
