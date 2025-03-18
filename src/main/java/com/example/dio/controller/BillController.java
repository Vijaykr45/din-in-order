package com.example.dio.controller;

import com.example.dio.dto.response.BillResponse;
import com.example.dio.service.BillService;
import com.example.dio.utility.ResponseBuilder;
import com.example.dio.utility.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${app.base-url}")
@AllArgsConstructor
public class BillController {

    private final BillService billService ;

    @PostMapping("/bills/tables/{tableId}")
    public ResponseEntity<ResponseStructure<BillResponse>> createBill(@PathVariable long tableId){
        BillResponse billResponse = billService.createBill(tableId);
        return ResponseBuilder.created("Bill Generated !!" , billResponse);
    }

    @GetMapping("/bills/{billId}")
    public ResponseEntity<ResponseStructure<BillResponse>> findByBillId(@PathVariable long billId){
        BillResponse billResponse = billService.findById(billId);
        return ResponseBuilder.ok("Bill Found !!" , billResponse);
    }

    @GetMapping("/bills/pdf/{billId}")
    public ResponseEntity<ResponseStructure<Byte[]>> findBillById(@PathVariable long billId){
        BillResponse billResponse = billService.findById(billId);
        ResponseBuilder.ok("Bill Found !!" , billResponse);
        return null;
    }
}
