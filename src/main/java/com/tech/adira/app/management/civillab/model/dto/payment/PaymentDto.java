package com.tech.adira.app.management.civillab.model.dto.payment;

import com.tech.adira.app.management.civillab.common.AbstractAuditableDto;
import com.tech.adira.app.management.civillab.constants.expense.ExpenseType;
import com.tech.adira.app.management.civillab.constants.payment.PayMode;
import com.tech.adira.app.management.civillab.constants.payment.PaymentStatus;
import com.tech.adira.app.management.civillab.model.dto.employee.EmployeeDto;
import com.tech.adira.app.management.civillab.model.dto.account.AccountDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto extends AbstractAuditableDto {

    private ExpenseType expenseType;
    private String expenseId;
    private AccountDto account;
    private PayMode payMode;
    private String transactionId;
    private EmployeeDto payer;
    private Boolean isCompanyPaid;
    private Instant payTime;
    private PaymentStatus paymentStatus;
}

