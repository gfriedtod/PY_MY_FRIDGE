package view;


import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import org.jfree.chart.ChartPanel;

//import org.jfree.chart.ChartPanel;

public class view extends JFrame {

    private static final long serialVersionUID = 1L;

    // Labels
    public JLabel labelTargetTemp;
    public JLabel labelTempDHT;
    public JLabel labelTempOutside;
    public JLabel labelTempPeltier;
    public JLabel labelDewTemp;
    public JLabel labelHumidity;
    public JLabel alertCondensation;
    public JLabel alertTempAnomaly;

    public JButton buttonTargetPlus; // Target Temperature Button + (Plus)
    public JButton buttonTargetMinus; // Target Temperature Button - (Minus)


    // The chart
    public LineChart chart;

    public view() {

        setBounds(100, 100, 1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("PimpMyFridge - CommandCenter");

        JLabel labelPeltierTemperature = new JLabel("�C Peltier (Internal)");
        labelPeltierTemperature.setForeground(Color.WHITE); // Set White Color
        labelPeltierTemperature.setHorizontalAlignment(SwingConstants.CENTER); // Aligned to center
        labelPeltierTemperature.setFont(new Font("Sans Serif", Font.PLAIN, 16));


        labelTempPeltier = new JLabel("0 \u00B0C"); // �C
        labelTempPeltier.setFont(new Font("Sans Serif", Font.PLAIN, 22));
        labelTempPeltier.setForeground(new Color(241, 61, 7));
        labelTempPeltier.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel labelInternalTemperature = new JLabel("�C Internal (DHT)");
        labelInternalTemperature.setForeground(Color.WHITE); // Set White Color
        labelInternalTemperature.setHorizontalAlignment(SwingConstants.CENTER); // Aligned to center
        labelInternalTemperature.setFont(new Font("Sans Serif", Font.PLAIN, 16));


        labelTempDHT = new JLabel("0 \u00B0C"); // �C
        labelTempDHT.setFont(new Font("Sans Serif", Font.PLAIN, 22));
        labelTempDHT.setForeground(new Color(0, 174, 189));
        labelTempDHT.setHorizontalAlignment(SwingConstants.CENTER);


        JLabel labelExternalTemperature = new JLabel("�C Outside");
        labelExternalTemperature.setForeground(Color.WHITE); // Set White Color
        labelExternalTemperature.setHorizontalAlignment(SwingConstants.CENTER); // Aligned to center
        labelExternalTemperature.setFont(new Font("Sans Serif", Font.PLAIN, 16));

        labelTempOutside = new JLabel("0\u00B0 C"); // �C
        labelTempOutside.setFont(new Font("Sans Serif", Font.PLAIN, 22));
        labelTempOutside.setForeground(new Color(34, 212, 34));
        labelTempOutside.setHorizontalAlignment(SwingConstants.CENTER);


        JLabel labelTempDew = new JLabel("�C Dew");
        labelTempDew.setForeground(Color.WHITE); // Set White Color
        labelTempDew.setHorizontalAlignment(SwingConstants.CENTER); // Aligned to center
        labelTempDew.setFont(new Font("Sans Serif", Font.PLAIN, 16));

        labelDewTemp = new JLabel("0\u00B0 C"); // �C
        labelDewTemp.setFont(new Font("Sans Serif", Font.PLAIN, 22));
        labelDewTemp.setForeground(new Color(200, 51, 255));
        labelDewTemp.setHorizontalAlignment(SwingConstants.CENTER);


        /* Text for the Humidity Section */
        JLabel labelHumidityPercent = new JLabel("% Humidity"); // Create JLabel
        labelHumidityPercent.setForeground(Color.WHITE); // Set White Color
        labelHumidityPercent.setHorizontalAlignment(SwingConstants.CENTER); // Aligned to center
        labelHumidityPercent.setFont(new Font("Sans Serif", Font.PLAIN, 16));

        labelHumidity = new JLabel("0 %");
        labelHumidity.setFont(new Font("Sans Serif", Font.PLAIN, 22));
        labelHumidity.setBackground(new Color(66, 255, 66));
        labelHumidity.setForeground(new Color(248, 224, 47));
        labelHumidity.setHorizontalAlignment(SwingConstants.CENTER);


        JLabel labelTarget = new JLabel("Target");
        labelTarget.setForeground(Color.WHITE); // Set White Color
        labelTarget.setHorizontalAlignment(SwingConstants.CENTER); // Aligned to center
        labelTarget.setFont(new Font("Sans Serif", Font.PLAIN, 16));


        labelTargetTemp = new JLabel("0 \u00B0C");
        labelTargetTemp.setForeground(Color.WHITE);
        labelTargetTemp.setFont(new Font("Sans Serif", Font.PLAIN, 28));
        labelTargetTemp.setHorizontalAlignment(SwingConstants.CENTER);


        // Button Plus
        buttonTargetPlus = new JButton("+");
        buttonTargetPlus.setFont(new Font("Sans Serif", Font.BOLD, 30));
		/*buttonTargetPlus.setBorderPainted(false);
		buttonTargetPlus.setFocusPainted(false);
		buttonTargetPlus.setContentAreaFilled(false);*/

        // Button Minus
        buttonTargetMinus = new JButton("-");
        buttonTargetMinus.setFont(new Font("Sans Serif", Font.BOLD, 30));
		/*buttonTargetMinus.setBorderPainted(false);
		buttonTargetMinus.setFocusPainted(false);
		buttonTargetMinus.setContentAreaFilled(false);*/

        // Condensation Alert Text
        alertCondensation = new JLabel("Risk of condensation");
        alertCondensation.setFont(new Font("Sans Serif", Font.BOLD, 11));
        alertCondensation.setForeground(new Color(241, 61, 7));


        // Temperature Anomaly Alert Text
        alertTempAnomaly = new JLabel("Temperature Anomaly");
        alertTempAnomaly.setFont(new Font("Sans Serif", Font.BOLD, 11));
        alertTempAnomaly.setForeground(new Color(241, 61, 7));



        JPanel panelCenter = new JPanel();
        chart = new LineChart("Temperature Chart", "Internal and External Temperatures");
        ChartPanel component = new ChartPanel(chart.getJChart());

        panelCenter.add(component, "chart");

        // Instantiate Left Panel
        JPanel panelLeft = new JPanel();

        // Set Background for Left Panel
        panelLeft.setBackground(new Color(107, 106, 104));

        // We don't want borders. If borders are required, uncomment the following line :
        //panelLeft.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), null, TitledBorder.LEADING, TitledBorder.TOP));

        JPanel panelRight = new JPanel();
        panelRight.setBackground(new Color(107, 106, 104));

        // We don't want borders. If borders are required, uncomment the following line :
        //panelRight.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), null, TitledBorder.LEADING, TitledBorder.TOP));

        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.TRAILING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(panelCenter, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addComponent(panelLeft, GroupLayout.PREFERRED_SIZE, 510, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(panelRight, GroupLayout.PREFERRED_SIZE, 100, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addComponent(panelCenter, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(panelLeft, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(panelRight, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        panelCenter.setLayout(new CardLayout(0, 0));

        GroupLayout gl_panelRight = new GroupLayout(panelRight);
        gl_panelRight.setHorizontalGroup(
                gl_panelRight.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panelRight.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_panelRight.createParallelGroup(Alignment.LEADING, false)
                                        .addComponent(labelTargetTemp, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelTarget, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_panelRight.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panelRight.createSequentialGroup()
                                                .addComponent(buttonTargetMinus)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(buttonTargetPlus)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addGroup(gl_panelRight.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(alertTempAnomaly, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                                        .addComponent(alertCondensation, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))))
                                .addContainerGap())
        );
        gl_panelRight.setVerticalGroup(
                gl_panelRight.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panelRight.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_panelRight.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panelRight.createSequentialGroup()
                                                .addGroup(gl_panelRight.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(labelTarget)
                                                        .addComponent(alertTempAnomaly))
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addGroup(gl_panelRight.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(labelTargetTemp, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(gl_panelRight.createSequentialGroup()
                                                                .addComponent(alertCondensation)
                                                                .addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE))))
                                        .addGroup(gl_panelRight.createParallelGroup(Alignment.BASELINE)
                                                .addComponent(buttonTargetMinus, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(buttonTargetPlus, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        panelRight.setLayout(gl_panelRight);


        GroupLayout gl_panelLeft = new GroupLayout(panelLeft);
        gl_panelLeft.setHorizontalGroup(
                gl_panelLeft.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panelLeft.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_panelLeft.createParallelGroup(Alignment.LEADING, false)
                                        .addComponent(labelTempPeltier, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(labelPeltierTemperature, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(gl_panelLeft.createParallelGroup(Alignment.TRAILING, false)
                                        .addComponent(labelTempDHT, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(labelInternalTemperature, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(gl_panelLeft.createParallelGroup(Alignment.LEADING, false)
                                        .addComponent(labelTempOutside, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(labelExternalTemperature, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(gl_panelLeft.createParallelGroup(Alignment.LEADING, false)
                                        .addComponent(labelDewTemp, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(labelTempDew, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(gl_panelLeft.createParallelGroup(Alignment.LEADING, false)
                                        .addComponent(labelHumidity, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(labelHumidityPercent, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                                .addContainerGap(308, Short.MAX_VALUE))
        );


        gl_panelLeft.setVerticalGroup(
                gl_panelLeft.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panelLeft.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_panelLeft.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(labelPeltierTemperature)
                                        .addComponent(labelInternalTemperature)
                                        .addComponent(labelExternalTemperature)
                                        .addComponent(labelTempDew)
                                        .addComponent(labelHumidityPercent))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_panelLeft.createParallelGroup(Alignment.LEADING)
                                        .addComponent(labelTempPeltier, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                                        .addComponent(labelTempDHT, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                                        .addComponent(labelTempOutside, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                                        .addComponent(labelDewTemp, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                                        .addComponent(labelHumidity, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                                )
                                .addContainerGap())
        );
        panelLeft.setLayout(gl_panelLeft);
        getContentPane().setLayout(groupLayout);


        // Gray color on the main Frame Background of the Window
        getContentPane().setBackground(new Color(107, 106, 104));

    }
}
