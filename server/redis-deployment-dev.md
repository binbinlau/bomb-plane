#redis 版本为5.0.5，部署在测试服务器192.168.1.126，集群部署
docker run -d --privileged -p 7381:7381 -p 17381:17381 -v /data/env/redis-cluster/7381/db:/data/env/redis/db -v /data/env/redis-cluster/7381/redis.conf:/data/env/redis/redis.conf --name redis-7381 redis5
docker run -d --privileged -p 7382:7382 -p 17382:17382 -v /data/env/redis-cluster/7382/db:/data/env/redis/db -v /data/env/redis-cluster/7382/redis.conf:/data/env/redis/redis.conf --name redis-7382 redis5
docker run -d --privileged -p 7383:7383 -p 17383:17383 -v /data/env/redis-cluster/7383/db:/data/env/redis/db -v /data/env/redis-cluster/7383/redis.conf:/data/env/redis/redis.conf --name redis-7383 redis5
docker run -d --privileged -p 7384:7384 -p 17384:17384 -v /data/env/redis-cluster/7384/db:/data/env/redis/db -v /data/env/redis-cluster/7384/redis.conf:/data/env/redis/redis.conf --name redis-7384 redis5
docker run -d --privileged -p 7385:7385 -p 17385:17385 -v /data/env/redis-cluster/7385/db:/data/env/redis/db -v /data/env/redis-cluster/7385/redis.conf:/data/env/redis/redis.conf --name redis-7385 redis5
docker run -d --privileged -p 7386:7386 -p 17386:17386 -v /data/env/redis-cluster/7386/db:/data/env/redis/db -v /data/env/redis-cluster/7386/redis.conf:/data/env/redis/redis.conf --name redis-7386 redis5
docker exec -it redis-7381 redis-cli --cluster create 192.168.1.126:7381 192.168.1.126:7382 192.168.1.126:7383 192.168.1.126:7384 192.168.1.126:7385 192.168.1.126:7386 --cluster-replicas 1
#####redis.conf 修改
# port 7381  根据文件路径，7382,7383 .....
# cluster-enabled yes
# cluster-config-file nodes-7381.conf
#  cluster-node-timeout 5000
#####-p 7381:7381 -p 17381:17381 将redis的端口号和端口号+1000的端口号同时打开，否则集群创建失败