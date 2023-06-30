package com.example.kinoteka.domain.type;


import com.example.kinoteka.domain.type.dto.TypeDto;

class TypeDtoMapper {
    static TypeDto map(Type type){
        return new TypeDto(
                type.getId(),
                type.getName(),
                type.getDescription()
        );
    }


}
