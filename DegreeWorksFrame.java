// Frame Program

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.FlowLayout;
import java.util.*;
import java.io.*;
import java.util.concurrent.ThreadLocalRandom; 

public class DegreeWorksFrame extends JFrame
{
    private static int width = 450; 
    private static int height = 450; 
    private JPanel panel; //
    private JScrollPane scrollplane; 
    private JLabel labCode, labName, labCredit, labGrade; //
    private JTextField inputCode, inputName, inputCredit, inputGrade; 
    private JTextArea output; 
    private JButton AddCourse, CalculateGPA, ResetInput, ResetOutput, exitButton, GenerateButton;
    private ArrayList<Course> listMain;
    private ArrayList<Double> sum = new ArrayList<Double> ();
    private ArrayList<Double> credits = new ArrayList<Double> ();
    private boolean buttonPressed = false; 
    private int count = 0; 
    private double grade;
    private double total; 
    private double totalCredits = 0;
    private double gpa = 0;  
    private double totalSum = 0;
    public void createWindow()
    {
        // Array List

        listMain = new ArrayList<Course>();

        // Labels

        labCode = new JLabel("Course Code:");
        labCode.setBounds(10, 10, 100, 100);

        labName = new JLabel("Course Name:");
        labName.setBounds(10, 10, 100, 100);

        labCredit = new JLabel("Course Credits:");
        labCredit.setBounds(10, 10, 100, 100);

        labGrade = new JLabel("Course Grade:");
        labGrade.setBounds(10, 10, 100, 100);

        // Input Fields
        inputCode = new JTextField(30);
        inputCode.setBounds(110, 50, 130, 30);

        inputName = new JTextField(30);
        inputName.setBounds(110, 50, 130, 30);

        inputCredit = new JTextField(30);
        inputCredit.setBounds(110, 50, 130, 30);

        inputGrade = new JTextField(30);
        inputGrade.setBounds(110, 50, 130, 30);

        // Buttons

        AddCourse = new JButton("AddCourse");
        AddCourse.setBounds(100,100,300,40);

        ActionListener AddC = new AddCourseListener();
        AddCourse.addActionListener(AddC);

        CalculateGPA = new JButton("Calculate GPA"); 
        CalculateGPA.setBounds(100,100,140, 40);

        ActionListener gpaList = new CalGPAListener();
        CalculateGPA.addActionListener(gpaList); 

        ResetInput = new JButton("Reset Input");
        ResetInput.setBounds(100,100,300,40);

        ActionListener ResetI = new ResetInputListener();
        ResetInput.addActionListener(ResetI);

        ResetOutput = new JButton("Reset Output"); 
        ResetOutput.setBounds(100,100,140, 40);

        ActionListener ResetO = new ResetOutputListener();
        ResetOutput.addActionListener(ResetO);

        exitButton = new JButton("Exit Program");
        exitButton.setBounds(100,100,140, 40);

        ActionListener ExitB = new ExitListener();
        exitButton.addActionListener(ExitB);

        GenerateButton = new JButton("Generate Grades");
        GenerateButton.setBounds(100,100,300,40);

        ActionListener GenB = new GenerateListener();
        GenerateButton.addActionListener(GenB); 

        // Output Scroll
        output = new JTextArea(10,35);
        scrollplane = new JScrollPane(output);
        scrollplane.setBounds(100,100,140, 40);
        output.setEditable(false);
        output.setLineWrap(false);
        output.setWrapStyleWord(true);
        output.append("Code\tName\tCredits\tGrade\n");

        this.add(labCode);
        this.add(inputCode);
        this.add(labName);
        this.add(inputName);
        this.add(labCredit);
        this.add(inputCredit);
        this.add(labGrade);
        this.add(inputGrade);
        this.add(AddCourse);
        this.add(CalculateGPA);
        this.add(ResetInput);
        this.add(ResetOutput);
        this.add(GenerateButton); 
        this.add(scrollplane);
        this.add(exitButton); 
        this.setLayout(null);

    }

    public DegreeWorksFrame()
    {
        createWindow();
        this.setSize(height,width);
    }
    class AddCourseListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            buttonPressed = true; 
            String Code = inputCode.getText();
            String Name = inputName.getText();
            int Credit = Integer.parseInt(inputCredit.getText());
            String Grade = inputGrade.getText();
            if(inputCode.getText() != "" && inputName.getText() != "" && inputCredit.getText() != "" && inputGrade.getText() != "")
            {
                Course temp = new Course(Code, Name, Credit, Grade);
                listMain.add(temp); 
            }
            output.append(listMain.get(count).toString());
            count++; 
        }
    }
    class CalGPAListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            int A, B, C, D, F;
            gpa = 0; 
            A = 4; 
            B = 3; 
            C = 2; 
            D = 1;
            F = 0;
            for(int i = 0; i < listMain.size(); i++)
            {
                double c = listMain.get(i).getCredit();
                switch(listMain.get(i).getGrade())
                {
                    case "A":
                    grade = A; 
                    break;
                    case "B":
                    grade = B;
                    break;
                    case "C": 
                    grade = C;
                    break;
                    case "D": 
                    grade = D;
                    break;
                    case "F":
                    grade = F;
                    break;
                    default:
                    grade = F; 
                    break;
                }
                total = c * grade; 
                sum.add(total); // add all of these in here 
                credits.add(c); // all of the credits
            } 
            for(double answer : sum)
            {
                totalSum = totalSum + answer; 
            }
            for(double answer2 : credits)
            {
                totalCredits = totalCredits + answer2; 
            } 
            gpa = (totalSum/totalCredits);
            output.append(" \nGPA: " + String.valueOf(String.format("%.2f", gpa) + "\n"));
        }
    }
    class ResetInputListener implements ActionListener // Sets input to default
    {
        public void actionPerformed(ActionEvent event)
        {
            inputCode.setText("");
            inputName.setText("");
            inputCredit.setText("");
            inputGrade.setText("");
        }
    }
    class ResetOutputListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            output.setText("Code\tName\tCredits\tGrade\n");
            for(int k = 0; k < 4; k++) // removes objs
            {
                listMain.remove(k);
                System.out.println(listMain.get(k));
            }
            gpa = 0; 
        }
    }
    class ExitListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            System.exit(1); // Closes Application
        }
    } 
    class GenerateListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            ClassGeneration gen = new ClassGeneration(); 
            listMain = gen.pickClass();
            int rand = ThreadLocalRandom.current().nextInt(9);
            rand = rand + 1; 
            for(int x = 0; x < 1; x++)
            {
                output.append(listMain.get(rand).toString());
            }
        }
    }

}

