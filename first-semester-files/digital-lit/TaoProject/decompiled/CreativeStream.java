import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.LineNumberReader;
import java.io.PrintStream;
import java.io.Reader;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class CreativeStream
implements Runnable {
    private String name;
    private String filepath;
    private String[] lines;
    private Scanner sc;
    private File file;
    private int lineNumber;

    public CreativeStream(String name) {
        this.name = name;
        try {
            Scanner sc;
            File file = null;
            String resource = "" + name + ".txt";
            URL res = this.getClass().getResource(resource);
           
            if (res.toString().startsWith("jar:")) {
                try {
                    int read;
                    InputStream input = this.getClass().getResourceAsStream(resource);
                    file = File.createTempFile("tempfile", ".tmp");
                    FileOutputStream out = new FileOutputStream(file);
                    byte[] bytes = new byte[1024];
                    while ((read = input.read(bytes)) != -1) {
                        out.write(bytes, 0, read);
                    }
                    file.deleteOnExit();
                }
                catch (IOException input) {}
            } else {
                file = new File(res.getFile());
               // System.out.println(file.getName());
            }
            //System.out.println(file.getName());
            this.sc = sc = new Scanner(file);
            LineNumberReader lnr = new LineNumberReader(new FileReader(file));
            lnr.skip(Long.MAX_VALUE);
            //System.out.println(lnr.getLineNumber());
            lines = new String[lnr.getLineNumber() + 1];
            lineNumber = (lnr.getLineNumber() + 1);
            lnr.close();
        }
        catch (FileNotFoundException e2) {
            System.out.print("File error: " + e2.getMessage());
        }
        catch (IOException e2) {
            // empty catch block
        }
        stanzanator();
    }

    @Override
    public void run() {
        for (int i = 0; i < 40; ++i) {
            try {
                System.out.println(this.outputLine());
                TimeUnit.MILLISECONDS.sleep(250);
                continue;
            }
            catch (InterruptedException var2_2) {
                // empty catch block
            }
        }
    }

    private void stanzanator() {
        System.out.println("Stanzanting");
        int count = 0;
        for(int i = 0; i < lineNumber; i++) {
            lines[i] = sc.nextLine();
            System.out.println("Line Read");
            
        }
    }

    private String outputLine() {
        int id = (int)(Math.random() * lines.length);
        return this.lines[id];
    }
}

