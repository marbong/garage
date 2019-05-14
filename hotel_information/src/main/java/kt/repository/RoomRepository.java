package kt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kt.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Room findByNumber(int number);
}
