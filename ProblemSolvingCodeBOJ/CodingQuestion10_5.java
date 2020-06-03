import java.util.HashMap;

public class CodingQuestion10_5 {
    public static void main(String[] args) {
        String strEx[] = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < strEx.length; i++) {
            if (!strEx.equals("")) {
                hm.put(strEx[i], i);
            }
        }
        String Query = "car";
        System.out.println(Query(hm, Query));
    }

    public static int Query(HashMap hm, String Query) {
        return (int)hm.get(Query);
    }
}