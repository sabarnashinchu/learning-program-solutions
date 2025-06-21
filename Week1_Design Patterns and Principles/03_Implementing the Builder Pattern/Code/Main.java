public class Main {
    public static void main(String[] args) {
        Computer basicComputer = new Computer.Builder()
            .setCPU("Intel i3")
            .setRAM("8GB")
            .build();

        System.out.println("Basic Configuration:");
        basicComputer.displayConfig();

        System.out.println("\n------------------\n");
        Computer gamingComputer = new Computer.Builder()
            .setCPU("Intel i9")
            .setRAM("32GB")
            .setStorage("1TB SSD")
            .setGraphicsCard("NVIDIA RTX 3080")
            .build();

        System.out.println("Gaming Configuration:");
        gamingComputer.displayConfig();
    }
}
