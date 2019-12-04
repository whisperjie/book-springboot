create table user
(
    id       int auto_increment
        primary key,
    name     varchar(10) not null,
    password varchar(20) not null,
    constraint name
        unique (name)
);

