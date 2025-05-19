package com.example.umc_spring_mission.service.StoreService;

import com.example.umc_spring_mission.apiPayload.exception.ErrorStatus;
import com.example.umc_spring_mission.apiPayload.exception.handler.NeighborhoodHandler;
import com.example.umc_spring_mission.converter.StoreConverter;
import com.example.umc_spring_mission.domain.Neighborhood;
import com.example.umc_spring_mission.domain.Restaurant;
import com.example.umc_spring_mission.repository.NeighborhoodRepository.NeighborhoodRepository;
import com.example.umc_spring_mission.repository.StoreRespository.StoreRepository;
import com.example.umc_spring_mission.web.dto.Store.StoreRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final NeighborhoodRepository neighborhoodRepository;

    @Override
    @Transactional
    public Restaurant addRestaurant (StoreRequestDTO.AddStoreRequestDTO request) {
        Neighborhood neighborhood = neighborhoodRepository.findById(request.getDongId())
                .orElseThrow(() -> new NeighborhoodHandler(ErrorStatus.NEIGHBORHOOD_NOT_FOUND));

        Restaurant  newRestaurant = StoreConverter.toRestaurant(request, neighborhood);
        return storeRepository.save(newRestaurant);
    }
}
