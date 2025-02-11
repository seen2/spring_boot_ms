package com.antatrix.payment_services.controller;

import org.springframework.web.bind.annotation.RestController;

import com.antatrix.payment_services.entity.Payment;
import com.antatrix.payment_services.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("payment")
public class PaymentController {

  @Autowired
  private PaymentService paymentService;

  @PostMapping("makePayment") 
  public Payment makePayment(@RequestBody Payment payment) {
      return paymentService.save(payment);
  }
  

}
