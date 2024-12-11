package br.com.edernilson.distributedscheduling.models;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 08/12/2024, domingo
 */
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}