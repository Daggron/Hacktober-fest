public class AmericanFlag {
    public static void main(String[] args) {
                for(int i=0;i<11;i++) {
            if (i < 5) {
                for (int j = 0; j < 40; j++) {
                    if (j < 6) {
                        System.out.print("*" + " ");
                    } else {
                        System.out.print("=");
                    }
                }
                System.out.println();
                for (int k = 0; k < 39; k++) {
                    if (k < 5) {
                        System.out.print(" *");
                    } else if (k == 5) {
                        System.out.print("  =");
                    } else {
                        System.out.print("=");
                    }
                }
                System.out.println();
            }else{
                for(int l=0;l<46;l++){
                    System.out.print("=");
                }
                System.out.println();
            }
        }
    }
}

