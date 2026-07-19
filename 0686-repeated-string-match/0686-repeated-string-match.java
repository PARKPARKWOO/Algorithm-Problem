class Solution {
    private static final long BASE = 257;
    private static final long MOD = 1_000_000_007;

    public int repeatedStringMatch(String a, String b) {
        int repeatCount =
            (b.length() + a.length() - 1) / a.length();

        StringBuilder repeated = new StringBuilder();

        for (int i = 0; i < repeatCount; i++) {
            repeated.append(a);
        }

        if (contains(repeated, b)) {
            return repeatCount;
        }

        repeated.append(a);

        if (contains(repeated, b)) {
            return repeatCount + 1;
        }

        return -1;
    }

    private boolean contains(
        CharSequence text,
        String pattern
    ) {
        int textLength = text.length();
        int patternLength = pattern.length();

        if (patternLength > textLength) {
            return false;
        }

        long patternHash = 0;
        long windowHash = 0;
        long highestPower = 1;

        for (int i = 0; i < patternLength; i++) {
            patternHash =
                (patternHash * BASE + pattern.charAt(i)) % MOD;

            windowHash =
                (windowHash * BASE + text.charAt(i)) % MOD;

            if (i < patternLength - 1) {
                highestPower = (highestPower * BASE) % MOD;
            }
        }

        for (int start = 0;
             start + patternLength <= textLength;
             start++) {

            if (
                windowHash == patternHash &&
                matches(text, pattern, start)
            ) {
                return true;
            }

            if (start + patternLength == textLength) {
                break;
            }

            char outgoing = text.charAt(start);
            char incoming =
                text.charAt(start + patternLength);

            windowHash =
                (
                    windowHash
                    - outgoing * highestPower % MOD
                    + MOD
                ) % MOD;

            windowHash =
                (windowHash * BASE + incoming) % MOD;
        }

        return false;
    }

    private boolean matches(
        CharSequence text,
        String pattern,
        int start
    ) {
        for (int i = 0; i < pattern.length(); i++) {
            if (text.charAt(start + i) != pattern.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}