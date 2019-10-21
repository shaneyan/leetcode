public class Problem26 {
        public static void main(String[] args) {
            //int[] a = {1,1,2};
            int[] a = {0,0,1,1,1,2,2,3,3,4};
            int len = removeDuplicates(a);
            System.out.println("len = " + len);
            for(int i = 0;i < len;i++) {
                System.out.print(a[i] + " ");
            }
        }

        private static int removeDuplicates(int[] a) {
            int len = 0;
            int i = 1;
            while(len+i+1 < a.length) {
                if(a[i-1] == a[i]) {
                    for(int j = i;j < a.length-len;j++) {
                        a[j-1] = a[j];
                    }
                    len++;
                } else {
                    i++;
                }
            }
            return a.length-len;
        }
}
