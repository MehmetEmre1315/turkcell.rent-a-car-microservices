# Rent a Car Microservices
Turkcell Bootcamp Çalışması. Microservisler birbirleriyle sekron ve asekron bağlı
şekilde uygulama docker üzerinden çalışmakta.


**Api Gateway**, Tek bir port üzerinden üzerinden gelen requestler önce service discovery'e sonra uygun olan micro servise yönlendiriliyor.
8020 portunu kullanmakta. Servislerin tamamı 8020 portuna route edilmiş durumda.
Eureka Server:

http://localhost:8020/eureka/web

![Screenshot 2023-11-29 200147.png](images%2FScreenshot%202023-11-29%20200147.png)



**Keycloak ve OAuth2**, Keycloak 8080 portunu kullanıyor. 
Authorization tipi OAuth 2.0 kullanarak JWT üretiliyor.

**Discovery Server**, Spring Eureka ile aynı servis birden çok portta çalışabiliyor. 
Servisler arası bağlantı static belirtilmeden yük durumuna göre açık olan portla yapılabiliyor. 
Seçilecek Port boşta olan herhangi bir port oluyor, IDE üzerinden istenilen port seçimi yapılmakta
Eureka portu:

http://localhost:8761/


**Car Service** database olarak mongodb kullanmakta, 
6001 portunu kullanıyor, Cloudinary kullanılarak localde
bulunan resimler buluta yükleneniyor.
swagger arayüzü:

http://localhost:6001/swagger-ui/index.html#/

![Screenshot 2023-11-29 194032.png](images%2FScreenshot%202023-11-29%20194032.png)

**Rental Service** database olarak postgreSql kullanmakta,
7001 portunu kullanıyor, swagger arayüzü:

http://localhost:7001/swagger-ui/index.html#/

![Screenshot 2023-11-29 201128.png](images%2FScreenshot%202023-11-29%20201128.png)

**Customer Service** database olarak postgreSql kullanmakta,
8001 portunu kullanıyor, swagger arayüzü:

http://localhost:8001/swagger-ui/index.html#/

![Screenshot 2023-11-29 201158.png](images%2FScreenshot%202023-11-29%20201158.png)

**Notification Service** rental service ile kafka ile
async olarak bağlı.

**Docker**, yml dosyası konfigirasyonu ile uygulama dockerize edildi.

**Kafka**, zookeeper ile birlikte docker üzerinden çalışıyor. 
Rental Service üzerinden rent a car isteği atıldığında, 
Notification Service ile kafka ile asekron bağlanıyor, 
cevap Notification Service üzerinden (terminali) veriliyor. 
Kafka Manager ile kafka izleniyor.
