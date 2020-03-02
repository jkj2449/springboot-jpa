create table comment (
    id bigint not null auto_increment,
    created_date datetime,
    modified_date datetime,
    author varchar(255),
    comment varchar(200) not null,
    primary key (id)
) engine=InnoDB;

create table posts (
    id bigint not null auto_increment,
    created_date datetime,
    modified_date datetime,
    author varchar(255),
    content varchar(1000) not null,
    title varchar(200) not null,
     primary key (id)
) engine=InnoDB;