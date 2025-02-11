package com.antatrix.payment_services.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antatrix.payment_services.entity.Payment;
import com.antatrix.payment_services.repository.PaymentRepository;

@Service
public class PaymentService {

  @Autowired
  private PaymentRepository paymentRepository;

  public Payment save(Payment payment) {
    payment.setTransactionId(UUID.randomUUID().toString());
    payment.setPaymentStatus(isPaymentProcessing());
    return paymentRepository.save(payment);
  }

  public String isPaymentProcessing() {
    return new Random().nextBoolean() ? "success" : "failed";
  }

}
