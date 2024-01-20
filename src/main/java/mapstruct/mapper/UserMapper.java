package mapstruct.mapper;

import mapstruct.source.User;
import mapstruct.target.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class UserMapper {
    public static UserMapper INSTANCES = Mappers.getMapper(UserMapper.class);

    //@Mappings(@Mapping(source = "name", target = "name"))
    public abstract UserDto toUserRoleDto(User user);
}
