package com.example.dio.service;

import com.example.dio.dto.response.BillResponse;

public interface BillService {

    public BillResponse createBill(long tableId);

    public BillResponse findById(long billId);

    Byte[] findBillById(long billId);
}
