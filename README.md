# RMall 电子商城

RMall电子商城是一款简单的电商系统，本项目是RMall电子商城的后端系统。

 本项目提供RMall商城中用户、商品数据的管理和存储，提供对订单支付等业务的逻辑处理。本项目按照功能主要可以分成用户模块、分类模块、商品模块、购物车模块、收货地址管理模块、订单模块、支付模块等。各个模块的说明文档请查看以模块名命名的Markdown文件。

本项目需要数据库和FTP服务器进行数据及文件的存储。其中，数据库选取的是MySQL、FTP服务器为vsftpd。其相关配置属性配置如下：

#### 数据库配置

在/src/main/resources/datasource.properties配置文件中说明

```
//连接驱动设置
db.driverLocation=C:\\Users\\ylf\\.m2\\repository\\mysql\\mysql-connector-java\\5.1.6\\mysql-connector-java-5.1.6.jar
db.driverClassName=com.mysql.jdbc.Driver

//用于指定数据库的ip、端口以及database
db.url=jdbc:mysql://192.168.5.139:3306/rmall_learning?characterEncoding=utf-8
//数据库用户名和密码
db.username=root
db.password=dididada

//相关连接参数设置
db.initialSize = 20
db.maxActive = 50
db.maxIdle = 20
db.minIdle = 10
db.maxWait = 10
db.defaultAutoCommit = true
db.minEvictableIdleTimeMillis = 3600000
```

#### FTP服务器配置

在/src/main/resources/rmall.properties配置文件中说明

```
ftp.server.ip=192.168.5.139
ftp.user=ftpuser
ftp.pass=123456
ftp.server.http.prefix=http://image.rmall.com/
```

同时，需要提供对支付宝连接时的参数设置，由于本项目中采用的是沙箱模拟，需要在支付宝沙箱官网获取虚拟账户的用户名和密钥

其配置文件在/src/main/resources/zfbinfo.properties配置文件中说明

