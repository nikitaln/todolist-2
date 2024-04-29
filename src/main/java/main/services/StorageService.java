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

    @Value("${upload.path}")   //значение из application.properties (место сохранения картинки)
    String uploadPath;



    public String savePersonalImage(User user, MultipartFile file) throws IOException {

        String resourceURI = null;
        String newFilename = String.valueOf(user.getId()) + "_" + user.getSurname() + "_" + user.getName(); // 1_Луканин_Никита.jpg

        System.out.println("Путь к папке - " + uploadPath);
        System.out.println("имя файла - " + file.getName());
        System.out.println("имя файла оригинал - " + file.getOriginalFilename());


        if (!file.isEmpty()) {
            if (!new File(uploadPath).exists()) {
                Files.createDirectories(Paths.get(uploadPath));
                System.out.println("Создали папку " + uploadPath);
            }

            String fileFormat = FilenameUtils.getExtension(file.getOriginalFilename()); //формат - расширение

            Path path = Paths.get(uploadPath,file.getOriginalFilename());

            file.transferTo(path);

            File oldFile = new File(path.toString());
            File newFile = new File(uploadPath + "\\" + newFilename + "." + fileFormat);
            oldFile.renameTo(newFile);

            resourceURI = "\\todolist-img\\" + newFile.getName();
            System.out.println("новый путь = " + newFile.getPath());

            System.out.println("resourceURI - " + resourceURI);
            System.out.println("path - " + path);


        }

        return resourceURI;
    }
}
