# Ödev - 4 ve 5. Hafta

Bu haftaki göreviniz swapper uygulamasının bazı modullerini tamamlamanızı bekliyoruz.

## **Görev**

Swapper uygulamasının yönettiği 4 adet entity'yi tanımladık (`com.gokhantamkoc.javabootcamp.odevhafta45.model` java `package` altında bulabilirsiniz).
Bu entity'lere iş mantığını yönetecek `service`, veriyi kayıt edecek/güncelleyecek `repository` paketleri de tanımlı halde. Ancak bazı kısımları eksik kaldı. Sizden bu eksik kısımları tamamlamanızı bekliyoruz.

**Yapılacaklar:**


1. `Product` objelerinin veritabanına kayıt edilebilmesi, güncellenebilmesi ve uygulamada görüntüleyebilmek için gereken kodun yazılmasını bekliyoruz.
2. `Order` ve `Owner` arasındaki Entity-Relationship ilişkisini yönetecek kodun yazılmasını bekliyoruz.

> **ÖNEMLİ UYARI 1:** Doldurmanız gereken metodları tanımladık. Eğer diğer kodları değiştirmeye kalkarsanız ödevinizi tamamlayamazsınız.
>
> **ÖNEMLİ UYARI 2:** Veritabanı üzerinde mantığı `{root_project_folder}/compose/db/init.sql` altında tanımladık. Sizden bu mantığı yönetebilecek kodlamayı yapmanızı bekliyoruz. Projede docker-compose bulunmaktadır.
>
> **ÖNEMLİ UYARI 3**: Ödevi gerekli araştırmaları yapmadan başlamanızı önermiyoruz. Hafta 5'deki anlattığımız gibi; internet üzerinden araştırdıktan sonra bu ödevi tamamlamanız kolay olacaktır. Araştırmanızı tamamladıktan sonra kod incelemesi yapmanızı şiddetle tavsiye ediyoruz.
> 
> **ÖNEMLİ UYARI 4**: `Repository` sınıflarını yazarken mutlaka `jdbc`nin `PreparedStatement` özelliğini kullanın.
>
> **ÖNEMLİ UYARI 5**: Veritabanı testlerini classroom job'lari ile yapmayı daha öğrenmediğimiz için kodları manuel olarak deneyip notlandırma yapacağız.
> 
> **İPUCU:** Product objesi için CRUD işlemleri yazılırken sizin için tamamladığımız OwnerService kodlarını referans alabilirsiniz.

## İnternette Araştırma Yapmak için Yararlı Anahtar Kelimeler

- How to draw an ER Diagram?
- CRUD Operations with JDBC
- Repository/DAO Pattern
- Executing SQL Query in DBeaver

## Meraklıysanız Buyurun!

Bu ödevde design pattern (Spring Boot ve Java sağladığı pattern'ler dışında) kullandım.
Bakalım hangisi olduğunu bulabilecek misiniz. (Bunu bulmak ödevin görevlerinden değildir!)
Derste veya Office Hours da bu konuda konuşacağız.

Kolaylıklar diliyorum.
