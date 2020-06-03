package com.cb.colorbrain.service;

import com.cb.colorbrain.model.File;
import com.cb.colorbrain.model.Post;
import com.cb.colorbrain.model.Response;
import com.cb.colorbrain.repository.FileRpository;
import com.cb.colorbrain.repository.PostRepository;
import com.google.common.io.Files;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class FileService {

    @Autowired
    private FileRpository fileRpository;

    @Autowired
    private PostRepository postRepository;

    private static String uploadPath = "/E:/JavaProjects/TEST/ColorBrain/uploads";

    public List<File> getAllFileByPostId(Long postId) {
        return fileRpository.getAllByActiveTrueAndPostIdOrderByQueueAsc(postId);
    }

    public Response updateCover(Long fileId, Long postId) {
        try {
            com.cb.colorbrain.model.File fileFromDb = fileRpository.getOne(fileId);
            fileRpository.refreshQueue(postId);
            fileFromDb.setQueue(1);
            fileRpository.save(fileFromDb);
            return new Response("Cover fotosu uğurla dəyişdirildi", 1);
        } catch (Exception ex) {
            return new Response("Xəta", 1);
        }
    }

    public Response updateFiles(Long postId, List<MultipartFile> files) {
        try {
            saveMultiple(postRepository.getOne(postId), files);
            return new Response("Yeni fayllar uğurla əlavə edildi.", 1);
        } catch (IOException ex) {
            ex.printStackTrace();
            return new Response("Xəta", 0);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new Response("Xəta", 0);
        }
    }

    public static String saveSingle(MultipartFile file) throws IOException {
        String resultFilename = "";
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            java.io.File uploadDir = new java.io.File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            resultFilename = uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new java.io.File(uploadPath + "/" + resultFilename));
        }
        return resultFilename;
    }

    public void saveMultiple(Post post, List<MultipartFile> files) throws IOException {
        if (files.size() != 0) {
            for (MultipartFile fileFromForm : files) {
                File file = new File();
                String fileName = saveSingle(fileFromForm);
                file.setPostId(post.getId());
                file.setFileName(fileName);
                file.setQueue(0);
                extensionDetector(file, fileName);
                fileRpository.save(file);
            }
        }
    }

    private void extensionDetector(File file, String fileName) {
        switch (Files.getFileExtension(fileName)) {
            case "jpg":
            case "png":
            case "jpeg":
            case "img":
                file.setFileType(2);
                break;
            case "mp4":
            case "webm":
            case "flv":
            case "wmv":
                file.setFileType(3);
                break;
            case "mp3":
            case "m4p":
            case "msv":
                file.setFileType(4);
                break;
            case "pdf":
                file.setFileType(5);
                break;
            default:
                file.setFileType(0);
        }
    }

    public Response deleteFile(Long postId, Long fileId) {
        try {
            File file = fileRpository.getOne(fileId);
            fileRpository.delete(file);
            return new Response("Fayl uğurla silindi", 1);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new Response("Xəta", 0);
        }
    }
}
