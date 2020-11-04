
import java.util.*;
import java.io.*; 
import java.util.concurrent.ThreadLocalRandom; 

public class ClassGeneration 
{
    private String grad; 
    
    public ClassGeneration() 
    {
        String grad = ""; 
    }

    public ArrayList<Course> pickClass() 
    {
        ArrayList<Integer> Code = new ArrayList<Integer>();
        ArrayList<String> Class = new ArrayList<String>();
        ArrayList<String> Name = new ArrayList<String>();
        ArrayList<Course> list = new ArrayList<Course>();

        Class.add("CSPC");
        Code.add(101);
        Name.add("Intro to Computers");

        Class.add("CSPC");
        Code.add(244);
        Name.add("Java I");

        Class.add("CSPC");
        Code.add(245);
        Name.add("Java II");

        Class.add("CSPC");
        Code.add(325);
        Name.add("Database Systems");

        Class.add("CSPC");
        Code.add(303);
        Name.add("Computer Org");

        Class.add("CSPC");
        Code.add(335);
        Name.add("Data Structures"); 

        Class.add("MATH");
        Code.add(101);
        Name.add("College Algebra");

        Class.add("MATH");
        Code.add(180);
        Name.add("Pre-Cal");

        Class.add("MATH");
        Code.add(181);
        Name.add("Cal I");

        Class.add("MATH");
        Code.add(202);
        Name.add("Cal II"); 

        for(int i = 0; i < Class.size(); i++)
        {
            String CompiledClass = Class.get(i) + Code.get(i);
            int rand_int = ThreadLocalRandom.current().nextInt(4);
            rand_int = rand_int + 2; 
            if(rand_int == 5)
            {
                rand_int = rand_int - 1; 
            }
            if(rand_int == 2)
            {
                rand_int = rand_int + 1; 
            }
            int getGrade = ThreadLocalRandom.current().nextInt(3);
            getGrade++; 
            switch(getGrade)
            {
                case 1:
                    grad = "A";
                    break;
                case 2: 
                    grad = "B";
                    break;
                case 3:
                    grad = "C";
                    break;
                case 4:
                    grad = "D";
                    break;
                case 5: 
                    grad = "F";
                    break;
                default:
                    grad = "F";
                    break;
            }
            list.add(new Course(CompiledClass, Name.get(i),rand_int, grad)); 
        }
        return list; 
    }
}
