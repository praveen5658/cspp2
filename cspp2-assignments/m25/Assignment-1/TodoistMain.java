import java.util.Scanner;
import java.util.Arrays;

/**
  * write your code below this comment
  */

/**
 * Class for todoist main.
 */
public final class TodoistMain {
    /**
     * Constructs the object.
     */
    private TodoistMain() {

    }
    /**
     * Starts a test.
     */
    public static void startTest() {
        Todoist todo = new Todoist();
        Scanner s = new Scanner(System.in);
        String st;
        while (s.hasNext()) {
            st = s.nextLine();
            st = st.replaceAll(",,", ",notitle,");
            String[] tokens = st.split(",");
            switch (tokens[0]) {
            case "task":
                testTask(tokens);
                break;
            case "add-task":
                testAddTask(todo, tokens);
                break;
            case "print-todoist":
                System.out.println(todo);
                break;
            case "get-next":
                System.out.println(todo.getNextTask(tokens[1]));
                break;
            case "get-next-n":
                int n = Integer.parseInt(tokens[2]);
                Task[] tasks = todo.getNextTask(tokens[1], n);
                System.out.println(Arrays.deepToString(tasks));
                break;
            case "total-time":
                System.out.println(todo.totalTime4Completion());
                break;
            default:
                break;
            }
        }
    }

