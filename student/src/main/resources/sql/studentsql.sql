create table student (
    student_id serial primary key not null,
    current_degree character varying(50) not null,
    first_name character varying(50) not null,
    last_name character varying(50) not null,
    email character varying(50) not null
);