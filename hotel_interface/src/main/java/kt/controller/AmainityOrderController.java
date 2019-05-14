package kt.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kt.model.AmenityItem;
import kt.model.AmenityOrder;
import kt.repository.AmenityOrderRepository;

@RestController
public class AmainityOrderController {
	
	@Autowired
	AmenityOrderRepository amenityOrderRepository;
	
	
	@GetMapping("/amenityOrder/{item_no}")
	public AmenityOrder amenityOrder(@PathVariable Long item_no){
		Optional<AmenityOrder> amenityOrder = amenityOrderRepository.findById(item_no);
		return amenityOrder.get();
	}

}
