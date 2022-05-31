package vms.dal;

import org.springframework.stereotype.Component;
import vms.models.Voucher;
import vms.models.VoucherClaim;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class InMemoryVoucherRepository implements VoucherRepository {
    private final Map<String, Voucher> vouchers;

    public InMemoryVoucherRepository() {
        vouchers = new HashMap<>();
    }

    @Override
    public Voucher createVoucher(Voucher voucher) {
        String uuid = UUID.randomUUID().toString();
        voucher.setCode(uuid);
        vouchers.put(uuid, voucher);
        return voucher;
    }

    @Override
    public Voucher getVoucher(String code) {
        return vouchers.get(code);
    }

    @Override
    public synchronized Voucher substractAmountFromVoucher(String voucherCode, Double amount) {
        var voucher = vouchers.get(voucherCode);
        if (voucher == null) return null;
        if (voucher.getAmount() < amount) return null;
        voucher.setAmount(voucher.getAmount() - amount);
        return voucher;
    }

    @Override
    public boolean isVoucherExists(String code) {
        return vouchers.containsKey(code);
    }
}
