create table genero (
    id bigint not null auto_increment,
    descricao varchar(20) not null,

    primary key (id)
);

alter table genero
add constraint uk_genero unique (descricao)