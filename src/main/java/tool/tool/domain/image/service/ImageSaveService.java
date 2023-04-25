package tool.tool.domain.image.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tool.tool.global.config.ImageConfig;

import java.io.File;
import java.io.IOException;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ImageSaveService {
    private final ImageConfig imageConfig;

    public String execute(MultipartFile file) throws IOException {
        File file_ = new File(imageConfig.getPath(), getRandomStr());
        try {
            file.transferTo(file_);
        } catch (IOException e) {
            throw new IOException("can not save file", e);
        }
        return file_.getName();
    }

    private static String getRandomStr(){
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 10;
        Random random = new Random();
        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

}
