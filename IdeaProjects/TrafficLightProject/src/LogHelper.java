import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class LogHelper {
  private static final String LOG_FILE = "app_log.txt";
  private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

  public static void append(String objectName, String message) {
    String timestamp = LocalDateTime.now().format(DATE_FORMAT);
    String logLine = String.format("[%s] [%s] %s", timestamp, objectName, message);
    MainPanel.logPanel.appendText(logLine);

    try(BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
      writer.write(logLine);
      writer.newLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  // загрузка при старте
  public static void load() {
    try {
      if (!Files.exists(Path.of(LOG_FILE))) return;
      String content = Files.readString(Path.of(LOG_FILE));
      MainPanel.logPanel.appendText(content);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  //очистка старых логов
  public static void cleanOldLogs() {
    try {
      if (!Files.exists(Path.of(LOG_FILE))) return;
      List<String> lines = Files.readAllLines(Path.of(LOG_FILE));
      LocalDateTime now = LocalDateTime.now();
      List<String> filtered = lines.stream().filter(line -> {
        try {
          if (!line.startsWith("[")) return true;

          String dateStr = line.substring(1, 17);
          LocalDateTime time = LocalDateTime.parse(dateStr, DATE_FORMAT);
          return Duration.between(time, now).toDays() < 730;
        } catch (Exception e) {
          return true;
        }
      }).collect(Collectors.toList());

      Files.write(Path.of(LOG_FILE), filtered);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static List<String> filterByObjectName(String objectName) {
    try {
      Path p = Path.of(LOG_FILE);
      if (!Files.exists(p)) return List.of();

      List<String> all = Files.readAllLines(p);
      if (objectName == null || objectName.isBlank()) {
        return all;
      }
      return Files.readAllLines(p).stream()
          .filter(line -> line.contains("[" + objectName + "]")).collect(Collectors.toList());
    } catch (IOException e) {
      e.printStackTrace();
      return List.of();
    }
  }

}
