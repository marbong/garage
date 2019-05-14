package kt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kt.entity.AmenityItem;

public interface AmenityItemRepository extends JpaRepository<AmenityItem, Long> {
    AmenityItem findByName(String name);
}
