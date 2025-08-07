package com.messenger.upi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpiController {
    private final NpciClient npci = new NpciClient();

    @GetMapping("/upi/deeplink")
    public String deeplink(@RequestParam String pa, @RequestParam String am) {
        return npci.buildDeepLink(pa, "Merchant", "TXN123", am, "INR");
    }
}