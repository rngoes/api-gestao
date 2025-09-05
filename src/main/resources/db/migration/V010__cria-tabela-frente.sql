create table frente (
    id bigint not null auto_increment,
    descricao varchar(20) not null,

    primary key (id)
);

alter table frente
add constraint uk_frente unique (descricao)