import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.datatransfer.*;

public class Util extends JFrame implements ActionListener
{
    private JButton split;
    private JButton copyUser;
    private JButton copyPass;
    private JButton clear;
    private JTextField altInput;
    private JTextField user;
    private JTextField pass;
    private JLabel jlabel;
    
    public Util() {
        super("Alt Splitter v1.1");
        this.setLayout(new FlowLayout());
        (this.split = new JButton("Split Account")).setToolTipText("Press to split your alt");
        this.split.addActionListener(this);
        (this.altInput = new JTextField(80)).setEditable(true);
        this.altInput.setSize(300, 250);
        this.user = new JTextField(80);
        this.pass = new JTextField(80);
        (this.jlabel = new JLabel("Alt Splitter v1.1 | Made by comu")).setToolTipText("comu#1337");
        this.copyUser = new JButton("Copy Username");
        this.copyPass = new JButton("Copy Password");
        this.copyUser.setToolTipText("Press to copy your username");
        this.copyPass.setToolTipText("Press to copy your password");
        this.copyUser.addActionListener(this);
        this.copyPass.addActionListener(this);
        (this.clear = new JButton("Clear")).addActionListener(this);
        this.add(this.altInput);
        this.add(this.user);
        this.add(this.pass);
        this.add(this.split);
        this.add(this.copyUser);
        this.add(this.copyPass);
        this.add(this.clear);
        this.add(this.jlabel);
    }
    
    @Override
    public void actionPerformed(final ActionEvent e) {
        if (e.getSource() == this.split) {
            this.user.setText(this.altInput.getText().split(":")[0]);
            this.pass.setText(this.altInput.getText().split(":")[1]);
        }
        if (e.getSource() == this.copyUser) {
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(this.user.getText()), null);
        }
        if (e.getSource() == this.copyPass) {
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(this.pass.getText()), null);
        }
        if (e.getSource() == this.clear) {
            this.altInput.setText("");
            this.user.setText("");
            this.pass.setText("");
        }
    }
}
