package com.hegde.playground;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Collections.emptyList;

public class StreamProblems {

    @Test
    void streamExample() {
        List<PaymentType> paymentTypes = List.of(new PaymentType("VISA", "CREDIT_CARD"),
                new PaymentType("VISA", "CREDIT_CARD"),
                new PaymentType("MASTERCARD", "CREDIT_CARD"),
                new PaymentType("RUPAY", "CREDIT_CARD"),
                new PaymentType("DINERS", "CREDIT_CARD"),
                new PaymentType("UPI", "UPI"),
                new PaymentType(null, "NET_BANKING"),
                new PaymentType(null, "OLA_MONEY"),
                new PaymentType(null, "AMAZON_PAY"));

        List<PaymentMethod> expected = List.of(new PaymentMethod("CREDIT_CARD", List.of("VISA", "MASTERCARD", "RUPAY", "DINERS")),
                new PaymentMethod("UPI", List.of("UPI")),
                new PaymentMethod("NET_BANKING", emptyList()),
                new PaymentMethod("OLA_MONEY", emptyList()));

        List<PaymentMethod> actual = emptyList();

        Assertions.assertEquals(expected, actual);
    }

    public static class PaymentType {
        private String subType;
        private String type;

        public PaymentType(String subType, String type) {
            this.subType = subType;
            this.type = type;
        }

        public String getSubType() {
            return subType;
        }

        public String getType() {
            return type;
        }
    }

    public static class PaymentMethod {
        private String type;
        private List<String> options;

        public PaymentMethod(String type, List<String> options) {
            this.type = type;
            this.options = options;
        }

        public String getType() {
            return type;
        }

        public List<String> getOptions() {
            return options;
        }
    }
}
