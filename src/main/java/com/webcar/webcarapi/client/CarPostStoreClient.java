package com.webcar.webcarapi.client;

import com.webcar.webcarapi.dto.CarPostDTO;
import com.webcar.webcarapi.dto.OwnerPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class CarPostStoreClient {
    private final String USER_STORE_SERVICE_URI = "http://localhost:8080/user";
    private final String POSTS_STORE_SERVICE_URI = "http://localhost:8080/sales";

    @Autowired
    RestTemplate restTemplate;

    public List<CarPostDTO> carForSaleClient() {
        ResponseEntity<CarPostDTO[]> responseEntity = restTemplate.getForEntity(POSTS_STORE_SERVICE_URI+"/cars", CarPostDTO[].class);
        return Arrays.asList(Objects.requireNonNull(responseEntity.getBody()));
    }

    public void ownerPostsClient(OwnerPostDTO newUser) {
        restTemplate.postForEntity(USER_STORE_SERVICE_URI, newUser, OwnerPostDTO.class);
    }

    public void changeCarForSaleClient(CarPostDTO carPostDTO, String id) {
        restTemplate.put(USER_STORE_SERVICE_URI+"/car/"+ id, carPostDTO, CarPostDTO.class);
    }

    public void deleteCarForSaleClient(String id) {
        restTemplate.delete(USER_STORE_SERVICE_URI+"/car/"+ id);
    }

}
