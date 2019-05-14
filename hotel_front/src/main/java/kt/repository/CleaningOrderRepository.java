package kt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kt.entity.CleaningOrder;

public interface CleaningOrderRepository extends JpaRepository<CleaningOrder, Long> {

}
