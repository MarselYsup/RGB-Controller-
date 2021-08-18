 import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class RGBFrame extends JFrame   {
    private JPanel mainPanel;
    private JPanel ovalPanel;
    private JLabel redLabel;
    private JSlider redSlider;
    private JLabel greenLabel;
    private JSlider greenSlider;
    private JLabel blueLabel;
    private JSlider blueSlider;
    private int red;
    private int green;
    private int blue;

    public RGBFrame () {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,1000);
        setName("RGB Changer");
        red = 0;
        green = 0;
        blue = 0;
        add_contents();
    }

    private void add_contents(){
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2,3,5,12));
        //font for labels
        Font fontForLabels = new Font("SansSerif", Font.BOLD, 80);

        redLabel = new JLabel("Red - 0");
        redLabel.setForeground(Color.red);
        redLabel.setFont(fontForLabels);
        mainPanel.add(redLabel);

        greenLabel = new JLabel("Green - 0");
        greenLabel.setForeground(Color.green);
        greenLabel.setFont(fontForLabels);
        mainPanel.add(greenLabel);

        blueLabel = new JLabel("Blue - 0");
        blueLabel.setForeground(Color.blue);
        blueLabel.setFont(fontForLabels);
        mainPanel.add(blueLabel);

        redSlider = new JSlider(0,255,0);
        redSlider.setPreferredSize(new Dimension(400,200));
        redSlider.setMajorTickSpacing(51);
        redSlider.setMinorTickSpacing(25);
        redSlider.setPaintTicks(true);
        redSlider.setPaintTrack(true);
        redSlider.setPaintLabels(true);
        redSlider.addChangeListener(new RedChangeListener());
        mainPanel.add(redSlider);

        greenSlider = new JSlider(0,255,0);
        greenSlider.setPreferredSize(new Dimension(400,200));
        greenSlider.setMajorTickSpacing(51);
        greenSlider.setMinorTickSpacing(25);
        greenSlider.setPaintTicks(true);
        greenSlider.setPaintTrack(true);
        greenSlider.setPaintLabels(true);
        greenSlider.addChangeListener(new GreenChangeListener());
        mainPanel.add(greenSlider);

        blueSlider = new JSlider(0,255,0);
        blueSlider.setPreferredSize(new Dimension(400,200));
        blueSlider.setMajorTickSpacing(51);
        blueSlider.setMinorTickSpacing(25);
        blueSlider.setPaintTicks(true);
        blueSlider.setPaintTrack(true);
        blueSlider.setPaintLabels(true);
        blueSlider.addChangeListener(new BlueChangeListener());
        mainPanel.add(blueSlider);

        getContentPane().add(mainPanel,BorderLayout.SOUTH);

        ovalPanel = new OvalDrawPanel();
        getContentPane().add(ovalPanel,BorderLayout.CENTER);


    }

    private class RedChangeListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            redLabel.setText("Red - "+ redSlider.getValue());
            red = redSlider.getValue();
            ovalPanel.repaint();
        }
    }

    private class GreenChangeListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            greenLabel.setText("Green - "+greenSlider.getValue());
            green = greenSlider.getValue();
            ovalPanel.repaint();
        }
    }

    private class BlueChangeListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            blueLabel.setText("Blue - "+blueSlider.getValue());
            blue = blueSlider.getValue();
            ovalPanel.repaint();
        }
    }
    class OvalDrawPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(Color.WHITE);
            g.fillRect(0,0,this.getWidth(),this.getHeight());

            g.setColor(new Color(red,green,blue));
            g.fillOval(600,50,200,200);
        }
    }
}
