import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Appointment {
    private String appointmentId;
    private String patientName;
    private String phoneNumber;
    private LocalDate appointmentDate;
    private String doctor;

    public Appointment() {}

    public Appointment(String appointmentId, String patientName, String phoneNumber,
                       LocalDate appointmentDate, String doctor) {
        this.appointmentId = appointmentId;
        this.patientName = patientName;
        this.phoneNumber = phoneNumber;
        this.appointmentDate = appointmentDate;
        this.doctor = doctor;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public void inputData(Scanner scanner, List<Appointment> appointments) {
        while (true) {
            System.out.print("Nhập mã lịch hẹn (6 ký tự): ");
            String id = scanner.nextLine();
            if (id.length() != 6 || appointments.stream().anyMatch(a -> a.getAppointmentId().equalsIgnoreCase(id))) {
                System.out.println("Mã không hợp lệ hoặc đã tồn tại.");
            } else {
                this.appointmentId = id;
                break;
            }
        }

        while (true) {
            System.out.print("Nhập tên bệnh nhân (10-50 ký tự): ");
            String name = scanner.nextLine();
            if (name.length() >= 10 && name.length() <= 50) {
                this.patientName = name;
                break;
            } else {
                System.out.println("Tên không hợp lệ.");
            }
        }

        while (true) {
            System.out.print("Nhập số điện thoại (VN): ");
            String phone = scanner.nextLine();
            if (Pattern.matches("0[3-9]\\d{8}", phone)) {
                this.phoneNumber = phone;
                break;
            } else {
                System.out.println("Số điện thoại không hợp lệ.");
            }
        }

        while (true) {
            try {
                System.out.print("Nhập ngày hẹn (dd/MM/yyyy): ");
                String dateStr = scanner.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                this.appointmentDate = LocalDate.parse(dateStr, formatter);
                break;
            } catch (Exception e) {
                System.out.println("Ngày không hợp lệ.");
            }
        }

        while (true) {
            System.out.print("Nhập tên bác sĩ (≤ 200 ký tự): ");
            String doc = scanner.nextLine();
            if (doc.length() <= 200) {
                this.doctor = doc;
                break;
            } else {
                System.out.println("Tên bác sĩ quá dài.");
            }
        }
    }

    @Override
    public String toString() {
        return String.format("ID: %s | Tên: %s | SDT: %s | Ngày: %s | Bác sĩ: %s",
                appointmentId, patientName, phoneNumber,
                appointmentDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), doctor);
    }
}
