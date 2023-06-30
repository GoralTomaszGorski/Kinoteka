package com.example.kinoteka.domain.type;


import com.example.kinoteka.domain.type.dto.TypeDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class TypeService {
    private final TypeRepository typeRepository;

    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public Optional<TypeDto> findTypeByName(String name){
        return typeRepository.findByNameIgnoreCase(name)
                .map(TypeDtoMapper::map);
    }

    public List<TypeDto> findAllTypes(){
        return StreamSupport.stream(typeRepository.findAll().spliterator(), false)
                .map(TypeDtoMapper::map)
                .toList();
    }

    @Transactional
    public void addType(TypeDto type){
        Type typeToSave = new Type();
        typeToSave.setName(type.getName());
        typeToSave.setDescription(type.getDescription());
        typeRepository.save(typeToSave);
    }



}
