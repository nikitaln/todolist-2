package main.services;

import main.dto.User;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class StorageService {

    @Value("${upload.path}")   //значение из application.properties
    String uploadPath;

    public String savePersonalImage(MultipartFile file) throws IOException {

        String resourceURI = null;
        System.out.println("Путь к папке - " + uploadPath);

        if (!file.isEmpty()) {
            if (!new File(uploadPath).exists()) {
                Files.createDirectories(Paths.get(uploadPath));
                System.out.println("Создали папку " + uploadPath);
            }

            String filename = file.getOriginalFilename();
            System.out.println("filename - " + filename);

            Path path = Paths.get(uploadPath, filename);
            System.out.println("path " + path.toString());

            resourceURI = filename;
            System.out.println("resourceURI " + resourceURI);

            file.transferTo(path);

//            File oldFileName = new File(path.toString());
//            String newFilePathWithUserName = uploadPath + "\\" + user.getSurname() + "_" + user.getName() + ".jpg";
//            System.out.println(newFilePathWithUserName);
//            File newFileName = new File(newFilePathWithUserName);
//            oldFileName.renameTo(newFileName);

        }

        return "";
    }
}
