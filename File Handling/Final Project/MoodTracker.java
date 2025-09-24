import java.util.Scanner;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;

public class MoodTracker
{
    public static boolean isMoodValid(Mood mood, ArrayList<Mood> moodsList) throws InvalidMoodException {
        for(Mood tempMood: moodsList) {
            if (tempMood.equals(mood)) {
                throw new InvalidMoodException();
            }
        }
        return true;
    }

    public static boolean deleteMoods(LocalDate moodDate, ArrayList<Mood> moodsList) {
        boolean removed = false;
        for(Mood tempMood: moodsList) {
            if (tempMood.getDate().equals(moodDate)) {
                moodsList.remove(tempMood);
                removed = true;
            }
        }
        return removed;
    }

    public static boolean editMood(Mood moodToEdit, ArrayList<Mood> moodsList) {
        for(Mood tempMood: moodsList) {
            if (tempMood.equals(moodToEdit)) {
                tempMood.setNotes(moodToEdit.getNotes());
                return true;
            }
        }
        return false;
    }
    
    // search of moods by date
    public static void searchMoods(LocalDate moodDate, ArrayList<Mood> moodsList) {
        boolean found = false;
        for(Mood tempMood: moodsList) {
            if (tempMood.getDate().equals(moodDate)) {
                found = true;
                System.out.println(tempMood);
            }
        }
        if(!found) {
            System.out.println("No matching records could be found!");
        }
    }
    // specific search mood
    public static void searchMood(Mood mood, ArrayList<Mood> moodsList) {
        boolean found = false;
    
        for(Mood tempMood: moodsList) {
            if (tempMood.equals(mood)) {
                found = true;
                System.out.println(tempMood);
            }
        }
        if(!found) {
            System.out.println("No matching records could be found!");
        }
    }

