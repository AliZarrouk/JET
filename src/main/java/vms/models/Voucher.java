package vms.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Voucher {
    private String code;
    private Date expiresOn;
    private Double amount;
}
