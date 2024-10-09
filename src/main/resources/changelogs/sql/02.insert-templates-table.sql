INSERT INTO message_template(created_at, updated_at, delivery_channel, message_type,name, title)
VALUES (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'EMAIL', 'NEW_BOOKING', 'new-email.ftl', 'Подтверждение бронирования %s');
INSERT INTO message_template(created_at, updated_at, delivery_channel, message_type,name, title)
VALUES (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'EMAIL', 'CANCELLED_BOOKING', 'delete-email.ftl', 'Отмена бронирования %s');
INSERT INTO message_template(created_at, updated_at, delivery_channel, message_type,name)
VALUES (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SMS', 'NEW_BOOKING', 'new-sms.ftl');





