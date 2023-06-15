CREATE TABLE  user_work(
     作业号 int,
     船公司 varchar(20),
     船名称 varchar(20),
     作业开始时间 DATETIME(0),
     作业结束时间 DATETIME(0),
     始发时间    DATETIME(0),
     到达时间    DATETIME(0),
     作业港口 varchar(20),
     提单号 varchar(20),
     集装箱箱号 varchar(255),
     "箱尺寸（TEU）" varchar(20),
     启运地 varchar(20),
     目的地 varchar(20),
     操作 int
);

CREATE TABLE user_物流信息(
      提单号  varchar(20) PRIMARY KEY,
      货主名称 varchar(20),
      货主代码 char(18),
      "物流公司（货代）" varchar(20),
      集装箱箱号 varchar(255),
      货物名称 varchar(20),
      "货重（吨）" varchar(20)
);

CREATE TABLE user_集装箱动态(
     流水号 int,
     堆存港口 varchar(20),
     集装箱箱号 varchar(20),
      "箱尺寸（TEU）" varchar(20),
     提单号 varchar(20),
     堆场位置 varchar(20),
     操作 varchar(20),
     操作日期 DATE
);
CREATE TABLE user_客户信息(
    客户编号 char(18) PRIMARY KEY,
    客户名称 varchar(20),
    手机号 char(11),
    省市区 varchar(50)
);
CREATE TABLE user_物流公司(
      公司号 int,
      公司名称 varchar(20),
      客户编号 char(18),
      联系人 varchar(20),
      电话 char(11),
      省市区 varchar(50)
);

CREATE SEQUENCE ww
INCREMENT BY 1
START WITH 1
MAXVALUE 999999999
NOCYCLE
CACHE 20
ORDER;

CREATE SEQUENCE dd
INCREMENT BY 1
START WITH 1
MAXVALUE 999999999
NOCYCLE
CACHE 20
ORDER;

CREATE SEQUENCE cc
INCREMENT BY 1
START WITH 1
MAXVALUE 999999999
NOCYCLE
CACHE 20
ORDER;

ALTER TABLE user_物流公司
MODIFY (
  公司号 NUMBER DEFAULT cc.NEXTVAL PRIMARY KEY
);
ALTER TABLE user_work
MODIFY (
  作业号 NUMBER DEFAULT ww.NEXTVAL PRIMARY KEY
);
ALTER TABLE user_集装箱动态
MODIFY (
  流水号 NUMBER DEFAULT dd.NEXTVAL PRIMARY KEY
);

select * from user_物流公司
drop table user_work;
drop table user_客户信息;
drop table user_物流信息;
drop table user_集装箱动态;
drop table user_物流公司;
drop table 物流;

insert into user_work (船公司,船名称,作业开始时间,作业结束时间,始发时间,到达时间,作业港口,提单号,集装箱箱号,"箱尺寸（TEU）",启运地,目的地,操作) values('创新船舶','宜江897','2022-10-05 05:44:49','2022-10-05 18:44:49','2022-10-05 19:44:49','2022-10-09 16:44:49','苏州港','TKNG2924820','YWCM8054','20','苏州港','铜陵港',1)

CREATE table dt(
	日期 date,
	时间 time,
	日期时间 datetime
);

insert into dt(日期,时间,日期时间)values('2022-1-1','12:12:12','2022-1-1 01:12:12')
select * from user_work

insert into user_work("船公司	","船名称","作业开始时间","作业结束时间","始发时间","到达时间","作业港口","提单号","集装箱箱号","箱尺寸（TEU）","启运地","目的地",操作) values('创新船舶','宜江897','2022-10-05 05:44:49','2022-10-05 18:44:49','2022-10-05 19:44:49','2022-10-09 16:44:49','苏州港','TKNG2924820','YWCM8054','20','苏州港','铜陵港',1)
