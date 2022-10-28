create table hibernate_sequence
(
    next_val bigint
) engine=MyISAM;

insert into hibernate_sequence
values (1);
insert into hibernate_sequence
values (1);

CREATE TABLE car
(
    id       BIGINT      NOT NULL AUTO_INCREMENT,
    name varchar(64) not null,
    description varchar(64) not null unique,
    price int,
    office varchar(64),
    PRIMARY KEY (id)
) engine=MyISAM;