    public static void main(String[] args)
    {
        ArrayList<Mood> list = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        /*Mood mood1 = new Mood("Arjun", "2002-10-01", "06:30 AM");
        Mood mood2 = new Mood("Chandrahaas", "2004-06-25", "06:30 PM");

        list.add(mood1);
        list.add(mood2);*/
        //or with Scanner class

        System.out.println("Enter the name of the mood");
        String name = scan.nextLine();

        System.out.println("Enter the date of the mood");
        LocalDate date = scan.nextLine();

        System.out.println("Enter the time of the mood");
        LocalTime time = scan.nextLine();

        list.add(name, date, time);
        
        // infinite loop unitl user clicks exist
        while(true)
        {
            System.out.println("Press 'a' to add mood\n" +
                                "'d' to delete mood(s)\n" +
                                "'e' to edit mood\n" +
                                "'s' to search for moods\n" +
                                "'M' to get all moods\n" +
                                "'w' to write the moods to a file\n" +
                                "Type 'Exit' to exit");

            String option = scan.nextLine();
            switch(option)
            {
                case "a" : 
                        System.out.println("Enter the mood name");
                        String moodName = scan.nextLine();
                        System.out.println("Are you tracking the mood for a current day? y/n");
                        String isForCurrentDate = scan.nextLine();
                        Mood moodToAdd = null;
                        if(isForCurrentDate.equalsIgnoreCase("n")) {
                            try {
                                System.out.println("Input the date in MM/dd/yyyy format:");
                                String moodDateStr = scan.nextLine();
                                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                                LocalDate moodDate = LocalDate.parse(moodDateStr, dateFormatter);
                                System.out.println("Input the time in HH:mm:ss format:");
                                String moodTimeStr = sca.nextLine();
                                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                                LocalTime moodTime = LocalTime.parse(moodTimeStr, timeFormatter);
                                System.out.println("Add notes about this mood");
                                String moodNotes = sca.nextLine();
                                if(moodNotes.strip().equalsIgnoreCase("")) {
                                    moodToAdd = new Mood(moodName, moodDate, moodTime);
                                } else {
                                    moodToAdd = new Mood(moodName, moodDate, moodTime, moodNotes);
                                }
                            } catch (DateTimeParseException dfe) {
                                System.out.println("Incorrect format of date or time. Cannot create mood.\n"+dfe);
                                continue;
                            }
                        } else {
                            System.out.println("Add notes about this mood");
                            String moodNotes = scan.nextLine();
                            if(moodNotes.strip().equalsIgnoreCase("")) {
                                moodToAdd = new Mood(moodName);
                            } else {
                                moodToAdd = new Mood(moodName, moodNotes);
                            }
                        }
                        try {
                            boolean isValid = isMoodValid(moodToAdd, moodsList);
                            if(isValid) {
                                moodsList.add(moodToAdd);
                                System.out.println("The mood has been added to the tracker");
                                continue;
                            }
                        } catch(InvalidMoodException ime) {
                            System.out.println("The mood is not valid");
                        }
                            continue;
                case "d" :
                System.out.println("Enter '1' to delete all moods by date\n"+
                "Enter '2' to delete a specific mood");
String deleteVariant = scan.nextLine();
if(deleteVariant.equals("1")) {
try {
    System.out.println("Input the date in MM/dd/yyyy format:");
    String moodDateStr = scan.nextLine();
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    LocalDate moodDate = LocalDate.parse(moodDateStr, dateFormatter);
    boolean areMoodsDeleted = deleteMoods(moodDate, moodsList);
    if(areMoodsDeleted) {
        System.out.println("The moods have been deleted");
    } else {
        System.out.println("No matching moods found");
    }
} catch (DateTimeParseException dfe) {
    System.out.println("Incorrect format of date. Cannot delete mood.");
    continue;
}
} else if (deleteVariant.equals("2")) {
try {
    System.out.println("Enter the mood name");
    moodName = scan.nextLine();
    System.out.println("Input the date in MM/dd/yyyy format:");
    String moodDateStr = scan.nextLine();
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    LocalDate moodDate = LocalDate.parse(moodDateStr, dateFormatter);
    System.out.println("Input the time in HH:mm:ss format:");
    String moodTimeStr = scan.nextLine();
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    LocalTime moodTime = LocalTime.parse(moodTimeStr, timeFormatter);
    Mood delMood = new Mood(moodName, moodDate, moodTime);
    boolean isMoodDeleted = deleteMood(delMood, moodsList);
    if(isMoodDeleted) {
        System.out.println("The mood has been deleted");
    } else {
        System.out.println("No matching mood found");
    }
} catch (DateTimeParseException dfe) {
    System.out.println("Incorrect format of date or time. Cannot delete mood.");
    continue;
}
}
                            continue;
                case "e" :
                Mood moodToEdit = null;
                try {
                    System.out.println("Enter the mood name");
                    moodName = scan.nextLine();
                    System.out.println("Input the date in MM/dd/yyyy format:");
                    String moodDateStr = scan.nextLine();
                    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                    LocalDate moodDate = LocalDate.parse(moodDateStr, dateFormatter);
                    System.out.println("Input the time in HH:mm:ss format:");
                    String moodTimeStr = scan.nextLine();
                    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                    LocalTime moodTime = LocalTime.parse(moodTimeStr, timeFormatter);
                    System.out.println("Add new notes about this mood");
                    String moodNotes = scan.nextLine();
                    if(moodNotes.strip().equalsIgnoreCase("")) {
                        System.out.println("No notes entered");
                        continue;
                    } else {
                        moodToEdit = new Mood(moodName, moodDate, moodTime, moodNotes);
                        boolean isMoodEdited = editMood(moodToEdit, moodsList);
                        if(isMoodEdited) {
                            System.out.println("The mood has been successfully edited");
                        } else {
                            System.out.println("No matching mood could be found");
                        }
                    }
                } catch (DateTimeParseException dfe) {
                    System.out.println("Incorrect format of date or time. Cannot create mood.");
                    continue;
                } 
                            continue;
                case "s" :
                System.out.println("Enter '1' to search for all moods by date\n"+
                "Enter '2' to search for a specific mood");
String searchVariant = scan.nextLine();
if(searchVariant.equals("1")) {
try {
System.out.println("Input the date in MM/dd/yyyy format:");
String moodDateStr = scan.nextLine();
DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
LocalDate moodDate = LocalDate.parse(moodDateStr, dateFormatter);
searchMoods(moodDate, moodsList);
} catch (DateTimeParseException dfe) {
System.out.println("Incorrect format of date. Cannot search mood.");
continue;
}
} else if (searchVariant.equals("2")) {
try {
System.out.println("Enter the mood name");
moodName = scan.nextLine();
System.out.println("Input the date in MM/dd/yyyy format:");
String moodDateStr = scan.nextLine();
DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
LocalDate moodDate = LocalDate.parse(moodDateStr, dateFormatter);
System.out.println("Input the time in HH:mm:ss format:");
String moodTimeStr = scan.nextLine();
DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
LocalTime moodTime = LocalTime.parse(moodTimeStr, timeFormatter);
Mood delMood = new Mood(moodName, moodDate, moodTime);
searchMood(delMood, moodsList);
} catch (DateTimeParseException dfe) {
System.out.println("Incorrect format of date or time. Cannot search mood.");
continue;
}
} 
                            continue;
                case "M" : 
                for(Mood moodObj: moodsList) {
                    System.out.println(moodObj);
                }
                            continue;
                case "w" : 
                try (PrintWriter writer = new PrintWriter(new FileWriter("Moods.txt"))) {
                    for (Mood mood : moodsList) {
                        writer.println(mood+"\n\n");
                    }
                    System.out.println("The entries are written to a file");
                } catch (IOException e) {
                    System.err.println("Error writing to file: " + e.getMessage());
                }
                            continue;
                case "EXIT" : System.out.println("Thank you for using my MoodTracker app. GoodByee!...");
                default : System.out.println("Not a valid option, please click the correct option....");
                continue;
            }
        }





        /*for(Mood mood : list)
        {
            System.out.println(mood);
        }*/
    }
}
