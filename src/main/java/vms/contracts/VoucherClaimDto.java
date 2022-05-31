package vms.contracts;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class VoucherClaimDto {
    @NotNull
    private Double amount;
}
