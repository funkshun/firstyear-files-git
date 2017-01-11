import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TaoCommand
extends WindowAdapter
implements WindowListener,
ActionListener,
Runnable {
    private JFrame frame = new JFrame("Java Console");
    private JTextArea textArea;
    private Thread reader;
    private Thread reader2;
    private boolean quit;
    private final PipedInputStream pin = new PipedInputStream();
    private final PipedInputStream pin2 = new PipedInputStream();
    Thread errorThrower;

    public TaoCommand() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = new Dimension(screenSize.width / 2, screenSize.height / 2);
        int x = frameSize.width / 2;
        int y = frameSize.height / 2;
        this.frame.setBounds(x, y, frameSize.width, frameSize.height);
        Font source = new Font("Source Sans Pro", 0, 15);
        this.textArea = new JTextArea();
        this.textArea.setEditable(false);
        this.textArea.setFont(source);
        JButton button = new JButton("clear");
        this.frame.getContentPane().setLayout(new BorderLayout());
        this.frame.getContentPane().add((Component)new JScrollPane(this.textArea), "Center");
        this.frame.getContentPane().add((Component)button, "South");
        this.frame.setVisible(true);
        this.frame.addWindowListener(this);
        button.addActionListener(this);
        try {
            PipedOutputStream pout = new PipedOutputStream(this.pin);
            System.setOut(new PrintStream(pout, true));
        }
        catch (IOException io) {
            this.textArea.append("Couldn't redirect STDOUT to this console\n" + io.getMessage());
        }
        catch (SecurityException se) {
            this.textArea.append("Couldn't redirect STDOUT to this console\n" + se.getMessage());
        }
        try {
            PipedOutputStream pout2 = new PipedOutputStream(this.pin2);
            System.setErr(new PrintStream(pout2, true));
        }
        catch (IOException io) {
            this.textArea.append("Couldn't redirect STDERR to this console\n" + io.getMessage());
        }
        catch (SecurityException se) {
            this.textArea.append("Couldn't redirect STDERR to this console\n" + se.getMessage());
        }
        this.quit = false;
        this.reader = new Thread(this);
        this.reader.setDaemon(true);
        this.reader.start();
        this.reader2 = new Thread(this);
        this.reader2.setDaemon(true);
        this.reader2.start();
    }

    @Override
    public synchronized void windowClosed(WindowEvent evt) {
        this.quit = true;
        this.notifyAll();
        try {
            this.reader.join(1000);
            this.pin.close();
        }
        catch (Exception var2_2) {
            // empty catch block
        }
        try {
            this.reader2.join(1000);
            this.pin2.close();
        }
        catch (Exception var2_3) {
            // empty catch block
        }
        System.exit(0);
    }

    @Override
    public synchronized void windowClosing(WindowEvent evt) {
        this.frame.setVisible(false);
        this.frame.dispose();
    }

    @Override
    public synchronized void actionPerformed(ActionEvent evt) {
        this.textArea.setText("");
    }

    @Override
    public synchronized void run() {
        try {
            String input2;
            while (Thread.currentThread() == this.reader) {
                try {
                    this.wait(100);
                }
                catch (InterruptedException var1_2) {
                    // empty catch block
                }
                if (this.pin.available() != 0) {
                    input2 = this.readLine(this.pin);
                    this.textArea.append(input2);
                }
                if (!this.quit) continue;
                return;
            }
            while (Thread.currentThread() == this.reader2) {
                try {
                    this.wait(100);
                }
                catch (InterruptedException input2e) {
                    // empty catch block
                }
                if (this.pin2.available() != 0) {
                    input2 = this.readLine(this.pin2);
                    this.textArea.append(input2);
                }
                if (!this.quit) continue;
                return;
            }
        }
        catch (Exception e) {
            this.textArea.append("\nConsole reports an Internal error.");
            this.textArea.append("The error is: " + e);
        }
        if (Thread.currentThread() == this.errorThrower) {
            try {
                this.wait(1000);
            }
            catch (InterruptedException e) {
                // empty catch block
            }
            throw new NullPointerException("Application test: throwing an NullPointerException It should arrive at the console");
        }
    }

    public synchronized String readLine(PipedInputStream in) throws IOException {
        int available;
        String input = "";
        while ((available = in.available()) != 0) {
            byte[] b = new byte[available];
            in.read(b);
            if (!(input = input + new String(b, 0, b.length)).endsWith("\n") && !input.endsWith("\r\n") && !this.quit) continue;
        }
        return input;
    }

    public static void main(String[] arg) {
        new TaoCommand();
    }
}
