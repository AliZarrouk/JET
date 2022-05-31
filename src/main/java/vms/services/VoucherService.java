package vms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vms.dal.VoucherRepository;
import vms.models.Voucher;
import vms.models.VoucherClaim;
import vms.tools.Clock;

@Service
public class VoucherService {

    private final VoucherRepository voucherRepository;
    private final Clock clock;

    @Autowired
    public VoucherService(VoucherRepository voucherRepository, Clock clock) {
        this.voucherRepository = voucherRepository;
        this.clock = clock;
    }

    public Voucher createVoucher(Voucher voucher) {
        return voucherRepository.createVoucher(voucher);
    }

    public Voucher claimVoucher(VoucherClaim voucherClaim, String code) {
        Voucher voucher = voucherRepository.getVoucher(code);
        if (clock.now().after(voucher.getExpiresOn())) return null;
        return voucherRepository.substractAmountFromVoucher(code, voucherClaim.getAmount());
    }

    public boolean voucherExists(String code) {
        return voucherRepository.isVoucherExists(code);
    }

    public Voucher getVoucher(String code) {
        return voucherRepository.getVoucher(code);
    }
}
