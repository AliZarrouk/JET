package vms.mappers;

import org.springframework.stereotype.Component;
import vms.contracts.VoucherClaimDto;
import vms.contracts.VoucherDto;
import vms.models.Voucher;
import vms.models.VoucherClaim;

@Component
public class VoucherMapper {
    public Voucher voucherDtoToVoucher(VoucherDto dto) {
        if (dto == null) return null;
        Voucher voucher = new Voucher();
        voucher.setAmount(dto.getAmount());
        voucher.setCode(dto.getCode());
        voucher.setExpiresOn(dto.getExpiresOn());
        return voucher;
    }

    public VoucherDto voucherToVoucherDto(Voucher voucher) {
        if (voucher == null) return null;
        VoucherDto dto = new VoucherDto();
        dto.setAmount(voucher.getAmount());
        dto.setCode(voucher.getCode());
        dto.setExpiresOn(voucher.getExpiresOn());
        return dto;
    }

    public VoucherClaim voucherClaimDtoToVoucherClaim(VoucherClaimDto dto) {
        if (dto == null) return null;
        VoucherClaim voucherClaim = new VoucherClaim();
        voucherClaim.setAmount(dto.getAmount());
        return voucherClaim;
    }
}
