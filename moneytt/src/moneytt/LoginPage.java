package moneytt;
import moneytt.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.IOException;


import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.*;

public class LoginPage extends JFrame implements ActionListener {
    // UI components
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JCheckBox btnPasswordShow;
    private JButton btnLogIn, btnSignUp;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginPage().setVisible(true));
    }

    public LoginPage() {
        setTitle("Login Page");
        setSize(1100, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setResizable(false);

        // Welcome Panel
        JPanel panelWelcome = new JPanel(null);
        panelWelcome.setBounds(0, 0, 700, 563);
        panelWelcome.setBackground(Color.WHITE);
        panelWelcome.setBorder(new MatteBorder(0, 0, 2, 0, Color.BLACK));
        add(panelWelcome);

        JLabel lblIconWelcome = new JLabel(new ImageIcon(getClass().getResource("/icon/signup_background.png")));
        lblIconWelcome.setBounds(138, 108, 441, 442);
        panelWelcome.add(lblIconWelcome);
        panelWelcome.add(createLabel("	Expenza", 163, 57, 195, 41, 30, new Color(0, 0, 0)));

        // Login Panel
        JPanel panelLogin = new JPanel(null);
        panelLogin.setBounds(700, 0, 386, 563);
        panelLogin.setBackground(new Color(255, 102, 102));
        add(panelLogin);
        
        
        
//String text,int x,int y,int w,int h,int fontSize,Color color,int align
        panelLogin.add(createLabel("Login", 100, 20, 195, 40, 30, Color.WHITE, SwingConstants.CENTER));
        panelLogin.add(createLabel("Username", 90, 118, 195, 30, 20, Color.WHITE));
        txtUsername = createTextField(90, 148); panelLogin.add(txtUsername);
        panelLogin.add(createLabel("Password", 90, 226, 195, 30, 20, Color.WHITE));
        txtPassword = createPasswordField(90, 256); panelLogin.add(txtPassword);

        btnPasswordShow = new JCheckBox("Show Password");
        btnPasswordShow.setBounds(90, 302, 254, 20);
        btnPasswordShow.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnPasswordShow.setBackground(Color.WHITE);
        btnPasswordShow.setForeground(new Color(155, 163, 139));
        btnPasswordShow.addActionListener(this);
        panelLogin.add(btnPasswordShow);

        btnLogIn = createButton("LOG IN", 90, 368, 254, new Color(255, 102, 102));
        btnLogIn.addActionListener(this); panelLogin.add(btnLogIn);

        btnSignUp = createButton("SIGN UP", 128, 426, 182, new Color(255, 102, 102));
        btnSignUp.addActionListener(this); panelLogin.add(btnSignUp);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == btnPasswordShow) {
            txtPassword.setEchoChar(btnPasswordShow.isSelected() ? (char)0 : '*');
        } else if (src == btnLogIn) {
            if (checkLogin()) 
            	validateUser();
        } else if (src == btnSignUp) {
        	SignupPage login = new SignupPage();
			login.setVisible(true);
            JOptionPane.showMessageDialog(this, "Redirect to Signup Page");
        }
    }

    private boolean checkLogin() {
        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());
        if (username.isEmpty()) {
            showMsg("Please enter username."); return false;
        }
        if (password.isEmpty()) {
            showMsg("Please enter password."); return false;
        }
        if (!password.matches("[a-zA-Z0-9]+")) {
            showMsg("Password must contain only letters and digits."); return false;
        }
        return true;
    }

    private void validateUser() {
		String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());
        
        User user = DBUserService.validateUserLogin(username, password);
		if (user != null) {
			JOptionPane.showMessageDialog(this, "Login successfully.\n Hello " + username + "!");
			HomePage home = new HomePage(user);
			home.setVisible(true);
			this.dispose();
		} else {
			HomePage home = new HomePage(user);
			home.setVisible(true);
			this.dispose();
			return;
		}
	}


    private void showMsg(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    private JLabel createLabel(String text, int x, int y, int w, int h, int fontSize, Color color) {
        return createLabel(text, x, y, w, h, fontSize, color, SwingConstants.LEFT);
    }

    private JLabel createLabel(String text, int x, int y, int w, int h, int fontSize, Color color, int align) {
        JLabel lbl = new JLabel(text);
        lbl.setBounds(x, y, w, h);
        lbl.setFont(new Font("Times New Roman", Font.PLAIN, fontSize));
        lbl.setForeground(color);
        lbl.setHorizontalAlignment(align);
        return lbl;
    }

    private JTextField createTextField(int x, int y) {
        JTextField tf = new JTextField();
        tf.setBounds(x, y, 254, 30);
        tf.setFont(new Font("Serif", Font.PLAIN, 20));
        tf.setBorder(new MatteBorder(0, 0, 2, 0, Color.WHITE));
        return tf;
    }

    private JPasswordField createPasswordField(int x, int y) {
        JPasswordField pf = new JPasswordField();
        pf.setBounds(x, y, 254, 30);
        pf.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        pf.setBorder(new MatteBorder(0, 0, 2, 0, Color.WHITE));
        return pf;
    }

    private JButton createButton(String text, int x, int y, int width, Color bgColor) {
        JButton btn = new JButton(text);
        btn.setBounds(x, y, width, 40);
        btn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btn.setForeground(Color.WHITE);
        btn.setBackground(bgColor);
        return btn;
    }
}
