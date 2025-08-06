import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AppointmentBusiness {
    private List<Appointment> appointments = new ArrayList<>();

    public void add(Scanner scanner) {
        Appointment appointment = new Appointment();
        appointment.inputData(scanner, appointments);
        appointments.add(appointment);
        System.out.println("Thêm thành công.");
    }

    public void displayAll() {
        appointments.stream()
                .sorted(Comparator.comparing(Appointment::getAppointmentDate))
                .forEach(System.out::println);
    }

    public void searchByPatientName(Scanner scanner) {
        System.out.print("Nhập tên cần tìm: ");
        String keyword = scanner.nextLine().toLowerCase();
        List<Appointment> result = appointments.stream()
                .filter(a -> a.getPatientName().toLowerCase().contains(keyword))
                .collect(Collectors.toList());
        if (result.isEmpty()) {
            System.out.println("Không tìm thấy.");
        } else {
            result.forEach(System.out::println);
        }
    }

    public void updateById(Scanner scanner) {
        System.out.print("Nhập mã lịch hẹn: ");
        String id = scanner.nextLine();
        Optional<Appointment> optional = appointments.stream()
                .filter(a -> a.getAppointmentId().equalsIgnoreCase(id))
                .findFirst();
        optional.ifPresentOrElse(appointment -> {
            appointment.inputData(scanner, appointments);
            System.out.println("Cập nhật thành công.");
        }, () -> System.out.println("Không tìm thấy."));
    }

    public void deleteById(Scanner scanner) {
        System.out.print("Nhập mã lịch hẹn: ");
        String id = scanner.nextLine();
        Optional<Appointment> optional = appointments.stream()
                .filter(a -> a.getAppointmentId().equalsIgnoreCase(id))
                .findFirst();
        optional.ifPresentOrElse(appointment -> {
            System.out.print("Xác nhận xóa (Y/N): ");
            String confirm = scanner.nextLine();
            if (confirm.equalsIgnoreCase("Y")) {
                appointments.remove(appointment);
                System.out.println("Đã xóa.");
            } else {
                System.out.println("Không xóa.");
            }
        }, () -> System.out.println("Không tìm thấy."));
    }

    public void statistics() {
        System.out.println("Tổng số lịch hẹn: " + appointments.size());
        Map<String, Long> countByDoctor = appointments.stream()
                .collect(Collectors.groupingBy(Appointment::getDoctor, Collectors.counting()));
        countByDoctor.forEach((doctor, count) -> System.out.println("Bác sĩ: " + doctor + " - " + count + " lịch hẹn"));
    }
}
