package kt.service;

import kt.entity.Room;
import kt.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {
    @Autowired
    RoomRepository roomRepository;

    public Room getRoom(int roomNo){
        return roomRepository.findByNumber(roomNo);
    }

    public List<Room> getRoomList(){
        return roomRepository.findAll();
    }

    public String saveRoom(Room room){
        if(roomRepository.findByNumber(room.getNumber()) == null){
            return  roomRepository.save(room).toString();
        } else {
            return updateRoom(room.getNumber(), room).toString();
        }

    }

    public Room updateRoom(int roomNo, Room room) {
        room.setId(roomRepository.findByNumber(roomNo).getId());
        return roomRepository.save(room);
    }

    public void deleteRoom(Room room) {
        roomRepository.delete(room);
    }

    public int initRoom() {
        List<Room> amenityItems = new ArrayList<Room>() {{
            add(Room.builder().number(401).type("Single").status("available").build());
            add(Room.builder().number(402).type("Double").status("available").build());
            add(Room.builder().number(403).type("Triple").status("available").build());
            add(Room.builder().number(404).type("Twin").status("available").build());
            add(Room.builder().number(405).type("Standard").status("available").build());
            add(Room.builder().number(406).type("Delux").status("available").build());
            add(Room.builder().number(407).type("Superior").status("available").build());
            add(Room.builder().number(408).type("Standard").status("available").build());
            add(Room.builder().number(409).type("Executive").status("available").build());
            add(Room.builder().number(410).type("Club").status("available").build());
        }};
        return roomRepository.saveAll(amenityItems).size();
    }
}
