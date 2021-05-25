create database SinhVien

go

use SinhVien

go

create table Registration(
	username nvarchar(20) not null,
	password nvarchar(50) not null,
	fullname nvarchar(50) not null,
	Role nvarchar(50) not null
)

insert into Registration values('admin','1','le huu hieu','admin')
insert into Registration values('user','1','le huu hieu','user')