package com.tech.adira.app.management.civillab.mapper.payment;

import com.tech.adira.app.management.civillab.common.AbstractAuditableMapper;
import com.tech.adira.app.management.civillab.model.dto.payment.PaymentDto;
import com.tech.adira.app.management.civillab.model.entity.payment.PaymentEntity;
import com.tech.adira.app.management.civillab.mapper.account.AccountMapper;
import com.tech.adira.app.management.civillab.mapper.employee.EmployeeMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PaymentMapper extends AbstractAuditableMapper<PaymentEntity, PaymentDto> {

    private final AccountMapper accountMapper;
    private final EmployeeMapper employeeMapper;

    public PaymentMapper(AccountMapper accountMapper,
                         EmployeeMapper employeeMapper) {
        this.accountMapper = accountMapper;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public PaymentDto toDto(PaymentEntity entity) {
        if (entity == null) {
            return null;
        }
        PaymentDto dto = new PaymentDto();
        Optional.ofNullable(entity.getExpenseType()).ifPresent(dto::setExpenseType);
        Optional.ofNullable(entity.getExpenseId()).ifPresent(dto::setExpenseId);
        if (entity.getAccount() != null) {
            dto.setAccount(accountMapper.toDto(entity.getAccount()));
        }
        Optional.ofNullable(entity.getPayMode()).ifPresent(dto::setPayMode);
        Optional.ofNullable(entity.getTransactionId()).ifPresent(dto::setTransactionId);
        if (entity.getPayer() != null) {
            dto.setPayer(employeeMapper.toDto(entity.getPayer()));
        }
        Optional.ofNullable(entity.getIsCompanyPaid()).ifPresent(dto::setIsCompanyPaid);
        Optional.ofNullable(entity.getPayTime()).ifPresent(dto::setPayTime);
        Optional.ofNullable(entity.getPaymentStatus()).ifPresent(dto::setPaymentStatus);
        mapAuditToDto(entity, dto);
        return dto;
    }

    @Override
    public PaymentEntity toEntity(PaymentDto dto) {
        if (dto == null) {
            return null;
        }
        PaymentEntity entity = new PaymentEntity();
        Optional.ofNullable(dto.getExpenseType()).ifPresent(entity::setExpenseType);
        Optional.ofNullable(dto.getExpenseId()).ifPresent(entity::setExpenseId);
        if (dto.getAccount() != null) {
            entity.setAccount(accountMapper.toEntity(dto.getAccount()));
        }
        Optional.ofNullable(dto.getPayMode()).ifPresent(entity::setPayMode);
        Optional.ofNullable(dto.getTransactionId()).ifPresent(entity::setTransactionId);
        if (dto.getPayer() != null) {
            entity.setPayer(employeeMapper.toEntity(dto.getPayer()));
        }
        Optional.ofNullable(dto.getIsCompanyPaid()).ifPresent(entity::setIsCompanyPaid);
        Optional.ofNullable(dto.getPayTime()).ifPresent(entity::setPayTime);
        Optional.ofNullable(dto.getPaymentStatus()).ifPresent(entity::setPaymentStatus);
        mapAuditToEntity(dto, entity);
        return entity;
    }
}
