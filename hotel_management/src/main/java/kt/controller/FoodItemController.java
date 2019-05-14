package kt.controller;

import kt.entity.FoodServiceMenu;
import kt.repository.FoodServiceMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/food")
public class FoodItemController {
    @Autowired
    FoodServiceMenuRepository foodServiceMenuRepository;

    /**
     * food_name 에 해당하는 food item 을 반환한다.
     * @param food_name food item 이름
     * @return food item 정보
     */
    @GetMapping("/foodItem/{food_name}")
    public FoodServiceMenu getFoodItem(@PathVariable String food_name){
        return foodServiceMenuRepository.findByName(food_name);
    }

    /**
     * food item list 를 반환한다.
     * @return food item list
     */
    @GetMapping("/list")
    public List<FoodServiceMenu> getFoodItemList(){
        return foodServiceMenuRepository.findAll();
    }

    /**
     * 신규 food item 을 추가한다.
     * @return	추가된 food item 정보
     */
    @PostMapping("/foodItem")
    public FoodServiceMenu saveFoodItem(@RequestBody FoodServiceMenu foodItem) {
        return foodServiceMenuRepository.save(foodItem);
    }

    /**
     * food_name 에 해당하는 food 정보를 수정한다.
     * @param food_name food item 이름
     * @param foodItem 수정할 food item 정보
     * @return 수정된 food item 정보
     */
    @PutMapping("/foodItem/{food_name}")
    public FoodServiceMenu updateFoodItem(@PathVariable String food_name, @RequestBody FoodServiceMenu foodItem) {
        foodItem.setId(foodServiceMenuRepository.findByName(food_name).getId());
        return foodServiceMenuRepository.save(foodItem);
    }

    /**
     * food_name 에 해당하는 food 정보를 삭제한다.
     * @param food_name food item 이름
     */
    @DeleteMapping("/foodItem/{food_name}")
    public void deleteFoodItem(@PathVariable String food_name) {
        foodServiceMenuRepository.deleteById(foodServiceMenuRepository.findByName(food_name).getId());
    }

    @GetMapping("/init")
    public Integer initAmenityItem() {
        List<FoodServiceMenu> foodServiceMenus = new ArrayList<FoodServiceMenu>() {{
            add(FoodServiceMenu.builder().name("Fried Chicken").price(21000).build());
            add(FoodServiceMenu.builder().name("Garlic Stake").price(54000).build());
            add(FoodServiceMenu.builder().name("Beer").price(4000).build());
            add(FoodServiceMenu.builder().name("Soju").price(5000).build());
            add(FoodServiceMenu.builder().name("Wine").price(15000).build());
            add(FoodServiceMenu.builder().name("Cup Lamen").price(3000).build());
            add(FoodServiceMenu.builder().name("Kimchi Soup").price(8000).build());
            add(FoodServiceMenu.builder().name("Tomato Pasta").price(15000).build());
            add(FoodServiceMenu.builder().name("Alfredo Pasta").price(16000).build());
            add(FoodServiceMenu.builder().name("Rose Pasta").price(16500).build());
        }};
        return foodServiceMenuRepository.saveAll(foodServiceMenus).size();
    }
}
