## Java Stream
#### Bước 1: Tạo class Person, đọc dữ liệu person từ file json và lưu vào List Person.

![image](screenshots/person.png)
![image](screenshots/fetchData.png)


#### Bước 2: FilterList tuổi >=20 && <= 30 dùng stream().filter().collect() 
![image](screenshots/filter-age.png)


#### Bước 3: Lấy tuổi trung bình dùng mapToInt().average()
![image](screenshots/getAvg.png)

#### Bước 4: Lấy tuổi trung bình theo từng nước 
    - Set<String> filtered nationality từ list 
    - Filter.mapToInt().average() cho từng nationality
![image](screenshots/avgByCountry.png)
