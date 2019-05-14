package kt.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kt.model.AmenityItem;
import kt.repository.AmenityItemRepository;

@RestController
@RequestMapping(value = "/amenity")
public class AmainityItemController {
	
	@Autowired
	AmenityItemRepository amenityItemRepository;
	
	
	/**
	 * item_no 에 해당하는 amenity item을 반환한다. 
	 * @param item_no
	 * @return
	 */
	@GetMapping("/amenityItem/{item_no}")
	public AmenityItem amenityItem(@PathVariable Long item_no){
		Optional<AmenityItem> amenityitem = amenityItemRepository.findById(item_no);
		return amenityitem.get();
	}
	
	/**
	 * 신규 amenity Item 을 추가한다. 
	 * @return	추가된 amenity Item 정보
	 */
	@PostMapping("/amenityItem")
	public AmenityItem saveAmenityItem(@RequestBody AmenityItem amenityItem) {
		//AmenityItem amenityItem = AmenityItem.builder().name("").available_count(3).build();
		amenityItemRepository.save(amenityItem);
		return amenityItem;
	}
	
	/**
	 * item_no 에 해당하는 amenity 정보를 수정한다. 
	 * @param item_no
	 * @param amenityItem
	 * @return
	 */
	@PutMapping("/amenityItem/{item_no}")
	public AmenityItem sendAmenityRequest(@PathVariable Long item_no, @RequestBody AmenityItem amenityItem) {
		amenityItem.setId(item_no);

		amenityItemRepository.save(amenityItem);
		//amenityMessageSenderService.send(amenityItem.toString());
		return amenityItem;
	}
	
	/**
	 * item_no 에 해당하는 amenity 정보를 삭제한다. 
	 * @param item_no
	 */
	@DeleteMapping("/amenityItem/{item_no}")
	public void delAmenityRequest(@PathVariable Long item_no) {
		amenityItemRepository.deleteById(item_no);
	}

}
