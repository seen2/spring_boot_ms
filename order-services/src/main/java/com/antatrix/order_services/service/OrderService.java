package com.antatrix.order_services.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.antatrix.order_services.common.Payment;
import com.antatrix.order_services.common.TransactionRequest;
import com.antatrix.order_services.common.TransactionResponse;
import com.antatrix.order_services.entity.Order;
import com.antatrix.order_services.repository.OrderRepository;

@Service
public class OrderService {

  private final OrderRepository orderRepository;
  @Autowired
  private RestTemplate restTemplate;

  public OrderService(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  public TransactionResponse save(TransactionRequest transactionRequest) {
    Order order=transactionRequest.getOrder();
    Payment payment=transactionRequest.getPayment();
    payment.setOrderAmount(order.getPrice()*order.getQty());
    payment.setOrderId(order.getId());
    Payment paymentResponse=restTemplate.postForObject("http://localhost:9191/payment/makePayment", payment, Payment.class);
    orderRepository.save(order);
    TransactionResponse transactionResponse=new TransactionResponse(order,paymentResponse.getOrderAmount(),paymentResponse.getTransactionId(),paymentResponse.getPaymentStatus());
    return transactionResponse;
  }



}
