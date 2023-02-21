create table info_subject (
    info_id serial primary key not null,
    subject_code character varying(20) unique not null constraint info_subject_code_fk references subject,
    description character varying(250) not null,
    language character varying(20) not null
);