package org.senla.komar.spring.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Перечисление {@code BookingStatus} представляет возможные статусы бронирования.
 * Каждый статус бронирования имеет свое имя и описание.
 *
 * @author Olga Komar
 * @since 1.0
 */
@Getter
public enum BookingStatus {
    NEW("new", "booking created"),
    PENDING("pending", "booking to pending"),
    WAIT_LIST("wait list", "booking to wait list"),
    CONFIRMED("confirmed", "booking confirmed"),
    CANCELLED("cancelled", "booking cancelled"),
    MODIFIED("modified", "booking modified"),
    COMPLETED("completed", "booking completed");

    private final String name;
    private final String description;

    BookingStatus(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
