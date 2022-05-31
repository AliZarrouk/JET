package vms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vms.contracts.VoucherClaimDto;
import vms.contracts.VoucherDto;
import vms.mappers.VoucherMapper;
import vms.services.VoucherService;

import javax.validation.Valid;

@RestController
@RequestMapping("voucher")
@Validated
@SuppressWarnings("unused")
public class VoucherController {

    private final VoucherService voucherService;
    private final VoucherMapper voucherMapper;

    @Autowired
    public VoucherController(VoucherService voucherService, VoucherMapper voucherMapper) {
        this.voucherMapper = voucherMapper;
        this.voucherService = voucherService;
    }

    @PostMapping
    public ResponseEntity<VoucherDto> createVoucher(@Valid @RequestBody VoucherDto voucherDto) {
        var voucher = voucherMapper.voucherDtoToVoucher(voucherDto);
        voucher = voucherService.createVoucher(voucher);
        return ResponseEntity.ok(voucherMapper.voucherToVoucherDto(voucher));
    }

    @GetMapping("/{code}")
    public ResponseEntity<VoucherDto> getVoucher(@PathVariable String code) {
        var voucher = voucherService.getVoucher(code);
        if (voucher == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(voucherMapper.voucherToVoucherDto(voucher));
    }

    @PostMapping("/{code}/claim")
    public ResponseEntity<VoucherDto> claimVoucher(@PathVariable String code,
                                                   @Valid @RequestBody VoucherClaimDto voucherClaimDto) {
        if (!voucherService.voucherExists(code)) return ResponseEntity.notFound().build();
        var voucherClaim = voucherMapper.voucherClaimDtoToVoucherClaim(voucherClaimDto);
        var voucher = voucherService.claimVoucher(voucherClaim, code);
        if (voucher == null) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(voucherMapper.voucherToVoucherDto(voucher));
    }
}
