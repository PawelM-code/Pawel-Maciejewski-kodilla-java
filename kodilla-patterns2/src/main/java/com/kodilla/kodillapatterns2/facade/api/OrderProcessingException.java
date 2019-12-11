package com.kodilla.kodillapatterns2.facade.api;

public class OrderProcessingException extends Exception {
    public static String ERR_NOT_AUTHORISED = "User is not authorised";
    public static String ERR_PAYMENT_REJECTED = "Payment is rejected";
    public static String ERR_VERIFICATION_ERROR = "Verification error";
    public static String ERR_SUBMITTING_ERROR = "Cannot submit oteder";

    public OrderProcessingException(String message) {
        super(message);
    }
}
