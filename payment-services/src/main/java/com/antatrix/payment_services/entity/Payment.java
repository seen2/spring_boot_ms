package com.antatrix.payment_services.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payments")
public class Payment {

  @Id
  @GeneratedValue
  private int paymentId;
  private String paymentStatus;
  private String transactionId;
  private int orderId;
  private double orderAmount;


}
