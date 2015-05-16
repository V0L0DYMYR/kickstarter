create table categories (
  id integer primary key,
  name varchar(256)
);
create table projects (
  id integer primary key ,
  category_id integer,
  name varchar(256),
  description varchar(256),
  foreign key (category_id) references categories (id)
);
