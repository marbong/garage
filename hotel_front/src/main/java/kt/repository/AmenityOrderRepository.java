package kt.repository;

import kt.entity.AmenityItem;
import kt.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import kt.entity.AmenityOrder;

import java.util.Optional;

public interface AmenityOrderRepository extends JpaRepository<AmenityOrder, Long> {
    Optional<AmenityOrder> findByAmenityItem(AmenityItem amenityItem);
    Optional<AmenityOrder> findByRoom(Room room);
    AmenityOrder findByRoomAndAmenityItem(Room room, AmenityItem amenityItem);
}
