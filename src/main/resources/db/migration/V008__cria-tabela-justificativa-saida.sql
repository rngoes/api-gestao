create table justificativa_saida (
    id bigint not null auto_increment,
    descricao varchar(20) not null,

    primary key (id)
);

alter table justificativa_saida
add constraint uk_justificativa_saida unique (descricao)