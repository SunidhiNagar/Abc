package utility;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import javax.activation.MimetypesFileTypeMap;

public final class FileUtil {

    private FileUtil() {
        // Private constructor to prevent instantiation
    }

    public static boolean isValidFile(String base64String) {
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(base64String);
            // Check if the decoded bytes are valid by attempting to read them
            new ByteArrayInputStream(decodedBytes).read();
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public static String getFileMimeType(String base64String) {
        byte[] decodedBytes = Base64.getDecoder().decode(base64String);
        File tempFile = null;
        try (ByteArrayInputStream bais = new ByteArrayInputStream(decodedBytes)) {
            tempFile = File.createTempFile("temp", null);
            try (FileOutputStream out = new FileOutputStream(tempFile)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = bais.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
            }
            return new MimetypesFileTypeMap().getContentType(tempFile);
        } catch (IOException e) {
            return "unknown/unknown";
        } finally {
            if (tempFile != null && tempFile.exists()) {
                tempFile.delete();
            }
        }
    }

    public static int getFileSizeInKB(String base64String) {
        byte[] decodedBytes = Base64.getDecoder().decode(base64String);
        return decodedBytes.length / 1024;
    }
}
