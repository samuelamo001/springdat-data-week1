package springdata.week1.springdata.dto.doctor;

public interface DoctorPatientCountDTO {
    Long getDoctorId();
    String getDoctorFullName();
    String getSpeciality();
    Long getNumberOfPatients();
}
