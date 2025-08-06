import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AppointmentBusiness business = new AppointmentBusiness();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n************ QUẢN LÝ LỊCH HẸN ************");
            System.out.println("1. Thêm lịch hẹn");
            System.out.println("2. Hiển thị danh sách lịch hẹn");
            System.out.println("3. Tìm kiếm lịch hẹn theo tên bệnh nhân");
            System.out.println("4. Cập nhật lịch hẹn theo mã");
            System.out.println("5. Xóa lịch hẹn theo mã");
            System.out.println("6. Thống kê");
            System.out.println("7. Thoát");
            System.out.print("Lựa chọn: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> business.add(scanner);
                case "2" -> business.displayAll();
                case "3" -> business.searchByPatientName(scanner);
                case "4" -> business.updateById(scanner);
                case "5" -> business.deleteById(scanner);
                case "6" -> business.statistics();
                case "7" -> {
                    exit = true;
                    System.out.println("Kết thúc chương trình.");
                }
                default -> System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}
