create table novel
(
    id     int auto_increment
        primary key,
    author varchar(20)  null,
    title  varchar(20)  null,
    size   varchar(20)  null,
    intro  varchar(255) null
);