package com.example.practice.utils;

import com.example.practice.model.dto.DTOEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DtoUtils
{
    public DTOEntity convertToDto(Object obj, DTOEntity mapper)
    {
        return new ModelMapper().map(obj, mapper.getClass());
    }

    public Object convertToEntity(Object obj, DTOEntity mapper)
    {
        return new ModelMapper().map(mapper, obj.getClass());
    }

    public List<DTOEntity> convertListToDto(List<?> objList, DTOEntity mapper){
        return objList
                .stream()
                .map(source -> new ModelMapper().map(source, mapper.getClass()))
                .collect(Collectors.toList());
    }
}
