package com.ben.leetcode.skipped;

/**
 * Created by ben on 2018/5/20.
 */
public class H_10_RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (s == null && p == null)
            return true;
        if (s == null)
            return false;
        if (p == null)
            return false;

        if (s.length() == 0 && p.length() == 0)
            return true;
        if (s.length() == 0)
            return false;
        if (p.length() == 0)
            return false;

        if (s.equals(p))
            return true;

        //* cannot be the first letter
        if (p.charAt(0) == '*')
            return false;

        int lens = s.length();
        int lenp = p.length();

        int idxs = 0;
        int idxp = 0;

        while (idxs < lens && idxp < lenp) {
            char cs = s.charAt(idxs);
            char cp = p.charAt(idxp);
            if (cs == cp) {
                idxs++;
                idxp++;
                continue;
            }
            if (cp == '.') {
                if (idxp + 1 < lenp) {
                    char nextChar = p.charAt(idxp + 1);
                    if (nextChar == '*') {
                        //match any letter
                        if (idxp + 2 < lenp) {
                            char nextNextChar = p.charAt(idxp + 2);
                            while (idxs < lens && s.charAt(idxs) != nextNextChar) {
                                idxs++;
                            }
                            idxs++;
                            idxp += 3;
                        } else {
                            return true;
                        }
                    } else {
                        idxs++;
                        idxp++;
                        continue;
                    }
                } else {
                    idxs++;
                    idxp++;
                    continue;
                }
            } else if (cp == '*') {
                char lastChar = p.charAt(idxp - 1);
                //lastChar exit 0 time, means we ignore this one
                if (cs != lastChar) {
                    idxp++;
                    continue;
                } else {
                    idxp++;
                    if (idxp < lenp) {
                        char nextChar = p.charAt(idxp);
                        while (nextChar == lastChar) {
                            idxp++;
                            if (idxp == lenp)
                                break;
                            nextChar = p.charAt(idxp);
                        }
                    }
//                    else {
//                        break;
//                    }
                }

                while (cs == lastChar) {
                    idxs++;
                    if (idxs == lens) {
                        break;
                    }
                    cs = s.charAt(idxs);
                }
                continue;
            } else {
                if (idxp + 1 < lenp) {
                    char nextChar = p.charAt(idxp + 1);
                    if (nextChar == '*') {
                        idxp = idxp + 2;
                        continue;
                    }
                }
                return false;
            }
        }

        return idxs == lens && idxp == lenp;
    }

    public static void main(String[] args) {
        String s = "mississippi";
        String p = "mis*is*p*.";

        H_10_RegularExpressionMatching q = new H_10_RegularExpressionMatching();
        boolean match = q.isMatch(s, p);
        System.out.println(match);
    }
}
