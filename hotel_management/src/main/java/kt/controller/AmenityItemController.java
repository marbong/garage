package kt.controller;

import java.util.List;

import kt.service.AmenityItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import kt.entity.AmenityItem;

@RestController
@RequestMapping(value = "/amenity")
public class AmenityItemController {
    @Autowired
    AmenityItemService amenityItemService;

    /**
     * item_name 에 해당하는 amenity item 을 반환한다.
     * @param item_name amenity item 이름
     * @return amenity item 정보
     */
    @GetMapping("/amenityItem/{item_name}")
    public AmenityItem get(@PathVariable String item_name){
        return amenityItemService.getAmenityItem(item_name);
    }

    /**
     * amenity item list 를 반환한다.
     * @return amenity item list
     */
    @CrossOrigin(origins = "http://169.56.70.69:31110")
    @GetMapping("/list")
    public List<AmenityItem> getList(){
        return amenityItemService.getAmenityItemList();
    }

    /**
     * 신규 amenity item 을 추가한다.
     * @return	추가된 amenity Item 정보
     */
    @CrossOrigin(origins = "http://169.56.70.69:31110")
    @RequestMapping("/amenityItem")
    public String save(@RequestBody AmenityItem amenityItem) {
        return amenityItemService.saveAmenityItem(amenityItem);
    }

    /**
     * item_name 에 해당하는 amenity 정보를 수정한다.
     * @param item_name amenity 이름
     * @param amenityItem 수정할 amenity item 정보
     * @return 수정된 amenity item 정보
     */
    @PutMapping("/amenityItem/{item_name}")
    public AmenityItem update(@PathVariable String item_name, @RequestBody AmenityItem amenityItem) {
        return amenityItemService.updateAmenityItem(item_name, amenityItem);
    }

    /**
     * item_name 에 해당하는 amenity 정보를 삭제한다.
     * @param amenityItem amenity item 정보
     */
    @CrossOrigin(origins = "http://169.56.70.69:31110")
    @RequestMapping("/amenityItem/delete")
    public void delete(@RequestBody AmenityItem amenityItem) {
        amenityItemService.deleteAmenityItem(amenityItem.getName());
    }

    @GetMapping("/init")
    public Integer init() {
        return amenityItemService.initAmenityItem();
    }
}