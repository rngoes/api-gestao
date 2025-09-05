create table tipo_alocacao (
    id bigint not null auto_increment,
    descricao varchar(20) not null,

    primary key (id)
);

alter table tipo_alocacao
add constraint uk_tipo_alocacao unique (descricao)