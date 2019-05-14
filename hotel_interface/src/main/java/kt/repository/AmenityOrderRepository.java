package kt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kt.model.AmenityOrder;

public interface AmenityOrderRepository extends JpaRepository<AmenityOrder, Long> {

}
