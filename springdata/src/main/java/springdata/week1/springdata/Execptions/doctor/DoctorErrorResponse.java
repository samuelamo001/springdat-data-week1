package springdata.week1.springdata.Execptions.doctor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DoctorErrorResponse {

    private LocalDateTime timestamp;
    private String message;
}
