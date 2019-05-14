package kt.controller;

import kt.entity.Room;
import kt.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/room")
public class RoomController {
    @Autowired
    RoomService roomService;

    /**
     * room_no 에 해당하는 room 을 반환한다.
     * @param room_no room_no 이름
     * @return room 정보
     */
    @GetMapping("/{room_no}")
    public Room get(@PathVariable int room_no){
        return roomService.getRoom(room_no);
    }

    /**
     * room list 를 반환한다.
     * @return room list
     */
    @CrossOrigin(origins = "http://169.56.70.69:31110")
    @GetMapping("/list")
    public List<Room> getList(){
        return roomService.getRoomList();
    }

    /**
     * 신규 room 을 추가한다.
     * @return	추가된 room 정보
     */
    @CrossOrigin(origins = "http://169.56.70.69:31110")
    @RequestMapping("/save")
    public String save(@RequestBody Room room) {
        return roomService.saveRoom(room);
    }

    /**
     * room_no 에 해당하는 room 정보를 수정한다.
     * @param room_no room 번호
     * @param room 수정할 room 정보
     * @return 수정된 room 정보
     */
    @PutMapping("/update/{room_no}")
    public Room updateRoom(@PathVariable int room_no, @RequestBody Room room) {
        return roomService.updateRoom(room_no, room);
    }

    /**
     * room_no 에 해당하는 room 정보를 삭제한다.
     * @param room room 정보
     */
    @CrossOrigin(origins = "http://169.56.70.69:31110")
    @RequestMapping("/delete")
    public void delete(@RequestBody Room room) {
        roomService.deleteRoom(room);
    }

    @GetMapping("/init")
    public Integer init() {
        return roomService.initRoom();
    }
}
