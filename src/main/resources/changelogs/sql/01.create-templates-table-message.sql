create table message_template(
                         id serial primary key,
                         created_at timestamp without time zone,
                         updated_at timestamp without time zone,
                         delivery_channel varchar(50) not null,
                         message_type varchar(50) not null,
                         name  varchar not null,
                         title varchar(300)
);
