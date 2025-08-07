package com.messenger.aadhaar;

public class AadhaarClient {
    public static class EsignResponse {
        public final byte[] signedPdf;
        public EsignResponse(byte[] signedPdf) { this.signedPdf = signedPdf; }
    }

    public EsignResponse esignV21(byte[] pdfPayload) {
        // Stub: call UIDAI eSign v2.1 API, return signed mandate PDF
        // Store in vault path kv/aadhaar/consents/{uuid}
        return new EsignResponse(pdfPayload);
    }
}