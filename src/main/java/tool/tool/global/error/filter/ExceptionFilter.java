package tool.tool.global.error.filter;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.filter.OncePerRequestFilter;
import tool.tool.global.error.ErrorResponse;
import tool.tool.global.error.exception.ErrorCode;
import tool.tool.global.error.exception.ErrorProperty;
import tool.tool.global.error.exception.ToolException;
import tool.tool.global.security.jwt.exception.ExpiredTokenException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RequiredArgsConstructor
public class ExceptionFilter extends OncePerRequestFilter {

    private final ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try{
            filterChain.doFilter(request, response);
        } catch (ExpiredTokenException e) {
            writeErrorResponse(e.getErrorProperty(), response);
        } catch (ToolException e) {
            writeErrorResponse(e.getErrorProperty(), response);
        } catch (Exception e) {
            if (e.getCause() instanceof ToolException) {
                writeErrorResponse(((ToolException) e.getCause()).getErrorProperty(), response);
            } else {
                e.printStackTrace();
                writeErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR, response);
            }
        }
    }

    private void writeErrorResponse(ErrorProperty errorProperty, HttpServletResponse response) throws IOException {
        response.setStatus(errorProperty.getStatus());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.getWriter().write(
                objectMapper.writeValueAsString(
                        new ErrorResponse(errorProperty)
                )
        );
    }

}
