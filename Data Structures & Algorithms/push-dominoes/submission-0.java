class Solution {
    public String pushDominoes(String dominoes) {
        StringBuilder res = new StringBuilder();
        int dots = 0;
        boolean R = false;

        for (char d : dominoes.toCharArray()) {
            if (d == '.') {
                dots++;
            } else if (d == 'R') {
                if (R) {
                    res.append("R".repeat(dots + 1));
                } else if (dots > 0) {
                    res.append(".".repeat(dots));
                }
                dots = 0;
                R = true;
            } else {
                if (R) {
                    res.append("R");
                    if (dots > 0) {
                        res.append("R".repeat(dots / 2));
                        if (dots % 2 != 0) {
                            res.append(".");
                        }
                        res.append("L".repeat(dots / 2));
                    }
                    res.append("L");
                    R = false;
                    dots = 0;
                } else {
                    res.append("L".repeat(dots + 1));
                    dots = 0;
                }
            }
        }

        if (R) {
            res.append("R".repeat(dots + 1));
        } else {
            res.append(".".repeat(dots));
        }

        return res.toString();
    }
}
