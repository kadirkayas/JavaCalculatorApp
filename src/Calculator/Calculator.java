package Calculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons=new JButton[10];
    JButton[] functionButton=new JButton[9];
    JButton addButton,subButton,mulButton,divButton;
    JButton decButton,equButton,delButton,clrButton,negButton;
    JPanel panel;

    Font myFont =  new Font("Arial",Font.BOLD,20);

    double num1=0,num2=0,result=0;
    char operator;

    Calculator(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);
        textField=new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(myFont);
        textField.setEditable(false);

        addButton=new JButton("+");
        subButton=new JButton("-");
        mulButton=new JButton("*");
        divButton=new JButton("/");
        decButton=new JButton(".");
        equButton=new JButton("=");
        delButton=new JButton("Delete");
        clrButton=new JButton("Clear");
        negButton=new JButton("(-)");

        functionButton[0]=addButton;
        functionButton[1]=subButton;
        functionButton[2]=mulButton;
        functionButton[3]=divButton;
        functionButton[4]=decButton;
        functionButton[5]=equButton;
        functionButton[6]=delButton;
        functionButton[7]=clrButton;
        functionButton[8]=negButton;

        for(int i=0;i<9;i++){
            functionButton[i].addActionListener(this);
            functionButton[i].setFont(myFont);
            functionButton[i].setFocusable(false);
        }


        for(int i=0;i<10;i++){
            numberButtons[i]=new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        negButton.setBounds(50,430,90,50);
        delButton.setBounds(150,430,90,50);
        clrButton.setBounds(250,430,90,50);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));

        for(int i=1;i<10;i++){
            panel.add(numberButtons[i]);
            switch (i){
                case 3:
                    panel.add(addButton);
                    break;
                case 6:
                    panel.add(subButton);
                    break;
                case 9:
                    panel.add(mulButton);
                    panel.add(decButton);
                    panel.add(numberButtons[0]);
                    panel.add(equButton);
                    panel.add(divButton);
                    break;
            }
        }

        frame.add(panel);
        frame.add(textField);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i=0;i<10;i++){
            if(e.getSource()==numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==decButton){
            textField.setText(textField.getText().concat(String.valueOf(decButton.getText())));
        }
        if(e.getSource()==negButton){
            textField.setText("-"+ textField.getText());

        }
        if(e.getSource()==clrButton){
            System.out.println("cleared");
            textField.setText("");
            num1=0;
            num2=0;
            result=0;
        }
        if (e.getSource()==delButton){
            String textfielt=textField.getText();
            textField.setText("");
            for (int i=0;i<textfielt.length()-1;i++){
                textField.setText(textField.getText()+textfielt.charAt(i));
            }
        }
        if (e.getSource()==addButton){
            num1=Double.parseDouble(textField.getText());
            operator='+';
            textField.setText("");
        }
        if (e.getSource()==subButton){
            num1=Double.parseDouble(textField.getText());
            operator='-';
            textField.setText("");
        }
        if (e.getSource()==mulButton){
            num1=Double.parseDouble(textField.getText());
            operator='*';
            textField.setText("");
        }
        if (e.getSource()==divButton){
            num1=Double.parseDouble(textField.getText());
            operator='/';
            textField.setText("");
        }

        if (e.getSource()==equButton){
            num2=Double.parseDouble(textField.getText());

            switch (operator){
                case '+':
                    result=num1+num2;
                    break;
                case '-':
                    result=num1-num2;
                    break;
                case '*':
                    result=num1*num2;
                    break;
                case '/':
                    result=num1/num2;
                    break;
            }
            textField.setText(String.valueOf(result));
        }
    }
}