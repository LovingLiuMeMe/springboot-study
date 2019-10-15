```sql
-- ----------------------------
-- Table structure for broker_message_log
-- ----------------------------
DROP TABLE IF EXISTS `broker_message_log`;
CREATE TABLE `broker_message_log` (
  `message_id` varchar(255) NOT NULL COMMENT '消息唯一ID',
  `message` varchar(4000) NOT NULL COMMENT '消息内容',
  `try_count` int(4) DEFAULT '0' COMMENT '重试次数',
  `status` varchar(10) DEFAULT '' COMMENT '消息投递状态 0投递中，1投递成功，2投递失败',
  `next_retry` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '下一次重试时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `message_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2018091102 DEFAULT CHARSET=utf8;
```
### @RabbitListener @RabbitHandler @Payload @Headers
 `@RabbitListener` 注解标记方法，当监听到队列 debug 中有消息时则会进行接收并处理  
 `@RabbitHandler` 指定方法处理  
 使用`@Payload` 和 `@Headers` 注解可以消息中的 `body` 与 `headers` 信息  
 通过 `@RabbitListener` 的 `bindings` 属性声明 `Binding`（若 `RabbitMQ` 中不存在该绑定所需要的 `Queue`、`Exchange`、`RouteKey` 则自动创建，若存在则抛出异常）

### 序列化和反序列化
RabbitMQ 的序列化是指 Message 的 body 属性，即我们真正需要传输的内容，RabbitMQ 抽象出一个 MessageConvert 接口处理消息的序列化，其实现有 `SimpleMessageConverter`（默认）、`Jackson2JsonMessageConverter` 

### 100%可靠性投递
step1. 数据入库同时消息（msg）入库

step2.发送消息

step3.请求确认 confirm

step4.读取数据库msg消息修改状态status：1

step5.但发送消息网络中断，通过定时任务查询状态为status：0的消息

step6.抓取消息，重新投递

## RabbitMQ的基础信息