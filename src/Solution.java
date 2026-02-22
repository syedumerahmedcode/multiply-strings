public class Solution {
    public String multiply(String num1, String num2) {
        /**
         * Edge case scenario:
         * 
         * If one of the numbers is zero, the result is always zero
         */
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        // initialize an array to hold the result of the multiplication
        int[] result = new int[num1.length() + num2.length()];

        // Reverse both num1 and num2 for easier calculations (rightmost digit comes first)
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                // Multiply digits
                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';
                int mul = digit1 * digit2;

                // Find positions in result array where to add the product
                int posLow = i + j + 1;
                int posHigh = i + j;

                // Add multiplication result to the position and handle carry
                int sum = mul + result[posLow];

                // Set the current position to the remainder
                result[posLow] = sum % 10;
                // Add the carry to the next higher position
                result[posHigh] += sum / 10;
            }
        }
        
        /**
         * Convert the result array into a string
         */
        StringBuilder product = new StringBuilder();
        for (int num : result) {
            // Skip leading zeros
            if (!(product.length() == 0 && num == 0)) {
                product.append(num);
            }
        }
        
        // Return the product string
        return product.length() == 0 ? "0" : product.toString();        
    }
}