```

# 支付宝网关名、partnerId和appId
open_api_domain = https://openapi.alipaydev.com/gateway.do
mcloud_api_domain = http://mcloudmonitor.com/gateway.do
pid = 2088102172945782
appid = 2016082500309800

# RSA私钥、公钥和支付宝公钥
private_key = MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCch1bZXuEkBGqCsPo/Z6KXsKcM6w1NURGQFJIZlKOSNThZL3aNxkHPEtXXVGbOQWHXgSXh+Ic3pswxk3skwGLqxSy/g61M4h4vBtPq0a11ZpRR1zuoX4MZR7snHSIQ4B0L8VWYHvV/N/8H0X2cw1IVNa+p3XBYBH3j3eB2Sx04n7UsCw6VYPjdP5OQ4xz+cvI76CZlfCGIWPSNy5Ln3AMPrTg9c9pb4deMJ/z9vZtgTc3mHjHxKvA/k/+iRF9Ij+zofbWoiGRxMZ1MaWfrPXoLyp0M8y8d839H+nbGiY3Pfx/MAr6FsL95ji+UDjP9Ll0sbizCfCTzTClQqsx1qF2VAgMBAAECggEADI+DtZ+6e1RrY59mBW6AiqGfVhcKkzi9Kw2rh6f41EO3CNkZL1lIcKB3Tnc0ZLq0akGv04lI+HtHCXdnO1TA20wFQj0DzBadC3MF0GMRA0m+/y5BWEqJz56E8yeQU0BYtFuiXbmmQ5YvveXeqZS24oLTXNMrL7T0kTN9zqBKcP+nfyYi0SV44e/fKOREu5K2QsHGnnmKn1E6+5KaHP0Koomct1mowq+pMUD1bdcDOOROOHwrsVm/vfML4hsMYu8bKJV6N+tskIVjkb9GOx9zAEmjXVJWiM/CBtTK6FFPoV2guzuqqhGwy6Ccskdui8ILP2BacfM3VgxEQ+4PkdEloQKBgQDipWNyZJVletp5nPT2XaU7OeUtKyTDyM+c8zEsMet156U4upEnOULlfDcBvMe5eGwvng/examGrdr1pm80mazj9Z/l8qtas8rufgg0oIdW0sf28w6iMaPBWhkkPJ5HyXRbcZUqx6c4BCmD2xKPPosoOimiSEoY7bIfZXD63SgSzQKBgQCwzSi1ALxKDf+aIn6lltn9bDnpyN0ttZz+YsoGJw+T8XNe01Uvo05jfLr2vIiYpjywsS6v+XFLmRVj4qtT9p1rlhpggm19/JaHhBqeHyjqVJR1LmagVqjhSi7tuGV1gDZg0AQMFp1fSIphfkVA/ke9XyHXhUMSC49QccHZx5ZF6QKBgH9AVMGZb7f2bkvxsCfTFD5Yly/xFUdHrCl28ZjavlUIpl9fgLgBEmo+f7PeBlVAI53opQhy+me/nTxnIfDqh4PGGOzGfycB42JcKMdDijlZRySD+yddr4+TwqHx1vx/Q3FEKHhIeL6et6Bsk9MRTphbb5zJ8bBlZKj0D6cKHMHRAoGARf4iZG3THNon24RWcQWkbSBgWP4tGcBxU4AWjJMAJsiKrPqrGb3j9ZzWg4Gl7hC5rBWo7v+oa45CGpYMz6OtNH9rF9Pqttq9WQ7iXsDlOMedMjrZZBaKqw3sQC4k9Hx6ip8vSv3U9XjJV8leb1l7WywDQMhAAi/TX7x5Stcp1akCgYEAy6pWuXfbh6qZDLwGl3T4y1KeJMOsr9Bjzwlbnjz9y7NOxSuYkdaRRI/AV722LNma5pV3vleYavNBLxVSZZ6P2r+FKjAN8zkHAUDYjjM7S/L4ReoOf8aBHznvIaMOQamz2UPrY1OAZL2Vl/gFQSvlOCxVCk7RjlY/DViiiEoDpxo=
public_key = MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnIdW2V7hJARqgrD6P2eil7CnDOsNTVERkBSSGZSjkjU4WS92jcZBzxLV11RmzkFh14El4fiHN6bMMZN7JMBi6sUsv4OtTOIeLwbT6tGtdWaUUdc7qF+DGUe7Jx0iEOAdC/FVmB71fzf/B9F9nMNSFTWvqd1wWAR9493gdksdOJ+1LAsOlWD43T+TkOMc/nLyO+gmZXwhiFj0jcuS59wDD604PXPaW+HXjCf8/b2bYE3N5h4x8SrwP5P/okRfSI/s6H21qIhkcTGdTGln6z16C8qdDPMvHfN/R/p2xomNz38fzAK+hbC/eY4vlA4z/S5dLG4swnwk80wpUKrMdahdlQIDAQAB

#SHA1withRsa对应支付宝公钥
#alipay_public_key = MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDI6d306Q8fIfCOaTXyiUeJHkrIvYISRcc73s3vF1ZT7XN8RNPwJxo8pWaJMmvyTn9N4HQ632qJBVHf8sxHi/fEsraprwCtzvzQETrNRwVxLO5jVmRGi60j8Ue1efIlzPXV9je9mkjzOmdssymZkh2QhUrCmZYI/FCEa3/cNMW0QIDAQAB

#SHA256withRsa对应支付宝公钥
alipay_public_key = MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA0LoO7w7U9CEiQVGE6QhgRBnJpngHxLjICtGNW1qCMlFX/tV3jL6kHeXHKE5zT7Az6Cw83DVTvoMFt6YcvPBISaneQacp5b+JMqLVwRgiT2CrjHUVGU5uYJFmWZvJS7Rh862ATThekAOwgpsy6ICJpvHoswj0LKI3owC/bKBuuCn7GT7RUjwOknE6tGI/AYuHiEtfEaVRe74gx66bTyFNYE3NjSrzSy6DBOrsLgUtPTHw0KjiwDUE/fLR3aQzsa80pPK+267JBfNOLt/rDRJXZso8V3oegzvQo1/AI+CLijAPfup5ndaGUQph/Rpjsh+E/SyfeaRmBnfSD9+L6kE3EwIDAQAB

# 签名类型: RSA->SHA1withRsa,RSA2->SHA256withRsa
sign_type = RSA2
# 当面付最大查询次数和查询间隔（毫秒）
max_query_retry = 5
query_duration = 5000

# 当面付最大撤销次数和撤销间隔（毫秒）
max_cancel_retry = 3
cancel_duration = 2000

# 交易保障线程第一次调度延迟和调度间隔（秒）
heartbeat_delay = 5
heartbeat_duration = 900
```

### 启动设置

本项目采用Maven进行管理，并采用Tomcat服务器搭建。项目启动脚本如下

```shell
#进入git项目rmall目录
#git切换分之到rmall-v1.0
git checkout rmall-v1.0 
git fetch 
git pull 
#编译并跳过单元测试
mvn clean package -Dmaven.test.skip=true 
#删除旧的ROOT.war
rm /user/local/apache-tomcat-7.0.73/webapps/ROOT.war 
#删除tomcat下旧的ROOT文件夹
rm -rf /user/local/apache-tomcat-7.0.73/webapps/ROOT
#拷贝编译出来的war包到tomcat下-ROOT.war
cp /user/local/git-repository/rmall/target/rmall.war /user/local/apache-tomcat-7.0.73/webapps/ROOT.war 
#关闭tomcat
/user/local/apache-tomcat-7.0.73/bin/shutdown.sh 
#等待10s 
for i in {1..10} 
do 
   	echo $i"s" 
   	sleep 1s 
done 
#启动tomcat
/user/local/apache-tomcat-7.0.73/bin/startup.sh 
```

