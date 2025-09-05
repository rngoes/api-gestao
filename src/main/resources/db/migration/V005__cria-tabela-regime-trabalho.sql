create table regime_trabalho (
    id bigint not null auto_increment,
    descricao varchar(20) not null,

    primary key (id)
);

alter table regime_trabalho
add constraint uk_regime_trabalho unique (descricao)