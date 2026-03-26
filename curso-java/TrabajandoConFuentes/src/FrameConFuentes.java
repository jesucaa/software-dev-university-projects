import java.awt.Color;
import javax.swing.JFrame;

public class FrameConFuentes extends JFrame {
    public FrameConFuentes() {
        setTitle("Frame con fuentes");
        setSize(600, 400);
        PanelConFuentes panel = new PanelConFuentes();
        panel.setForeground(Color.blue);
        add(panel);
    }
}
