package kt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kt.model.FoodOrder;

public interface FoodOrderRepository extends JpaRepository<FoodOrder, Long> {

}
