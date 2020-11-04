// Main Class 

import javax.swing.*; 
import java.awt.FlowLayout;
public class DegreeWorksViewer
{
    public static void main(String[]args)
    {
        DegreeWorksFrame gui = new DegreeWorksFrame(); 
        gui.setTitle("Degree Works");
        gui.getContentPane().setLayout(new FlowLayout());
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
    }
}
