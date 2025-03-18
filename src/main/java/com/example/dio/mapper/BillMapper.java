package com.example.dio.mapper;


import com.example.dio.dto.response.BillResponse;
import com.example.dio.model.Bill;
import com.example.dio.model.Category;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface BillMapper {

    public BillResponse mapToBillResponse(Bill bill);
    List<String> map(List<Category> value);
    default String mapToString(Category value) {
        if(value == null) {
            return null;
        }
        else return value.getCategory().toLowerCase();
    }
}
