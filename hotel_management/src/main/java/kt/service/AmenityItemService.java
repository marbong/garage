package kt.service;

import kt.entity.AmenityItem;
import kt.repository.AmenityItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AmenityItemService {
    @Autowired
    AmenityItemRepository amenityItemRepository;

    public AmenityItem getAmenityItem(String itemName){
        return amenityItemRepository.findByName(itemName);
    }

    public List<AmenityItem> getAmenityItemList(){
        return amenityItemRepository.findAll();
    }

    public AmenityItem saveAmenityItem(String itemName, int count){
        AmenityItem amenityItem = AmenityItem.builder().build();
        amenityItem.setName(itemName);
        amenityItem.setAvailable_count(count);
        return amenityItemRepository.save(amenityItem);
    }

    public String saveAmenityItem(AmenityItem amenityItem){
        if(amenityItemRepository.findByName(amenityItem.getName()) == null){
            return amenityItemRepository.save(amenityItem).toString();
        } else {
            return updateAmenityItem(amenityItem.getName(), amenityItem).toString();
        }

    }

    public AmenityItem updateAmenityItem(String itemName, AmenityItem amenityItem){
        amenityItem.setId(amenityItemRepository.findByName(itemName).getId());
        return amenityItemRepository.save(amenityItem);
    }

    public void deleteAmenityItem(String itemName){
        amenityItemRepository.deleteById(amenityItemRepository.findByName(itemName).getId());
    }

    public int initAmenityItem(){
        List<AmenityItem> amenityItems = new ArrayList<AmenityItem>() {{
            add(AmenityItem.builder().name("Towel").available_count(200).build());
            add(AmenityItem.builder().name("Toothbrush").available_count(100).build());
            add(AmenityItem.builder().name("Shampoo").available_count(50).build());
            add(AmenityItem.builder().name("BodyCleanser").available_count(50).build());
            add(AmenityItem.builder().name("Shaver").available_count(500).build());
            add(AmenityItem.builder().name("Soap").available_count(400).build());
            add(AmenityItem.builder().name("Water").available_count(200).build());
            add(AmenityItem.builder().name("GreenTea").available_count(200).build());
            add(AmenityItem.builder().name("Coffee").available_count(200).build());
        }};
        return amenityItemRepository.saveAll(amenityItems).size();
    }
}
