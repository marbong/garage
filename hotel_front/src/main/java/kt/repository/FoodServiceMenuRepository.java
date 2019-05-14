package kt.repository;

import kt.entity.FoodServiceMenu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodServiceMenuRepository extends JpaRepository<FoodServiceMenu, Long> {
    FoodServiceMenu findByName(String name);
}
