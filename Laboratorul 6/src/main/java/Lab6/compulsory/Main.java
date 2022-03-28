package Lab6.compulsory;

public class Main {

   public static void main(String args[]) {
       MainFrame mainFrame = new MainFrame(20, 17);
       mainFrame.setVisible(true);
       ConfigPanel configPanel = new ConfigPanel(mainFrame, 20, 10);
   }
}
