-- 创建数据库
create database study_system;

-- 使用数据库
use study_system;

-- 删除表
drop table if exists eresult;
drop table if exists exam;
drop table if exists info;
drop table if exists question;
drop table if exists resources;
drop table if exists user;

-- 用户表
create table user
(
    id       int unsigned primary key auto_increment comment 'ID',
    username varchar(20) not null unique comment '用户名',
    password varchar(32) comment '密码',
    email    varchar(50) comment '邮箱',
    sex      enum ('male', 'female') comment '性别(male|female)',
    phone    varchar(20) comment '手机号',
    age      int comment '年龄',
    role     varchar(10) default 'user' comment '角色(admin|user)',
    state    varchar(10) default 'default' comment '账号状态(default|freeze|audit)'
) comment '用户表';

-- 学习资源表
create table resources
(
    id    int unsigned primary key auto_increment comment 'ID',
    name  varchar(255) not null comment '名称',
    uname varchar(255) not null comment 'uid名称',
    time  datetime     not null comment '上传时间'
) comment '学习资源表';

-- 题库表
create table question
(
    id      int unsigned primary key auto_increment comment 'ID',
    title   varchar(255)                    not null comment '标题',
    content text                            not null comment '题目内容',
    options text                            not null comment '选项内容',
    level   enum ('easy', 'common', 'hard') not null comment '难度(easy|common|hard)',
    type    varchar(20)                     not null comment '题目类型',
    answer  varchar(10)                     not null comment '答案'
) comment '题库表';

-- 考公信息表
create table info
(
    id      int unsigned primary key auto_increment comment 'ID',
    user_id int unsigned               not null comment '发布人ID',
    title   varchar(255)               not null comment '标题',
    content text comment '内容',
    type    enum ('public', 'private') not null comment '类型(公告|个人)',
    time    date                       not null comment '发布时间',
    constraint fk_info_user foreign key (user_id) references user (id) on update cascade on delete cascade-- 外键约束
) comment '考公信息表';

-- 考试表
create table exam
(
    id         int unsigned primary key auto_increment comment 'ID',
    start_time datetime     not null comment '开始时间',
    end_time   datetime     not null comment '结束时间',
    rule       varchar(1000) comment '规则',
    num        int unsigned not null comment '题目数量'
) comment '考试表';

-- 考试记录表
create table eresult
(
    id      int unsigned primary key auto_increment comment 'ID',
    exam_id int unsigned not null comment '考试ID',
    user_id int unsigned not null comment '考试者ID',
    score   varchar(10)  not null comment '分数',
    record  text         not null comment '结果记录',
    constraint fk_result_exam foreign key (exam_id) references exam (id) on update cascade on delete cascade, -- 外键约束
    constraint fk_result_user foreign key (user_id) references user (id) on update cascade on delete cascade -- 外键约束
) comment '考试记录表';
