import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Crawler {

    public static void main(String[] args) {
        new Crawler().exec();
    }

    public void exec() {
        BufferedReader reader = null;
        int id;
        for (id = 1500; id < 1579; id++) {
            try {
                URL site = new URL("https://shurup.net.ua/.p" + id);
                reader = new BufferedReader(new InputStreamReader(site.openStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    char[] chars;
                    chars = line.toCharArray();
                    if(line.contains("<div class=\"price x-6 text-left\">")) {
                        System.out.print("Product ID: " + id + "  Price: ");
                        for (int i = 58; i < chars.length; i++) {
                            if(chars[i] == '.')
                                i = chars.length - 1;
                            System.out.print(chars[i]);
                        }
                        System.out.println("");
                    }
                }
                reader.close();
            } catch (IOException ex) {
                //
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException ex) {
                        System.out.println("Error Null");
                    }
                }
            }
        }

    }
}