    /**
     * method to test add task.
     *
     * @param      todo    The todo
     * @param      tokens  The tokens
     */
    public static void testAddTask(final Todoist todo,
                                   final String[] tokens) {
        try {
            todo.addTask(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * method to test the creation of task object.
     *
     * @param      tokens  The tokens
     */
    public static void testTask(final String[] tokens) {
        try {
            System.out.println(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates a task object.
     *
     * @param      tokens     The tokens
     *
     * @return     Task object
     *
     * @throws     Exception  if task inputs are invalid
     */
    public static Task createTask(final String[] tokens) throws Exception {
        final int three = 3;
        final int four = 4;
        final int five = 5;
        final int six = 6;
        String title = tokens[1];
        String assignedTo = tokens[2];
        int timeToComplete = Integer.parseInt(tokens[three]);
        boolean important = tokens[four].equals("y");
        boolean urgent = tokens[five].equals("y");
        String status = tokens[six];
        return new Task(
                   title, assignedTo, timeToComplete,
                   important, urgent, status);
    }

    /**
     * main method.
     *
     * @param      args  The command line arguments
     */
    public static void main(final String[] args) {
        startTest();
    }
}
/**
 * Class for task.
 */
class Task {
    /**
     * Value.
     */
    private String title;
    /**
     * Value.
     */
    private String assignedTo;
    /**
     * Value.
     */
    private int timeToComplete;
    /**
     * Value.
     */
    private String important;
    /**
     * Value.
     */
    private String urgent;
    /**
     * Value.
     */
    private String status;
    /**
     * Value.
     */
    private int c = 0;
    /**
     * Constructs the object.
     *
     * @param      t     { parameter_description }
     * @param      n     { parameter_description }
     * @param      d     { parameter_description }
     * @param      i     { parameter_description }
     * @param      u     { parameter_description }
     * @param      sta   The sta
     * @throws     Exception  if task inputs are invalid
     */
    Task(final String t, final String n, final int d,
         final boolean i, final boolean u,
         final String sta) throws Exception {
        if (!(t.equals("notitle"))) {
            title = t;
            assignedTo = n;
            if (d >= 0) {
                timeToComplete = d;
                if (i) {
                    important = "Important";
                } else {
                    important = "Not Important";
                }
                if (u) {
                    urgent = "Urgent";
                } else {
                    urgent = "Not Urgent";
                }
                if (sta.equals("todo") || sta.equals("done")) {
                    status = sta;
                } else {
                    System.out.println("Invalid status " + sta);
                    c++;
                }
            } else {
                System.out.println("Invalid timeToComplete " + d);
                c++;
            }
        } else {
            System.out.println("Title not provided");
            c++;
        }
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String st = "";
        if (c == 0) {
            st = title + ", " + assignedTo + ", "
                 + timeToComplete + ", " + important + ", "
                 + urgent + ", " + status;
        }
        return st;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return assignedTo;
    }
    /**
     * Gets the important.
     *
     * @return     The important.
     */
    public String getImportant() {
        return important;
    }
    /**
     * Gets the urgent.
     *
     * @return     The urgent.
     */
    public String getUrgent() {
        return urgent;
    }
    /**
     * Gets the status.
     *
     * @return     The status.
     */
    public String getStatus() {
        return status;
    }
    /**
     * Gets the time.
     *
     * @return     The time.
     */
    public int getTime() {
        return timeToComplete;
    }
}
/**
 * Class for todoist.
 */
class Todoist {
    /**
     * Value.
     */
    private Task[] tasks;
    /**
     * Value.
     */
    private int size;
    /**
     * Constructs the object.
     */
    protected Todoist() {
        final int ten = 10;
        tasks = new Task[ten];
        size = 0;
    }
    /**
     * { Resize }.
     */
    public void resize() {
        final int two = 2;
        tasks = Arrays.copyOf(tasks, two * tasks.length);
    }
    /**
     * Adds a task.
     *
     * @param      task  The task
     */
    public void addTask(final Task task) {
        if (tasks.length == size) {
            resize();
        }
        tasks[size++] = task;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String str = "";
        for (int i = 0; i < size - 1; i++) {
            str += tasks[i].toString() + "\n";
        }
        str += tasks[size - 1].toString();
        return str;
    }
    /**
     * Gets the next task.
     *
     * @param      na    { parameter_description }
     *
     * @return     The next task.
     */
    public Task getNextTask(final String na) {
        Task sample;
        for (int i = 0; i < size; i++) {
            if ((tasks[i].getName().equals(na)) && (
                        tasks[i].getStatus().equals("todo"))) {
                sample = tasks[i];
                if ((sample.getImportant().equals("Important")) && (
                            sample.getUrgent().equals("Not Urgent"))) {
                    return sample;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            if ((tasks[i].getName().equals(na)) && (
                        tasks[i].getStatus().equals("todo"))) {
                sample = tasks[i];
                if ((sample.getImportant().equals("Important")) && (
                            sample.getUrgent().equals("Urgent"))) {
                    return sample;
                }
            }
        }
        return null;
    }
    /**
     * Gets the next task.
     *
     * @param      na    { parameter_description }
     * @param      cou   The cou
     *
     * @return     The next task.
     */
    public Task[] getNextTask(final String na, final int cou) {
        Task sample;
        Task[] sample1 = new Task[cou];
        final int three = 3;
        int k = 0;
        for (int i = 0; i < size; i++) {
            if ((tasks[i].getName().equals(na)) && (
                        tasks[i].getStatus().equals("todo"))) {
                sample = tasks[i];
                if ((sample.getImportant().equals("Important")) && (
                            sample.getUrgent().equals("Not Urgent"))) {
                    sample1[k] = sample;
                    k++;
                    if (k == three) {
                        break;
                    }
                }
            }
        }
        if (k < three) {
            for (int i = 0; i < size; i++) {
                if ((tasks[i].getName().equals(na)) && (
                            tasks[i].getStatus().equals("todo"))) {
                    sample = tasks[i];
                    if ((sample.getImportant().equals("Important")) && (
                                sample.getUrgent().equals("Urgent"))) {
                        sample1[k] = sample;
                        k++;
                        if (k == three) {
                            break;
                        }
                    }
                }
            }
        }
        if (k < three) {
            while (k < three) {
                sample1[k] = null;
                k++;
            }
        }
        return sample1;
    }
    /**
     * { Sum of time}.
     *
     * @return     { description_of_the_return_value }.
     */
    public int totalTime4Completion() {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            if (tasks[i].getStatus().equals("todo")) {
                sum += tasks[i].getTime();
            }
        }
        return sum;
    }
}
