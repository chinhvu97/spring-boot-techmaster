## Car Thymleaf
### Lưu ý: 
- Project chỉ sort được list của tất cả car tại home.html
- Khi tìm bằng keyword ra list -> sort thì chưa làm được
- Project sử dụng bootstrap để tạo nav-bar, buttons & modal
### Project structure
![Structure](screenshots/structure.png)
### Fetch data from json file
- Add dependency\
![add-dependency](screenshots/json-dependency.png)
- Json File
  ![add-dependency](screenshots/json-file.png)
- Read data from json\
![repo-fetch-data](screenshots/repo-fetch-data-json.png)
### GetMapping: Return List Car: All, Find by keyword, Sort By Price
- Ý tưởng: để hết trong home.html, tùy vào biến keyword/sort có được truyền vào không mà render ra list
  - Controller
![controller-getmapping](screenshots/controller-get-mapping-home.png)
  - Repo (Thêm dependency commonlang để dùng StringUtils)
![service-findByKeyword](screenshots/repo-find-keyword.png)
![common-lang](screenshots/common-lang.png)
  - Thymeleaf
![view-search](screenshots/view-list.png)
![view-search](screenshots/view-search.png)
![view-sort](screenshots/view-sort.png)
  - Test
    - home
  ![test-home](screenshots/test-home.png)
    - search
  ![test-search](screenshots/test-search.png)
    - sort
  ![test-sort](screenshots/test-sort.png)
  
### PostMapping: Add new car - direct sang trang add (Không cho update id)
![controller-add](screenshots/controller-add.png)
    (Service & Repo chỉ đơn giản là add vào list)
  - Thymeleaf: add link ở nav-bar
![view-add](screenshots/view-add.png)
  - Test
    ![test-add](screenshots/test-add.png)
### Update car (dùng Get & Post (tương tự PutMapping))
- Controller
![controller-update](screenshots/controller-edit.png)
![view-edit](screenshots/view-edit.png)
- update.html
![view-update-html](screenshots/update-html.png)
- Test
![test-update](screenshots/test-edit.png)
### Delete: dùng GetMapping delete và redirect lại home
> Thêm modal: modal xuất hiện để confirm xóa car
- Controller
![controller-delete](screenshots/controller-delete.png)
  (Service & Repo chỉ đơn giản là xóa đi)
- Thymeleaf:
  - Button toggle modal:
    - button
  ![button](screenshots/view-button.png)
    - modal
  ![button](screenshots/view-modal.png)
- Test: 
![test-delete](screenshots/test-delete.png)
