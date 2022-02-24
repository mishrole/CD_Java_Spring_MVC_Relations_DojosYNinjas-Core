Create database cd_spring_dojosninjas;
Use cd_spring_dojosninjas;

Create table dojos (
	id int primary key auto_increment,
    name varchar(255) not null,
    createdAt datetime,
    updatedAt datetime
);

Create table ninjas (
	id int primary key auto_increment,
    firstName varchar(255) not null,
    lastName varchar(255) not null,
    age int not null,
    createdAt datetime,
    updatedAt datetime,
    dojo_id int not null,
    foreign key (dojo_id) references dojos(id)
);
