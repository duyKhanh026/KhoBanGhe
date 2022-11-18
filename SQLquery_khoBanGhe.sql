create database KhoBanGhe

use KhoBanGhe
Go

create table BanGhe(
	MaBG nchar(6) primary key,
	Tensp nvarchar(50),
	NoiSX nvarchar(50),
	ChatLieu nvarchar(50),
	KichThuoc nvarchar(50),
	SoLuong smallint
)

create table LuuLS(
	MaPhieu char(6) primary key,
	MaBG  char(6),
	soluong smallint
)

create table PhieuNhap (
	MaPN char(6) primary key,
	NgayLapPN date,
	ID char(6)
)

create table PhieuXuat (
	MaPX char(6) primary key,
	NgayLapPX date,
	ID char(6)
)

create table TaiKhoan (
	ID char(6) primary key,
	Username nvarchar(50),
	Passwordd nchar(16),
	HoTen nvarchar(50),
	GioiTinh bit,
	DiaChi nvarchar(100)
)



