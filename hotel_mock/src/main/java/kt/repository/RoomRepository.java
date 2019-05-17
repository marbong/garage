package kt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kt.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {

}
