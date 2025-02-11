package com.antatrix.order_services.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.antatrix.order_services.common.TransactionRequest;
import com.antatrix.order_services.common.TransactionResponse;
import com.antatrix.order_services.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("order")
public class OrderController {

  @Autowired
  private OrderService orderService;

  @PostMapping("create")
  public TransactionResponse bookOrder(@RequestBody TransactionRequest transactionRequest) {
    return orderService.save(transactionRequest);

  }

}
