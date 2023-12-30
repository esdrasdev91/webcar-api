package com.webcar.webcarapi.service;

import com.webcar.webcarapi.dto.OwnerPostDTO;
import org.springframework.stereotype.Service;

@Service
public interface OwnerPostService {

    void createOwnerCar(OwnerPostDTO ownerPostDTO);
}
