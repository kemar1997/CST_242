package studenttuition;

import javax.swing.JOptionPane;
/**
 * Tests the Student class and demonstrates inheritance with classes 
 * SuffolkResident, NassauResident and NonResident.
 *
 * @author Carl B. Struck
 * @version Copyright 2002 (c) SCCC West
 */
public class StudentTuition
{
    /**
     * Instantiates an array of SuffolkResident, NassauResident and NonResident 
     * objects and iterates through the objects to call their toString() methods.
     *
     * @param args the String[] array command line parameter
     */
    public static void main(String[] args)
    {
        Student[] student =
        {
            new SuffolkResident("Sally", "Walters", "Z", 7),
            new NassauResident("Charles", "Jones", "B+", 13),
            new NonResident("Corrine", "Alexander", "A", 12, "Wendover", "ma")
        };

        for (Student s : student)
        {
            JOptionPane.showMessageDialog(null, s);
        }

    }
}
