create table level (
    id bigint not null auto_increment,
    level int not null,
    descricao varchar(30) not null,

    primary key (id)
);

alter table level
add constraint uk_level unique (level);