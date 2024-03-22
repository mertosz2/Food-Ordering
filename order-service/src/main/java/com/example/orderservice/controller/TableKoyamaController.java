package com.example.orderservice.controller;

import com.example.orderservice.dto.TableRequest;

import com.example.orderservice.dto.UsersRequest;
import com.example.orderservice.model.TableKoyama;
import com.example.orderservice.service.TableKoyamaService;
import com.example.orderservice.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/table")
@RequiredArgsConstructor
public class TableKoyamaController {

    private final TableKoyamaService tableKoyamaService;

    @PostMapping
    public String createTable(@RequestBody TableRequest tableRequest){
        return tableKoyamaService.createTable(tableRequest);
    }

    @GetMapping
    public TableKoyama findTable(@RequestBody TableRequest request){
        return tableKoyamaService.findTableByTableNumber(request.getTable_number());
    }
}
