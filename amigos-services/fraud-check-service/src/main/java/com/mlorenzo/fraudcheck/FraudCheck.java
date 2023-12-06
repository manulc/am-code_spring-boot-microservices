package com.mlorenzo.fraudcheck;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "fraud_checks")
public class FraudCheck {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fraud_id_sequence")
    @SequenceGenerator(name = "fraud_id_sequence", sequenceName = "fraud_id_sequence")
    private Integer id;

    private Integer customerId;
    private Boolean isFraudster;
    private LocalDateTime createdAt;
}
