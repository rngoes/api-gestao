create table organizacao (
    id bigint not null auto_increment,
    descricao varchar(20) not null,

    primary key (id)
);

alter table organizacao
add constraint uk_organizacao unique (descricao)