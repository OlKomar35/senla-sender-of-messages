package org.senla.komar.spring.enums;

import lombok.Getter;

@Getter
public enum PaymentStatus {
    PENDING("pending", "ожидает оплаты"),
    SUCCESS("success", "оплаченно"),
    DECLINED("declined", "оплата не прошла"),
    PROCESSING("processing", "в процессе обработки"),
    CANCELLED("cancelled", "оплата отменина"),
    EXPIRED("expired", "оплата просрочена");

    private final String name;
    private final String description;


    PaymentStatus(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
