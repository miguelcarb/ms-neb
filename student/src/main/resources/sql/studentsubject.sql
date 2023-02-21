create table student_subject (
    student_subject_id serial primary key not null,
    student_id integer not null,
    subject_id integer not null
);