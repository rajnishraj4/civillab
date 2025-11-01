package com.tech.adira.app.management.civillab.mapper.account;

import com.tech.adira.app.management.civillab.common.AbstractAuditableMapper;
import com.tech.adira.app.management.civillab.model.dto.account.AccountDto;
import com.tech.adira.app.management.civillab.model.entity.account.AccountEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AccountMapper extends AbstractAuditableMapper<AccountEntity, AccountDto> {

    @Override
    public AccountDto toDto(AccountEntity entity) {
        if (entity == null) {
            return null;
        }

        AccountDto dto = new AccountDto();
        Optional.ofNullable(entity.getAccountSourceType()).ifPresent(dto::setAccountSourceType);
        Optional.ofNullable(entity.getAccountDetail()).ifPresent(dto::setAccountDetail);
        Optional.ofNullable(entity.getBankName()).ifPresent(dto::setBankName);
        Optional.ofNullable(entity.getProvider()).ifPresent(dto::setProvider);
        Optional.ofNullable(entity.getAccountTypes()).ifPresent(dto::setAccountTypes);
        Optional.ofNullable(entity.getStatus()).ifPresent(dto::setStatus);
        Optional.ofNullable(entity.getAccountGroup()).ifPresent(dto::setAccountGroup);
        mapAuditToDto(entity, dto);

        return dto;
    }

    @Override
    public AccountEntity toEntity(AccountDto dto) {
        if (dto == null) {
            return null;
        }

        AccountEntity entity = new AccountEntity();
        Optional.ofNullable(dto.getAccountSourceType()).ifPresent(entity::setAccountSourceType);
        Optional.ofNullable(dto.getAccountDetail()).ifPresent(entity::setAccountDetail);
        Optional.ofNullable(dto.getBankName()).ifPresent(entity::setBankName);
        Optional.ofNullable(dto.getProvider()).ifPresent(entity::setProvider);
        Optional.ofNullable(dto.getAccountTypes()).ifPresent(entity::setAccountTypes);
        Optional.ofNullable(dto.getStatus()).ifPresent(entity::setStatus);
        Optional.ofNullable(dto.getAccountGroup()).ifPresent(entity::setAccountGroup);
        mapAuditToEntity(dto, entity);

        return entity;
    }
}
