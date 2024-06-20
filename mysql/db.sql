create table db_culture.appointment
(
    id            int auto_increment comment '主键'
        primary key,
    experience_id int null comment '体验',
    constraint appointment_id_uindex
        unique (id)
) comment '预约表' engine = InnoDB;

create table db_culture.collection
(
    id            int auto_increment comment '主键'
        primary key,
    experience_id int null comment '体验',
    constraint collection_id_uindex
        unique (id)
) comment '收藏表' engine = InnoDB;

create table db_culture.culture
(
    id         int auto_increment comment '主键'
        primary key,
    city       varchar(20) null comment '地点',
    code       varchar(5) null comment '编号',
    serial     varchar(4) null comment '序号',
    name       varchar(50) null comment '名称',
    category   int null comment '类别',
    announce   varchar(20) null comment '公布时间',
    type       varchar(10) null comment '类型',
    reporting  varchar(50) null comment '申报地区或单位',
    protection varchar(50) null comment '保护单位',
    constraint culture_id_uindex
        unique (id),
    constraint culture_estate_id_fk
        foreign key (category) references db_culture.estate (id)
) comment '文化遗产表' engine = InnoDB;

create table db_culture.estate
(
    id       int auto_increment comment '主键'
        primary key,
    category varchar(10) null comment '名称',
    constraint estate_id_uindex
        unique (id)
) comment '遗产类别表' engine = InnoDB;


create table db_culture.experience
(
    id      int auto_increment
        primary key,
    pic     varchar(255) null comment '图片',
    title   varchar(255) null comment '标题',
    intro   varchar(255) null comment '介绍',
    detail  varchar(800) null comment '详情',
    address varchar(100) null comment '地址',
    date    varchar(30) null comment '时间',
    phone   varchar(30) null comment '联系电话',
    constraint experience_id_uindex
        unique (id)
) comment '体验表' engine = InnoDB;


create table db_culture.forum
(
    id     int auto_increment
        primary key,
    pic    varchar(255) null comment '主键',
    title  varchar(255) null comment '标题',
    datail varchar(800) null comment '详情',
    date   varchar(20) null comment '时间',
    constraint forum_id_uindex
        unique (id)
) comment '论坛表' engine = InnoDB;


create table db_culture.survey
(
    id     int auto_increment comment '主键'
        primary key,
    title  varchar(255) null comment '标题',
    intro  varchar(255) null comment '介绍',
    detail varchar(800) null comment '详情',
    date   varchar(20) null comment '时间',
    constraint survey_id_uindex
        unique (id)
) comment '调研表' engine = InnoDB;


create table db_culture.user
(
    id         int auto_increment comment '主键'
        primary key,
    acc        varchar(18) null comment '账号',
    pwd        varchar(50) null comment '密码',
    pic        varchar(255) null comment '头像',
    realname   varchar(50) null comment '真实姓名',
    sex        int null comment '性别',
    age        int null comment '年龄',
    address    varchar(100) null comment '收获地址',
    postalcode varchar(6) null comment '邮政编码',
    CreateTime varchar(20) null comment '创建时间',
    constraint user_id_uindex
        unique (id)
) comment '用户表' engine = InnoDB;


