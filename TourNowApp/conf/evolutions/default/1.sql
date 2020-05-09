# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table car (
  id                            integer auto_increment not null,
  registration_number           integer,
  model                         varchar(255),
  manufacturer                  varchar(255),
  price                         integer,
  city                          varchar(255),
  constraint pk_car primary key (id)
);


# --- !Downs

drop table if exists car;

