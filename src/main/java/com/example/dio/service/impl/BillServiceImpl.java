package com.example.dio.service.impl;

import com.example.dio.dto.response.BillResponse;
import com.example.dio.enums.OrderStatus;
import com.example.dio.enums.TableStatus;
import com.example.dio.exception.NoBillFoundException;
import com.example.dio.mapper.BillMapper;
import com.example.dio.model.Bill;
import com.example.dio.model.Order;
import com.example.dio.model.RestaurantTable;
import com.example.dio.repository.BillRepository;
import com.example.dio.repository.OrderRepository;
import com.example.dio.repository.RestaurantTableRepository;
import com.example.dio.service.BillService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class BillServiceImpl implements BillService {


    private final BillRepository billRepository;
    private final RestaurantTableRepository restaurantTableRepository;
    private final OrderRepository orderRepository;
    private  final BillMapper billMapper;

    @Override
    public BillResponse createBill(long tableId) {
        RestaurantTable restaurantTable = restaurantTableRepository.findById(tableId)
                .orElseThrow(() -> new NoSuchElementException("Table not found !!"));

        List<Order> orderList = orderRepository.findByRestaurantTable(restaurantTable, OrderStatus.PAID);
        double totalAmount = orderList.stream()
                .mapToDouble(Order::getTotalAmount)
                .sum();
        Bill bill = null;
        if(!orderList.isEmpty()) {
            bill = new Bill();
            bill.setOrders(orderList);
            bill.setTotalPayableAmount(totalAmount);
            billRepository.save(bill);
        }
        else{
            throw new NoSuchElementException(" No CartItem Selected !! ");
        }

        orderList.forEach(order -> order.setOrderStatus(OrderStatus.PAID));
        restaurantTable.setStatus(TableStatus.AVAILABLE);
        restaurantTableRepository.save(restaurantTable);
        orderRepository.saveAll(orderList);

        return billMapper.mapToBillResponse(bill);
    }

    @Override
    public BillResponse findById(long billId) {
        Bill bill = billRepository.findById(billId)
                .orElseThrow(() -> new NoBillFoundException("No bill found with "+ billId +" id"));
        return billMapper.mapToBillResponse(bill);
    }

    @Override
    public Byte[] findBillById(long billId) {

        Bill bill = billRepository.findById(billId)
                .orElseThrow(() -> new NoBillFoundException("No bill found with "+ billId +" id"));

        billMapper.mapToBillResponse(bill);
        return null ;
    }
}
