import java.io.File;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        System.out.println("Start searching...");

        File directory = new File("directory.txt");
        File find = new File("find.txt");

        List findList = new Files().addFind(find);
        List directoryList = new Files().addDir(directory);

        Search.searching(findList,directoryList);
    }

}
