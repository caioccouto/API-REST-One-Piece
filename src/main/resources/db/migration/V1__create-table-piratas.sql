CREATE TABLE piratas(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    idade int(3) not null,
    bando varchar(100) not null,
    funcao varchar(100) not null,

    primary key(id)

)