class Solution {
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder(s);
        
        while (true) {
            int digitIndex = -1;
            for (int i = 0; i < sb.length(); i++) {
                if (Character.isDigit(sb.charAt(i))) {
                    digitIndex = i;
                    break;
                }
            }
            
            if (digitIndex == -1) {
                break;
            }
            
            int leftNonDigitIndex = -1;
            for (int i = digitIndex - 1; i >= 0; i--) {
                if (!Character.isDigit(sb.charAt(i))) {
                    leftNonDigitIndex = i;
                    break;
                }
            }
            
            if (leftNonDigitIndex != -1) {
                sb.deleteCharAt(digitIndex);
                sb.deleteCharAt(leftNonDigitIndex);
            } else {
                sb.deleteCharAt(digitIndex);
            }
        }
        
        return sb.toString();
    }
}