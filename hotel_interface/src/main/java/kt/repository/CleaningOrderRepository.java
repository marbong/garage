package kt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kt.model.CleaningOrder;

public interface CleaningOrderRepository extends JpaRepository<CleaningOrder, Long> {

}
