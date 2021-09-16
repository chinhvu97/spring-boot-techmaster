## Cách làm:
- Tạo RestController RestBook để xử lí trả về json
- Tạo thêm BookService để xử lí logic, tránh trùng lặp code tại Controller
### Chuẩn bị
#### Cấu trúc thư mục
![structure](screenshots/structure.png)
#### Tạo class BookService & thêm Bean ở AppConfig
![book-service](screenshots/book-service.png)
![config](screenshots/config.png)

### GetMapping
1. Controller
- Autowire BookService
- Nhận id từ param và truyền xuống Service

![getRestBook](screenshots/getRestBook.png)
2. Service
- truyền xuống Repository và nhận về Optional Book
- Chuyển Optional<Book> về Book (nếu optional == null -> return null)

![getBookService](screenshots/getBookService.png)
3. Repo
- Tìm Book bằng stream.filter (giả định là Id không trùng nhau)

![getBookRepo](screenshots/get-book-repo.png)
 
4. Test

![list](screenshots/book-list.png)
![postman](screenshots/postman-get.png)
### PostMapping
1. Controller
- Nhận param id, title, description
- truyền xuống Service

![controller-post](screenshots/controller-post.png)
2. Service & Repo
- Thêm sách vào collection

![service-post](screenshots/service-post.png)

![repo-post](screenshots/repo-post.png)
3. Test
  
![test-post](screenshots/test-post.png)

### PutMapping
1. Controller
- Nhận param id, title, description và truyền xuống Service 
- Trong trường hợp id chưa tồn tại thì ta sẽ tạo một Book mới

![controller-put](screenshots/controller-put.png)
2. Service
- Tìm Book bằng id (hàm getBook)
- Update book tìm được (nếu trống trường nào thì ta để nguyên trường đó)
- Nếu không tìm được book => tạo book mới (hàm add(new Book))
![service-put](screenshots/service-put.png)
3. Test
![test-put](screenshots/test-put.png)
### DeleteMapping
1. Controller
- Nhận param id và truyền xuống Service

![controller-delete](screenshots/controller-delete.png)
 
2. Service
- Tìm book bằng hàm getBook, nếu tìm được thì truyền xuống Repo xóa; nếu không tìm được thì không làm gì cả

![service-delete](screenshots/service-delete.png)
 
3. Repo
- Xóa khỏi collection

![repo-delete](screenshots/repo-delete.png)
 
4. Test
![test-delete](screenshots/test-delete.png)

