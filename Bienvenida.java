import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;

public class Bienvenida extends JFrame{
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton ingresarButton;
    private JButton salirButton;
    private JPasswordField passwordField1;


    public Bienvenida(){
        super("Bienvenida");
        setContentPane(panel1);
        setSize(500,500);
        setResizable(false);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int respuesta = JOptionPane.showConfirmDialog(null, "Quiere salir de la app",
                        "Salir", JOptionPane.YES_NO_OPTION);
                try {
                    if (respuesta == JOptionPane.YES_OPTION) {
                        dispose();

                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        ingresarButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = "Luis";
                String contrasenia = "123";

                try{
                    if (usuario.equals(textField1.getText()) && contrasenia.equals(passwordField1.getText())){
                        Menu_Opciones menu = new Menu_Opciones();
                        menu.setVisible(true);
                        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panel1);
                        frame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null,"Error en las credenciales");
                        textField1.setText("");
                        textField2.setText("");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Bienvenida();
            }
        });
        /*JFrame frame = new JFrame("Opciones");
        frame.setContentPane(new Bienvenida().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();*/
    }
}
