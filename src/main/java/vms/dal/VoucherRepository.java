package vms.dal;

import vms.models.Voucher;
import vms.models.VoucherClaim;

public interface VoucherRepository {
    Voucher createVoucher(Voucher voucher);
    Voucher getVoucher(String code);
    Voucher substractAmountFromVoucher(String voucherCode, Double amount);
    boolean isVoucherExists(String code);
}
