package changeJarPack;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

/**
 * Write a description of class ChangeJarPanel here.
 *
 * @author Roger Ferguson
 */
public class ChangeJarPanel extends JPanel{

    private ChangeJar jar;

    NumberFormat fmt = NumberFormat.getCurrencyInstance();
    JButton takeOutButton;
    JButton incButton;
    JButton decButton;
    JButton addButton;
    JButton toStringButton;
    JTextField qField, dField, nField, pField;
    JButton mutateButton;

    /** labels for message and credits */
    JLabel message, credits;

    public ChangeJarPanel(){

        // create the game object as well as the ChangeJarGUI Frame
        jar = new ChangeJar(100,2,3,4);

        // set the layout to GridBag
        setLayout(new GridLayout(12,2));
        setBackground(Color.lightGray);

        // get Die #2 from game and place on ChangeJarGUI
        qField = new JTextField("0", 3);
        add(qField);
        add(new JLabel("Quarters:"));

        dField = new JTextField("0", 3);
        add(dField);
        add(new JLabel("Dimes:"));

        nField = new JTextField("0", 3);
        add(nField);
        add(new JLabel("Nickels:"));

        pField = new JTextField("0", 3);
        add(pField);
        add(new JLabel("Pennies:"));

        toStringButton = new JButton("toString");
        add(toStringButton);
        takeOutButton = new JButton("Take Out");
        add(takeOutButton);
        incButton = new JButton("Increment");
        add(incButton);
        decButton = new JButton("Decrement");
        add(decButton);
        addButton = new JButton("Add");
        add(addButton);
        mutateButton = new JButton("Toggle Mutate");
        add(mutateButton);


        credits = new JLabel();
        credits.setText(fmt.format(jar.getAmount()));
        add (new JLabel(" "));
        add(new JLabel("Total:"));
        add(credits);

        // register the listeners
        takeOutButton.addActionListener(new ButtonListener());
        incButton.addActionListener(new ButtonListener());
        decButton.addActionListener(new ButtonListener());
        mutateButton.addActionListener(new ButtonListener());
        addButton.addActionListener(new ButtonListener());
        toStringButton.addActionListener(new ButtonListener());
        mutateButton.addActionListener(new ButtonListener());
    }



    /****************************************************************
     Inner class to repond to the user action

     ****************************************************************/
    private class ButtonListener implements ActionListener{

        public void actionPerformed(ActionEvent event){

            int quarters, dimes, nickels, pennies;

            if (event.getSource() == takeOutButton){
                try{
                    quarters = Integer.parseInt(qField.getText());
                    dimes = Integer.parseInt(dField.getText());
                    nickels = Integer.parseInt(nField.getText());
                    pennies = Integer.parseInt(pField.getText());
                    jar.takeOut(quarters,dimes,nickels,pennies);
                }catch(NumberFormatException io){
                    JOptionPane.showMessageDialog(null,"Enter an integer in all fields");
                }catch(IllegalArgumentException e){
                    JOptionPane.showMessageDialog(null,"Not enough specified coins for this operation");
                }
            }

            if(event.getSource() == incButton){
                try{
                    jar.inc();
                }catch (NumberFormatException e){
                    JOptionPane.showMessageDialog(null,"Not enough specified coins for this operation");
                }

            }

            if(event.getSource() == decButton){
                try{
                    jar.dec();
                }catch (NumberFormatException e){
                    JOptionPane.showMessageDialog(null,"Not enough specified coins for this operation");
                }

            }

            if(event.getSource() == toStringButton){
                try{
                    JOptionPane.showInputDialog(jar.toString());
                }catch (NumberFormatException e){
                    JOptionPane.showMessageDialog(null,"Not enough specified coins for this operation");
                }

            }

            if(event.getSource() == mutateButton){
                    if(jar.isMutate() == true){
                        jar.setMutate(false);
                    }else if(jar.isMutate() == false){
                        jar.setMutate(true);
                    }


            }

            if(event.getSource() == addButton){
                try{
                    quarters = Integer.parseInt(qField.getText());
                    dimes = Integer.parseInt(dField.getText());
                    nickels = Integer.parseInt(nField.getText());
                    pennies = Integer.parseInt(pField.getText());
                    jar.add(quarters, dimes, nickels, pennies );
                }catch (NumberFormatException e){
                    JOptionPane.showMessageDialog(null,"Not enough specified coins for this operation");
                }

            }


            // update the labels
            credits.setText(fmt.format(jar.getAmount()));
        }

    }
}
