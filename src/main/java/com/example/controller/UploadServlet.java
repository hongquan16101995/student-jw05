package com.example.controller;

import java.io.IOException;
import java.io.File;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet{
 private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Kiểm tra nếu form có enctype là multipart/form-data
        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                // Link thư mục chứa file (lưu ý tự đổi theo từng máy cá nhân)
                String uploadPath = "C:/Users/ADMIN/Desktop/ME";
                // Tạo link thư mục, kiểm tra thư mục tồn tại chưa
                // Nếu chưa tồn tại, tạo mới thư mục
                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()) {
                    uploadDir.mkdir();
                }

                // Xử lý các file upload
                List<FileItem> formItems = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                if (formItems != null && formItems.size() > 0) {
                    for (FileItem item : formItems) {
                        // Kiểm tra nếu là file
                        if (!item.isFormField()) {
                            String fileName = new File(item.getName()).getName();
                            String filePath = uploadPath + "/" + fileName;
                            File storeFile = new File(filePath);
                            
                            // Lưu tệp lên server
                            item.write(storeFile);
                        }
                    }
                }
            } catch (Exception ex) {
                request.setAttribute("message", "Đã xảy ra lỗi: " + ex.getMessage());
            }
        }
        // Chuyển tiếp về trang JSP thông báo kết quả
        request.getRequestDispatcher("/students").forward(request, response);
    }
}
