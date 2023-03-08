
import java.util.List;

public class Search {
    public static void searching(List findList,List directoryList){
        int count = 0;
        for (int i = 0; i < directoryList.size(); i++){
            for (int j = 0; j < findList.size();j++){

                if (directoryList.get(i).equals(findList.get(j))){
                    count++;

                }
            }
        }
        System.out.printf("Found %d/500 entries.", count);
        int time = (int) System.currentTimeMillis();
        System.out.printf("Time taken:  %d ms.",time);
    }
}
