# Proje Çalışması 1

![Untitled_Diagram.drawio_1.png](..%2F..%2F..%2FUsers%2Fkahra%2FDownloads%2FUntitled_Diagram.drawio_1.png)


Projenize aşağıdaki servisleri base yapıda ekleyiniz;

Keycloak
Gateway
Eureka (Service Discovery)
Rental Service & PostgreSql
Car Service MongoDb


docker-compose.yml

İlk faz için aşağıdaki özelliklerin uygulamanıza entegrasyonu beklenmektedir:

Arabaların marka,model,renk,model yılı, günlük ücret ve resim bilgisi tutulmalıdır.
Arabalar listelenebilmelidir.
Arabanın durumu o an rental servisle haberleşerek "kiralamaya uygun" veya "değil" şeklinde listeleme endpointinde gösterilmelidir.
Sisteme giriş yapan kullanıcılar tarafından araba eklenebilmelidir (şu anlık rol kontrolü gerekmiyor)
Araba servisinde aşağıdaki 5 endpoint bulunmalıdır;

GetAll

GetById

Add

Update

Delete

Bir sonraki adımlarımız Customer nesnesini oluşturmak olacak. Bu konuda da ar-ge çalışması yapmanızı rica edeceğim 
