package vms.contracts;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.Date;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VoucherDto {
    @NotNull
    @Min(10)
    @Max(100)
    private Double amount;

    @NotNull
    @Future
    private Date expiresOn;

    private String code;
}
