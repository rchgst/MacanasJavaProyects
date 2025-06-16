import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TeGarcho extends JFrame {
    private JLabel preguntita;
    private Respuestas resp;

    public TeGarcho(){
        setSize(400,100);
        setLayout(new BorderLayout());
        this.preguntita=new JLabel("TE RECONTRA DETONO LA COLA?");
        this.resp=new Respuestas(this);
        add(preguntita,BorderLayout.NORTH);
        add(resp,BorderLayout.CENTER);
        this.resp.getRespuestita2().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                resp.getRespuestita2().setText("SI PORFA Q RICO");
            }
            @Override
            public void mouseExited(MouseEvent e) {
                resp.getRespuestita2().setText("MMM... no gracias!");
            }
        });
    }

}
