package springdata.week1.springdata.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import springdata.week1.springdata.dto.department.DepartmentDirectorDTO;
import springdata.week1.springdata.repository.DepartmentRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {

    @Mock
    private DepartmentRepository departmentRepository;

    @InjectMocks
    private DepartmentService departmentService;

    @Test
    void testFindDepartmentDirectorsByDepartmentName(){
        DepartmentDirectorDTO departmentDirectorDTO = new DepartmentDirectorDTO() {
            @Override
            public String getDepartmentName() {
                return "Cardiology";
            }

            @Override
            public String getDepartmentCode() {
                return "CAR001";
            }

            @Override
            public String getDirectorFirstname() {
                return "John";
            }

            @Override
            public String getDirectorSurname() {
                return "Doe";
            }

            @Override
            public String getDirectorSpeciality() {
                return "Cardiology";
            }
        };
        List<DepartmentDirectorDTO> expected = List.of(departmentDirectorDTO);
        when(departmentRepository.findDepartmentDirectorsByDepartmentName()).thenReturn(expected);

        List<DepartmentDirectorDTO> actual = departmentService.findDepartmentDirectorsByDepartmentName();
        assertEquals(expected, actual);

        verify(departmentRepository).findDepartmentDirectorsByDepartmentName();
    }



}