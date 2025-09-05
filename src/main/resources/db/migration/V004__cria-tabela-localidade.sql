create table localidade (
    id bigint not null auto_increment,
    descricao varchar(20) not null,

    primary key (id)
);

alter table localidade
add constraint uk_localidade unique (descricao)