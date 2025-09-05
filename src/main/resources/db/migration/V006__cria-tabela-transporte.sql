create table transporte (
    id bigint not null auto_increment,
    descricao varchar(20) not null,

    primary key (id)
);

alter table transporte
add constraint uk_transporte unique (descricao)