package com.tech.adira.app.management.civillab.model.dto.account;

import com.tech.adira.app.management.civillab.common.AbstractAuditableDto;
import com.tech.adira.app.management.civillab.constants.account.AccountGroup;
import com.tech.adira.app.management.civillab.constants.account.AccountSourceType;
import com.tech.adira.app.management.civillab.constants.account.AccountTypes;
import com.tech.adira.app.management.civillab.constants.management.ActiveStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto extends AbstractAuditableDto {
    private AccountSourceType accountSourceType;
    private String accountDetail;
    private String bankName;
    private String provider;
    private AccountTypes accountTypes;
    private ActiveStatus status;
    private AccountGroup accountGroup;
}

