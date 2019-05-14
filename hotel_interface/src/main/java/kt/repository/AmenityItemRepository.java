package kt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kt.model.AmenityItem;

public interface AmenityItemRepository extends JpaRepository<AmenityItem, Long> {

}
