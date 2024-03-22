package com.example.orderservice.controller;

import com.example.orderservice.dto.TableRequest;
import com.example.orderservice.repository.TableKoyamaRepository;
import com.example.orderservice.service.TableKoyamaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/table")
@RequiredArgsConstructor
public class TableKoyamaController {

    private final TableKoyamaService tableKoyamaService;

    @PostMapping
    public String createTable(@RequestBody TableRequest tableRequest){
        return tableKoyamaService.createTable(tableRequest);
    }
}
