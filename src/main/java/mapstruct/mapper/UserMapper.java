package mapstruct.mapper;

import mapstruct.source.User;
import mapstruct.target.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCES = Mappers.getMapper(UserMapper.class);

    //@Mappings(@Mapping(source = "name", target = "name"))
    UserDto toUserRoleDto(User user);
}
