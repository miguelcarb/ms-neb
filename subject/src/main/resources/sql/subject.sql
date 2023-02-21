create table subject (
    subject_id serial primary key not null,
    subject_code character varying(20) unique not null,
    subject_title character varying(50) not null,
    subject_credits integer not null
);