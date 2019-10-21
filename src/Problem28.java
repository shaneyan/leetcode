public class Problem28 {
        public static void main(String[] args) {
            //String haystack = "hello";
            //String needle = "ll";
            String haystack = "aaaaa";
            String needle = "bba";
            int index = strStr(haystack,needle);
            System.out.println("index = " + index);
        }

        private static int strStr(String haystack,String needle) {
            return haystack.indexOf(needle);
        }
}
