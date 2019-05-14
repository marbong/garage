package kt.controller;

import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonProcessingException;
import kt.service.AmenityOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kt.entity.AmenityOrder;

@RestController
@RequestMapping(value = "/amenityOrder")
public class AmenityOrderController {
	@Autowired
	AmenityOrderService amenityOrderService;

	/**
	 * item_name 에 해당하는 amenity order 리스트를 반환한다.
	 * @param item_name amenity item 이름
	 * @return amenity item 리스트
	 */
	@GetMapping("/list/{item_name}")
	public Optional<AmenityOrder> getListByItemName(@PathVariable String item_name){
		return amenityOrderService.getAmenityOrderListByItemName(item_name);
	}

	/**
	 * room_no 에 해당하는 amenity order 리스트를 반환한다.
	 * @param room_no room 번호
	 * @return amenity item 리스트
	 */
	@GetMapping("/list/{room_no}")
	public Optional<AmenityOrder> getListByRoomNo(@PathVariable int room_no){
		return amenityOrderService.getAmenityOrderListByRoomNo(room_no);
	}

	/**
	 * room_no, item_name 에 해당하는 amenity order 를 반환한다.
	 * @param room_no room 번호
	 * @param item_name amenity item 이름
	 * @return amenity order 정보
	 */
	@GetMapping("/amenityOrderItem/{room_no}/{item_name}")
	public AmenityOrder get(@PathVariable int room_no, @PathVariable String item_name){
		return amenityOrderService.getAmenityOrder(room_no, item_name);
	}

	/**
	 * 신규 amenity order 를 추가한다.
	 * @param amenityOrder amenity order 정보
	 * @return	추가된 amenity item 정보
	 */
	@PostMapping("/amenityOrderItem/{room_no}/{item_name}")
	public AmenityOrder save(@RequestBody AmenityOrder amenityOrder) {
		return amenityOrderService.saveAmenityOrder(amenityOrder);
	}

	/**
	 * room_no, item_name 에 해당하는 amenity order 를 수정한다.
	 * @param room_no room 번호
	 * @param item_name amenity item 이름
	 * @param amenityOrder 수정할 amenity order 정보
	 * @return 수정된 amenity order 정보
	 */
	@PutMapping("/amenityOrderItem/{room_no}/{item_name}")
	public AmenityOrder update(@PathVariable int room_no, @PathVariable String item_name,
										   @RequestBody AmenityOrder amenityOrder) {
		return amenityOrderService.updateAmenityOrder(room_no, item_name, amenityOrder);
	}

	/**
	 * room_no, item_name 에 해당하는 amenity order 를 삭제한다.
	 * @param room_no room 번호
	 * @param item_name amenity item 이름
	 */
	@DeleteMapping("/amenityOrderItem/{room_no}/{item_name}")
	public void delete(@PathVariable int room_no, @PathVariable String item_name) {
		amenityOrderService.deleteAmenityOrder(room_no, item_name);
	}

	@CrossOrigin(origins = "http://169.56.70.69:31110")
	@RequestMapping(value = "/", consumes = "multipart/form-data")
	public String order(@RequestParam Map<String, String> params) throws JsonProcessingException {
		return amenityOrderService.orderAmenity(params);
	}
}