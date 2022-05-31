package vms.services;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import vms.dal.VoucherRepository;
import vms.models.Voucher;
import vms.tools.Clock;

import java.util.Date;
import java.util.UUID;

import static org.junit.Assert.fail;


@RunWith(MockitoJUnitRunner.class)
public class VoucherServiceTest {

    private VoucherService underTest;

    @Mock
    private Clock clock;

    @Mock
    private VoucherRepository voucherRepository;

    @Before
    public void setUp() {
        underTest = new VoucherService(voucherRepository, clock);
    }

    @After
    public void tearDown() {
        Mockito.verifyNoMoreInteractions(voucherRepository);
    }

    @Test
    public void createVoucher() {
        Date someDate = new Date();
        UUID uuid = UUID.randomUUID();
        Voucher voucher = new Voucher();
        voucher.setAmount(10d);
        voucher.setExpiresOn(someDate);

        Voucher voucherResult = new Voucher();
        voucherResult.setAmount(10d);
        voucherResult.setExpiresOn(someDate);
        voucherResult.setCode(uuid.toString());
        Mockito.when(voucherRepository.createVoucher(voucher)).thenReturn(voucherResult);

        Voucher outputVoucher = underTest.createVoucher(voucher);

        assert outputVoucher != null;
        assert outputVoucher.getAmount().equals(voucherResult.getAmount());
        assert outputVoucher.getCode().equals(voucherResult.getCode());
        assert outputVoucher.getExpiresOn().equals(voucherResult.getExpiresOn());
        Mockito.verify(voucherRepository).createVoucher(voucher);
    }

    @Test
    public void claimVoucher() {
        fail();
        //// creating a Calendar object
        //        Calendar c1 = Calendar.getInstance();
        //
        //        // set Month
        //        // MONTH starts with 0 i.e. ( 0 - Jan)
        //        c1.set(Calendar.MONTH, 11);
        //
        //        // set Date
        //        c1.set(Calendar.DATE, 05);
        //
        //        // set Year
        //        c1.set(Calendar.YEAR, 1996);
        //
        //        // creating a date object with specified time.
        //        Date dateOne = c1.getTime();
    }

    @Test
    public void voucherExists() {
        fail();

    }

    @Test
    public void getVoucher() {
        fail();

    }
}