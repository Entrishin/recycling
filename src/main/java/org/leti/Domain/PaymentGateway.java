package org.leti.Domain;

import javax.persistence.*;

/**
 *  ?????????????????????
 *  Таблица Payment_gateway - платежный шлюз (webmoney?)
 */

@Entity
@Table(name = "payment_gateway")
public class PaymentGateway {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
