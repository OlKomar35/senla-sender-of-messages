INSERT INTO email(created_at, updated_at, booking_status, message, title)
VALUES (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'NEW', 'new-email.ftl', 'Подтверждение бронирования %s');
INSERT INTO email(created_at, updated_at, booking_status, message, title)
VALUES (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'CANCELLED', 'delete-email.ftl', 'Отмена бронирования %s');






