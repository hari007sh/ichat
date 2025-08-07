package com.messenger.upi;

import android.content.Intent;
import android.net.Uri;

public class DeepLinkExample {
    public static Intent buildIntent() {
        return new Intent(Intent.ACTION_VIEW, Uri.parse(
          "upi://pay?pa=merchant@upi&pn=Merchant&tr=TXN123&am=1.00&cu=INR"));
    }
}