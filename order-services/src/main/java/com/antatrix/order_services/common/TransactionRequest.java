package com.antatrix.order_services.common;

import com.antatrix.order_services.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequest {
  private Order order;
  private Payment payment;
}
