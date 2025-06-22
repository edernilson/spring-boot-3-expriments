package br.com.edernilson.distributedscheduling.models;

import java.util.List;

import org.hibernate.LockOptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import jakarta.persistence.LockModeType;
import jakarta.persistence.QueryHint;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 08/12/2024, domingo
 */
@Repository
public interface PaymentStatusRepository extends JpaRepository<PaymentStatusEntity, Long> {

    @QueryHints({
            @QueryHint(
                    name = "jakarta.persistence.lock.timeout",
                    value = LockOptions.SKIP_LOCKED + ""
            )
    })
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<PaymentStatusEntity> findTop50ByOrderStatusOrderByCreatedAtDesc(OrderStatus orderStatus);
}