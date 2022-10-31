create table gen_message (
    message_id serial primary key not null,
    email character varying(50) not null,
    date_created timestamp without time zone not null,
    message_content character varying(100) not null
);