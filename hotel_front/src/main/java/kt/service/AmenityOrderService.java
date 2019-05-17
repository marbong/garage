package kt.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kt.entity.AmenityItem;
import kt.entity.AmenityOrder;
import kt.entity.Room;
import kt.kafka.producer.Sender;
import kt.repository.AmenityItemRepository;
import kt.repository.AmenityOrderRepository;
import kt.repository.RoomRepository;
import org.apache.http.HttpConnection;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Map;
import java.util.Optional;

@Service
public class AmenityOrderService {
    @Autowired
    AmenityOrderRepository amenityOrderRepository;
    @Autowired
    AmenityItemRepository amenityItemRepository;
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    Sender kafkaSender;
    private RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
    @Value("${app.targetName}")
    String targetName;

    public Optional<AmenityOrder> getAmenityOrderListByItemName(String itemName){
        return amenityOrderRepository.findByAmenityItem(amenityItemRepository.findByName(itemName));
    }

    public Optional<AmenityOrder> getAmenityOrderListByRoomNo(int roomNo){
        return amenityOrderRepository.findByRoom(roomRepository.findByNumber(roomNo));
    }

    public AmenityOrder getAmenityOrder(int roomNo, String itemName){
        Room room = roomRepository.findByNumber(roomNo);
        AmenityItem amenityItem = amenityItemRepository.findByName(itemName);
        return amenityOrderRepository.findByRoomAndAmenityItem(room, amenityItem);
    }

    public AmenityOrder saveAmenityOrder(AmenityOrder amenityOrder) {
        return amenityOrderRepository.save(amenityOrder);
    }

    public AmenityOrder updateAmenityOrder(int room_no, String item_name, AmenityOrder amenityOrder) {
        Room room = roomRepository.findByNumber(room_no);
        AmenityItem amenityItem = amenityItemRepository.findByName(item_name);
        amenityOrder.setId(amenityOrderRepository.findByRoomAndAmenityItem(room, amenityItem).getId());
        return amenityOrderRepository.save(amenityOrder);
    }

    @DeleteMapping("/amenityOrderItem/{room_no}/{item_name}")
    public void deleteAmenityOrder(@PathVariable int room_no, @PathVariable String item_name) {
        Room room = roomRepository.findByNumber(room_no);
        AmenityItem amenityItem = amenityItemRepository.findByName(item_name);
        amenityItemRepository.deleteById(amenityOrderRepository.findByRoomAndAmenityItem(room, amenityItem).getId());
    }

    public String orderAmenity(@RequestParam Map<String, String> params) throws JsonProcessingException {
        String item_name = params.get("Amenity");
        int count = Integer.parseInt(params.get("count"));
        int room_no = Integer.parseInt(params.get("room"));

        Room room = roomRepository.findByNumber(room_no);
        AmenityItem amenityItem = amenityItemRepository.findByName(item_name);

        if(amenityItem.getAvailable_count() < count){
            return "Quantity is insufficient.";
        } else{
            amenityItem.setAvailable_count(amenityItem.getAvailable_count() - count);
            amenityItemRepository.save(amenityItem);
        }

        // dev env
        params.put("type","order");
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(params);
        kafkaSender.send(jsonStr);
        // istio env
//        try {
//            params.put("type","order");
//            ObjectMapper objectMapper = new ObjectMapper();
//            String jsonStr = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(params);
//
//            HttpClient httpClient = HttpClientBuilder.create().build();
//            HttpPost httpPost = new HttpPost("http://10.1.178.198:80/internal/api/pms/call");
//            httpPost.setEntity(new StringEntity(jsonStr));
//            HttpResponse httpResponse = null;
//            httpResponse = httpClient.execute(httpPost);
//
//            if (httpResponse.getStatusLine().getStatusCode() == 200) {
//                ResponseHandler<String> handler = new BasicResponseHandler();
//                String body = handler.handleResponse(httpResponse);
//                System.out.println(body);
//            } else {
//                System.out.println("response is error : " + httpResponse.getStatusLine().getStatusCode());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        AmenityOrder amenityOrder = AmenityOrder.builder().build();
        amenityOrder.setRoom(room);
        amenityOrder.setAmenityItem(amenityItem);
        amenityOrder.setCount(count);
        amenityOrder.setStatus("processing");
        amenityOrder.setReq_time(LocalDateTime.now(ZoneId.of("Asia/Seoul")));

        return amenityOrderRepository.save(amenityOrder).toString();
    }
}