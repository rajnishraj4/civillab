package com.tech.adira.app.management.civillab.model.entity.account;

import com.tech.adira.app.management.civillab.common.AbstractAuditableEntity;
import com.tech.adira.app.management.civillab.constants.account.AccountSourceType;
import com.tech.adira.app.management.civillab.constants.account.AccountTypes;
import com.tech.adira.app.management.civillab.constants.management.ActiveStatus;
import com.tech.adira.app.management.civillab.constants.account.AccountGroup;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "account")
@Getter
@Setter
@NoArgsConstructor
public class AccountEntity extends AbstractAuditableEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "account_source_type", nullable = false)
    private AccountSourceType accountSourceType = AccountSourceType.UPI;

    @Column(name = "account_detail", length = 100, nullable = false)
    private String accountDetail;

    @Column(name = "bank_name", length = 100, nullable = false)
    private String bankName;

    @Column(name = "provider", length = 100, nullable = false)
    private String provider;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_types", nullable = false)
    private AccountTypes accountTypes = AccountTypes.SAVING;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ActiveStatus status = ActiveStatus.ACTIVE;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_group", nullable = false)
    private AccountGroup accountGroup = AccountGroup.OTHER;
}

