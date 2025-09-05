create table motivo_saida (
    id bigint not null auto_increment,
    descricao varchar(20) not null,

    primary key (id)
);

alter table motivo_saida
add constraint uk_motivo_saida unique (descricao)