create table if not exists info_subject (
    info_id serial primary key,
    subject_id integer not null,
    description character varying(50) not null,
    code_language character varying(5) not null,
    constraint fk_subject_id_info_subject foreign key (subject_id)
    references subject(subject_id)
);