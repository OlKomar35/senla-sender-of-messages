create table audit(
                         id bigserial primary key,
                         user_id bigserial not null,
                         send_at timestamp without time zone,
                         delivery_channel varchar(50) not null,
                         message_type varchar(50) not null
);
