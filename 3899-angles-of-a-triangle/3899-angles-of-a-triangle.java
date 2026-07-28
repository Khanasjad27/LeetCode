import java.util.Arrays;

class Solution {
    public double[] internalAngles(int[] sides) {
        // Sides ko alag-alag variables me store kar rhe hain simple calculation ke liye
        double a = sides[0];
        double b = sides[1];
        double c = sides[2];
        
        // Semi-perimeter calculate kiya (Heron's Formula ke liye)
        double sum = (a + b + c) / 2;
        
        // Heron's formula se triangle ka area nikala
        double area = Math.sqrt(sum * (sum - a) * (sum - b) * (sum - c));
        
        double A1 = 0, A2 = 0, A3 = 0;

        // Agar area zero se bada hai, matlab triangle valid hai
        if (area > 0) {
            // Law of Cosines laga kar angles nikale aur Math.toDegrees() se Degrees me convert kiya
            A1 = Math.toDegrees(Math.acos(((b * b) + (c * c) - (a * a)) / (2 * b * c)));  
            A2 = Math.toDegrees(Math.acos(((a * a) + (c * c) - (b * b)) / (2 * a * c)));
            A3 = Math.toDegrees(Math.acos(((b * b) + (a * a) - (c * c)) / (2 * b * a)));

            // Saare angles ko ek array me dala
            double[] result = {A1, A2, A3};
            
            // Question me bola hai ki angles sorted order (chote se bada) me chahiye
            Arrays.sort(result);  
            
            return result;
        }

        // Agar valid triangle nahi ban sakta (area <= 0), toh empty array return kar do
        return new double[0];
    }
}
