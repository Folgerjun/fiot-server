# fiot-server
Spring Boot 2.0 + Spring Data JPA 动态切换数据源实现类似多租户功能，开发尚在进行中...

## 前言
想自己做这么个项目起初是因为所在公司的业务原因，想在公司架上云端来使得数据方便汇集并可视。

由于公司数据采集项目现在差不多是我一人在撑，所以对这个业务逻辑还是相对清楚的。物联网就在于设备多且杂，所以之前我们都是项目跑上去然后手动配置，这样的效率低不说，搞得人也会糊涂。

所以我想着就用 MongoDB 这个强大的文档数据库来作为程序初始的配置文件，一些信息配置就可以直接读取数据库来操作了，省时省力。

## 架构
这个是服务端也就是云端的代码，而并不是业主方的，所以这部分只管取数据，而至于业主方那端怎么采集数据怎么同步云端的就看各自主要业务了。

MongoDB 作为项目的一些信息配置存储地，包括用户以及对应的权限（即能查看的项目）

Redis 来作为实时数据的存取，可集群部署以防项目数量增加后影响其性能

Mysql 可用 Docker 容器部署，一个项目对应一个数据源，可动态切换获取对应数据，进而页面可视化

搭配的项目：[fiot-web](https://github.com/Folgerjun/fiot-web)

## 配置文件

MongoDB：

**USER**
```
{ 
    "_id" : ObjectId("5c08f2219924a623b4b64cc4"), 
    "userName" : "ffj",  // 用户名
    "passWord" : "ffj",  // 密码
    "authorizations" : [ // 授权可查看的项目
        "shibo", 
        "kunyi"
    ], 
    "_class" : "com.fiot.server.entity.UserEntity"
}
```

**Auth_Project_Model**
```
{ 
    "_id" : ObjectId("5c0a22a39924a62ec41883fb"), 
    "modelCollectionName" : "SHIBO_MODEL",  // 对应的项目数据表（想着 ThreeJs 用 JSON 格式的数据）
    "introduction" : "这是世博文化中心项目",  // 项目介绍
    "logoName" : "shibo-logo.png",  // 项目的 logo 图片名字
    "imgName" : "shibo-img.png", // 项目的显示图片
    "_class" : "com.fiot.server.entity.AuthProjectModel", 
    "projectName" : "shibo" // 项目名（与上表中的对应）
    
}
```

其它数据文件按照各自具体业务在项目中处理即可。