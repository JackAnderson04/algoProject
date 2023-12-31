import java.util.LinkedList;
import java.util.List;
import java.io.*;

public static class ShowScheduler {
    class Show {
        String name;
        int seniority;

        Show(String name, int seniority) {
            this.name = name;
            this.seniority = seniority;
        }
    }
    public List<Show> scheduleShows(List<Show> shows, int totalShowtimes) {
        List<Show> highPriority = new LinkedList<>();
        List<Show> mediumPriority = new LinkedList<>();
        List<Show> lowPriority = new LinkedList<>();
        List<Show> scheduledShows = new LinkedList<>();

        // Categorize shows based on seniority
        for (Show show : shows) {
            if (show.seniority == 2) {
                highPriority.add(show);
            } else if (show.seniority == 1) {
                mediumPriority.add(show);
            } else {
                lowPriority.add(show);
            }
        }

        // Allocate showtimes
        int highShowtimes = (int) (0.50 * totalShowtimes);
        int mediumShowtimes = (int) (0.30 * totalShowtimes);
        int lowShowtimes = totalShowtimes - highShowtimes - mediumShowtimes;

        // Schedule shows from high priority
        while (highShowtimes > 0 && !highPriority.isEmpty()) {
            scheduledShows.add(highPriority.remove(0));
            highShowtimes--;
        }
        // Schedule shows from medium priority
        while (mediumShowtimes > 0 && !mediumPriority.isEmpty()) {
            scheduledShows.add(mediumPriority.remove(0));
            mediumShowtimes--;
        }
        // Schedule shows from low priority
        while (lowShowtimes > 0 && !lowPriority.isEmpty()) {
            scheduledShows.add(lowPriority.remove(0));
            lowShowtimes--;
        }

        return scheduledShows;
    }

    public static void main(String[] args) {
        ShowScheduler scheduler = new ShowScheduler();
       // List<Show> shows = new LinkedList<>();

       try {
        String filePath = "Radio Schedule.txt"; 
        List<Show> shows = readShowsFromFile(filePath);

        List<Show> scheduled = scheduler.scheduleShows(shows, 10);
        for (Show show : scheduled) {
            System.out.println(show.name);
        }
    } catch (IOException e) {
        e.printStackTrace();
        // Handle the exception or exit the program
    }

        /*shows.add(scheduler.new Show("Show1", 2));
        shows.add(scheduler.new Show("Show2", 1));
        shows.add(scheduler.new Show("Show3", 0));
        shows.add(scheduler.new Show("Show4", 2));
        shows.add(scheduler.new Show("Show5", 2));
        shows.add(scheduler.new Show("Show6", 1));
        shows.add(scheduler.new Show("Show7", 0));
        shows.add(scheduler.new Show("Show8", 1)); */
    }

private static List<Show> readShowsFromFile(String filePath) throws IOException {
    List<Show> shows = new LinkedList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = br.readLine()) != null) {
            if (!line.isEmpty() && !Character.isDigit(line.charAt(0))) {
                // Assume the line is the name of the show
                String showName = line.trim();
                // Read the next line for seniority
                int seniority = Integer.parseInt(br.readLine().trim());
                // Skip lines until the next show
                while ((line = br.readLine()) != null && !line.isEmpty()) {
                    // Just read through the lines
                }
                shows.add(new Show(showName, seniority));
            }
        }
    }
    return shows;
}
}