package springdata.week1.springdata.Execptions.doctor;

public class DoctorCreationException extends RuntimeException {
    public DoctorCreationException(String message) {
        super(message);
    }
}
