package com.tech.adira.app.management.civillab.model.entity.payment;

import com.tech.adira.app.management.civillab.common.AbstractAuditableEntity;
import com.tech.adira.app.management.civillab.constants.expense.ExpenseType;
import com.tech.adira.app.management.civillab.constants.payment.PayMode;
import com.tech.adira.app.management.civillab.constants.payment.PaymentStatus;
import com.tech.adira.app.management.civillab.model.entity.account.AccountEntity;
import com.tech.adira.app.management.civillab.model.entity.employee.EmployeeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "payment")
@Getter
@Setter
@NoArgsConstructor
public class PaymentEntity extends AbstractAuditableEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "expense_type", nullable = false, length = 50)
    private ExpenseType expenseType = ExpenseType.GENERAL;

    @Column(name = "expense_id", length = 26, nullable = false)
    private String expenseId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private AccountEntity account;

    @Enumerated(EnumType.STRING)
    @Column(name = "pay_mode", nullable = false, length = 20)
    private PayMode payMode = PayMode.UPI;

    @Column(name = "transaction_id", length = 100)
    private String transactionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payer_id", referencedColumnName = "id")
    private EmployeeEntity payer;

    @Column(name = "is_company_paid", nullable = false)
    private Boolean isCompanyPaid = Boolean.FALSE;

    @Column(name = "payment_time", nullable = false)
    private Instant payTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status", nullable = false, length = 20)
    private PaymentStatus paymentStatus = PaymentStatus.DUE;
}
