import java.util.HashMap;
import java.util.Map;

public class Qn4 {

    int firstUniqueCharacter(String S) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            map.put(ch,
                    map.getOrDefault(ch, 0)+1
            );
        }

        System.out.println(map);

        for(int i = 0; i < S.length(); i++) {
            if(map.get(S.charAt(i)) < 2)
                return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        String S = "ashvani";
        System.out.println(new Qn4().firstUniqueCharacter(S));
    }
}
