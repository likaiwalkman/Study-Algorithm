# Study-Algorithm
dijkstra: Dijkstra Algorithm

backpack: Backpack Problem

stack：二叉树的非递归（迭代）实现

#Dubbo在Zookeeper上的注册的路径：
                      root(/)
                       /
                      /
                    dubbo
                    /
                   /
                 com.pajk.message.api.SmsService
                 /   \              \        \
                /     \              \        \
          consumers  configurators routers    providers
             /                                        \
            /                                          \  
           /                                            \
          /                                              \ 
         /                                                \
 consumer://10.255.134.103/com.pajk.message.api.SmsService?\
 application=dubbo-service-plaza-admin                      \
 &category=consumers                                         \
 &check=false&dubbo=2.5.3.14                                  \
 &interface=com.pajk.message.api.SmsService                    \
 &methods=getTplKeysBySys,operationalSend,sendBatch,            \
 queryQueueLength,queryMessageList,querySPBalance,send,          \
 queryMessageListCount,sendDelay                                  \
 &pid=91488                                                        \
 &revision=1.7.9                                                    \
 &side=consumer                                                      \
 &timeout=60000                                                       \
 &timestamp=1498111878812                                              \
 &version=LATEST                                                        \
                                               dubbo://10.255.133.139:20880/com.pajk.message.api.SmsService?
                                               anyhost=true
                                               &application=message
                                               &dubbo=2.5.3.14
                                               &interface=com.pajk.message.api.SmsService
                                               &methods=getTplKeysBySys,operationalSend,send,queryQueueLength,
                                               querySPBalance,queryMessageList,sendDelay,sendBatch,queryMessageListCount
                                               &pid=88006
                                               &revision=1.8.6-SNAPSHOT
                                               &side=provider
                                               &timestamp=1498109581086
                                               &version=LATEST
             

