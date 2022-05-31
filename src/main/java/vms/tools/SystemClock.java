package vms.tools;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SystemClock implements Clock {

    @Override
    public Date now() {
        return new Date(System.currentTimeMillis());
    }
}
