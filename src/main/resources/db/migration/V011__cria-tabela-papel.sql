create table papel (
    id bigint not null auto_increment,
    descricao varchar(20) not null,

    primary key (id)
);

alter table papel
add constraint uk_papel unique (descricao)