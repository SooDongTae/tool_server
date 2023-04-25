package tool.tool.domain.image.service;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tool.tool.domain.image.exception.NoImageException;
import tool.tool.global.config.ImageConfig;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class ImageResourceService {
    private final ImageConfig imageConfig;

    public ResponseEntity<Resource> execute(String filename, HttpServletRequest request) {
        Path uploadPath = Paths.get(imageConfig.getPath());
        try {
            Path path = uploadPath.resolve(filename).normalize();
            Resource resource = new UrlResource(path.toUri());
            if(resource.exists()) {
                return getResponseEntity(resource, request);
            }
            else {
                throw NoImageException.EXCEPTION;
            }
        } catch (MalformedURLException ex) {
            throw NoImageException.EXCEPTION;
        }
    }

    private ResponseEntity<Resource> getResponseEntity(Resource resource, HttpServletRequest request) {
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ignored) {

        }
        if(contentType == null) {
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header("Content-Type",contentType)
                .body(resource);
    }
}
