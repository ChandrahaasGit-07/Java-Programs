import java.util.*;

class Task
{
    // levels 
    public static int HIGH = 3;
    public static int MEDIUM = 2;
    public static int LOW = 1;


    // status
    public static String COMPLETED = "COMPLETED";
    public static String IN_PROGRESS = " IN PROGRESS";
    public static String NEW = "NEW";

    // setting initial configuration
    private String taskName;
    private int priority = LOW;
    private String status = NEW;

    public Task(String taskName, int priority)
    {
        this.taskName = taskName;
        this.priority = priority;
    }

    public Task(String taskName)
    {
        this.taskName = taskName;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task [taskName=" + taskName + ", priority=" + priority + ", status=" + status + "]";
    }

    
}

public class TodoList {
    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);

            // Arraylist to store of Task class, which stores Task class attributes. 
            ArrayList<Task> todoList = new ArrayList<>();

            while (true) {
                // Menue options
                System.out.println(
                    "Press 1 to add a task, " +
                    "\n2 to view all the tasks " +
                    "\n3 to change status of tasks " +
                    "\n4 to delete a task " +
                    "\nAny other key to exit"
                );

                String userAction = scan.nextLine();

                if(userAction.equals("1"))
                {
                    System.out.println("Enter the task");
                    String task = scan.nextLine();

                    // User choosen level
                    System.out.println("Enter Priority - 1 Low, 2 Medium, 3 High ");
                    int priority = Integer.parseInt(scan.nextLine());

                    // setting the priority by defualt
                    priority = priority > 3 ? 1 : priority;

                    todoList.add(new Task(task, priority));
                    System.out.println("The task as been added to the list");
                }
                else if(userAction.equals("2"))
                {
                    for(Task tasks : todoList)
                    {
                        System.out.println(tasks);
                    }
                }
                else if(userAction.equals("3"))
                {
                    // Prompt the user to enter the index of the task to update
                    System.out.println("Enter the index of the status you want to change ");
                    int chgIdx = Integer.parseInt(scan.nextLine());
                    // Check if the index is valid
                    if (chgIdx > (todoList.size() - 1)) {
                        System.out.println("There is no such index position in the list");
                    } else {
                        // Prompt the user to enter the new status for the task
                        System.out.println("Enter the new status for the task P for 'In Progress' or C for 'Completed'");
                        String updatedStatus = scan.nextLine();
                        // Update the task status based on user input
                        if (updatedStatus.equalsIgnoreCase("P")) {
                            todoList.get(chgIdx).setStatus(Task.IN_PROGRESS);
                        } else if (updatedStatus.equalsIgnoreCase("C")) {
                            todoList.get(chgIdx).setStatus(Task.COMPLETED);
                        }
                    }
                    System.out.println("The task has been changed in the list");
                }
                else if(userAction.equals("4"))
                {
                    System.out.println("Enter the index of the status to delete");
                    int removeInd = Integer.parseInt(scan.nextLine());

                    if(removeInd > ( todoList.size() -1))
                    {
                        System.out.println("Enter the correct index");
                    }
                    else
                    {
                        todoList.remove(removeInd);
                        System.out.println("The atsk as removed successfully");
                    }
                }
                else{
                    break;
                }
            }
        } catch (NumberFormatException e) {
            // TODO: handle exception
            System.out.println("Invalid input. Please enter the valid number");
        }
    }
}
