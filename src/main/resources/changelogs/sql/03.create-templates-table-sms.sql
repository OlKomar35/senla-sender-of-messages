create table sms(
                    id serial primary key,
                    created_at timestamp without time zone,
                    updated_at timestamp without time zone,
                    booking_status varchar(50) not null,
                    message  varchar(50) not null
);
