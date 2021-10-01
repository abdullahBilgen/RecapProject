package com.example.reCapProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reCapProject.entities.concretes.Payment;

public interface PaymentDao extends JpaRepository<Payment, Integer> {

}
