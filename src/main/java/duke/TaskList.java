package duke;

import java.util.ArrayList;

/**
 * Represents a task list.
 */
public class TaskList {

    private ArrayList<Task> list;
    private Duke duke = new Duke();

    /**
     * Constructs a task list.
     */
    public TaskList() {
        this.list = new ArrayList<>();
    }

    /**
     * Gets the task list.
     *
     * @return the task list.
     */
    public ArrayList<Task> getList() {
        return this.list;
    }

    /**
     * Adds task into the list.
     *
     * @param task the task to be added.
     */
    public void add(Task task) {
        this.getList().add(task);
    }

    /**
     * Gets the task from the list given its index.
     *
     * @param index the index in the list of a task that needs to be returned.
     * @return
     */
    public Task get(int index) {
        return this.getList().get(index);
    }

    /**
     * Deletes a task from the task list.
     *
     * @param list the task list.
     * @param task the task to be deleted.
     * @param index the index of the to-be-deleted task.
     */
    public void delete(TaskList list, Task task, int index) {
        list.getList().remove(index);
        System.out.println(Ui.DELETE_HEADER + task.toString()
                + "Now you have " + duke.getCount() + " tasks in the list." + "\n" + Duke.LINE);
    }

    /**
     * Deletes a task from the task list.
     *
     * @param list the task list.
     * @param task the task to be deleted.
     * @param index the index of the to-be-deleted task.
     * @return the description of the deleted task.
     */
    public String deleteGui(TaskList list, Task task, int index) {
        list.getList().remove(index);
        return Ui.DELETE_HEADER + task.toString()
                + "Now you have " + duke.getCount() + " tasks in the list." + "\n" + Duke.LINE;
    }
    /**
     * Lists out all the task in the task list.
     */
    public void list() {
        System.out.println(Ui.TASK_LIST_HEADER);
        for (int i = 0, j = 1; i < duke.getCount(); i++, j++) {
            System.out.print(j + ". ");
            list.get(i).list();
        }
        System.out.println(Duke.LINE + "\n");
    }

    /**
     * Lists out all the task in the task list.
     *
     * @return the task in the task list.
     */
    public String listGui() {
        String printString = Ui.TASK_LIST_HEADER + "\n";
        for (int i = 0, j = 1; i < duke.getCount(); i++, j++) {
            printString = printString + Integer.toString(j) + ". ";
            printString += list.get(i).listGui() + "\n";
        }
        printString += Duke.LINE + "\n";
        return printString;
    }

    /**
     * Marks a task as done.
     *
     * @param list the task list.
     * @param index the index of the task to be marked.
     */
    public void mark(TaskList list, int index) {
        System.out.println(Ui.MARK_HEADER + "[X] " + list.getList().get(index - 1).printDescription());
        list.getList().get(index - 1).setStatus("[X]");
    }

    /**
     * Marks a task as done.
     *
     * @param list the task list.
     * @param index the index of the task to be marked.
     * @return the description of the task being marked.
     */
    public String markGui(TaskList list, int index) {
        list.getList().get(index - 1).setStatus("[X]");
        return Ui.MARK_HEADER + "[X] " + list.getList().get(index - 1).printDescription();
    }

    /**
     * Marks a task as undone.
     *
     * @param list the task list.
     * @param index the index of the task to be unmarked.
     */
    public void unmark(TaskList list, int index) {
        System.out.println(Ui.UNMARK_HEADER + "[ ] " + list.getList().get(index - 1).printDescription());
        list.getList().get(index - 1).setStatus("[ ]");
    }

    /**
     * UnMarks a task as done.
     *
     * @param list the task list.
     * @param index the index of the task to be unmarked.
     * @return the description of the task being unmarked.
     */
    public String unmarkGui(TaskList list, int index) {
        list.getList().get(index - 1).setStatus("[ ]");
        return Ui.UNMARK_HEADER + "[ ] " + list.getList().get(index - 1).printDescription();
    }

    public String setPriority(TaskList list, int index, char priority) {
        System.out.println("I have set" + list.getList().get(index - 1).printDescription() + " to " + priority);
        list.getList().get(index - 1).setPriority(priority);
        return ("I have set" + list.getList().get(index - 1).printDescription() + " to " + priority);
    }

    /**
     * Finds tasks in the task list that matches the keyword.
     *
     * @param list the task list.
     * @param keyword the keyword to be mapped.
     */
    public void find(TaskList list, String keyword) {
        System.out.println(Ui.FIND_HEADER);
        Task task = null;
        int find = 1;
        for (int i = 0; i < duke.getCount(); i++) {
            task = list.get(i);
            String finding = task.getName();
            if (finding.contains(keyword)) {
                System.out.println(find++ + "." + task.toString());
            }
        }
        System.out.println(Duke.LINE);
    }

    /**
     * Finds tasks in the task list that matches the keyword.
     *
     * @param list the task list.
     * @param keyword the keyword to be mapped.
     * @return the found tasks.
     */
    public String findGui(TaskList list, String keyword) {
        String printString = Ui.FIND_HEADER;
        Task task = null;
        int find = 1;
        for (int i = 0; i < duke.getCount(); i++) {
            task = list.get(i);
            String finding = task.getName();
            if (finding.contains(keyword)) {
                printString += find++ + "." + task.toString();
            }
        }
        return printString;
    }

    /**
     * Finds task by priority.
     * @param list the task list.
     * @param priority priority.
     * @return the task given the priority.
     */
    public String findPriority(TaskList list, String priority) {
        String printString = Ui.FIND_PRIORITY_HEADER + priority + ": \n";
        System.out.println(printString);
        Task task = null;
        int find = 1;
        for (int i = 0; i < duke.getCount(); i++) {
            task = list.get(i);
            char finding = task.getPriority();
            if (Character.toUpperCase(priority.charAt(0)) == finding) {
                printString += find + "." + task.toString();
                System.out.println(find + "." + task.toString());
                find++;
            }
        }
        printString += Duke.LINE;
        System.out.println(Duke.LINE);
        return printString;
    }
}
