package com.messenger.upi;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class NpciClient {
    public String buildDeepLink(String pa, String pn, String tr, String am, String cu) {
        String base = "upi://pay";
        return base + "?pa=" + enc(pa) + "&pn=" + enc(pn) + "&tr=" + enc(tr) + "&am=" + enc(am) + "&cu=" + enc(cu);
    }

    private String enc(String s) { return URLEncoder.encode(s, StandardCharsets.UTF_8); }
}