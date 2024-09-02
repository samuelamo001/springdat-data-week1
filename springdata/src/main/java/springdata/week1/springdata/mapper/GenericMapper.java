package springdata.week1.springdata.mapper;

public interface GenericMapper <E,D>{
    D convertToDTO(E entity);
}
