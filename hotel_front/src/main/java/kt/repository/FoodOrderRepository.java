package kt.repository;

import kt.entity.FoodServiceMenu;
import kt.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import kt.entity.FoodOrder;

import java.util.Optional;

public interface FoodOrderRepository extends JpaRepository<FoodOrder, Long> {
    Optional<FoodOrder> findByFoodServiceMenu(FoodServiceMenu foodServiceMenu);
    Optional<FoodOrder> findByRoom(Room room);
    FoodOrder findByRoomAndFoodServiceMenu(Room room, FoodServiceMenu foodServiceMenu);
}
