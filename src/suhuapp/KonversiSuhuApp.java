package suhuapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KonversiSuhuApp extends JFrame {
    private JTextField txtSuhu;
    private JComboBox<String> cmbSatuanAwal, cmbSatuanAkhir;
    private JLabel lblHasil;
    private ButtonGroup bg;

    public KonversiSuhuApp() {
        setTitle("Konversi Suhu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,3));
        
        JLabel lblSuhu = new JLabel("Suhu:");
        txtSuhu = new JTextField(5);
        txtSuhu.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != '.') {
                    e.consume();
                }
            }
        });
        txtSuhu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                konversi();
            }
        });

        JLabel lblSatuanAwal = new JLabel("Dari:");
        cmbSatuanAwal = new JComboBox<>(new String[]{"Celcius", "Fahrenheit", "Reamur", "Kelvin"});

        JLabel lblSatuanAkhir = new JLabel("Ke:");
        cmbSatuanAkhir = new JComboBox<>(new String[]{"Celcius", "Fahrenheit", "Reamur", "Kelvin"});

        lblHasil = new JLabel();

        JButton btnKonversi = new JButton("Konversi");
        btnKonversi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                konversi();
            }
        });

        panel.add(lblSuhu);
        panel.add(txtSuhu);
        panel.add(lblSatuanAwal);
        panel.add(cmbSatuanAwal);
        panel.add(lblSatuanAkhir);
        panel.add(cmbSatuanAkhir);
        panel.add(new JLabel());
        panel.add(btnKonversi);
        panel.add(lblHasil);

        add(panel);
        setVisible(true);
    }

    private void konversi() {
    try {
        double suhu = Double.parseDouble(txtSuhu.getText());
        String satuanAwal = cmbSatuanAwal.getSelectedItem().toString();
        String satuanAkhir = cmbSatuanAkhir.getSelectedItem().toString();
        double hasil = 0;

        if (satuanAwal.equals("Celcius")) {
            if (satuanAkhir.equals("Fahrenheit")) {
                hasil = suhu * 1.8 + 32;
            } else if (satuanAkhir.equals("Reamur")) {
                hasil = suhu * 0.8;
            } else if (satuanAkhir.equals("Kelvin")) {
                hasil = suhu + 273.15;
            }
        } else if (satuanAwal.equals("Fahrenheit")) {
            if (satuanAkhir.equals("Celcius")) {
                hasil = (suhu - 32) / 1.8;
            } else if (satuanAkhir.equals("Reamur")) {
                hasil = (suhu - 32) * 4 / 9;
            } else if (satuanAkhir.equals("Kelvin")) {
                hasil = (suhu + 459.67) * 5 / 9;
            }
        } else if (satuanAwal.equals("Reamur")) {
            if (satuanAkhir.equals("Celcius")) {
                hasil = suhu * 1.25;
            } else if (satuanAkhir.equals("Fahrenheit")) {
                hasil = suhu * 2.25 + 32;
            } else if (satuanAkhir.equals("Kelvin")) {
                hasil = suhu * 1.25 + 273.15;
            }
        } else if (satuanAwal.equals("Kelvin")) {
            if (satuanAkhir.equals("Celcius")) {
                hasil = suhu - 273.15;
            } else if (satuanAkhir.equals("Fahrenheit")) {
                hasil = (suhu - 273.15) * 1.8 + 32;
            } else if (satuanAkhir.equals("Reamur")) {
                hasil = (suhu - 273.15) * 4 / 5;
            }
        }

        lblHasil.setText("Hasil: " + hasil + " " + satuanAkhir);
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null, "Masukkan suhu yang valid!");
    }
}

    // ... (fungsi konversi suhu)

    public static void main(String[] args) {
        new KonversiSuhuApp();
    }
}