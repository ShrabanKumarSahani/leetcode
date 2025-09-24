class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0)
            return "0";
        
        StringBuilder ans = new StringBuilder();

        // handling sign
        if((long) numerator * (long) denominator < 0) {
            ans.append("-");
        }

        long absNumerator = Math.abs((long) numerator);
        long absDenominator = Math.abs((long) denominator);

        // integer part
        long integerPart = absNumerator/absDenominator;
        ans.append(integerPart);

        long remain = absNumerator % absDenominator;
        if(remain == 0) {
            return ans.toString();
        }

        ans.append(".");

        Map<Long, Integer> mp = new HashMap<>();
        while(remain != 0) {
            if(mp.containsKey(remain)) {
                int insertPos = mp.get(remain);
                // inserting "(" at position where reminder first appeared    
                ans.insert(insertPos, "(");
                ans.append(")");
                break;
            }

            mp.put(remain, ans.length());
            remain *= 10;
            long digit = remain / absDenominator;
            ans.append(digit);
            remain %= absDenominator;
        }
        return ans.toString();
    }
}
/**
TC = O(Deno)
SC = O(1) */