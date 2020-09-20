create table t_order (
    `id` int(11) not null auto_increment primary key ,
    `user_id` int(11) default null comment '用户id',
    `product_id` int(11) default null comment '产品id',
    `count` int(11) default null comment '数量',
    `price` decimal(11, 0) default null comment '价格',
    `status` int(1) default null comment '订单状态：0：创建中；1：已完成'
) engine=innodb auto_increment=7 default charset=utf8;

select * from seata_order.t_order;


create table t_storage (
    `id` int(11) not null auto_increment primary key ,
    `product_id` int(11) default null comment '产品id',
    `total` int(11) default null comment '总库存',
    `used` int(11) default null comment '已用库存',
    `residue` int(11) default null comment '剩余库存'
) engine=innodb auto_increment=2 default charset=utf8;

insert into seata_storage.t_storage(`id`, `product_id`, `total`, `used`, `residue`)
values (1, 1, 100, 0, 100);

select * from seata_storage.t_storage;

create table t_account (
    `id` int(11) not null auto_increment primary key ,
    `user_id` int(11) default null comment '用户id',
    `total` decimal(10, 0) default null comment '总额度',
    `used` decimal(10, 0) default null comment '已用额度',
    `residue` decimal(10, 0) default null comment '剩余可用额度'
) engine=innodb auto_increment=1 default charset=utf8;

insert into seata_account.t_account(id, user_id, total, used, residue) VALUES (1, 1, 1000, 0, 1000);

select * from seata_account.t_account;