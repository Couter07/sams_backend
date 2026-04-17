package org.server.sams.service.admin;

import lombok.RequiredArgsConstructor;
import org.server.sams.dto.CountryDto;
import org.server.sams.repository.CountryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class AdminUserService {

    private final CountryRepository countryRepository;

    public List<CountryDto> getAllCountry(){
        return countryRepository.findAllCountry()
                .stream()
                .map(c -> CountryDto
                        .builder()
                        .id(c.getId())
                        .name(c.getName())
                        .build())
                .collect(Collectors.toList());
    }


}
