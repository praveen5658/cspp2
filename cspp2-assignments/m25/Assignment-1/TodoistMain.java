import java.util.Scanner;
import java.util.Arrays;

/**
  * write your code below this comment
  */

/**
 * Class for todoist main.
 */
public class TodoistMain {

	/**
	 * Starts a test.
	 */
	public static void startTest() {
		Todoist todo = new Todoist();
		Scanner s = new Scanner(System.in);
		String st;
		while (s.hasNext()) {
			st = s.nextLine();
			st.replaceAll(",,",",notitle,");
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
	public static void testAddTask(final Todoist todo, final String[] tokens) {
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
		String title = tokens[1];
		String assignedTo = tokens[2];
		int timeToComplete = Integer.parseInt(tokens[3]);
		boolean important = tokens[4].equals("y");
		boolean urgent = tokens[5].equals("y");
		String status = tokens[6];
		return new Task(
		           title, assignedTo, timeToComplete, important, urgent, status);
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
class Task {
	private String title;
	private String assignedTo;
	private int timeToComplete;
	private String important;
	private String urgent;
	private String status;
	private int c = 0;
	Task(final String t, final String n, final int d,
	     final boolean i, final boolean u, final String sta) throws Exception {
		if (t != "notitle") {
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
	public String toString() {
		String st = "";
		if (c == 0) {
			st = title + ", " + assignedTo + ", "
			     + timeToComplete + ", " + important + ", "
			     + urgent + ", " + status;
		}
		return st;
	}
	public String getName() {
		return assignedTo;
	}
	public String getImportant() {
		return important;
	}
	public String getUrgent() {
		return urgent;
	}
	public String getStatus() {
		return status;
	}
	public int getTime() {
		return timeToComplete;
	}
}
class Todoist {
	private Task[] tasks;
	private int size;
	Todoist() {
		tasks = new Task[10];
		size = 0;
	}
	public void resize() {
		tasks = Arrays.copyOf(tasks, 2 * tasks.length);
	}
	public void addTask(final Task task) {
		if (tasks.length == size) {
			resize();
		}
		tasks[size++] = task;
	}
	public String toString() {
		String str = "";
		for (int i = 0; i < size - 1; i++) {
			str += tasks[i].toString() + "\n";
		}
		str += tasks[size - 1].toString();
		return str;
	}
	public Task getNextTask(final String na) {
		Task sample;
		for (int i = 0; i < size; i++) {
			if ((tasks[i].getName().equals(na)) && (tasks[i].getStatus().equals("todo"))) {
				sample = tasks[i];
				if ((sample.getImportant().equals("Important")) && (sample.getUrgent().equals("Not Urgent"))) {
					return sample;
				}
			}
		}
		for (int i = 0; i < size; i++) {
			if ((tasks[i].getName().equals(na)) && (tasks[i].getStatus().equals("todo"))) {
				sample = tasks[i];
				if ((sample.getImportant().equals("Important")) && (sample.getUrgent().equals("Urgent"))) {
					return sample;
				}
			}
		}
		return null;
	}
	public Task[] getNextTask(final String na, final int cou) {
		// Task[] samp = new Task[cou];
		// for (int i = 0; i< cou ; i++) {
		// 	if (getNextTask(na) != null) {
		// 		samp[i] =
		// 	}
		// }
		Task sample;
		Task[] sample1 = new Task[cou];
		int k = 0;
		for (int i = 0; i < size; i++) {
			if ((tasks[i].getName().equals(na)) && (tasks[i].getStatus().equals("todo"))) {
				sample = tasks[i];
				if ((sample.getImportant().equals("Important")) && (sample.getUrgent().equals("Not Urgent"))) {
					sample1[k] = sample;
					k++;
					if (k == 3) {
						break;
					}
				}
			}
		}
		if (k < 3) {
			for (int i = 0; i < size; i++) {
				if ((tasks[i].getName().equals(na)) && (tasks[i].getStatus().equals("todo"))) {
					sample = tasks[i];
					if ((sample.getImportant().equals("Important")) && (sample.getUrgent().equals("Urgent"))) {
						sample1[k] = sample;
						k++;
						if (k == 3) {
							break;
						}
					}
				}
			}
		}
		if (k < 3) {
			while (k < 3) {
				sample1[k] = null;
				k++;
			}
		}
		return sample1;
	}
	public int totalTime4Completion() {
		int sum = 0;
		for (int i = 0; i< size;i++) {
			if (tasks[i].getStatus().equals("todo")) {
				sum += tasks[i].getTime();
			}
		}
		return sum;
	}
}