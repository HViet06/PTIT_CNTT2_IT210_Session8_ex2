Phân tích lỗi

Nhìn code bạn gửi, vấn đề nằm ở sai cơ chế binding của Spring MVC.

 Nguyên nhân chính

Bạn đang dùng:

@Valid @ModelAttribute("employee") EmployeeDto employee,
BindingResult bindingResult

 Cái này đúng cho form HTML (application/x-www-form-urlencoded)

 Nhưng lỗi 400 Bad Request - MethodArgumentNotValidException chỉ xảy ra khi:
Controller đang nhận JSON (@RequestBody)
HOẶC
Spring không bind được dữ liệu vào object
 Vì sao bindingResult không chạy?

Trong Spring MVC:

BindingResult CHỈ hoạt động khi đặt NGAY SAU object validate
Nếu sai thứ tự → Spring ném exception luôn, không vào if
 Trường hợp gây lỗi phổ biến:
public String saveEmployee(
@Valid @ModelAttribute("employee") EmployeeDto employee,
Model model,
BindingResult bindingResult //  sai vị trí
)

➡ BindingResult không đứng ngay sau employee
→ Spring không dùng nó
→ ném MethodArgumentNotValidException
→ trả về 400 trắng