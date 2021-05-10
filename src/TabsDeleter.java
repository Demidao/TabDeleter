import java.io.*;

public class TabsDeleter {

    /*
    Вставляем ПОЛНЫЙ путь текстового файла в SOURCE_FILE.
    Для удобства в папке src есть theCode.txt, можно работать с ним.
    В сам файл вставляем код из идеи, сохраняем файл и Alt+Shift+F10
     */
    private static final String SOURCE_FILE = "СЮДА_ВСТАВЛЯЕМ_ПОЛНЫЙ_ПУТЬ_ФАЙЛА";

    public static void main(String[] args) {
        deleteAllTabs();
    }

    public static void deleteAllTabs() {
        try (BufferedReader reader = new BufferedReader(new FileReader(SOURCE_FILE));
             BufferedWriter writer = new BufferedWriter(new FileWriter(SOURCE_FILE, true))) {
            writer.write("\n\n\n");
            writer.write("*******************************************************\n");
            writer.write("*******************************************************\n");
            writer.write("*******************************************************\n");

            /*
            Всё, что будет ниже этих звезд, будет без табов лишних.
             */

            String line = reader.readLine();
            while (line != null) {
                if (line.startsWith("    ")) {
                    writer.write(line.substring(4) + "\n");
                } else {
                    writer.write(line + "\n");
                }
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("The code has been successfully cleaned... В общем, все успешно прошло...");
    }
}
