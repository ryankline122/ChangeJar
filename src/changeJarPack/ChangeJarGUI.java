package changeJarPack;

import javax.swing.*;

public class ChangeJarGUI {
    public static void main(String arg[]){

        JMenu fileMenu;
        JMenuItem loadItem;
        JMenuItem quitItem;
        JMenuItem saveItem;
        JCheckBoxMenuItem suspendItem;
        JMenuBar menus;

        fileMenu = new JMenu("File");
        quitItem = new JMenuItem("Quit");
        loadItem = new JMenuItem("Load");
        saveItem = new JMenuItem("Save");
        suspendItem = new JCheckBoxMenuItem ("Suspend");
        fileMenu.add(suspendItem);
        fileMenu.add(loadItem);
        fileMenu.add(saveItem);
        fileMenu.add(quitItem);

        menus = new JMenuBar();

        menus.add(fileMenu);

        JFrame gui = new JFrame("Change Jar");
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ChangeJarPanelMain panel = new ChangeJarPanelMain(quitItem, suspendItem);
        gui.getContentPane().add(panel);

        gui.setSize(600,400);
        gui.setJMenuBar(menus);
        gui.pack();
        gui.setVisible(true);
    }
}
