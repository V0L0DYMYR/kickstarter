package ua.goit;

public class Test {

  public static void main(String[] args) {
    /*System.out.println(new Test().isMatch(
        "abbaabbbbababaababababbabbbaaaabbbbaaabbbabaabbbbbabbbbabbabbaaabaaaabbbbbbaaabbabbbbababbbaaabbabbabb",
        "*b*a*"));*/

    System.out.println(new Test().isMatch("AABAACAADAABAAABAA", "AABA"));
  }

  public boolean isMatch(String s, String p) {
    int[] prefix = getPrefix(p);
    int j = 0, i = 0;
    boolean res = false;

    while (i < s.length()) {
      if (j == p.length()) {
        System.out.println(i-p.length());
        j = 0;
        res = true;
      };
      char c = s.charAt(i);

      if (c == p.charAt(j)) {
        j++;
        i++;
      } else if(j == 0) {
        i++;
      } else {
        j = prefix[j-1];
      }
    }

    return res;
  }

  private int[] getPrefix(String p) {
    int[] prefix = new int[p.length()];
    int marked = 1, i = 0;

    while (marked < p.length() && i < p.length()) {

      if (prefix[i] == 0) {
        char c = p.charAt(i);
        int j = i+1, k = 1;

        while (marked < p.length() && j < p.length()) {
          if (c == p.charAt(j)) {
            prefix[j] = k;
            k = k+1;
            marked++;
          }
          j++;
        }
      }
      i++;
    }
    return prefix;
  }

}
