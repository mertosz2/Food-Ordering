package com.example.orderservice.service;

import com.example.orderservice.dto.TableRequest;
import com.example.orderservice.model.TableKoyama;
import com.example.orderservice.repository.TableKoyamaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TableKoyamaService {

    private final TableKoyamaRepository tableKoyamaRepository;
    public String createTable(TableRequest request){
        TableKoyama tableKoyama = TableKoyama.builder()
                .table_number(request.getTable_number())
                .capacity(request.getCapacity())
                .build();
        tableKoyamaRepository.save(tableKoyama);

        return  "table created";
    }
}
