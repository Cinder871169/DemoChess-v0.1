- CSDL đang dùng là SQL Server.
- T build bằng Maven => sửa file pom.xml cho nó tự cài cái driver JDBC hoặc tự tải trên mạng rồi add file jar vào reference libraries của java project(SQL Server thì tải Microsoft JDBC Driver for SQL Server, MySQL thì tải Connector-J bên Oracle).
- Hoặc nếu mì ăn liền nữa thì clone nguyên cái repository về rồi mở console gõ "mvn clean install" (đã viết sẵn file main r). (Tất nhiên là cần có sẵn maven trong máy hoặc extension pack cho java trong vscode và jdk).
- Lệnh truy vấn của SQL Server và MySQL có nhiều chỗ khác nhau. Ai dùng MySQL thì tự tìm hiểu (t không dùng kbt :v).
  ..
