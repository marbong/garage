package kt.controller;

import kt.entity.FoodOrder;
import kt.entity.FoodServiceMenu;
import kt.entity.Room;
import kt.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/foodOrder")
public class FoodOrderController {
    @Autowired
    FoodServiceMenuRepository foodServiceMenuRepository;
    @Autowired
    FoodOrderRepository foodOrderRepository;
    @Autowired
    RoomRepository roomRepository;

    /**
     * food_name 에 해당하는 food order 리스트를 반환한다.
     * @param food_name food item 이름
     * @return food item 리스트
     */
    @GetMapping("/list/{food_name}")
    public Optional<FoodOrder> getFoodOrderListByFoodName(@PathVariable String food_name){
        return foodOrderRepository.findByFoodServiceMenu(foodServiceMenuRepository.findByName(food_name));
    }

    /**
     * room_no 에 해당하는 food order 리스트를 반환한다.
     * @param room_no room 번호
     * @return food item 리스트
     */
    @GetMapping("/list/{room_no}")
    public Optional<FoodOrder> getFoodOrderListByRoomNo(@PathVariable int room_no){
        return foodOrderRepository.findByRoom(roomRepository.findByNumber(room_no));
    }

    /**
     * room_no, food_name 에 해당하는 food order 를 반환한다.
     * @param room_no room 번호
     * @param food_name food item 이름
     * @return food item 정보
     */
    @GetMapping("/foodOrderItem/{room_no}/{food_name}")
    public FoodOrder getFoodOrder(@PathVariable int room_no, @PathVariable String food_name){
        Room room = roomRepository.findByNumber(room_no);
        FoodServiceMenu foodServiceMenu = foodServiceMenuRepository.findByName(food_name);
        return foodOrderRepository.findByRoomAndFoodServiceMenu(room, foodServiceMenu);
    }

    /**
     * 신규 food order 를 추가한다.
     * @param foodOrder food order 정보
     * @param room_no room 번호
     * @param food_name food item 이름
     * @return	추가된 food order 정보
     */
    @PostMapping("/foodOrderItem")
    public FoodOrder saveFoodOrder(@PathVariable int room_no, @PathVariable String food_name,
                                   @RequestBody FoodOrder foodOrder) {
        Room room = roomRepository.findByNumber(room_no);
        FoodServiceMenu foodServiceMenu = foodServiceMenuRepository.findByName(food_name);
        foodOrder.setId(foodOrderRepository.findByRoomAndFoodServiceMenu(room, foodServiceMenu).getId());
        return foodOrderRepository.save(foodOrder);
    }

    /**
     * room_no, food_name 에 해당하는 food order 를 수정한다.
     * @param room_no room 번호
     * @param food_name food item 이름
     * @param foodOrder 수정할 food order 정보
     * @return 수정된 food order 정보
     */
    @PutMapping("/foodOrderItem/{room_no}/{food_name}")
    public FoodOrder updateFoodOrder(@PathVariable int room_no, @PathVariable String food_name,
                                           @RequestBody FoodOrder foodOrder) {
        Room room = roomRepository.findByNumber(room_no);
        FoodServiceMenu foodServiceMenu = foodServiceMenuRepository.findByName(food_name);
        foodOrder.setId(foodOrderRepository.findByRoomAndFoodServiceMenu(room, foodServiceMenu).getId());
        return foodOrderRepository.save(foodOrder);
    }

    /**
     * room_no, food_name 에 해당하는 food order 를 삭제한다.
     * @param room_no room 번호
     * @param food_name food item 이름
     */
    @DeleteMapping("/foodOrderItem/{room_no}/{food_name}")
    public void deleteFoodOrder(@PathVariable int room_no, @PathVariable String food_name) {
        Room room = roomRepository.findByNumber(room_no);
        FoodServiceMenu foodServiceMenu = foodServiceMenuRepository.findByName(food_name);
        foodOrderRepository.deleteById(foodOrderRepository.findByRoomAndFoodServiceMenu(room, foodServiceMenu).getId());
    }
}
