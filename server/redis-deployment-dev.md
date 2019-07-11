######看过更大的世界后，就再也不甘心留在原地。不甘心就是动力。

###### redis 版本为5.0.5，部署在测试服务器192.168.1.126，集群部署
docker run -d --privileged --network=host -p 7381:7381 -p 17381:17381 -v /data/env/redis-cluster/7381/db:/data/env/redis/db -v /data/env/redis-cluster/7381/redis.conf:/data/env/redis/redis.conf --name redis-7381 redis5
docker run -d --privileged --network=host -p 7382:7382 -p 17382:17382 -v /data/env/redis-cluster/7382/db:/data/env/redis/db -v /data/env/redis-cluster/7382/redis.conf:/data/env/redis/redis.conf --name redis-7382 redis5
docker run -d --privileged --network=host -p 7383:7383 -p 17383:17383 -v /data/env/redis-cluster/7383/db:/data/env/redis/db -v /data/env/redis-cluster/7383/redis.conf:/data/env/redis/redis.conf --name redis-7383 redis5
docker run -d --privileged --network=host -p 7384:7384 -p 17384:17384 -v /data/env/redis-cluster/7384/db:/data/env/redis/db -v /data/env/redis-cluster/7384/redis.conf:/data/env/redis/redis.conf --name redis-7384 redis5
docker run -d --privileged --network=host -p 7385:7385 -p 17385:17385 -v /data/env/redis-cluster/7385/db:/data/env/redis/db -v /data/env/redis-cluster/7385/redis.conf:/data/env/redis/redis.conf --name redis-7385 redis5
docker run -d --privileged --network=host -p 7386:7386 -p 17386:17386 -v /data/env/redis-cluster/7386/db:/data/env/redis/db -v /data/env/redis-cluster/7386/redis.conf:/data/env/redis/redis.conf --name redis-7386 redis5
docker exec -it redis-7381 redis-cli --cluster create 192.168.1.126:7381 192.168.1.126:7382 192.168.1.126:7383 192.168.1.126:7384 192.168.1.126:7385 192.168.1.126:7386 --cluster-replicas 1
###### redis.conf 修改
##### port 7381  根据文件路径，7382,7383 .....
##### cluster-enabled yes
##### cluster-config-file nodes-7381.conf
##### cluster-node-timeout 5000
##### -p 7381:7381 -p 17381:17381 将redis的端口号和端口号+1000的端口号同时打开，否则集群创建失败
##### 使用docker时需要添加 --network=host 否则集群ip是docker分配的ip，在应用中无法使用，这样可以使用主机对应的ip及端口进行集群配置

######  测试sql 脚本
CREATE TABLE `message` (
  `uid` char(32) NOT NULL COMMENT '唯一ID',
  `fromuseruid` char(32) DEFAULT NULL COMMENT '来自谁UID',
  `fromuseroid` int(11) DEFAULT NULL COMMENT '来自谁OID',
  `fromusername` varchar(100) DEFAULT NULL COMMENT '来自谁NAME',
  `touseruid` varchar(32) DEFAULT NULL COMMENT '评论给谁的uid',
  `touseroid` int(11) DEFAULT NULL COMMENT '发给谁OID',
  `tousername` varchar(100) DEFAULT NULL COMMENT '发给谁NAME',
  `useravatar` varchar(200) DEFAULT NULL COMMENT '会员头像or网站头像',
  `title` varchar(200) DEFAULT NULL COMMENT '标题',
  `content` varchar(4000) DEFAULT NULL COMMENT '内容',
  `href` varchar(100) DEFAULT NULL COMMENT '链接',
  `state` tinyint(1) DEFAULT NULL COMMENT '未读、已读、已删除',
  `type` tinyint(1) DEFAULT NULL COMMENT '消息类型',
  `site` tinyint(1) DEFAULT NULL COMMENT '来自哪个项目',
  `sn` varchar(10) DEFAULT '' COMMENT '编号',
  `data` varchar(255) DEFAULT NULL COMMENT '其他数据json格式',
  `status` tinyint(1) DEFAULT '1' COMMENT '状态(0禁用1启用)',
  `createtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`uid`),
  UNIQUE KEY `uid` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4